/*
 * PhotoViewer.java implements a photo album viewer and allows the user to:
 * go the next image, previous image, first image, and the last image
 */


/*
 * importing relevant libaries for creating the interface, reading file (including checking for supported paths),
 * and displaying image
 */

import java.awt.Image;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

// node class
class Node {
    // every node has file name, file path, and size asscoiated with it
    String fileName;
    String filePath;
    long size;
    // since this is a doubly linked list, it is bidirectional and we
    // need to keep track of the next and the previous nodes
    Node prevNode;
    Node nextNode;

    // constructor that sets the file name, file path, and size
    // initializing previous and next as null here
    Node(String newFileName, String newFilePath, long newSize) {
        this.fileName = newFileName;
        this.filePath = newFilePath;
        this.size = newSize;
        this.prevNode = null;
        this.nextNode = null;
    }


    /*
     * getters and setters for file name, file path, size, previous node, and next node
     */
    public void setFileName(String newFileName) {
        this.fileName = newFileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFilePath(String newFilePath) {
        this.filePath = newFilePath;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setSize(long newSize) {
        this.size = newSize;
    }

    public long getSize() {
        return this.size;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getPrevNode() {
        return this.prevNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getNextNode() {
        return this.nextNode;
    }
}

// PhotoViewer class
public class PhotoViewer {
    // sentinels as per textbook: head and tail
    private Node head;
    private Node tail;
    // keeping track of the current node
    // number of elements, that is, images in the folder
    private Node current;
    private int size;

    // constructor
    public PhotoViewer() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    // return number of images
    public int size() {
        return size;
    }

    // checking whether doubly linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // the following snippet of code was given to us on canvas by Professor
    // size of the file:
    // https://stackoverflow.com/questions/2149785/get-size-of-folder-or-file
    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += folderSize(file);
            }
        }
        return length;
    }

    // add file name, file path, and size of the image from the folder
    public void add(String newFileName, String newFilePath, long newSize) {
        Node newNode = new Node(newFileName, newFilePath, newSize);
        if (isEmpty()) {
            // if no images yet in our linkedlist, setting head and tail as the new image
            head = newNode;
            tail = newNode;
        } else {
            // if there are images in the linked list,
            // setting the new node's next pointer to head
            // setting head's previous pointer to the newnode
            // now defining head to be the newdone
            newNode.nextNode = head;
            head.prevNode = newNode;
            head = newNode;
        }
        // incrementing the size as we added an image either to an empty doubly linked list or not empty list
        size++;
    }

    // if the user presses next, user wants to see the next image in the folder
    // type is of ImageIcon in order to display the image
    public ImageIcon next() {
        if (isEmpty()) {
            System.out.println("No images in the folder");
            return null;
        } // display the only image we have
        if (current == null) {
            current = head;
        } else if (current.nextNode == null) {
            // we reached the end of the folder signal
            System.out.println("No more images in the folder (at the last image)");
            return null;
        } else {
            // increment the image, like image = image+1 to see the next image
            current = current.nextNode;
        }
        // calling the getImage function and passing current node as input to display
        return getImage(current);
    }

     // user presses previous, to go back one image in the folder
    public ImageIcon previous() {
        if (isEmpty()) {
             // if the doubly linked list is empty, that is, no images
            System.out.println("No images in the folder");
            return null;

        }// setting tail node as current
        if (current == null) {
            current = tail;

        } else if (current.prevNode == null) {
            // if no more images in the folder
            System.out.println("No more images before this (at the first image)");
            return null;
        } else {
            // go to the previous nodes (opposite way)
            current = current.prevNode;
        }
        // calling the getImage function and passing current node as input to display
        return getImage(current);
    }

    // display the first image which is the head
    public ImageIcon first() {
        if (isEmpty()) {
            System.out.println("No images in the folder");
            return null;
        }
        current = head;
        // calling the getImage function and passing current node as input to display
        return getImage(current);
    }

    // display the last image
    public ImageIcon last() {
        if (isEmpty()) {
            System.out.println("No images in the folder");
            return null;
        }
        current = tail;
        // calling the getImage function and passing current node as input to display
        return getImage(current);
    }

    // getting the image from node
    public ImageIcon getImage(Node node) {
        if (node != null) {
            ImageIcon image = new ImageIcon(node.getFilePath()); // getting the file path
            // using the .getScaledInstance() method as suggested by Prof. Joshi
            Image scaled = image.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } else {
            // otherwise no image to display
            System.out.println("No image to display");
            return null;
        }
    }

    public static void main(String[] args) {
        // if the user did not enter the folder path
        if (args.length == 0) {
            System.out.println("Please provide path to folder of images");
            return;
        }
        // take in the argument after PhotoViewer 
        String path = args[0];

        // and checking whether a directory exists
        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            return;
        }

        // expanded Prof. Joshi's code
        // to support: .png and .gif files
        String[] myFiles = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File directory, String fileName) {
                String lowercaseName = fileName.toLowerCase();
                return lowercaseName.endsWith(".jpg") || lowercaseName.endsWith(".png") || lowercaseName.endsWith(".gif");
            }
        });

        // error handling whether or not a folder is empty
        if (myFiles == null || myFiles.length == 0) {
            System.out.println("Empty folder");
            return;
        }
        // creating photo viewer object
        // and taking in file name, file path, and size of the file
        PhotoViewer pv = new PhotoViewer();
        for (String fileName : myFiles) {
            File file = new File(directory, fileName);

            try {
                String fullPath = file.getCanonicalPath(); // as suggested on campuswire
                long size = file.length();
                pv.add(fileName, fullPath, size);
            } catch (IOException e) {
                System.out.println("Error getting the canonical path: " + e);
            }
        }
        // calling the pvFourButtons object and passing this current file's instance
        SwingUtilities.invokeLater(() -> {
            pvFourButtons pvF = new pvFourButtons(pv);
            pvF.setVisible(true);
        });
    }
}

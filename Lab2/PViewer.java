// Implement a custom Linked List class that stores information about all the images in a pre-specified folder

import java.io.File;
import java.io.FilenameFilter;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/*
 * Node class with getters and setters for name of the file, full path of the file, and size of the file
 */

class Node {
    String fileName;
    String fullPath;
    long size;
    Node next;

    Node(String newFileName, String newFullPath, long newSize) {
        this.fileName = newFileName;
        this.fullPath = newFullPath;
        this.size = newSize;
        this.next = null;
    }

    public void setFileName(String newFileName) {
        this.fileName = newFileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFullPath(String newFullPath) {
        this.fullPath = newFullPath;
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public void setSize(long newSize) {
        this.size = newSize;
    }

    public long getSize() {
        return this.size;
    }
}

/*
 * PhotoViewer class that has root node as head and we keep track of current
 * node
 */

public class PViewer {
    // data attributes
    private Node head;
    private Node current;

    // constructor with head and current as null
    public PViewer() {
        head = null;
        current = null;
    }

    // add method to add file name, file path, and size of the file
    public void add(String newFileName, String newFullPath, long newSize) {
        // new node with those new features
        Node newNode = new Node(newFileName, newFullPath, newSize);

        // if there is no node, make a new node and set that to be head and current
        // (first node)
        if (head == null) {
            head = newNode;
            current = newNode;
        } else {
            // temp variable to loop through nodes
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            // add a new node once we reach the end
            temp.next = newNode;
        }

    }

    // print the file name, full path, and size
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println("FileName: " + current.getFileName() + "; FullPath: " + current.getFullPath()
                    + "; Size: " + current.getSize());
            current = current.next;
        }
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

    // loop as long as we did not reach end of file
    public void next() {
        if (current.next != null) {
            current = current.next;
        } else {
            System.out.println("Last image of the folder");
        }
    }

    // get back to the first node, in other words, to the head
    public void reset() {
        current = head;
    }

    // get the full path to display the image, if the image is present in the folder
    public ImageIcon getImage() {
        if (current != null) {
            return new ImageIcon(current.getFullPath());
        } else {
            // we reached end of folder
            System.out.println("all images complete");
            return null;
        }
    }

    public static void main(String[] args) {

        // user enters the folder path
        if (args.length == 0) {
            System.err.println("path for images folder not provided");
            return;
        }

        // we take the user path and pass it to the file object
        String path = args[0];
        File directory = new File(path);

        // error handling for directory existence
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        // the following 3 lines are from stack overflow
        // https://stackoverflow.com/questions/5603966/how-to-make-filefilter-in-java
        String[] myFiles = directory.list(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".jpg");
            }
        });

        // error handling for empty directory
        if (myFiles == null || myFiles.length == 0) {
            System.out.println("Empty directory");
            return;
        }

        // creating an instance of the PhotoViewer object
        PViewer pv = new PViewer();
        // looping across the directory
        for (String fileName : myFiles) {
            File file = new File(directory, fileName);
            String fullPath = file.getAbsolutePath();
            long size = file.length();
            // adding the file name, full path, and size
            pv.add(fileName, fullPath, size);
        }
        // print the contents
        pv.printList();

        // using the invokeLater() method to create an instance of the
        // ImageAndTwoButtonsUI object
        SwingUtilities.invokeLater(() -> {
            ImageAndTwoButtonsUI itbu = new ImageAndTwoButtonsUI(pv);
            itbu.setVisible(true);

        });

    }
}
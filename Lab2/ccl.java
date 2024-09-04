import java.awt.Image;
import java.io.File;
import java.io.FilenameFilter;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

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

public class ccl {
    private Node tail;
    private int size = 0;

    public ccl() {
        tail = null;
    }

    public int size() {
        return size;
    }

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

    public void add(String newFileName, String newFullPath, long newSize) {
        Node newNode = new Node(newFileName, newFullPath, newSize);
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.next;
        } else {
            System.out.println("no elements to rotate");
        }
    }

    public void next() {
        rotate();
    }

    public ImageIcon getImage() {
        if (tail != null) {
            ImageIcon ogImg = new ImageIcon(tail.next.getFullPath());
            Image scaled = ogImg.getImage().getScaledInstance(700,500, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        } else {
            System.out.println("all images complete");
            return null;
        }
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("folder path not provided");
            return;
        }

        String path = args[0];
        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("invalid directory");
            return;
        }

        // the following 3 lines are from stack overflow
        // https://stackoverflow.com/questions/5603966/how-to-make-filefilter-in-java
        String[] myFiles = directory.list(new FilenameFilter() {
            public boolean accept(File directory, String fileName) {
                return fileName.endsWith(".jpg");
            }
        });

        if (myFiles == null || myFiles.length == 0) {
            System.out.println("empty directory");
            return;
        }

        ccl cl = new ccl();
        for (String fileName : myFiles) {
            File file = new File(directory, fileName);
            String fullPath = file.getAbsolutePath();
            long size = file.length();
            cl.add(fileName, fullPath, size);
        }
        // using the invokeLater() method to create an instance of the
        // ImageAndTwoButtonsUI object
        SwingUtilities.invokeLater(() -> {
            cclImageAndTwoButtonsUI itbu = new cclImageAndTwoButtonsUI(cl);
            itbu.setVisible(true);

        });

    }
}
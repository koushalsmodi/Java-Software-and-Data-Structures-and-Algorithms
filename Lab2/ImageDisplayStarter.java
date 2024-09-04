import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageDisplayStarter extends JFrame {
    private static final Logger LOGGER = Logger.getLogger(ImageDisplayStarter.class.getName());
    private List<File> imageFiles;
    private int currentIndex = 0;
    private JLabel imageLabel;
    private JLabel statusLabel;
    
    public ImageDisplayStarter(String directoryPath) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Image Display");
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        add(buttonPanel, BorderLayout.SOUTH);

        statusLabel = new JLabel("Status: ");
        add(statusLabel, BorderLayout.NORTH);

        prevButton.addActionListener(e -> showPreviousImage());
        nextButton.addActionListener(e -> showNextImage());

        loadImagesFromDirectory(directoryPath);
        if (!imageFiles.isEmpty()) {
            displayImage(currentIndex);
        } else {
            statusLabel.setText("Status: No images found in the specified directory.");
        }

        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void loadImagesFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            // Convey error message to the viewer 
            return;
        }

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                return lowercaseName.endsWith(".jpg");  // png / gif we need to fix this
            }
        });

        if (files == null || files.length == 0) {
            // Inform the user that no files were found in the specified folder 
            imageFiles = new ArrayList<>();
        } else {
            // This should be replaced with your own method that iterates over the files in the folder and 
            // adds each image to your Linked List
            imageFiles = new ArrayList<>(Arrays.asList(files)); 
            LOGGER.log(Level.INFO, "Found {0} image files in directory: {1}", new Object[]{files.length, directoryPath});
            statusLabel.setText("Status: Found " + files.length + " image(s).");
        }
    }

    private void displayImage(int index) {
        if (index >= 0 && index < imageFiles.size()) {
            try {
                File imageFile = imageFiles.get(index);
                BufferedImage image = ImageIO.read(imageFile);
                if (image != null) {
                    imageLabel.setIcon(new ImageIcon(image));
                    statusLabel.setText("Status: Displaying image " + (index + 1) + " of " + imageFiles.size());
                } else {
                    LOGGER.log(Level.WARNING, "Failed to read image file: {0}", imageFile.getPath());
                    statusLabel.setText("Status: Failed to read image file.");
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error loading image", e);
                statusLabel.setText("Status: Error loading image - " + e.getMessage());
            }
        } else {
            LOGGER.log(Level.WARNING, "Invalid image index: {0}", index);
            statusLabel.setText("Status: No image to display.");
        }
    }

    // Method to show the previous image 
    private void showPreviousImage() {
        System.out.println("Previous button clicked!");
    }

    // Method to show the next image 
    private void showNextImage() {
        System.out.println("Next button clicked!");
       
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            String directoryPath = "images/"; // Replace with your image directory path
            ImageDisplayStarter display = new ImageDisplayStarter(directoryPath);
            display.setVisible(true);
        });
    }
}
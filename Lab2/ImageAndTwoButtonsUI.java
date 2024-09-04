import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageAndTwoButtonsUI extends JFrame {
    // data attributes
    private JLabel imageLabel;
    private PViewer pv;

    public ImageAndTwoButtonsUI(PViewer pv) {
        this.pv = pv;

        setTitle("Image and Two Buttons UI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setPreferredSize(new Dimension(700, 500));
        nextImage();

        add(imageLabel, BorderLayout.CENTER);

        // creating a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton button1 = new JButton("Reset");
        JButton button2 = new JButton("Next");

        button1.addActionListener(new Button1Listener());
        button2.addActionListener(new Button2Listener());

        buttonPanel.add(button1);
        buttonPanel.add(button2);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void nextImage() {
        ImageIcon img = pv.getImage(); // returning the ImageIcon of the current image being displayed
        if (img != null) {
            imageLabel.setIcon(img); // display the image in the JLabel component
        } else {
            imageLabel.setText("no images"); // else no images in the folder
        }

    }

    class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Reset was pressed");
            // calls the reset method from PhotoViewer which sets current to head
            pv.reset();
            // calls the nextImage() method above to continue
            nextImage();

        }
    }

    class Button2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Next was pressed");
            // calls the next method from PhotoViewer to get the next image for display
            pv.next();
            // calls the nextImage() method above to continue
            nextImage();

        }
    }

    public static void main(String[] args) {
        // running from PhotoViewer.java 
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cclImageAndTwoButtonsUI extends JFrame {
    // data attributes
    private JLabel imageLabel;
    private ccl cl;

    public cclImageAndTwoButtonsUI(ccl cl) {
        this.cl = cl;

        setTitle("One Image and One Button UI");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        add(imageLabel, BorderLayout.CENTER);

        nextImage();

        // creating a panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton button1 = new JButton("Next");

        button1.addActionListener(new Button1Listener());

        buttonPanel.add(button1);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void nextImage() {
        ImageIcon img = cl.getImage(); // returning the ImageIcon of the current image being displayed
        if (img != null) {
            imageLabel.setIcon(img); // display the image in the JLabel component
        } else {
            imageLabel.setText("no images"); // else no images in the folder
        }

    }

    class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Next was pressed");
            // calls the next method from PhotoViewer to get the next image for display
            cl.next();
            // calls the nextImage() method above to continue
            nextImage();

        }
    }

    public static void main(String[] args) {
        //

    }
}

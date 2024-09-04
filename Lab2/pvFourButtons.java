// pvFourButtons.java handles GUI interface and takes in input from the user (4 button options) 
// and calls the methods from PhotoViewer.java

/*
 * importing relevant libraries for GUI and action listening after a button is pressed
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pvFourButtons extends JFrame{
    // data attributes
    PhotoViewer pv;
    JLabel imageLabel;

    // constructor that takes in PhotoViewer object
    public pvFourButtons(PhotoViewer pv){
        this.pv = pv;
        setTitle("Image display and four buttons UI");

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // panel for buttons, like magents on the fridge (on the lower section) of the door
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        add(buttonPanel, BorderLayout.SOUTH);

        // button names
        JButton button1 = new JButton("Previous");
        JButton button2 = new JButton("Next");
        JButton button3 = new JButton("First");
        JButton button4 = new JButton("Last");

        // calling every buttons action 
        button1.addActionListener(new Button1Listener());
        button2.addActionListener(new Button2Listener());
        button3.addActionListener(new Button3Listener());
        button4.addActionListener(new Button4Listener());

        // add the 4 buttons on the button panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);


    }

    // takes in ImageIcon type input and displays an image if it's not null
    // else prints nothing
    public void displayImage(ImageIcon image){
        if (image != null){
            imageLabel.setIcon(image);
        }
        else{
            imageLabel.setIcon(null);
        }
    }

    // calling the previous method from PhotoViewer.java and displays the previous image
    class Button1Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Previous was pressed");
            ImageIcon image = pv.previous();
            displayImage(image);

        }
    }
    // calling the next method from PhotoViewer.java and displays the next image
    class Button2Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Next was pressed");
            ImageIcon image = pv.next();
            displayImage(image);

        }
    }
    // calling the first method from PhotoViewer.java and displays the first image
    class Button3Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("First was pressed");
            ImageIcon image = pv.first();
            displayImage(image);

        }
    }

    // calling the last method from PhotoViewer.java and displays the last image
    class Button4Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Last was pressed");
            pv.last();
            ImageIcon image = pv.last();
            displayImage(image);

        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            PhotoViewer pv = new PhotoViewer();
            // creating an instance of the object and passing PhotoViewer object as input
            pvFourButtons ui = new pvFourButtons(pv);
            ui.setVisible(true);
        });

    }

    
}

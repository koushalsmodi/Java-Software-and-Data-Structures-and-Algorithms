import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourButtonUIMultipleListeners extends JFrame {

    public FourButtonUIMultipleListeners() {
        setTitle("Four Button UI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");


        button1.addActionListener(new Button1Listener());
        button2.addActionListener(new Button2Listener());
        button3.addActionListener(new Button3Listener());
        button4.addActionListener(new Button4Listener());
        button5.addActionListener(new Button5Listener());

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
    }

    class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button 1 was pressed");
        }
    }

    class Button2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button 2 was pressed");
        }
    }

    class Button3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button 3 was pressed");
        }
    }

    class Button4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button 4 was pressed");
        }
    }
    class Button5Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println("Button 5 was pressed");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FourButtonUIMultipleListeners ui = new FourButtonUIMultipleListeners();
            ui.setVisible(true);
        });
    }
}
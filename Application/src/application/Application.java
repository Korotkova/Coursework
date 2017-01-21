package application;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Application extends JFrame {

    public Application() {
        
        setTitle("Транспортная задача");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,500, 300);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
       
        JTextArea display = new JTextArea();
        JPanel buttonPanel = new JPanel(); 
        JTextField o1 = new JTextField(2);
        JTextField o2 = new JTextField(2);
        
        add(buttonPanel);
        buttonPanel.add(o1);
        buttonPanel.add(o2);
        
        //JButton button = new JButton("▲");
        //JButton button1 = new JButton("▼");
        JButton button2 = new JButton("Решение");
        
        //button.setFocusPainted(false);
        //button1.setFocusPainted(false);
        button2.setFocusPainted(false);
        
        //buttonPanel.add(button);
        //buttonPanel.add(button1);

        /*button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText()+ "▲");
                display.setText(display.getText() + "▼");
            }
        });*/
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Application a = new Application();
    }
    
}

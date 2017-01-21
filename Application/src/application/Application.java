package application;

import java.awt.BorderLayout;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Application extends JFrame {

    public Application() {
        
        setTitle("Транспортная задача");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,500, 300);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        
        SpinnerModel numbers = new SpinnerNumberModel(1, 0, 15, 1);
        SpinnerModel numbers1 = new SpinnerNumberModel(1, 0, 15, 1);

        JPanel buttonPanel = new JPanel(); 
        JSpinner row = new JSpinner(numbers);
        JSpinner colums = new JSpinner(numbers1);
        JButton button2 = new JButton("Решение");
        
        add(buttonPanel);
        buttonPanel.add(row);
        buttonPanel.add(colums);
      
        button2.setFocusPainted(false);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Application a = new Application();
    }
    
}

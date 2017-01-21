package application;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Application extends JFrame {

    public Application() {
        
        setTitle("Транспортная задача");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,500, 300);
        setResizable(false);
        //getContentPane().setLayout(new BorderLayout());
        
        SpinnerModel numbers = new SpinnerNumberModel(1, 1, 15, 1);
        SpinnerModel numbers1 = new SpinnerNumberModel(1, 1, 15, 1);
        
        JPanel panel = new JPanel(); 
        JSpinner row = new JSpinner(numbers);
        JSpinner colums = new JSpinner(numbers1);
        JButton next = new JButton(">>");
        // JButton button = new JButton("Решение");
        JLabel text = new JLabel("<html> <font size = +2> Решение Транспортной задачи </font> </html>");
        JLabel text1 = new JLabel("Для решения задачи укажите её размерность");
        JLabel text2 = new JLabel("<html> <font size = +1> Количество Спроса </font> </html>");
        JLabel text3 = new JLabel("<html> <font size = +1> Количество Предложений </font> </html>");
        
        text1.setPreferredSize(new Dimension(270,100));
        text2.setPreferredSize(new Dimension(250,50));
        text3.setPreferredSize(new Dimension(250,50));

        add(panel).setBackground(Color.WHITE);
        panel.add(text); 
        panel.add(text1);
        panel.add(text2);
        panel.add(row);
        panel.add(text3);
        panel.add(colums);
        panel.add(next);

        next.setFocusPainted(false);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Application a = new Application();
    }
}

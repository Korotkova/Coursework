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
        
        SpinnerModel numbers = new SpinnerNumberModel(1, 1, 15, 1);
        SpinnerModel numbers1 = new SpinnerNumberModel(1, 1, 15, 1);
        
        JPanel panel = new JPanel(); 
        JButton next = new JButton(">>");
        // JButton button = new JButton("Решение");

        add(panel).setBackground(Color.WHITE);
        panel.add(new JLabel("<html> <font size = +2> Решение Транспортной задачи </font> </html>")); 
        panel.add(new JLabel("Для решения задачи укажите её размерность")).setPreferredSize(new Dimension(270,100));
        panel.add(new JLabel("<html> <font size = +1> Количество Спроса </font> </html>")).setPreferredSize(new Dimension(250,50));
        panel.add(new JSpinner(numbers));
        panel.add(new JLabel("<html> <font size = +1> Количество Предложений </font> </html>")).setPreferredSize(new Dimension(250,50));
        panel.add(new JSpinner(numbers1));
        panel.add(next);

        next.setFocusPainted(false);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        Application a = new Application();
    }
}

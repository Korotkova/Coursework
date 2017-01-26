package application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Application extends JFrame {

    public Application() {
        
        setTitle("Транспортная задача");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,500, 300);
        setResizable(false);
        
        SpinnerNumberModel numberModel1 = new SpinnerNumberModel(1, 1, 15, 1);
        SpinnerNumberModel numberModel2 = new SpinnerNumberModel(1, 1, 15, 1);

        JPanel panel = new JPanel(); 
        JButton next = new JButton(">>");
        JSpinner spinner1 = new JSpinner(numberModel1);
        JSpinner spinner2 = new JSpinner(numberModel2);
        
        int value1 = numberModel1.getNumber().intValue();
        int value2 = numberModel2.getNumber().intValue();
        
        add(panel).setBackground(Color.WHITE);
        panel.add(new JLabel("<html> <font size = +2> Решение Транспортной задачи </font> </html>")); 
        panel.add(new JLabel("Для решения задачи укажите её размерность")).setPreferredSize(new Dimension(270,100));
        panel.add(new JLabel("<html> <font size = +1> Количество Спроса </font> </html>")).setPreferredSize(new Dimension(250,50));
        panel.add(spinner1);
        panel.add(new JLabel("<html> <font size = +1> Количество Предложений </font> </html>")).setPreferredSize(new Dimension(250,50));
        panel.add(spinner2);
        panel.add(next).setFocusable(false);
        
        setVisible(true);

        next.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                application2();
            }
        });
    }
    
    void application2() {
        
        setTitle("Транспортная задача");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,200,500, 300);
        setResizable(false);
        JPanel panel = new JPanel(); 
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        new Application();
    }
}

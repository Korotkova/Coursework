package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;

public class Application {
    
    private final SpinnerNumberModel numberModel1;
    private final SpinnerNumberModel numberModel2;

    public Application() {
        
        JFrame f = new JFrame();
        f.setTitle("Транспортная задача");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setBounds(500, 200, 500, 300);
        f.setResizable(false);
        
        numberModel1 = new SpinnerNumberModel(1, 1, 6, 1);
        numberModel2 = new SpinnerNumberModel(1, 1, 6, 1);

        JPanel panel = new JPanel(); 
        JLabel text1 = new JLabel("Решение Транспортной задачи");
        JLabel text2 = new JLabel("Для решения задачи укажите её размерность");
        JLabel text3 = new JLabel("Количество Спроса");
        JLabel text4 = new JLabel("Количество Предложений");
        JButton next = new JButton(">>");
        JSpinner spinner1 = new JSpinner(numberModel1);
        JSpinner spinner2 = new JSpinner(numberModel2);
        
        text1.setFont(new Font("Tahoma", 1, 24));
        text2.setFont(new Font("Tahoma", 1, 12)); 
        text3.setFont(new Font("Tahoma", 1, 18));
        text4.setFont(new Font("Tahoma", 1, 18));
        spinner1.setFont(new Font("Tahoma", 0, 12));
        spinner2.setFont(new Font("Tahoma", 0, 12));
        
        f.add(panel).setBackground(Color.WHITE); GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(text1))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(text2)
                            .addComponent(text3))))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(text4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(spinner1)
                    .addComponent(spinner2))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(next, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text1)
                .addGap(40, 40, 40)
                .addComponent(text2)
                .addGap(81, 81, 81)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(text3)
                    .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(text4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinner2))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(next, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        GroupLayout layout = new GroupLayout(f.getContentPane());
        f.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        f.pack();
        
        f.setVisible(true);

        next.addActionListener((ActionEvent e) -> {
            f.setVisible(false);
            new EnterValuesWindow((Integer) numberModel1.getValue(), (Integer) numberModel2.getValue());
        });
    }
    
    public static void main(String[] args) {
        
        new Application();
    }
}

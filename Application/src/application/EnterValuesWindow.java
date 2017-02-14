package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class EnterValuesWindow {

    public int[] masU;
    public int[] masV;
    public int[][] money;
    private final DefaultTableModel model1, model2, model3;
    private static JTable table1, table2, table3;
    private JCheckBox checkBox;
    private JComboBox cb1;
    private JComboBox cb2;
    NorthwestCorner nc;
    
    public EnterValuesWindow(Integer row, Integer column) {
        
        JFrame jf = new JFrame();
        jf.setTitle("Транспортная задача");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setBounds(300, 200, 500, 300);
        jf.setResizable(false);
        
        model1 = new DefaultTableModel(new Object[column], 1){
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return Integer.class;
                }
        };
        
        model2 = new DefaultTableModel(new Object[row], 1){
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return Integer.class;
                }
        };
        
        model3 = new DefaultTableModel(new Integer[column], row){
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return Integer.class;
                }
        };
        
        JScrollPane jScrollPane1 = new JScrollPane();
        JScrollPane jScrollPane2 = new JScrollPane();
        JScrollPane jScrollPane3 = new JScrollPane();
        JPanel panel = new JPanel(); 
        cb1 = new JComboBox();
        cb2 = new JComboBox();
        checkBox = new JCheckBox();
        JLabel text1 = new JLabel("Введите значения спроса и предложений");
        JLabel text2 = new JLabel(" Спрос");
        JLabel text3 = new JLabel("Предложение");
        JLabel text4 = new JLabel("Заполните таблицу издержек");
        JLabel text5 = new JLabel("Метод нахождения опорного плана");
        JLabel text6 = new JLabel("Целевая функция");
        table1 = new JTable(model1);
        table2 = new JTable(model2);
        table3 = new JTable(model3);
        JButton button = new JButton("Решить");
        
        cb1.setModel(new DefaultComboBoxModel<>(new String[] { "Северо-Западного угла", "Аппроксимации Фогеля", "Минимального элемента", "Максимального элемента" }));
        cb2.setModel(new DefaultComboBoxModel<>(new String[] { "Минимальные затраты", "Максимальные затраты" }));
        checkBox.setText("С подробным решением ");
        checkBox.setHorizontalTextPosition(SwingConstants.LEFT);
        checkBox.setFocusable(false);
        button.setFocusable(false);
        text1.setFont(new Font("Tahoma", 1, 11));
        text2.setFont(new Font("Tahoma", 0, 12));
        text3.setFont(new Font("Tahoma", 0, 12));
        text4.setFont(new Font("Tahoma", 1, 11));
        text5.setFont(new Font("Tahoma", 1, 12));
        text6.setFont(new Font("Tahoma", 1, 12));
        table3.setRowHeight(20);
        jScrollPane1.setViewportView(table2);
        jScrollPane2.setViewportView(table1);
        jScrollPane3.setViewportView(table3);
        table1.getTableHeader().setReorderingAllowed(false);//Запрет перетаскивания столбцов
        table2.getTableHeader().setReorderingAllowed(false);
        table3.getTableHeader().setReorderingAllowed(false);
        table1.getTableHeader().setResizingAllowed(false);//Запрет на изменение ширины столбцов
        table2.getTableHeader().setResizingAllowed(false);
        table3.getTableHeader().setResizingAllowed(false);
        
        jf.add(panel).setBackground(Color.WHITE);
        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(text2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(text1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
                            .addComponent(text4, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(checkBox)
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(text5)
                                                .addGap(32, 32, 32)
                                                .addComponent(cb1, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(text6)
                                                .addGap(18, 18, 18)
                                                .addComponent(cb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addGap(329, 329, 329)
                                        .addComponent(button, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(text1)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(text2))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(text3)))
                                .addGap(8, 8, 8))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(text4)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(text5)
                            .addComponent(cb1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(text6)
                                    .addComponent(cb2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(checkBox)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(jf.getContentPane());
        jf.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        jf.pack();
        
        jf.setVisible(true);
        
        button.addActionListener((ActionEvent e) -> {
            masU = new int[row];
            for(int i = 0; i < table2.getColumnCount(); i++){
                masU[i] = (int) model2.getValueAt(0, i);
            }
            masV = new int[column];
            for(int i = 0; i < table1.getColumnCount(); i++){
                masV[i] = (int) model1.getValueAt(0, i);
            }
            money = new int[row + 1][column + 1];
            for(int i = 0; i < table3.getRowCount(); i++){
                for(int j = 0; j < table3.getColumnCount(); j++){
                    money[i][j] = (int) model3.getValueAt(i, j);
                }
            }
            //if(nc.balan1 == nc.balan2){
                jf.setVisible(false);
                conditionSelection();
            //}
            /*else{
                new NotBalans();
            }*/
        });
    }
    public void conditionSelection(){
        if(cb1.getSelectedItem() == cb1.getItemAt(0)){
            if(checkBox.getModel().isSelected()){
                new SolutionTheNorthwestCorner().setVisible(true);
            }
            else new OnlyAnswer();
        }

        if(cb1.getSelectedItem() == cb1.getItemAt(1)){
            if(checkBox.getModel().isSelected()){
                //SolutionFogel
            }
            else new OnlyAnswer();
        }
        if(cb1.getSelectedItem() == cb1.getItemAt(2)){
            if(checkBox.getModel().isSelected()){
                //SolutionMinElement
            }
            else new OnlyAnswer();
        }
        if(cb1.getSelectedItem() == cb1.getItemAt(3)){
            if(checkBox.getModel().isSelected()){
                //SolutionMaxElement
            }
            else new OnlyAnswer();
        }
    }
}

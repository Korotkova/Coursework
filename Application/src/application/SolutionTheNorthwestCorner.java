package application;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

class SolutionTheNorthwestCorner {

    public SolutionTheNorthwestCorner() {
        
        JFrame jf = new JFrame();
        jf.setTitle("Решение Метода Северо-Западного угла");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setResizable(false);
        
        JPanel jPanel1 = new JPanel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTable jTable1 = new JTable();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JTextField jTextField1 = new JTextField();
        JTextField jTextField2 = new JTextField();
        JLabel jLabel4 = new JLabel();
        JScrollPane jScrollPane2 = new JScrollPane();
        JTable jTable2 = new JTable();
        JLabel jLabel5 = new JLabel();
        JTextField jTextField3 = new JTextField();
        JLabel jLabel6 = new JLabel();
        JScrollPane jScrollPane3 = new JScrollPane();
        JTable jTable3 = new JTable();
        JScrollPane jScrollPane4 = new JScrollPane();
        JTable jTable4 = new JTable();
        JLabel jLabel7 = new JLabel();
        JTextField jTextField4 = new JTextField();
        JButton jToggleButton1 = new JButton();

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new Font("Tahoma", 0, 18)); 
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Предложение");

        jLabel2.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Спрос");

        jLabel3.setText("Задача сбалансированна:");

        jTextField1.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jTextField1.setText("jTextField1");

        jTextField2.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setText("jTextField2");

        jLabel4.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Опорный план:");

        jTable2.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jScrollPane2.setViewportView(jTable2);

        jLabel5.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("ЦФ:");

        jTextField3.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jTextField3.setText("jTextField3");

        jLabel6.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Метод потенциалов:");

        jTable3.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "НеБП", "Ui + Vj - Cij"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setRowHeight(20);
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "БП", "Урав. относ. потенц.", "Решение"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable4.setRowHeight(20);
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(2).setHeaderValue("Решение");
        }

        jLabel7.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Наибольшее значение");

        jTextField4.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jTextField4.setText("jTextField4");

        jToggleButton1.setFont(new Font("Tahoma", 0, 14)); // NOI18N
        jToggleButton1.setText("Следующий шаг");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextField1))
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(115, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jToggleButton1)
                                        .addContainerGap())))))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(282, 282, 282))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        GroupLayout layout = new GroupLayout(jf.getContentPane());
        jf.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        jf.pack();
        jf.setVisible(true);
    }
}

package application;

public class Solution extends javax.swing.JFrame {
   
    Integer row, column;
    Integer balan1, balan2, Z;
    Integer[][] money;
    Integer[][] xMN; 
    Integer[] masPredloj;
    Integer[] masSpros;

    public Solution(Integer row, Integer column, Integer balan1, Integer balan2, Integer[][] money, Integer[] masPredloj, Integer[] masSpros, Integer[][] xMN, Integer Z) {
        this.row = row;
        this.column = column;
        this.balan1 = balan1;
        this.balan2 = balan2;
        this.money = money;
        this.masPredloj = masPredloj;
        this.masSpros = masSpros;
        this.xMN = xMN;
        this.Z = Z;
        setLocation(330, 100);
        setResizable(false);
        initComponents();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setPreferredSize(new java.awt.Dimension(700, 550));

        table1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            money,
            new String [] {
                "A", "B", "C", "D", "E", "F", "G"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        table1.setPreferredSize(new java.awt.Dimension(525, 174));
        table1.setRequestFocusEnabled(false);
        table1.setRowHeight(25);
        table1.getTableHeader().setResizingAllowed(false);
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);

        label1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label1.setText("Спрос");

        label2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label2.setText("Предложение");

        label3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        label3.setText("Задача сбалансированна:");
        label3.setToolTipText("");

        label4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label4.setText("Опорный план:");
        label4.setToolTipText("");

        table2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            xMN,
            new String [] {
                "A", "B", "C", "D", "E", "F", "G"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setOpaque(false);
        table2.setPreferredSize(new java.awt.Dimension(525, 174));
        table2.setRowHeight(25);
        table2.getTableHeader().setResizingAllowed(false);
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table2);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Следующий шаг");
        jButton1.setFocusable(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(Integer.toString(balan1) + " = " + Integer.toString(balan2));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(label2))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(label3)
                        .addGap(32, 32, 32))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(label1))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(label4)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(label3)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        label1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        setVisible(false);
        new OnlyAnswer(Z);
    }//GEN-LAST:event_jButton1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JPanel panel;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}

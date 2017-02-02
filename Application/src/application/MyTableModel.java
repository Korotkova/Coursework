package application;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MyTableModel extends AbstractTableModel implements TableModel {

    NorthwestCorner nc;
    
    public MyTableModel(Integer i, Integer j){
        nc = new NorthwestCorner(i, j);
    }
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int r, int c) {
        if(c == 0 && r != getRowCount()) {return r;}
        if(c == getColumnCount() && r == getRowCount()) {return "";}
        if(c == 0) {return "";}
        if(c == getColumnCount()) {return nc.masU[r];}
        if(r == getRowCount() && c != getColumnCount()) {return nc.masV[c];}
        if(c != 0 && r != getRowCount() && c != getColumnCount()) {return nc.xMN[r][c];}
        return "";    }
}

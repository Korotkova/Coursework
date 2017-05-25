package application;

public final class NorthwestCornerMIN {
    
    Integer rows, columns;  
    Integer[] masV;
    Integer[] masU;
    Integer[][] money;
    Integer[][] xMN ;//опорный план
    boolean flagfirstX = false; // как только найдем первую базисную делаем true
    int kI = 0;//строка вводимой переменной в базис
    int kJ = 0;//столбец вводимой переменной в базис
    int vonI = 0;//строка выводимой переменной из базиса
    int vonJ = 0;//столбец выводимой переменной из базиса
    Integer[][] pyti;//для замкнутого цикла
    String pytuperem;
    String children;//для запоминания ячеек
    int kolTochek = 0;
    Integer Z = 0;//ЦФ
    Integer balan1 = 0, balan2 = 0;
    PotentialsMethodForMin method;
    
    public void setMoneyNM() {//расчет баланса и опорного плана
        xMN = new Integer[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                xMN[i][j] = 0;
            }
            xMN[i][columns] = money[i][columns];
            xMN[rows][i] = money[rows][i];
        }
        masU = new Integer[rows];
        for (int i = 0; i < rows; i++) {
            masU[i] = 999999;
        }
        masV = new Integer[columns];
        for (int i = 0; i < columns; i++) {
            masV[i] = 999999;
        }
    }

    public void poiskbazper(int i, int j) {
        xMN[i][j] = Math.min(xMN[i][columns], xMN[rows][j]);
        xMN[i][columns] -= xMN[i][j];
        xMN[rows][j] -= xMN[i][j];
        if (xMN[i][columns] == 0 & xMN[rows][j] != 0) {
            poiskbazper(i + 1, j);
        }
        if (xMN[i][columns] != 0 & xMN[rows][j] == 0) {
            poiskbazper(i, j + 1);
        }
        pyti = new Integer[rows + 1][columns + 1];
        for (i = 0; i < rows + 1; i++) {
            for (j = 0; j < columns + 1; j++) {
                pyti[i][j] = xMN[i][j];
            }
        }
    }

    public boolean vse(){ //проеряет, все ли мы нашли потенциалы, вернет тру если все, иначе волсе
        boolean ot = true;
        for (int i = 0; i < rows; i++) {
           if(masV[i] == 999999) {
           ot = false;
               break;}
        }
        for (int i = 0; i < columns; i++) {
            if(masU[i] == 999999) {
           ot = false;
               break;}
        }
        return ot;
    }

    public void potenshialBaz() {//расчет ЦФ и нахождение потенциалов U,V
        int k = 0;
        while (!vse()) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                   if (xMN[i][j] != 0 & !flagfirstX) {
                        masV[i] = 0;
                        k = i;
                        flagfirstX = true;
                    }
                    if (xMN[i][j] != 0 & flagfirstX) {
                        if (i == k & masV[k] == 0) {
                            masU[j] = money[i][j];
                        }
                        if (masV[i] == 999999 & k != i & masU[j] != 999999) {
                            masV[i] = money[i][j] - masU[j];
                        }
                        if (masU[j] == 999999 & k != i & masV[i] != 999999) {
                            masU[j] = money[i][j] - masV[i];
                        }
                    }
                }
            }
        }
        int Z1=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (xMN[i][j] != 0  & xMN[i][j] != 8888888){
                    Z1 += xMN[i][j] * money[i][j];
                }
            }
        }
        Z = Z1;
        flagfirstX = false;
    }

    public Integer[][] getxMN() {
        return xMN;
    }

    public Integer getZ() {
        return Z;
    }
    
    public void cycle(){
        setMoneyNM();
        poiskbazper(0, 0);
        potenshialBaz();
        method = new PotentialsMethodForMin(rows, columns, money, masV, masU, xMN);
        while(method.potenshialNotBaz()){
            method.forWay();
            method.WayZamknut();
            method.begay();
            potenshialBaz();
        }
    }
    
    public NorthwestCornerMIN(Integer row, Integer column, Integer balan1, Integer balan2, Integer[][] money){
        this.money = money;
        this.rows = row;
        this.columns = column;
        this.balan1 = balan1;
        this.balan2 = balan2;
    }
}

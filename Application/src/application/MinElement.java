package application;

public class MinElement {
 
    Integer rows;
    Integer columns;
    Integer[][] money;
    Integer[][] xMN;
    Integer[][] m;
    Integer[] masU;
    Integer[] masV;
    int min, J, I, sum = 0;
    Integer Z = 0;
    boolean flagfirstX = false; // как только найдем первую базисную делаем true
    boolean s = true;
    
    public MinElement(Integer rows, Integer columns, Integer[][] moneyMN) {
        this.rows = rows;
        this.columns = columns;
        this.money = moneyMN;
    }
    
    public void setMoneyNM() {
        m = new Integer[rows + 1][columns + 1];
        xMN = new Integer[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m[i][j] = money[i][j];
                xMN[i][j] = 0;
            }
        }
        for (int i = 0; i < rows; i++) {
            xMN[i][columns] = money[i][columns];
        }
        for (int j = 0; j < columns; j++) {
            xMN[rows][j] = money[rows][j];
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
      
    public void minArr(){
        min = money[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(money[i][j] != 0){
                    if(min == 0){
                        min = money[i][j];
                        I = i;
                        J = j;
                    }
                    if(money[i][j] < min) {
                        min = money[i][j];
                        I = i;
                        J = j;
                    }
                }
                else if(money[i][j] == 0){
                    sum += money[i][j];
                    s = false;
                }
            }
        }
    }
    
    public void step(){
        poiskbazper(I, J);
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(xMN[rows][j] == 0) cleanSTOLmoney(J);
                if(xMN[i][columns] == 0) cleanSTRmoney(I);
            }
        }
    }
    
    public void poiskbazper(int i, int j){
        xMN[i][j] = Math.min(xMN[i][columns], xMN[rows][j]);
        xMN[i][columns] -= xMN[i][j];
        xMN[rows][j] -= xMN[i][j];
        money[i][columns] -= xMN[i][j];
        money[rows][j] -= xMN[i][j];
    }
    
    public void cleanSTRmoney(int i){
        for(int j = 0; j < columns + 1; j++){
            if(xMN[i][columns] == 0){
                money[i][j] = 0;
            }
        }
    }
    
    public void cleanSTOLmoney(int j) {
        for(int i = 0; i < rows + 1; i++){
            if(xMN[rows][j] == 0) {
                money[i][j] = 0;
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
        Integer Z1 = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (xMN[i][j] != 0  & xMN[i][j] != 8888888){
                    Z1 += xMN[i][j] * m[i][j];
                }
            }
        }
        Z = Z1;
        flagfirstX = false;
    }
     
    public void cycle() {
        setMoneyNM();
        poiskbazper(0, 0);
        for(int i = 0; i < money.length-1; i++){
            if(xMN[i][columns] != 0 || xMN[rows][i] != 0){
                for(int j = 0; j < money[i].length; j++){
                    minArr();
                    step();
                    if(s) break;
                }
            }
        }
        PotentialsMethodForMin method = new PotentialsMethodForMin(rows, columns, money, masV, masU, xMN);
        potenshialBaz();
        while(method.potenshialNotBaz()){
            method.forWay();
            method.WayZamknut();
            method.begay();
            potenshialBaz();
        }
    }

    public Integer[][] getxMN() {
        return xMN;
    }

    public Integer getZ() {
        return Z;
    }

}

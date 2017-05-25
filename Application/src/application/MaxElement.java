package application;

public class MaxElement{
    
    Integer rows;
    Integer columns;
    Integer[][] moneyMN;
    Integer[][] m;
    Integer[][] xMN;
    int  max, sum = 0, I, J;
    boolean s = true;
    Integer Z = 0;
      
    public void setMoneyNM() {
        xMN = new Integer[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                xMN[i][j] = 0;
            }
            xMN[i][columns] = moneyMN[i][columns];
            xMN[rows][i] = moneyMN[rows][i];
        }
    }
    
    public void maxArr(){
        max = moneyMN[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(moneyMN[i][j] != 0){
                    if(max == 0){
                        max = moneyMN[i][j];
                        I = i;
                        J = j;
                    }
                    if(moneyMN[i][j] > max) {
                        max = moneyMN[i][j];
                        I = i;
                        J = j;
                    }
                }
                else if(moneyMN[i][j] == 0){
                    sum += moneyMN[i][j];
                }
            }
        }
        if(sum == 0)    s = false;
    }
     
    public void step(){
        poiskbazper(I, J);
        for(int i = 0; i < rows+1; i++){
            for(int j = 0; j < columns+1; j++){
                if(xMN[rows][j] == 0) cleanSTOLmoney(J);
                if(xMN[i][columns] == 0) cleanSTRmoney(I);
            }
        }
    }
    
    public void poiskbazper(int i, int j){
        xMN[i][j] = Math.min(xMN[i][columns], xMN[rows][j]);
        xMN[i][columns] -= xMN[i][j];
        xMN[rows][j] -= xMN[i][j];
        moneyMN[i][columns] -= xMN[i][j];
        moneyMN[rows][j] -= xMN[i][j];
    }
    
    public void cleanSTRmoney(int i){
        for(int j = 0; j < columns+1; j++){
            if(xMN[i][columns] == 0){
                moneyMN[i][j] = 0;
            }
        }
    }
    
    public void cleanSTOLmoney(int j) {
        for(int i = 0; i < rows + 1; i++){
            if(xMN[rows][j] == 0) {
                moneyMN[i][j] = 0;
            }
        }
    }
    
    public void raschetZ(int i, int j){
        int Z1 = 0;
        Z1 += m[i][j] * xMN[i][j];
        Z += Z1;
    }
    
    public void cycle(){
        for(int i = 0; i < moneyMN.length; i++){
            if(xMN[i][xMN.length - 1] != 0 || xMN[xMN.length - 1][i] != 0){
                for(int j = 0; j < moneyMN[i].length; j++){
                    maxArr();
                    step();
                    raschetZ(I,J);
                    if(s) break;
                }
            }
        }
    }
    
    public void cycles() {
        setMoneyNM();
        cycle();
        PotentialsMethodMAX pm = new PotentialsMethodMAX(m, xMN, rows, columns);
        pm.potenshialBaz();
        while(pm.potenshialNotBaz()){
            pm.forWay();
            pm.WayZamknut();
            pm.begay();
            pm.potenshialBaz();
        }
    }

    public Integer[][] getxMN() {
        return xMN;
    }

    public Integer getZ() {
        return Z;
    }

    public MaxElement(Integer rows, Integer columns, Integer[][] moneyMN) {
        this.rows = rows;
        this.columns = columns;
        this.moneyMN = moneyMN;
    }
}

package application;

public class Elements {
    
    Integer rows, columns;
    Integer[][] money;
    public Integer[][] xMN;
    Integer[][] m;
    Integer Z;
    int I, J;

    public Elements(Integer rows, Integer columns, Integer[][] money) {
        this.rows = rows;
        this.columns = columns;
        this.money = money;
    }

    public void setMoneyNM() {
        xMN = new Integer[rows + 1][columns + 1];
        m = new Integer[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                xMN[i][j] = 0;
            }
            xMN[i][columns] = money[i][columns];
            xMN[rows][i] = money[rows][i];
        }
    }
    
    public void step(){
        poiskbazper(I, J);
        /*for(int i = 0; i < xMN.length; i++){
            for(int j = 0; j < xMN[i].length; j++){
                System.out.print(xMN[i][j] + "\t");
            }
            System.out.println();
        }*/
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
        money[i][columns] -= xMN[i][j];
        money[rows][j] -= xMN[i][j];
    }
    
    public void cleanSTRmoney(int i){
        for(int j = 0; j < columns+1; j++){
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
    
    public void raschetZ(int i, int j){
        int Z1 = 0;
        Z1 += m[i][j] * xMN[i][j];
        Z += Z1;
        //System.out.println(Z1 + "\t" + Z);
    }
     
}

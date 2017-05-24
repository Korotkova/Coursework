package application;

public class MinElement extends Elements {
 
    Integer[][] m;
    Integer min, Z, sum = 0;
    Elements e;
    boolean s = true;

    public MinElement(Integer rows, Integer columns, Integer[][] money) {
        super(rows, columns, money);
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
        //System.out.println("Mинимальный элемент = " + min + " находящийся в строке " + I + "\tв столбце " + J);
    }

    public Integer[][] getxMN() {
        return xMN;
    }
    
    public Integer getZ() {
        return Z;
    }
    
    public void cycle(){
        e = new Elements(rows, columns, money);
        e.setMoneyNM();
        for(int i = 0; i < money.length; i++){
            if(e.xMN[i][e.xMN.length - 1] != 0 || e.xMN[e.xMN.length - 1][i] != 0){
                for(int j = 0; j < money[i].length; j++){
                    /*System.out.println("МАССИВ:");
                    for (Integer[] moneyMN1 : money){
                        for (int k = 0; k < moneyMN1.length; k++){
                            System.out.print(moneyMN1[k] + "\t");
                        }
                        System.out.println();
                    }*/
                    minArr();
                    e.step();
                    e.raschetZ(I,J);
                    if(s) break;
                }
            }
        }
    }
}

package application;

public class MaxElement extends Elements{
    
    Integer rows;
    Integer columns;
    Integer[][] moneyMN;
    Integer[][] m;
    Integer max, Z, sum = 0;
    Elements e;
    boolean s = true;

    public MaxElement(Integer rows, Integer columns, Integer[][] money) {
        super(rows, columns, money);
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
                    s = false;
                }
            }
        }
        //System.out.println("Mаксимальный элемент = " + max + " находящийся в строке " + I + "\tв столбце " + J);
    }
    
    public void cycle(){
        e = new Elements(rows, columns, money);
        e.setMoneyNM();
        for(int i = 0; i < moneyMN.length; i++){
            if(e.xMN[i][e.xMN.length - 1] != 0 || e.xMN[e.xMN.length - 1][i] != 0){
                for(int j = 0; j < moneyMN[i].length; j++){
                    /*System.out.println("МАССИВ:");
                    for (int[] moneyMN1 : moneyMN){
                        for (int k = 0; k < moneyMN1.length; k++){
                            System.out.print(moneyMN1[k] + "\t");
                        }
                        System.out.println();
                    }*/
                    maxArr();
                    e.step();
                    e.raschetZ(I,J);
                    if(s) break;
                }
            }
        }
    } 
}

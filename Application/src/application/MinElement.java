package application;

import java.util.Scanner;

public class MinElement {
    
    int rows;
    int columns;
    int[][] moneyMN;
    int[][] xMN;
    int[][] m;
    int min, J, I, Z, sum = 0;
    boolean s = true;
    
     public void setSprosPredlozhenie() {
        Scanner kons = new Scanner(System.in);
        System.out.print("Количество предложений: ");
        rows = kons.nextInt();
        System.out.print("Количество спроса: ");
        columns = kons.nextInt();
    }
     
    public void setMoneyNM() {
        
        int balan1 = 0, balan2 = 0;

        Scanner kons = new Scanner(System.in);
        moneyMN = new int[rows + 1][columns + 1];
        xMN = new int[rows + 1][columns + 1];
        m = new int[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                xMN[i][j] = 0;
            }
        }

        for (int i = 0; i < rows; i++) {
            System.out.print("Введите стоимость перевозок для " + (i + 1) + "го предложения: ");
            String money = kons.nextLine();
            String sp[] = money.split(" ");
            for (int j = 0; j < columns; j++) {
                moneyMN[i][j] = Integer.parseInt(sp[j]);
            }
        }

        System.out.print("Введите значения предложений: ");
        String pred = kons.nextLine();
        String pr[] = pred.split(" ");
        for (int i = 0; i < rows; i++) {
            moneyMN[i][columns] = Integer.parseInt(pr[i]);
            xMN[i][columns] = moneyMN[i][columns];
            balan1 += Integer.parseInt(pr[i]);
        }

        System.out.print("Введите значения спроса: ");
        String spros = kons.nextLine();
        String spr[] = spros.split(" ");
        for (int j = 0; j < columns; j++) {
            moneyMN[rows][j] = Integer.parseInt(spr[j]);
            xMN[rows][j] = moneyMN[rows][j];
            balan2 += Integer.parseInt(spr[j]);
        }

        if (balan1 == balan2){
            System.out.println("Задача сбалансирована " + balan1 + " = " + balan2);
            for (int i = 0; i < rows + 1; i++) {
                for (int j = 0; j < columns + 1; j++) {
                    m[i][j] = moneyMN[i][j];
                    System.out.print(moneyMN[i][j] + "\t");
                }
                System.out.println();
            }
        }
        
    }
      
    public void minArr(){
        min = moneyMN[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(moneyMN[i][j] != 0){
                    if(min == 0){
                        min = moneyMN[i][j];
                        I = i;
                        J = j;
                    }
                    if(moneyMN[i][j] < min) {
                        min = moneyMN[i][j];
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
        System.out.println("Mинимальный элемент = " + min + " находящийся в строке " + I + "\tв столбце " + J);
    }
    
    public void step(){
        poiskbazper(I, J);
        for(int i = 0; i < xMN.length; i++){
            for(int j = 0; j < xMN[i].length; j++){
                System.out.print(xMN[i][j] + "\t");
            }
            System.out.println();
        }
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
        System.out.println(Z1 + "\t" + Z);
    }
    
    public void cycle(){
        
        for(int i = 0; i < moneyMN.length; i++){
            if(xMN[i][xMN.length - 1] != 0 || xMN[xMN.length - 1][i] != 0){
                for(int j = 0; j < moneyMN[i].length; j++){
                    System.out.println("МАССИВ:");
                    for (int[] moneyMN1 : moneyMN){
                        for (int k = 0; k < moneyMN1.length; k++){
                            System.out.print(moneyMN1[k] + "\t");
                        }
                        System.out.println();
                    }
                    minArr();
                    step();
                    raschetZ(I,J);
                    if(s) break;
                }
            }
        }
    }
}

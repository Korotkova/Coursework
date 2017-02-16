package application;

import java.util.Scanner;

public class Fogel {
    
    int rows, columns, min1, min2, min12, max1, max2, max3 = 0;
    int[] masU;
    int[] masV;
    static int[][] moneyMN;
    int[][] xMN;//опорный план
    int[] difcol;//массив разности столбца
    int[] difrow;//массив разности строки
    boolean flagfirstX = false; // как только найдем первую базисную делаем true
    int kI = 0;//строка вводимой переменной в базис
    int kJ = 0;//столбец вводимой переменной в базис
    int vonI = 0;//строка выводимой переменной из базиса
    int vonJ = 0;//столбец выводимой переменной из базиса
    int[][] pyti;//для замкнутого цикла
    String pytuperem;
    String children;//для запоминания ячеек
    int kolTochek = 0;
    int Z = 0;//ЦФ
    int balan1 = 0, balan2 = 0;
    int I = 0, J = 0;//фиксирование строки/столбца, в которых находится max
    
    public void setSprosPredlozhenie() {
        Scanner kons = new Scanner(System.in);
        System.out.print("Количество строк: ");
        rows = kons.nextInt();
        System.out.print("Количество столбцов: ");
        columns = kons.nextInt();
    }

    public void setMoneyNM() {
        masU = new int[rows];
        for (int i = 0; i < rows; i++) {
            masU[i] = 999999;
        }
        masV = new int[columns];
        for (int i = 0; i < columns; i++) {
            masV[i] = 999999;
        }
        Scanner kons = new Scanner(System.in);
        moneyMN = new int[rows + 2][columns + 2];
        xMN = new int[rows + 1][columns + 1];
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

        difcolumn();
        difrow();
        if (balan1 == balan2) {
            System.out.println("Задача сбалансирована " + balan1 + " = " + balan2);
            for (int i = 0; i < rows + 1; i++) {
                for (int j = 0; j < columns + 1; j++) {
                    System.out.print(moneyMN[i][j] + "\t");
                }
                System.out.println();
            }
        }
        for(int i = 0; i < rows; i++){
                moneyMN[moneyMN.length - 1][i] = difrow[i];
        }
        for(int j = 0; j < columns; j++){
            moneyMN[j][moneyMN.length - 1] = difcol[j];
        }
        
        System.out.println("Метод Фогеля");
        for(int i = 0; i < moneyMN.length; i++){
            for(int j = 0; j < moneyMN[i].length; j++){
                System.out.print(moneyMN[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void difcolumn(){
        difcol = new int[rows];
        System.out.println("Одномерный массив строки");
        for(int i = 0; i < rows; i++) {
            min1 = moneyMN[i][0];
            min2 = moneyMN[i][1];
            for(int j = 2; j < columns; j++){
                if(moneyMN[i][j] < min2) {
                    if(moneyMN[i][j] < min1) {
                            if(min1 < min2)
                                min2 = moneyMN[i][j];
                            else min1 = moneyMN[i][j];
                    }
                    else min2 = moneyMN[i][j];
                }
                else if(moneyMN[i][j] < min1)   min1 = moneyMN[i][j];
                }
            min12 = Math.abs(min1 - min2);
            difcol[i] += min12;
        }
        for(int i = 0; i < difcol.length; i++){
            System.out.print(difcol[i] + "\t");
        }
        System.out.println();
    }
    
    public void difrow(){
        difrow = new int[columns];
        System.out.println("Одномерный массив столбца");
        for(int i = 0; i < columns; i++) {
            min1 = moneyMN[0][i];
            min2 = moneyMN[1][i];
            for(int j = 2; j < rows; j++){
                if(moneyMN[j][i] < min2) {
                    if(moneyMN[j][i] < min1) {
                            if(min1 < min2)
                                min2 = moneyMN[j][i];
                            else min1 = moneyMN[j][i];
                    }
                    else min2 = moneyMN[j][i];
                }
                else if(moneyMN[j][i] < min1)   min1 = moneyMN[j][i];
                }
            min12 = Math.abs(min1 - min2);
            difrow[i] += min12;
        }
        for(int i = 0; i < difrow.length; i++){
            System.out.print(difrow[i] + "\t");
        }
        System.out.println();
    }
    
    public void maxRowColumn(){
        for(int i = 0; i < moneyMN.length; i++){
            max1 = moneyMN[moneyMN.length-1][i];
            for(int j = 0; j < moneyMN.length; j++){
                if(moneyMN[i][j] > max1){
                    max1 = moneyMN[i][j];
                    J = j + 1;
                }
            }
        }
        System.out.println("Наибольшая из разностей в строке " + max1 + "   " + J);
        
        for(int j = 0; j < moneyMN.length; j++){
            max2 = moneyMN[j][moneyMN.length-1];
            for (int i = 0; i < moneyMN.length; i++) {
                if (moneyMN[i][j] > max2) {
                    max2 = moneyMN[i][j];
                    I = i + 1;
                }
            }
        }
        System.out.println("Наибольшая из разностей в столбце " + max2 + "  " + I);
        
        max3 = Math.max(max1, max2);
        System.out.println("Наибольшая из разностей " + max3);
    }
    
    public void pereshet() {
        //фиксирую строчку и бегаю по ней
        int st, t = J - 1;
        if(max3 == max1){
            st = moneyMN[0][t];
            for(int j = 1; j < columns; j++){
                if (moneyMN[j][t] < st) st = moneyMN[j][t];
            }
            System.out.println(st);
        }
        else if(max3 == max2){
            //фиксирую столбец и бегаю по столбцу
            int sl, t1 = I - 1;
            sl = moneyMN[t1][0];
            for (int i = 1; i < rows; i++) {
                if(moneyMN[t1][i] < sl) sl = moneyMN[t1][i];
            }
            System.out.println(sl);
        }
    }
    
    public void minForMaxRowColumn() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (max3 == moneyMN[i][j]) {
                    kI = i;
                    kJ = j;
                    
                    System.out.println("Для x[" + (kI + 1) + "][" + (kJ + 1) + "] = " + min1);
                }
            }
        } 
    }
}

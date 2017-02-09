package application;

import java.util.Scanner;

public class Fogel {
    
    int rows, columns, min1, min2, min12, max1, max2, max3;
    int[] masU;
    int[] masV;
    int[][] moneyMN;
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
    
    public Fogel() {
        
    }  
    
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
        moneyMN = new int[rows + 1][columns + 1];
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

        difcolumn(moneyMN);
        difrow(moneyMN);
        if (balan1 == balan2) {
            System.out.println("Задача сбалансирована " + balan1 + " = " + balan2);
            for (int i = 0; i < rows + 1; i++) {
                for (int j = 0; j < columns + 1; j++) {
                    System.out.print(moneyMN[i][j] + "\t");
                }
                System.out.println();
            }
        }
        for(int i = 0; i < rows+2; i++){
            if(i == moneyMN.length+2){
                moneyMN[i][columns] = difrow[i];
            }
        }
        for(int j = 0; j < columns; j++){
            moneyMN[rows][j] = difcol[j];
        }
        
        System.out.println("Матрица");
        for(int i = 0; i < moneyMN.length; i++){
            for(int j = 0; j < moneyMN[i].length; j++){
                System.out.print(moneyMN[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public void difcolumn(int[][]mon){
        difcol = new int[rows];
        System.out.println("Одномерный массив строки");
        for(int i = 0; i < rows; i++) {
            min1 = mon[i][0];
            min2 = mon[i][1];
            for(int j = 2; j < columns; j++){
                if(mon[i][j] < min2) {
                    if(mon[i][j] < min1) {
                            if(min1 < min2)
                                min2 = mon[i][j];
                            else min1 = mon[i][j];
                    }
                    else min2 = mon[i][j];
                }
                else if(mon[i][j] < min1)   min1 = mon[i][j];
                }
            min12 = Math.abs(min1 - min2);
            difcol[i] += min12;
        }
        for(int i = 0; i < difcol.length; i++){
            System.out.print(difcol[i] + "\t");
        }
        System.out.println();
    }
    
    public void difrow(int[][]mon){
        difrow = new int[columns];
        System.out.println("Одномерный массив столбца");
        for(int i = 0; i < columns; i++) {
            min1 = mon[0][i];
            min2 = mon[1][i];
            for(int j = 2; j < rows; j++){
                if(mon[j][i] < min2) {
                    if(mon[j][i] < min1) {
                            if(min1 < min2)
                                min2 = mon[j][i];
                            else min1 = mon[j][i];
                    }
                    else min2 = mon[j][i];
                }
                else if(mon[j][i] < min1)   min1 = mon[j][i];
                }
            min12 = Math.abs(min1 - min2);
            difrow[i] += min12;
        }
        for(int i = 0; i < difrow.length; i++){
            System.out.print(difrow[i] + "\t");
        }
        System.out.println();
    }
    
    public void maxRowColumn(int[][] mas){
        /*for(int i = 0; i < mas.length - 1; i++){
            max2 = mas[i][0];
            for(int j = 0; j < mas[i].length - 1; j++){
                max1 = mas[0][j];
                if(mas[i][j] > max1)    max1 = mas[i][j];
                if(mas[i][j] > max2)    max2 = mas[i][j];
                max3 = Math.max(max1, max2);
            }
            System.out.println("Наибольшая из разностей " + max3 + " , но наименьший из тарифов является ");
        }
            */
        max1 = difrow[0];
        max2 = difcol[0];
        for(int i = 1; i < rows & i < columns; i++){
            if(difrow[i] > max1) max1 = difrow[i];
            if(difcol[i] > max2) max2 = difcol[i];
            max3 = Math.max(max1, max2);
        }
        System.out.println("Наибольшая разность " + max3);
    }
}

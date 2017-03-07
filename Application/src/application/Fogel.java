package application;

import java.util.Scanner;

public class Fogel {
    
    int rows, columns;
    int min1, min2, min12;//две разности и их разность по abs
    int max1, max2, max3 = 0;
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
    int[][] basic;//массив опорного плана
    String pytuperem;
    String children;//для запоминания ячеек
    int kolTochek = 0;
    int Z = 0;//ЦФ
    int balan1 = 0, balan2 = 0;
    int mI, mJ;//минимальный в фиксированной строке/столбце
    int I = 0, J = 0;//фиксирование строки/столбца, в которых находится max
    int I1 = 0, J1 = 0;//второе фиксирование строки/столбца
    
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

        if (balan1 == balan2) {
            System.out.println("Задача сбалансирована " + balan1 + " = " + balan2);
            for (int i = 0; i < rows + 1; i++) {
                for (int j = 0; j < columns + 1; j++) {
                    System.out.print(moneyMN[i][j] + "\t");
                }
                System.out.println();
            }
        }
        System.out.println("Метод Фогеля");
        cycle();
    }
    
    public void difcolumn(){//поиск разности 2-х минимальных в строках
        difcol = new int[rows];
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
        for(int j = 0; j < columns; j++){
            moneyMN[j][moneyMN.length - 1] = difcol[j];
        }
    }
    
    public void difrow(){//поиск разности 2-х минимальных в столбцах
        difrow = new int[columns];
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
        for(int i = 0; i < rows; i++){
                moneyMN[moneyMN.length - 1][i] = difrow[i];
        }
    }
    
    public void maxRowColumn(){//посик максимального в последней строке/столбца и фиксирование стобца/строки
        for(int i = 0; i < moneyMN.length; i++){
            max1 = moneyMN[moneyMN.length - 1][i];
            for(int j = 0; j < moneyMN.length; j++){
                if(moneyMN[i][j] > max1){
                    max1 = moneyMN[i][j];
                    J = j;
                }
            }
        }
        System.out.println("Наибольшая из разностей в строке " + max1 + "   " + J);
        
        for(int j = 0; j < moneyMN.length; j++){
            max2 = moneyMN[j][moneyMN.length - 1];
            for (int i = 0; i < moneyMN.length; i++) {
                if (moneyMN[i][j] > max2) {
                    max2 = moneyMN[i][j];
                    I = i;
                }
            }
        }
        System.out.println("Наибольшая из разностей в столбце " + max2 + "  " + I);
        
        max3 = Math.max(max1, max2);
        System.out.println("Наибольшая из разностей " + max3);
    }
    
    public void minRowsColumns() {//поиск минимального в столбце/строке наибольшего из разностей
        //фиксирую строчку и бегаю по ней
        int t = J;
        if(max3 == max1){
            mI = moneyMN[0][t];
            for(int j = t; j < columns; j++){
                for (int i = 1; i < rows; i++) {
                    if (moneyMN[i][t] < mI) {
                        mI = moneyMN[i][t];
                        I1 = i;
                    }
                    else if(mI == moneyMN[0][t]) I1 = 0;
                }
            }
            System.out.println("В столбце " + J + " минимальный элемент = " + mI + "\t" + I1);
        }
        
        //фиксирую столбец и бегаю по столбцу
        else if(max3 == max2){
            int t1 = I - 1;
            mJ = moneyMN[t1][0];
            for(int i = t1; i < rows; i++){
                for(int j = 1; j < columns; j++){
                    if(moneyMN[t1][j] < mJ){
                        mJ = moneyMN[t1][j];
                        J1 = j;
                    }
                    else if(mJ == moneyMN[t1][0]) J1 = 0;
                }
            }
            System.out.println("В строке " + I + " минимальный элемент = " + mJ + "\t" + J1);
        }
    }
    
    public void poiskbazper(int i, int j) {
        xMN[i][j] = Math.min(xMN[i][xMN.length - 1], xMN[xMN.length - 1][j]);
        xMN[i][xMN.length - 1] -= xMN[i][j];
        xMN[xMN.length - 1][j] -= xMN[i][j];
        
        pyti = new int[rows + 1][columns + 1];
        for (i = 0; i < rows + 1; i++) {
            for (j = 0; j < columns + 1; j++) {
                pyti[i][j] = xMN[i][j];
            }
        }
    }
    
    public void basicPlan(){
        System.out.println("Опорный план:");
        if(max3 == max1){
            poiskbazper(I1, J);
        }
        else poiskbazper(I, J1);
        
        for (int[] xMN1 : xMN) {//распечатка опорного плана
            for (int j = 0; j < xMN1.length; j++) {
                System.out.print(xMN1[j] + "\t");
            }
            System.out.println();
        }
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < columns + 1; j++) {
                basic[i][j] = xMN[i][j];
            }
        }
    }
    
    public void invisibleRowOrColumn(){//невидимые столбец и строка
        for (int i = 0; i < xMN.length; i++) {
            for (int j = 0; j < xMN[i].length; j++) {
                if (xMN[xMN.length - 1][j] == 0) {
                    cleanSTOLxMN();
                } else if (xMN[i][xMN.length - 1] == 0) {
                    cleanSTRxMN();
                }
            }
        }
        System.out.println();
        /*System.out.println("лорпащгн");
        for (int[] xMN1 : xMN) {
            for (int j = 0; j < xMN1.length; j++) {
                System.out.print(xMN1[j] + "\t");
            }
            System.out.println();
        }*/
        System.out.println("База:");
        for (int[] basic1 : basic) {
            for (int j = 0; j < basic1.length; j++) {
                System.out.print(basic1[j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for(int i = 0; i < moneyMN.length-1; i++){
            for(int j = 0; j < moneyMN[i].length-1; j++){
                if(xMN[xMN.length - 1][j] == 0) {
                    cleanSTOLmoney(J);
                } else if(xMN[i][xMN.length - 1] == 0){
                    cleanSTRmoney(I);
                }
            }
        }
    }
    
    public void cleanSTRxMN() {
        for(int i = 0; i < xMN.length - 1; i++){
            for (int j = 0; j < xMN[i].length - 1; j++){
                if(xMN[i][xMN.length - 1] == 0) {
                    xMN[i][j] = 0;
                }
            }
        }
    }
    
    public void cleanSTOLxMN() {
        for(int i = 0; i < xMN.length - 1; i++){
            for(int j = 0; j < xMN[i].length - 1; j++){
                if(xMN[xMN.length - 1 ][j] == 0) {
                    xMN[i][j] = 0;
                }
            }
        }
    }
    
    public void cleanSTRmoney(int i){
        for(int j = 0; j < xMN[i].length; j++){
            if(xMN[i][xMN.length - 1] == 0){
                moneyMN[i][j] = 0;
            }
        }
    }
    
    public void cleanSTOLmoney(int j) {
        for(int i = 0; i < xMN.length; i++){
            if(xMN[xMN.length - 1][j] == 0) {
                moneyMN[i][j] = 0;
            }
        }
    }
    
    public void cycle(){
        System.out.println("МАССИВ:");
        for(int i = 0; i < moneyMN.length; i++){
            for(int j = 0; j < moneyMN[i].length; j++){
                if(xMN[xMN.length - 1][j] != 0 && xMN[i][xMN.length - 1] != 0){
                    difcolumn();
                    difrow();
                    for (int[] moneyMN1 : moneyMN){
                        for (int k = 0; k < moneyMN1.length; k++){
                            System.out.print(moneyMN1[k] + "\t");
                        }
                        System.out.println();
                    }
                    maxRowColumn();
                    minRowsColumns();
                    basicPlan();
                    invisibleRowOrColumn();
                    cleanSTOLmoney(J1);
                    cleanSTRmoney(I1);
                }
            }
        }
    }
}

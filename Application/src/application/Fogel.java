package application;

import java.util.Scanner;

public class Fogel {
    
    int rows, columns, min1, min2;
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

        if (balan1 == balan2) {
            System.out.println("Задача сбалансирована " + balan1 + " = " + balan2);
            for (int i = 0; i < rows + 1; i++) {
                for (int j = 0; j < columns + 1; j++) {
                    System.out.print(moneyMN[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}

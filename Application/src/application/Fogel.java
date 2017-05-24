package application;

public class Fogel {
    
    Integer rows, columns;
    int min1, min2, min12;//две разности и их разность по abs
    int max1, max2, max3 = 0;
    Integer[] masSpros;
    Integer[] masPredloj;
    static Integer[][] money;
    Integer[][] xMN;//опорный план
    int[] difcol;//массив разности столбца
    int[] difrow;//массив разности строки
    boolean flagfirstX = false; // как только найдем первую базисную делаем true
    int kI = 0;//строка вводимой переменной в базис
    int kJ = 0;//столбец вводимой переменной в базис
    int vonI = 0;//строка выводимой переменной из базиса
    int vonJ = 0;//столбец выводимой переменной из базиса
    int[][] pyti;//для замкнутого цикла
    Integer[][] basic;//массив опорного плана
    String pytuperem;
    String children;//для запоминания ячеек
    int kolTochek = 0;
    Integer Z = 0;//ЦФ
    Integer balan1 = 0, balan2 = 0;
    int mI, mJ;//минимальный в фиксированной строке/столбце
    int I = 0, J = 0;//фиксирование строки/столбца, в которых находится max
    int I1 = 0, J1 = 0;//второе фиксирование строки/столбца
    int invI, invJ;//невидимые строка/столбец
    
    public Fogel(Integer row, Integer column, Integer balan1, Integer balan2, Integer[][] money, Integer[] masPredloj, Integer[] masSpros){
        this.money = money;
        this.rows = row;
        this.columns = column;
        this.balan1 = balan1;
        this.balan2 = balan2;
        this.masPredloj = masPredloj;
        this.masSpros = masSpros;
    }

    public void setMoneyNM() {
        basic = new Integer[rows + 1][columns + 1];
        xMN = new Integer[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                xMN[i][j] = 0;
            }
            xMN[i][columns] = money[i][columns];
            xMN[rows][i] = money[rows][i];
        }
    }
    
    public void difcolumn(){//поиск разности 2-х минимальных в строках
        difcol = new int[rows];
        for(int i = 0; i < money.length - 2; i++) {
            min1 = money[i][0];
            min2 = money[i][1];
            if((min1 == 0) & (min2 != 0)){
                min1 = money[i][2];
            }
            else if((min2 == 0) & (min1 != 0)){
                min2 = money[i][2];
            }
            for(int j = 2; j < money[i].length - 2; j++){
                if(money[i][j] == 0){//если на складе 0
                    j++;
                    continue;
                }
                if(money[i][j] != 0){
                    if(money[i][j] < min2) {
                        if(money[i][j] < min1) {
                            if(min1 < min2)
                                min2 = money[i][j];
                            else min1 = money[i][j];
                        }
                        else min2 = money[i][j];
                    }
                    else if(money[i][j] < min1)   min1 = money[i][j];
                }
            }
            min12 = Math.abs(min1 - min2);
            difcol[i] += min12;
            for(int j = 0; j < columns; j++){
                money[j][money.length - 1] = difcol[j];
            }
        }
    }
    
    public void difrow(){//поиск разности 2-х минимальных в столбцах
        difrow = new int[columns];
        for(int i = 0; i < money.length - 2; i++) {
            min1 = money[0][i];
            min2 = money[1][i];
            if((min1 == 0) & (min2 != 0)){
                min1 = money[2][i];
            }
            else if((min2 == 0) & (min1 != 0)){
                min2 = money[2][i];
            }
            for(int j = 2; j < money[i].length - 2; j++){
                if(money[j][i] == 0){//если на складе 0
                    j++;
                    continue;
                }
                if(money[j][i] != 0){
                    if(money[j][i] < min2) {
                        if(money[j][i] < min1) {
                            if(min1 < min2)
                                min2 = money[j][i];
                            else min1 = money[j][i];
                        }
                        else min2 = money[j][i];
                    }
                    else if(money[j][i] < min1)   min1 = money[j][i];
                }
            }
            min12 = Math.abs(min1 - min2);
            difrow[i] += min12;
        }
        for(int i = 0; i < rows; i++){
                money[money.length - 1][i] = difrow[i];
        }
    }
    
    public void maxRowColumn(){//посик максимального в последней строке/столбца и фиксирование стобца/строки
        for(int i = 0; i < money.length; i++){
            max1 = money[money.length - 1][i];
            for(int j = 0; j < money.length; j++){
                if(money[i][j] > max1){
                    max1 = money[i][j];
                    J = j;
                }
            }
        }
        //System.out.println("Наибольшая из разностей в строке " + max1 + "   " + J);
        
        for(int j = 0; j < money.length; j++){
            max2 = money[j][money.length - 1];
            for (int i = 0; i < money.length; i++) {
                if (money[i][j] > max2) {
                    max2 = money[i][j];
                    I = i;
                }
            }
        }
        //System.out.println("Наибольшая из разностей в столбце " + max2 + "  " + I);
        
        max3 = Math.max(max1, max2);
        //System.out.println("Наибольшая из разностей " + max3);
    }
    
    public void minRowsColumns() {//поиск минимального в столбце/строке наибольшего из разностей
        //фиксирую строчку и бегаю по ней
        int t = J, h = 0;
        if(max3 == max1){
            mI = money[0][t];
            for(int j = t; j < money.length - 2; j++){
                for (int i = 0; i < money.length - 2; i++) {
                    if(money[i][t] == 0){
                        i++;
                        continue;
                    }
                    if (money[i][t] < mI && money[i][t]!= 0) {
                        mI = money[i][t];
                        I1 = i;
                    }
                    else if(mI == money[0][t]) I1 = 0;
                }
            }
            //System.out.println("В столбце " + J + " минимальный элемент = " + mI + "\t" + I1);
        }
        
        //фиксирую столбец и бегаю по столбцу
        else if(max3 == max2){
            int t1 = I;
            mJ = money[t1][0];
            for(int i = t1; i < money.length - 2; i++){
                for(int j = 0; j < money[i].length - 2; j++){
                    if(money[t1][j] == 0){
                        j++;
                        continue;
                    }
                    if(money[t1][j] < mJ && money[t1][j] != 0){
                        mJ = money[t1][j];
                        J1 = j;
                    }
                    else if(mJ == money[t1][0]) J1 = 0;
                }
            }
            //System.out.println("В строке " + I + " минимальный элемент = " + mJ + "\t" + J1);
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
        //System.out.println("Опорный план:");
        if(max3 == max1){
            poiskbazper(I1, J);
        }
        else poiskbazper(I, J1);
        
       /* for (Integer[] xMN1 : xMN) {//распечатка опорного плана
            for (int j = 0; j < xMN1.length; j++) {
               System.out.print(xMN1[j] + "\t");
            }
           System.out.println();
        }
        for (int i = 0; i < rows; i++) {//распечатка базы
            for (int j = 0; j < columns; j++) {
                basic[i][j] += xMN[i][j];
            }
        }*/
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
        /*System.out.println();
        System.out.println("База:");
        for (int[] basic1 : basic) {
            for (int j = 0; j < basic1.length; j++) {
                System.out.print(basic1[j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/
        for(int i = 0; i < money.length-1; i++){
            for(int j = 0; j < money[i].length-1; j++){
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
                money[i][j] = 0;
            }
        }
    }
    
    public void cleanSTOLmoney(int j) {
        for(int i = 0; i < xMN.length; i++){
            if(xMN[xMN.length - 1][j] == 0) {
                money[i][j] = 0;
            }
        }
    }

    public Integer[][] getBasic() {
        return basic;
    }

    public Integer getZ() {
        return Z;
    }
    
    public void cycle(){
        //System.out.println("МАССИВ:");
        for(int i = 0; i < money.length - 1; i++){
            if(xMN[i][xMN.length - 1] != 0 || xMN[xMN.length - 1][i] != 0){
            for(int j = 0; j < money[i].length; j++){
                    difcolumn();
                    difrow();
                    /*for (Integer[] moneyMN1 : money){
                        for (int k = 0; k < moneyMN1.length; k++){
                            System.out.print(moneyMN1[k] + "\t");
                        }
                        System.out.println();
                    }*/
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

package application;

public final class NorthwestCorner {
    
    Integer rows, columns;
    EnterValuesWindow ew = new EnterValuesWindow(rows, columns);    
    int[][] xMN;//опорный план
    boolean flagfirstX = false; // как только найдем первую базисную делаем true
    int kI = 0;//строка вводимой переменной в базис
    int kJ = 0;//столбец вводимой переменной в базис
    int vonI = 0;//строка выводимой переменной из базиса
    int vonJ = 0;//столбец выводимой переменной из базиса
    int[][] pyti;//для замкнутого цикла
    String pytuperem;
    String children;//для запоминания ячеек
    int kolTochek = 0;
    int Z=0;

    public void setMoneyNM() {
        int balan1 = 0, balan2 = 0;
        for (int i = 0; i < rows; i++) {
            ew.masU[i] = 999999;
        }
        for (int i = 0; i < columns; i++) {
            ew.masV[i] = 999999;
        }
        ew.money = new int[rows + 1][columns + 1];
        xMN = new int[rows + 1][columns + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                xMN[i][j] = 0;
            }
        }

        for (int i = 0; i < rows; i++) {
            ew.money[i][columns] = ew.masU[i];
            xMN[i][columns] = ew.money[i][columns];
            balan1 += ew.masU[i];
        }

        for (int j = 0; j < columns; j++) {
            ew.money[rows][j] = ew.masV[j];
            xMN[rows][j] = ew.money[rows][j];
            balan2 += ew.masV[j];
        }

        if (balan1 == balan2) {
            System.out.println("Задача сбалансирована " + balan1 + " = " + balan2);
            for (int i = 0; i < rows + 1; i++) {
                for (int j = 0; j < columns + 1; j++) {
                    System.out.print(ew.money[i][j] + "\t"); //поместить в JTabble1
                }
                System.out.println();
            }
        }
    }

    public void getxMN() {
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < columns + 1; j++) {
                System.out.print(xMN[i][j] + "\t");//поместить в JTable2
            }
            System.out.println();
        }
    }

    public void poiskbazper(int i, int j) {
        xMN[i][j] = Math.min(xMN[i][columns], xMN[rows][j]);
        xMN[i][columns] -= xMN[i][j];
        xMN[rows][j] -= xMN[i][j];
        if (xMN[i][columns] == 0 & xMN[rows][j] != 0) {
            poiskbazper(i + 1, j);
        }
        if (xMN[i][columns] != 0 & xMN[rows][j] == 0) {
            poiskbazper(i, j + 1);
        }
        pyti = new int[rows + 1][columns + 1];
        for (i = 0; i < rows + 1; i++) {
            for (j = 0; j < columns + 1; j++) {
                pyti[i][j] = xMN[i][j];
            }
        }
    }

    public boolean vse(){ //проеряет, все ли мы нашли потенциалы, вернет тру если все, иначе волсе
        boolean ot = true;
        for (int i = 0; i < rows; i++) {
           if(ew.masU[i] == 999999) {
           ot = false;
               break;}
        }
        for (int i = 0; i < columns; i++) {
            if(ew.masV[i] == 999999) {
           ot = false;
               break;}
        }
        return ot;
    }

    public void potenshialBaz() {
       int k = 0;
       while (!vse())
        {for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
               if (xMN[i][j] != 0 & !flagfirstX) {
                    ew.masU[i] = 0;
                    k = i;
                    flagfirstX = true;
                }
                if (xMN[i][j] != 0 & flagfirstX) {
                    if (i == k & ew.masU[k] == 0) {
                        ew.masV[j] = ew.money[i][j];
                    }
                    if (ew.masU[i] == 999999 & k != i & ew.masV[j] != 999999) {
                        ew.masU[i] = ew.money[i][j] - ew.masV[j];
                        //System.out.println("U[" + (i + 1) + "]=" + moneyMN[i][j] + "-" + masV[j] + "=" + masU[i]);
                    }
                    if (ew.masV[j] == 999999 & k != i & ew.masU[i] != 999999) {
                        ew.masV[j] = ew.money[i][j] - ew.masU[i];
                        //System.out.println("V[" + (j + 1) + "]=" + moneyMN[i][j] + "-" + masU[i] + "=" + masV[j]);
                    }
                }
            }
        }
    }
        int Z1=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (xMN[i][j] != 0  & xMN[i][j] != 8888888){
                    Z1 += xMN[i][j] * ew.money[i][j];
                }
            }
        }
       System.out.println("Оптимальное решение Z = " + Z1 + " ус. ед.");
       Z=Z1;
        flagfirstX = false;
        for (int i = 0; i < rows; i++) {
            System.out.println("U[" + (i + 1) + "] = " + ew.masU[i]);
        }
        for (int j = 0; j < columns; j++) {
            System.out.println("V[" + (j + 1) + "] = " + ew.masV[j]);
        }
    }

    public boolean potenshialNotBaz() {     //если нет больше положительных вернет false
        int perN = 0; 
        int per = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (xMN[i][j] == 0) {
                    per = ew.masU[i] + ew.masV[j] - ew.money[i][j];
                    System.out.println("Для x[" + (i + 1) + "][" + (j + 1) + "]: " + ew.masU[i] + "+" + ew.masV[j] + "-" + ew.money[i][j] + " = " + per);
                    if (per > 0 & per > perN) {
                        perN = per;
                        kI = i;
                        kJ = j;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            ew.masU[i] = 999999;
        }
        for (int i = 0; i < columns; i++) {
            ew.masV[i] = 999999;
        }
          //заполним вводимую в базис переенную значением
        //любое значение, лишь бы не ноль!
        pyti[kI][kJ] = 99999;
        if (perN > 0) {
            System.out.println("Вводимая в БП x[" + (kI + 1) + "][" + (kJ + 1) + "]");
            return true;
        } 
        else {
            return false;
        }
    }

    public void cleanTable() {
        pereshet();
        pereshet();
    }

    public void pereshet() {
      int kol = 0;
        //фиксирую столбец и бегаю по столбцу
        for (int j = 0, i; j < columns; j++) {
            for (i = 0; i < rows; i++) {
                if (pyti[i][j] != 0) {
                    kol++;
                }
            }
            if (kol == 1) {
                cleanSTOl(j);
                pyti[i][j] = 0;
            } 
            else {
                pyti[i][j] = kol;
            }
            kol = 0;
        }
        //фиксирую строчку и бегаю по ней
        for (int i = 0, j; i < rows; i++) {
            for (j = 0; j < columns; j++) {
                if (pyti[i][j] != 0) {
                    kol++;
                }
            }
            if (kol == 1) {
                cleanSTR(i);
                pyti[i][j] = 0;
            } 
            else {
                pyti[i][j] = kol;
            }
            kol = 0;
        }
    }

    public void cleanSTR(int i) {
        for (int j = 0; j < columns; j++) {
            if (pyti[i][j] != 0) {
                pyti[i][j] = 0;
            }
        }
    }

    public void cleanSTOl(int j) {
        for (int i = 0; i < rows; i++) {
            if (pyti[i][j] != 0) {
                pyti[i][j] = 0;
            }
        }
    }

    public boolean proverkaround() {
        boolean flag = true;
        for (int j = 0; j < columns; j++) {
            if (pyti[rows][j] == 1) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            return false;
        } 
        else {
            for (int i = 0; i < rows; i++) {
                if (pyti[i][columns] == 1) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return flag;
    }

    public void forWay() {
       cleanTable();
        while (!proverkaround()) {
            cleanTable();
        }
        System.out.println("Для пути:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(pyti[i][j] == 99999){
                    System.out.print("*" + "\t");}
                else{
                    if(pyti[i][j] == 8888888){
                        System.out.print("0" + "\t");
                    }
                    else System.out.print(pyti[i][j] + "\t");
                    }
            }
            System.out.println();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pyti[i][j] != 0) {
                    kolTochek++;
                }
            }
        }
    }

    public String poiskBSleva(int sr, int st) {
        String ret = "null";
        if (st == 0) {
            return ret;
        } else {
            for (int j = st - 1; j >= 0; j--) {
                if (pyti[sr][j] != 0) {
                    ret = sr + "." + st + "." + sr + "." + j;

                }
            }
        }
        return ret;
    }

    public String poiskBSprava(int sr, int st) {
        String ret = "null";
        if (st == columns - 1) {
            return ret;
        } else {
            for (int j = st + 1; j < columns; j++) {
                if (pyti[sr][j] != 0) {
                    ret = sr + "." + st + "." + sr + "." + j;

                }
            }
        }
        return ret;
    }

    public String poiskBSverhy(int sr, int st) {
        String ret = "null";
        if (sr == 0) {
            return ret;
        } else {
            for (int i = sr - 1; i >= 0; i--) {
                if (pyti[i][st] != 0) {
                    ret = sr + "." + st + "." + i + "." + st;

                }
            }
        }
        return ret;
    }

    public String poiskBSnizy(int sr, int st) {
        String ret = "null";
        if (sr == rows - 1) {
            return ret;
        } else {
            for (int i = sr + 1; i < rows; i++) {
                if (pyti[i][st] != 0) {
                    ret = sr + "." + st + "." + i + "." + st;

                }
            }
        }
        return ret;
    }

    public void SLedyushi(String parakey) {
        String sp[] = parakey.split("\\.");
        int IP = Integer.parseInt(sp[0]);
        int JP = Integer.parseInt(sp[1]);
        int IC = Integer.parseInt(sp[2]);
        int JC = Integer.parseInt(sp[3]);
        String parent = IC + "." + JC + "." + IP + "." + JP;
        if (!poiskBSleva(IC, JC).equals("null") & !poiskBSleva(IC, JC).equals(parent)) {
           //слева зашел
            pytuperem = poiskBSleva(IC, JC);
        } else {
            if (!poiskBSprava(IC, JC).equals("null") & !poiskBSprava(IC, JC).equals(parent)) {
                 //справа
                pytuperem = poiskBSprava(IC, JC);
            } else {
                if (!poiskBSverhy(IC, JC).equals("null") & !poiskBSverhy(IC, JC).equals(parent)) {
                     //сверху
                    pytuperem = poiskBSverhy(IC, JC);
                } else {
                    if (!poiskBSnizy(IC, JC).equals("null") & !poiskBSnizy(IC, JC).equals(parent)) {
                       //снизу
                        pytuperem = poiskBSnizy(IC, JC);
                    }
                }
            }
        }
      //итог
        String sp1[] = pytuperem.split("\\.");
        int bi = Integer.parseInt(sp1[2]);
        int bj = Integer.parseInt(sp1[3]);
        children += bi + "." + bj + ".";
    }
    
    public void WayZamknut() {
        if (!poiskBSleva(kI, kJ).equals("null")) {
            pytuperem = poiskBSleva(kI, kJ);
        } 
        else {
            if (!poiskBSprava(kI, kJ).equals("null")) {
                pytuperem = poiskBSprava(kI, kJ);
            } 
            else {
                if (!poiskBSverhy(kI, kJ).equals("null")) {
                    pytuperem = poiskBSverhy(kI, kJ);
                } 
                else {
                    if (!poiskBSnizy(kI, kJ).equals("null")) {
                        pytuperem = poiskBSnizy(kI, kJ);
                    }
                }
            }
        }
        String sp[] = pytuperem.split("\\.");
        int bi = Integer.parseInt(sp[2]);
        int bj = Integer.parseInt(sp[3]);
        children = bi + "." + bj + ".";
        for (int i = 1; i < kolTochek; i++) {
            SLedyushi(pytuperem);
        }
    }
    
    public void begay() {
    for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (pyti[i][j] == 8888888) {
                    xMN[i][j] = 0;
                pyti[i][j] = 0;
                }
            }
        }
        pyti[kI][kJ] = 0;
        int xyT[] = new int[kolTochek * 2];
        String sp[] = children.split("\\.");
        for (int i = 0; i < xyT.length; i++) {
            xyT[i] = Integer.parseInt(sp[i]);
        }
        int minOTRIc = pyti[xyT[0]][xyT[1]];
        //бегаю по "-" ищу минимальное среди них
        for (int i = 0; i < xyT.length;) {
            if (minOTRIc > pyti[xyT[i]][xyT[i + 1]]) {
                minOTRIc = pyti[xyT[i]][xyT[i + 1]];
            }
            if (i % 2 == 0) {
                i += 4;
            }
        }
        System.out.println("Минимальное значение БП со знаком \"-\": " + minOTRIc);
        //теперь отнимаю минимальное у "-"
        for (int i = 0; i < xyT.length;) {
            xMN[xyT[i]][xyT[i + 1]] -= minOTRIc;
            if (i % 2 == 0) {
                i += 4;
            }
        }
        //прибавляю минимальное у "+"
        for (int i = 2; i < xyT.length;) {
            xMN[xyT[i]][xyT[i + 1]] += minOTRIc;
            if (i % 2 == 0) {
                i += 4;
            }
        }
        boolean flagNashel = false;
        for (int i = 0; i < xyT.length; i += 2) {
            if (xMN[xyT[i]][xyT[i + 1]] == 0 & !flagNashel) {
                vonI = xyT[i];
                vonJ = xyT[i + 1];
                flagNashel = true;
                //нашёл первую нулевую
            }
            if (xMN[xyT[i]][xyT[i + 1]] == 0 & flagNashel & (vonI != xyT[i] | vonJ != xyT[i + 1])){
            //если у нас несколько обнулится со знаком минус 
            //но они все равно базисные нужно им присвоить значение, чтобы их не потерять!
            //вдруг ноль
                xMN[xyT[i]][xyT[i + 1]] = 8888888;
            }
        }
        System.out.println("Выводимая из БП х[" + (vonI + 1) + "][" + (vonJ + 1) + "]");
        kolTochek = 0;
       //После вывода
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pyti[i][j] = xMN[i][j];
            }
        }
    }
    
    public NorthwestCorner(Integer spros, Integer predloj){
        
        rows = spros; columns = predloj;
        
        while(potenshialNotBaz()){
            forWay();
            WayZamknut();
            begay();
            potenshialBaz();
        }
        System.out.println("Отрицательных потенциалов нет\nНевозможно уменьшить стоимость доставки продукции");
        System.out.println("Ответ:");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(xMN[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Z = " + Z + " ус. ед.");
    }
}


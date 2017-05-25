package application;

public class PotentialsMethodMAX {
    
    Integer m;//предложение -i-строки
    Integer n;//спрос - j - столбцы
    Integer[][] moneyMN;
    Integer[][] xMN;
    Integer[] masU;
    Integer[] masV;
    boolean flagfirstX = false; // как только найдем первую базисную делаем true
    int kI = 0;//строка вводимой переменной в базис
    int kJ = 0;//столбец вводимой переменной в базис
    int vonI = 0;//строка выводимой переменной из базиса
    int vonJ = 0;//столбец выводимой переменной из базиса
    int[][] pyti;//для замкнутого цикла
    String pytuperem;
    String children;//для запоминания ячеек
    int kolTochek = 0;
    Integer Z = 0;
    
    public PotentialsMethodMAX(Integer[][] m, Integer[][] xMN, Integer row, Integer column) {
        this.m = row;
        this.n = column;
        this.xMN = xMN;
        this.moneyMN = m;
    }
    
    public boolean vse(){ //проеряет, все ли мы нашли потенциалы, вернет тру если все, иначе волсе
        boolean ot = true;
        for (int i = 0; i < m; i++) {
           if(masU[i] == 999999) {
           ot = false;
               break;}
        }
        for (int i = 0; i < n; i++) {
            if(masV[i] == 999999) {
           ot = false;
               break;}
        }
        return ot;
    }
    
    public void potenshialBaz() {
        masU = new Integer[m];
        for (int i = 0; i < m; i++) {
            masU[i] = 999999;
        }
        masV = new Integer[n];
        for (int i = 0; i < n; i++) {
            masV[i] = 999999;
        }
        pyti = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                pyti[i][j] = xMN[i][j];
            }
        }
        int k = 0;
        while (!vse()){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (xMN[i][j] != 0 & !flagfirstX) {
                        masU[i] = 0;
                        k = i;
                        flagfirstX = true;
                    }
                    if (xMN[i][j] != 0 & flagfirstX) {
                        if (i == k & masU[k] == 0) {
                            masV[j] = moneyMN[i][j];
                        }
                        if (masU[i] == 999999 & k != i & masV[j] != 999999) {
                            masU[i] = moneyMN[i][j] - masV[j];
                        }
                        if (masV[j] == 999999 & k != i & masU[i] != 999999) {
                            masV[j] = moneyMN[i][j] - masU[i];
                        }
                    }
                }
            }
        }
        int Z1=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (xMN[i][j] != 0  & xMN[i][j] != 8888888){
                    Z1 += xMN[i][j] * moneyMN[i][j];
                }
            }
        }
        System.out.println("Оптимальное решение Z = " + Z1 + " ус. ед.");
        Z = Z1;
        flagfirstX = false;
        for (int i = 0; i < m; i++) {
            System.out.println("U[" + (i + 1) + "] = " + masU[i]);
        }
        for (int j = 0; j < n; j++) {
            System.out.println("V[" + (j + 1) + "] = " + masV[j]);
        }
    }
     
    public boolean potenshialNotBaz() {//если нет больше положительных вернет false
        int perN = 0; 
        int per = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (xMN[i][j] == 0) {
                    per = masU[i] + masV[j] - moneyMN[i][j];
                    System.out.println("Для x[" + (i + 1) + "][" + (j + 1) + "]: " + masU[i] + "+" + masV[j] + "-" + moneyMN[i][j] + " = " + per);
                    if (per < 0 & per < perN) {
                        perN = per;
                        kI = i;
                        kJ = j;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            masU[i] = 999999;
        }
        for (int i = 0; i < n; i++) {
            masV[i] = 999999;
        }
          //заполним вводимую в базис переенную значением
        //любое значение, лишь бы не ноль!
        pyti[kI][kJ] = 99999;
        if (perN < 0) {
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
        for (int j = 0, i; j < n; j++) {
            for (i = 0; i < m; i++) {
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
        for (int i = 0, j; i < m; i++) {
            for (j = 0; j < n; j++) {
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
        for (int j = 0; j < n; j++) {
            if (pyti[i][j] != 0) {
                pyti[i][j] = 0;
            }
        }
    }

    public void cleanSTOl(int j) {
        for (int i = 0; i < m; i++) {
            if (pyti[i][j] != 0) {
                pyti[i][j] = 0;
            }
        }
    }

    public boolean proverkaround() {
        boolean flag = true;
        for (int j = 0; j < n; j++) {
            if (pyti[m][j] == 1) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            return false;
        } 
        else {
            for (int i = 0; i < m; i++) {
                if (pyti[i][n] == 1) {
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        if (st == n - 1) {
            return ret;
        } else {
            for (int j = st + 1; j < n; j++) {
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
        if (sr == m - 1) {
            return ret;
        } else {
            for (int i = sr + 1; i < m; i++) {
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
            pytuperem = poiskBSleva(IC, JC);
        } else {
            if (!poiskBSprava(IC, JC).equals("null") & !poiskBSprava(IC, JC).equals(parent)) {
                pytuperem = poiskBSprava(IC, JC);
            } else {
                if (!poiskBSverhy(IC, JC).equals("null") & !poiskBSverhy(IC, JC).equals(parent)) {
                    pytuperem = poiskBSverhy(IC, JC);
                } else {
                    if (!poiskBSnizy(IC, JC).equals("null") & !poiskBSnizy(IC, JC).equals(parent)) {
                        pytuperem = poiskBSnizy(IC, JC);
                    }
                }
            }
        }
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
    for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
            }
            if (xMN[xyT[i]][xyT[i + 1]] == 0 & flagNashel & (vonI != xyT[i] | vonJ != xyT[i + 1])){
            //если у нас несколько обнулится со знаком минус 
            //но они все равно базисные нужно им присвоить значение, чтобы их не потерять!
                xMN[xyT[i]][xyT[i + 1]] = 8888888;
            }
        }
        System.out.println("Выводимая из БП х[" + (vonI + 1) + "][" + (vonJ + 1) + "]");
        kolTochek = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pyti[i][j] = xMN[i][j];
            }
        }
    }
}
package application;

public class PotentialsMethodMIN extends PotentialsMethod{

    Integer m;//предложение -i-строки
    Integer n;//спрос - j - столбцы
    Integer[][] moneyMN;
    Integer[][] xMN;

    public PotentialsMethodMIN(Integer m, Integer n, Integer[][] moneyMN, Integer[][] xMN, Integer row, Integer column, Integer[][] money, Integer[] masPredloj, Integer[] masSpros, Integer[][] xmn) {
        super(row, column, money, masPredloj, masSpros, xmn);
        this.m = m;
        this.n = n;
        this.moneyMN = moneyMN;
        this.xMN = xMN;
    }

    public boolean potenshialNotBaz() {//если нет больше положительных вернет false
        int perN = 0; 
        int per = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (xMN[i][j] == 0) {
                    per = masSpros[i] + masPredloj[j] - moneyMN[i][j];
                    System.out.println("Для x[" + (i + 1) + "][" + (j + 1) + "]: " + masSpros[i] + "+" + masPredloj[j] + "-" + moneyMN[i][j] + " = " + per);
                    if (per > 0 & per > perN) {
                        perN = per;
                        kI = i;
                        kJ = j;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            masSpros[i] = 999999;
        }
        for (int i = 0; i < n; i++) {
            masPredloj[i] = 999999;
        }
          //заполним вводимую в базис переенную значением
        //любое значение, лишь бы не ноль!
        if (perN > 0) {
            System.out.println("Вводимая в БП x[" + (kI + 1) + "][" + (kJ + 1) + "]");
            return true;
        } 
        else {
            return false;
        }
    }
}

package application;

public class PotentialsMethodMIN extends PotentialsMethod{

    int m;//предложение -i-строки
    int n;//спрос - j - столбцы
    int[][] moneyMN;
    int[][] xMN;

    public PotentialsMethodMIN(int[][] mon, int[][] mas, int i, int j) {
        super(mon, mas, i, j);
    }
    
    public boolean potenshialNotBaz() {//если нет больше положительных вернет false
        int perN = 0; 
        int per = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (xMN[i][j] == 0) {
                    per = masU[i] + masV[j] - moneyMN[i][j];
                    System.out.println("Для x[" + (i + 1) + "][" + (j + 1) + "]: " + masU[i] + "+" + masV[j] + "-" + moneyMN[i][j] + " = " + per);
                    if (per > 0 & per > perN) {
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
        if (perN > 0) {
            System.out.println("Вводимая в БП x[" + (kI + 1) + "][" + (kJ + 1) + "]");
            return true;
        } 
        else {
            return false;
        }
    }
}

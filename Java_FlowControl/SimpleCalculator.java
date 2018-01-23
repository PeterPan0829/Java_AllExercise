package Java_FlowControl;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        double squre,value;


        System.out.printf("請輸入一個浮點數 =>");
        value = keyin.nextDouble();


        if (value > 0){
            squre = Math.sqrt(value);
            System.out.printf("%.2f的平方根值為 = %.2f\n",value,squre);

        }else{
            System.out.printf("程式已結束");
        }

    }
}

package Java_Exercise;

import java.util.Scanner;

public class TemperatureChange {
    public static void main(String a[]){
        Scanner keyin = new Scanner(System.in);

        //華氏溫度F, 攝氏溫度C
        float value_F, value_C;

        System.out.printf("**** 攝氏 / 華氏 溫度轉換工具 ****\n");

        System.out.printf("請輸入華氏溫度 =>\n");
        value_F = keyin.nextFloat();
        value_C = (value_F - 32) * 5.0F/9.0F;
        System.out.printf("華氏 %.2f度, 攝氏 %.2f度\n",value_F,value_C);

        System.out.printf("請輸入攝氏溫度 =>\n");
        value_C = keyin.nextFloat();
        value_F = 32 + (9 * value_C) /5;
        System.out.printf("攝氏 %.2f度, 華氏 %.2f度\n",value_C,value_F);





    }
}

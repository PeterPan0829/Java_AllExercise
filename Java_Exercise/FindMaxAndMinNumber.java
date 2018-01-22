package Java_Exercise;

import java.util.Scanner;

public class FindMaxAndMinNumber {
    public static void main(String[] args){

        Scanner keyin = new Scanner(System.in);

        float value1, value2, value3;
        float max, min;

        System.out.println("**** 三個浮點數比較大小工具 ****\n");
        System.out.printf("請輸入三個浮點數（val1 val2 val3）");

        value1 = keyin.nextFloat();
        value2 = keyin.nextFloat();
        value3 = keyin.nextFloat();

        max = Math.max(value1,Math.max(value2,value3));
        min = Math.min(value1,Math.min(value2,value3));

        System.out.printf("最大數值 =>%.2f\n",max);
        System.out.printf("最小數值 =>%.2f\n",min);


    }
}

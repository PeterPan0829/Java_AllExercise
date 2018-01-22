package Java_Exercise;

import java.util.Scanner;

/*
    和這個 DenguefeverDiagosis.java 不同地方在於,

    這次的範例是以 Library 的 輔助函式-Math 去做開根號讓數值更精準
*/

public class NewDanguefeverDiagosis {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        final int a=6, b=3, c=8, d=3;
        float x, y, z, k;
        float value;


        System.out.println("**** 登革熱診斷系統 ****\n");
        System.out.printf("請依照程式詢問步驟, 輸入各種症狀明顯指數（0 ~ 10）\n ");
        System.out.println("     如：不明顯(0) 稍明顯(4) 明顯(6) Hen明顯(10) \n");

        System.out.printf("請輸入發燒症狀明顯與否（0 ~ 10）=>");
        x = keyin.nextInt();

        System.out.printf("請輸入筋骨痠痛症狀明顯與否（0 ~ 10）=>");
        y = keyin.nextInt();

        System.out.printf("請輸入感冒症狀明顯與否（0 ~ 10）=>");
        z = keyin.nextInt();

        System.out.printf("請輸入嗜睡症狀明顯與否（0 ~ 10）=>");
        k = keyin.nextInt();

        value = (float) Math.sqrt((a*x*x + b*y*y + c*z*z + d*k*k) / (double)(a+b+c+d));
        System.out.printf("您感染登革熱指數為 (0 ~ 10) =>%.2f\n",value);


    }
}

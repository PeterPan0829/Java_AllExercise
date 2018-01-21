package com.company;
import java.util.Scanner;


/*

發高燒x 比重a=6, 筋骨痠痛y 比重b=3, 感冒症狀z 比重c=8, 貪睡症狀k 比重d=3
上述症狀指數為（0 ~ 10）: 不明顯(0) 稍明顯(4) 明顯(6) Hen明顯(10)

登革熱自我診斷系統, 總共有四個症狀自我診斷以 x, y, z, k作為指標
感染登革熱指數為（0 ~ 10）= (x*6 + y*3 z*8 + k*3) / (6+3+8+3)

(四個症狀 * 比重abcd然後相加) / 所有abcd比重整合 （強制轉成小數）

*/
public class DenguefeverDiagnosis {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        final int a=6, b=3, c=8, d=3;
        int weights = a+b+c+d;
        int x, y, z, k;
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

        value = (float) (x*a + y*b + z*c + k*d) / weights;
        System.out.printf("您感染登革熱指數為 (0 ~ 10) =>%.2f\n",value);


    }
}



import java.util.Scanner;

public class StoreGiveChange {
    public static void main(String args[]){

        Scanner keyin = new Scanner(System.in);
        //total是錢; recept拿多少錢給商家; 找零錢用value; 剩下的值先用value1
        int total, recept, value, value1, handre, fifty = 0, ten = 0, five, one;

        System.out.printf("*** 超商找錢工具 ***\n");
        System.out.println("請輸入消費金額 => ");
        total = keyin.nextInt();

        //可以先用 248 去測試
        System.out.printf("請輸入繳費金額（大於消費金額 %d） =>",total);
        recept = keyin.nextInt();

        value = recept - total;
        value1 = value;
        handre = value / 100;
        value = value - handre * 100;
        five = value/5;
        value = value - five * 5;
        one = value;


        System.out.printf("應找金額 = %d 各種零錢數量如下:\n",value1);
        System.out.printf("\t 100 元紙鈔 = %d 張 \n", handre);
        System.out.printf("\t 50 元硬幣 = %d 個 \n", fifty);
        System.out.printf("\t 10 元硬幣 = %d 個 \n", ten);
        System.out.printf("\t 5 元硬幣 = %d 個 \n", five);
        System.out.printf("\t 1 元硬幣 = %d 個 \n", one);
    }
}

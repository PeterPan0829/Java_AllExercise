package Java_FlowControl;

/*
    計程車收費工具

    計費方式為 3 公里內收費 70 元，之後每滿 0.5 公里增加 10 元。


 */

import java.util.Scanner;

public class TaxiCost {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        double km;
        int money;

        System.out.printf("請輸入本次搭乘計程車公里數 =>");
        km = keyin.nextDouble();

        if (km <= 3){
            System.out.printf("\n收費 70 元");
        }else {
            money = 70 + (int)(( km - 3 ) / 0.5) * 10;
            System.out.printf("\n收費 %d 元",money);
        }
    }
}

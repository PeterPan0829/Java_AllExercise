package Java_FlowControl;
/*
       請幫電力公司製作一套電費計費工具，電費計算方式如下：

        50 度以內，收基本電費 150 元 。
        51~100 度，每度電價為 5.0 元 。
        101~150 度，每度電價為 6.0 元 。
        151~200 度，每度電價為 7.0 元 。
        200 度以上，每度電價為 8.0 元 。

        這個系統有一些 Bug 之後要繼續修改

 */
import java.util.Scanner;

public class ElectricPowerCost {
    public static void main(String[] args) {

        Scanner keyin = new Scanner(System.in);
        double degree;      //度數
        int money;          //收費


        System.out.printf("請輸入使用度數=> ");
        degree = keyin.nextFloat();

        if (degree <= 50){
            System.out.printf("\n電費應收取 150 元\n");
        }
        else if (degree > 51 && degree <=100){
            money = (int) ( 150 + (degree * 5) + (degree - 150));
            System.out.printf("電費應收取 %d 元\n",money);
        }
        else if (degree > 101 && degree <= 150){
            money = (int) (150 + (degree * 5) + (degree - 150) * 6);
            System.out.printf("電費應收取 %d 元\n",money);
        }
        else if (degree > 151 && degree < 200){
            money = (int) (150 + (50 * 5) + (50 * 6) + (degree - 150) * 7);
            System.out.printf("電費應收取 %d 元\n",money);
        }
        else if (degree > 200){
            money = (int) (150 + (50 * 5) + (50 * 6) + (50 * 7) + (degree - 150) * 8);
            System.out.printf("電費應收取 %d 元\n",money);
        }
    }
}

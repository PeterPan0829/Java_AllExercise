package Java_FlowControl;

/*
    瓦斯費計算工具

    瓦斯公司需要一套計費工具，
    假設天然瓦斯計費標準如下：若度數小於等於 20，則瓦斯費為 150 元(基本費)；若大於 20 度，每度 5 元。

 */


import java.util.Scanner;

public class GasPriceCalculate {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int number, money = 0; //用度數、錢兩個整數變數

        System.out.printf("請輸入使用度數 =>");
        number = keyin.nextInt();

        if (number <= 20){
            money = 150;
            System.out.printf("\n應繳費用為 => %d",money);
        }
        else {
            money = number * 5;
            System.out.printf("\n應繳費用為 => %d",money);
        }
    }
}

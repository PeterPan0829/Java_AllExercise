package Java_Exercise;

import java.io.*;
import java.util.Scanner;

public class StockAveragePrice {
    public static void main(String[] args) throws IOException {
        Scanner keyin = new Scanner(System.in);

        float ave, sum=0, cost;
        int number=0;

        System.out.printf("*** 計算股票平均價系統 ***\n");
        System.out.printf("請輸入第一個交易日股價 =>");

        cost = keyin.nextFloat();
        sum = sum + cost;
        number++;
        ave = sum / number;



        System.out.printf("(目前平均價 = %.2f)請輸入第二個交易日股價 =>", ave);

        cost = keyin.nextFloat();
        sum = sum + cost;
        number++;
        ave = sum / number;



        System.out.printf("(目前平均價 = %.2f)請輸入第三個交易日股價 =>", ave);

        cost = keyin.nextFloat();
        sum = sum + cost;
        number++;
        ave = sum / number;



        System.out.printf("(目前平均價 = %.2f)請輸入第四個交易日股價 =>", ave);
        cost = keyin.nextFloat();
        sum = sum + cost;
        number++;
        ave = sum / number;



        System.out.printf("(目前平均價 = %.2f)請輸入第五個交易日股價 =>", ave);
        cost = keyin.nextFloat();
        sum = sum + cost;
        number++;
        ave = sum / number;

        System.out.printf("五日平均價 = %.2f\n", ave);

    }
    }

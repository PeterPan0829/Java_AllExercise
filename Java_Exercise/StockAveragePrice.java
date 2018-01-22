package Java_Exercise;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class StockAveragePrice {
    public static void main(String[] args) throws IOException {
        Scanner keyin = new Scanner(System.in);
        try {

            float average = 0;
            float sum = 0;
            float cost;
            int number = 0;

            System.out.printf("*** 計算股價平均價格系統 ***\n");
            System.out.printf("請輸入第一個交易日股價 =>");

            cost = keyin.nextFloat();
            sum = sum + cost;
            number++;
            average = sum / number;

        } finally {
            keyin.close();
        }
    }

}


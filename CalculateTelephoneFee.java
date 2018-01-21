package com.company;

import java.util.Scanner;

public class CalculateTelephoneFee {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        int hour, minute,second;
        float units; /* units 是一秒多少錢*/
        float times, total; /* times 是所有的秒數, total 是總金額*/

        System.out.printf("**** 手機通話費計算工具 ****\n");
        System.out.printf("請輸入通話時間（時 分 秒）=>");

        hour = keyin.nextInt();
        minute = keyin.nextInt();
        second = keyin.nextInt();

        times = (hour * 60 + minute) * 60 + second;
        System.out.printf("通話時間總共 %f秒\n",times);

        System.out.printf("請輸入每秒計費（如 0.5）=>\n");
        units = keyin.nextFloat();

        total = units * times;
        System.out.printf("通話費總共 %d 元 \n",(int)total);
    }
}

//需要特別注意 Scope 的地方!!
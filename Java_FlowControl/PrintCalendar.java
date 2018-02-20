package Java_FlowControl;

/*
    列印月曆
 */

import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int first;
        int day;
        int total;
        int now = 0;

        System.out.printf("請指定本月 1 號為星期幾(1 ～ 7) =>");
        first = keyin.nextInt();
        System.out.printf("\n請指定該月總共天數(28 ~ 31) =>");
        total = keyin.nextInt();
        System.out.printf("\tMon\tTue\tWed\tThu\tFri\tSat\tSun\n");

        for (int i=1; i<first; i++){                                //印出空白格
            System.out.printf("\t");
            now = now +1;                                           //累加器, 從我們指定的 "一號是星期幾" 那天開始跑！
        }

        day = 1;                                                    //印出我們指定的 "一號是星期幾" 的第一天
        while (day <= total){                                       //第一天 小於 總天數
            System.out.printf("\t%d",day);
            now = now + 1;                                          //假設一號在星期六 一 二 三 四 五 六(1) 日
            if (now % 7 ==0){                                       //可以整除且取餘數是 0 就跳行然後從 0 開始
                System.out.printf("\n");
                now = 0;
            }
            day = day + 1;
        }

        while (now < 7){                                            //最後空白格
            System.out.printf("\t");
            now = now + 1;
        }
    }
}

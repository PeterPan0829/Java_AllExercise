package Java_Mathod_and_MethodLibrary;

/*
    完成時間計算工具製作之後，我們編寫 DateTool_main.java 程式來驗證工具是否運作正常。
    又 DateTool 工具內的方法皆被宣告成靜態方法，可不經由產生物件，即可直接引用行。

    詳細說明請搭配 wiki 25_2_3 類別方法範例研討：驗證日期計算工具_DateTool_main
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateTool_main {
    public static void main(String[] args) throws IOException {
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));

        Date now = new Date();            // 儲存當時日期
        Date date_T = new Date();         // 日期暫存變數
        Date date_B = new Date();         // 日期暫存變數
        String date_S;                    // 讀入日期字串
        int value;



        /* 設定目前日期 */
        System.out.printf("設定目前日期(年/月/日) =>");
        date_S = keyin.readLine();
        now = DateTool.getDate(date_S);


        /* 測試某日前之前天數的日期 */
        System.out.printf("\n目前是 %d 年 %d 月 %d 日\n", now.year, now.month, now.day);
        System.out.printf("請輸入之前的天數 (日) =>");
        value = Integer.parseInt(keyin.readLine());
        date_B = DateTool.dateBefore(now, value);
        System.out.printf("之前是 %d 年 %d 月 %d 日\n",date_B.year, date_B.month, date_B.day);


        /* 測試某日 (之前) 天數的日期 */
        System.out.printf("\n目前是 %d 年 %d 月 %d 日\n", now.year, now.month, now.day);
        System.out.printf("請輸入之後的天數 (日) =>");
        value = Integer.parseInt(keyin.readLine());
        date_B = DateTool.dateAfter(now, value);
        System.out.printf("之後是 %d 年 %d 月 %d 日\n", date_B.year, date_B.month, date_B.day);


        /* 測試計算兩個日期之前它們之間的天數 */
        System.out.printf("\n目前是 %d 年 %d 月 %d 日\n", now.year, now.month, now.day);
        System.out.printf("後面的第二個日期 (年/月/日) =>");
        date_S = keyin.readLine();
        keyin.readLine();       //緩衝器，需要再多按一次 enter 輸入
        date_T = DateTool.getDate(date_S);
        value = DateTool.dateInterval(now, date_T);
        System.out.printf("之前和之後兩點日期相差 %d 天\n", value);
    }
}


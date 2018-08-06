package Java_Mathod_and_MethodLibrary;

/*
    請參考 wiki 25_1 方法與方法庫產生 當中的 25_1_4 範例研討，會有詳細的說明和教學！

    完成 Time 與 Time_CalTools 兩類別之後，
    我們利用 Time_CalTools_main 範例驗證這兩類別所產生的物件，觀察其功能是否滿足所需。
    兩類別產生物件的情況，利用 Time 類別產生了 now 物件，
    該物件內具有 now.hour、now.minute 與 now.second 等 3 個變數成員，
    則利用這些成員記錄時間的時、分與秒。同樣的，Time_CalTools 類別產生 tool 物件後，
    該物件具有 tool.getTime()...等 4 個方法成員，也利用這 4 個方法庫計算時間長短。

    程式重點說明：
    (1) 『Time_CalTools tool = new timeTool();』。利用 Time_CalTools 類別產生物件工具 tool（包含 4 種方法），但 Time_CalTools.class 必須存在於同一目錄下。
    (2) 『Time now = new Time();』。利用 Time 類別產生物件變數 now（包含 3 個變數成員），但 Time.class 必須儲存同一目錄下。
    (3) 『now = tool.getTime(time_S);』。呼叫 tool 物件下的 getTime() 物件方法，傳回 Time 格式的物件。
    (4) 『time_B = tool.timeBefore(now, time_T);』。呼叫 tool 物件下的 timeBefore() 方法。
    (5) 『time_B = tool.timeAfter(now, time_T);』。呼叫 tool 物件下的 timeAfter() 方法。
    (6) 『time_B = tool.timeInterval(now, time_T);』。呼叫 tool 物件下的 timeInterval() 方法。
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Time_CalTools_main {
    public static void main(String[] args) throws IOException {
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in)); // 這是要去做讀取

        Time_CalTools tool = new Time_CalTools();       // 產生物件(產生工具, 包含 4 種方法)
        Time now = new Time();                          // 儲存目前時間 (其實就是引用 Time class 產生一個物件變數)
        Time time_T = new Time();                       // 時間暫存變數
        Time time_B = new Time();                       // 時間暫存變數
        String time_readIn;                             // 讀入時間字串

        /* 設定目前時間 */
        System.out.printf("設定目前時間（時 / 分 / 秒）=>>");
        time_readIn = keyin.readLine();                 // 這邊是去做 readLine 讀取你所輸入的時分秒
        now = tool.getTime(time_readIn);                // 我們用一個從 Time Class 產生的物件變數 now 然後去取得從 Time_CarTools 產生的物件變數 tool 去取得物件方法 getTime()

        /* 印出目前時間 */
        System.out.printf("\n目 前 是   %d  時  %d  分   %d  秒\n",now.hour,now.minute,now.second);

        /* 測試計算之前時間 */
        System.out.printf("\n請輸入之前時間距離（時 / 分 / 秒）=>>");
        time_readIn = keyin.readLine();
        time_T = tool.getTime(time_readIn);
        time_B = tool.timeBefore(now,time_T);           // 呼叫 timeBefore
        System.out.printf("\n之 前 是   %d  時  %d  分   %d  秒\n",time_B.hour,time_B.minute,time_B.second);


        System.out.printf("\n目 前 是   %d  時  %d  分   %d  秒\n",now.hour,now.minute,now.second);

        /* 測試計算之後時間 */
        System.out.printf("請輸入之後時間距離（時 / 分 / 秒）=>>");
        time_readIn = keyin.readLine();
        time_T = tool.getTime(time_readIn);
        time_B = tool.timeAfter(now, time_T);
        System.out.printf("\n之 後 是   %d  時  %d  分   %d  秒\n",time_B.hour,time_B.minute,time_B.second);


        System.out.printf("\n目 前 是   %d  時  %d  分   %d  秒\n", now.hour, now.minute, now.second);

        /* 測試計算兩個時間之間的距離 */
        System.out.printf("請輸入第二點時間（時 / 分 / 秒）=>>");
        time_readIn = keyin.readLine();
        time_T = tool.getTime(time_readIn);
        time_B = tool.timeInterval(now, time_T);
        System.out.printf("兩點時間相差 %d 時 %d 分 %d 秒\n", time_B.hour, time_B.minute, time_B.second);
    }
}

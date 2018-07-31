package Java_Mathod_and_MethodLibrary;

/* 範例研討：製作時間運算工具
 *
 * 請參考 wiki 25 1_方法與方法庫產生 當中的 25_1_3 範例研討：製作時間運算工具 會有詳細的說明和教學！
 *
 * 許多應用系統需要相關時間計算工具，Ex：兩個時間點之間相差多久（timeInterval()）、一個時間點再過後某些時間之後是何時（timeAfter()）
 * 以及一個時間點之前的某些時間數，又應該是何時（timeBefore()）。
 * 時間運算是屬於 60 進位方式，不同於一般 10 進位計算。
 *
 * 請製作上述 3 種時間工具，並測試其運算結果，期望操作介面如下：
 *
 * 設定目前時間(時/分/秒) =>9/20/30
 * 
 * 目前是 9 時 20 分 30 秒
 * 請輸入之前時間距離 (時/分/秒) =>2/30/50
 * 之前是 6 時 49 分 40 秒
 *
 * 目前是 9 時 20 分 30 秒
 * 請輸入之後時間距離 (時/分/秒) =>1/40/20
 * 之後是 11 時 0 分 50 秒
 *
 * 目前是 9 時 20 分 30 秒
 * 請輸入第二點時間 (時/分/秒) =>11/40/20
 * 兩點時間相差 2 時 19 分 50 秒
 *
 *
 * 製作技巧研討：
 * 製作此系統可區分為下列 3 個主題：
 * (1) 時間物件格式（Time.class）：需製作一個時間類別，規劃時間物件的規格；利用此類別所產生的物件變數之間，才可以做運算處理（於 Time_CalTools.java）。
 *
 * (2) 時間運算工具類別（Time_CalTools.class）：此類別內包含所需的時間計算器（或稱方法），再利用它產生（new）物件方法，就可以做運算處理事項。本範例包含下列四個工具（於 Time_CalTools.java）：
 * a. getTime()：輸入時間字串（時/分/秒），轉換成時間物件格式（時、分、秒）並回傳。
 * b. timeAfter()：輸入現在時間點與之前時間量，回傳之前的相當時間點（時、分、秒）。
 * c. timeBefore()：輸入現在時間點與之後時間量，回傳之後的相當時間（時、分、秒）。
 * d. timeInterval()：輸入兩個時間點（時、分、秒），回傳之間的距離時間量。
 *
 * (3) 編譯主程式（Time_CalTools_main.class）：測試所製作的工具是否可用。
 */

import java.util.Scanner;

/* 時間類別, 描述時間物件的規格 */
class Time{
    int hour;
    int minute;
    int second;
}

/* 時間工具類別, 包含 4 個方法 (計算器) */
class Time_CalTools {

    /* 轉換字串成為時間物件格式 */
    Time getTime(String time_S){            // 這裡的回傳就像這樣 int setID(String ID_Str) {       // 取得字串 ID_Str 的輸入
        Time time = new Time();
        Scanner keyin = new Scanner(time_S).useDelimiter("/");
        time.hour = keyin.nextInt();
        time.minute = keyin.nextInt();
        time.second = keyin.nextInt();
        return time;
    }

    /* 之前時間計算器, 下面還有之後時間計時器和兩點時間之間距離計算器, 只要搞懂 timeBefore怎麼寫後面你也可以觀察到其中的規則！ */
    Time timeBefore(Time now, Time value){              // 這裡的引數值 now 是指現在, value 是現在和之前的時間差
        Time time = new Time();                         // 物件宣告並產生, 可用 time 去取得 Time class 當中的變數和物件方法
        time.hour=0; time.minute=0; time.second=0;
        time.second = now.second - value.second;
        if (time.second < 0){                           // 如果不夠 "減" 向 "分的60秒借"
            time.second = time.second + 60;
            time.minute = 1;
        }

        time.minute = now.minute - value.minute - time.minute;          // now 的分 - 時間差的分 - 上面的 time.minute(1)
        if (time.minute <0 ) {                          // 如果不夠 "減" 向 "一小時的60分借"
            time.minute = time.minute + 60;
            time.hour = 1;
        }
        
        time.hour = now.hour - value.hour - time.hour;  // now 的小時 - 時間差的小時 - 上面的 time.hour(1)
        if (time.hour < 0){                             // 如果不夠 "減" 我們直接加上24小時"
            time.hour = time.hour + 24;
        }
        return time;                                // 回傳時間會傳回：time.hour、time.minute、time.second　的值
    }

        /* 之後時間計算器 用+ */
        Time timeAfter(Time now, Time value){
            Time time = new Time();
            time.hour = 0; time.minute = 0; time.second = 0;
            time.second = now.second + value.second;
            if (time.second > 60){
                time.second = 60 - time.second;
                time.minute = 1;
            }

            time.minute = time.minute + now.minute + value.minute;
            if (time.minute > 60){
                time.minute = 60 - time.minute;
                time.hour = 1;
            }

            time.hour = time.hour + now.hour + value.hour;
            if (time.hour > 24){
                time.hour = time.hour - 24;
            }
            return time;                                // 回傳時間會傳回：time.hour、time.minute、time.second　的值
        }

    /* 兩點時間之間距離計算器 */
    Time timeInterval(Time start, Time end){
        Time time = new Time();
        time.hour = 0; time.minute = 0; time.second = 0;
        time.second = end.second - start.second;
        if (time.second < 0){
            time.second = time.second + 60;
            time.minute = 1;
        }

        time.minute = end.minute - start.minute - time.minute;
        if (time.minute < 0){
            time.minute = time.minute + 60;
            time.hour = 1;
        }

        time.hour = end.hour - start.hour - time.hour;
        if (time.hour < 0){
            time.hour = time.hour + 24;
        }
        return time;
    }
}



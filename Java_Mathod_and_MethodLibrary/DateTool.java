package Java_Mathod_and_MethodLibrary;

/*
    類別方法宣告與引用
    詳細說明請搭配 wiki 25_2_2 類別方法範例研討：製作日期計算工具

    （A）程式功能：
    許多系統都可能遇到日期計算問題，造成程式設計師困擾。
    因此，軟體公司裡期望建立相關日期計算工具，爾後所有工程師直接引用即可。
    該公司對日期計算規劃有下列工具：

    (1) dataAfter()：指定某一日期（年、月、日），再給予幾個天數之後的日期，應該是何日期。
    呼叫方法時，給予指定某一特定日期，與之後的天數。執行方法後回覆相對日期的年、月、日之日期。

    (2) dataBefore()：指定某一日期，再給予該日期之前的天數，則計算出相對應的日期。
    呼叫此方法時，給予指定特定日期（年、月、日），與之前的天數。執行後回覆相對應的年、月、日。

    (3) dataInterval()：指定兩個日期（年、月、日），則計算出兩日期之間的天數。
    呼叫此方法時，給予兩個日期，執行後回覆之間的天數。

    期望操作及測試結果如下：
    設定目前日期(年/月/日) =>2004/3/12

    目前是 2004 年 3 月 12 日
    請輸入之前的天數 (日) =>100
    之前是 2003 年 12 月 2 日

    目前是 2003 年 12 月 2 日
    請輸入之後的天數 (日) =>100
    之後是 2004 年 3 月 12 日

    目前是 2004 年 3 月 12 日
    後面的第二個日期 (年/月/日) =>2005/4/6
    兩點日期相差 390 天

    （B）製作技巧研討：
    研發計算日前之前，需制定一個通用型的日期物件（Date），
    應包含有：年（year）、月（month）與（day）等三個變數成員。
    另外，每個月的天數並不相同，需要利用一個陣列（Months[]）來表示每個月最高天數。
    還有一個重點，如欲利用數值的加減運算子，製作日期計算工具是非常困難的，採用計數累加方法，可能較為容易達成。製作技巧說明如下：

    (1) 之後天數的日期（dateAfter()）：輸入第一點日期，與該日前之後的天數（value），計算並輸出第二點日期。
    製作方法是以第一點日期作基礎，由『日』（day）開始累計加一，當他超過該月最高天數（Months[]）後，
    『月』（month）則累計加一，又如果『月』超過 12 時，則『年』累計加一；如此一個循環則輸入天數（value）減一，
    一直到該數值為 0。最後得到的日期即是第二點日期。

    (2) 之前天數的日期（dateBefore()）：輸入第一點日期，
    與該日前之前的天數（value），計算並輸出第二點日期。方法是以第一點日期作基礎，
    由『日』開始累計減一，當它等於零，則『月』數累計減一，並將『日』設定為該月最高日數；如果『月』減一後等於 0，
    則『年』減一，亦將『月』設定為 12；如此一個循環則輸入天數（value）減一，依此類推，一直到輸入數值為 0。

    (3) 兩日期之間天數（dateInterval()）：與 dataAfter() 相似，由第一個日期開始累計，每次 value 數值累計加一。
    一直到第一個日期與第二個日期相同，最後 value 的數值即是兩日期之間的天數。
    日期計算工具大多僅簡單的輸入與輸出運算，極少牽涉到共享資料的處理，製作成靜態類別方法即可。
    因此我們將宣告日期物件（Date）與日期工具（dateTool()）兩類別規劃於 dateTool.java 檔案內，
    編譯後（javac）將產生 Data.class 與 dateTool.class 兩類別檔案，其中 dateTool.class 包含三個類別方法。
    另一方面，也製作了一個主程式（Ex8_2.java）測試這三個類別方法是否正確。

    （C）程式範例：dateTool.java
    利用 dateTool.java 檔案規劃 Date 與 dateTool 兩類別。Date 類別可宣告產生儲存日期的物件（年、月、日）。
    dateTool 類別包含 4 個靜態方法成員與 1 個變數成員，分別說明如下：
    (a) Date 類別：規劃日期物件的儲存格式，包含年（year）、月（month）與日（day）等變數成員。
    (b) Month[] 類別變數：儲存每年 12 個月，每月的日數（12 個元素）。
    (c) getDate() 方法：將日期字串（年/月/日）轉換成日期物件格式（年、月、日）。
    (d) dateBefore() 方法：計算某一指定日期，相對應之前的天數量，應該是何日前（年、月、日）。
    (e) dateAfere() 方法：計算某一指定日期，相對應之後的天數量，應該是何日前（年、月、日）。
 */

import java.util.Scanner;

// 日期類別, 產生日期物件的格式 */
class Date{
    int year;
    int month;
    int day;
}

/* 時間工具類別, 包含 4 個方法 (計算器) */
public class DateTool {
    /* 每月的天數 */
    static int Months[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* 轉換字串成為日期物件格式 */
    static Date getDate(String date_S) {
        Date date = new Date();
        Scanner keyin = new Scanner(date_S).useDelimiter("/");
        date.year = keyin.nextInt();
        date.month = keyin.nextInt();
        date.day = keyin.nextInt();
        return date;
    }

    /* 之後天數的日期計算器 */
    static Date dateAfter(Date now, int value) {
        int k;
        while (value > 0) {
            now.day = now.day + 1;
            if (now.day > Months[now.month - 1]) {
                now.day = 1;
                now.month = now.month + 1;
                if (now.month > 12) {
                    now.month = 1;
                    now.year = now.year + 1;
                }
            }
            value = value - 1;
        }
        return now;
    }

    /* 之前天數的日期計算器 */
    static Date dateBefore(Date now, int value) {
        while(value > 0) {
            now.day = now.day - 1;
            if (now.day < 1) {
                now.month = now.month - 1;
                if (now.month < 1) {
                    now.month = 12;
                    now.year = now.year - 1;
                }
                now.day = Months[now.month-1];
            }
            value = value - 1;
        }
        return now;
    }

    /* 計算兩個日期之間天數的計算器 */
    static int dateInterval(Date start, Date end){
        int number = 0;
        while (!((end.year == start.year)&&
                (end.month == start.month)&&
                (end.day == start.day))){
            start.day = start.day + 1;
            if (start.day > Months[start.month-1]){
                start.month = start.month + 1;
                start.day = 1;
                if (start.month > 12){
                    start.year = start.year +1;
                    start.month = 1;
                }
            }
            number = number + 1;
        }
        return number;
    }
}
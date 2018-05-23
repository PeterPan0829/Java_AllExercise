package Java_ObjectVariable_AND_ObjectArray;

/*
    超商販賣系統（運用物件陣列）_（可以搭配我們在 wiki 的學習講義 - 20_物件陣列的運用當中的20_3超商販賣系統（運用物件陣列））

    請幫『高雄第一生鮮超市』建立一套販賣系統，電腦視窗能出現各項商品名稱與單價，操作者連續點選客人購買商品與數量，最後顯示出購買商品清單，並計算出購買金額。
    假設僅販賣：可口餅乾（20 元）、味全鮮乳（30 元）、御便當（50 元）、黑松汽水（20 元）、頻果西打（30 元）與脆笛酥（20 元）。

    製作技巧研討：
    系統要求可連續選擇多項商品，再計算出總金額及印出購買清單，因此必須準備一物件陣列，存放客戶所購買產品名稱及數量。
    我們規劃產品物件包含有：產品名稱、單價、數量、以及小計，其中小計表示該樣產品的金額。
    客戶選購產品時，則需產生陣列內的物件元素，再填入該產品的屬性。

    製作本系統重點提示如下：
    (1) 系統操作隨時由螢幕點選購買產品及數量，因此需顯示產生清單編寫成一個獨立的 method ，隨時呼叫執行（Print_Element()）。
    (2) 需要一個陣列物件隨時登錄客戶所購買產品及數量，並規劃該物件的類別內容（class Element{ …}）。
    (3) 利用 while 迴圈與 switch/case 判斷選擇店員的操作輸入，並假設客戶最多購買 20 樣產品。


    期望操作介面如下：

    **** 歡迎光臨 高雄第一生鮮超市 請選擇購買商品  ****
    (1) 可口餅乾 20 元      (2) 味全鮮乳 30 元      (3) 御便當 50 元
    (4) 黑松汽水 20 元      (5) 頻果西打 30 元      (6) 脆迪酥 20 元
    (7) 結算金額
        請輸入選項 =>2
        購買數量 =>5

    **** 歡迎光臨 高雄第一生鮮超市 請選擇購買商品  ****
    (1) 可口餅乾 20 元      (2) 味全鮮乳 30 元      (3) 御便當 50 元
    (4) 黑松汽水 20 元      (5) 頻果西打 30 元      (6) 脆迪酥 20 元
    (7) 結算金額
        請輸入選項 =>3
        購買數量 =>2

    **** 歡迎光臨 高雄第一生鮮超市 請選擇購買商品  ****
    (1) 可口餅乾 20 元      (2) 味全鮮乳 30 元      (3) 御便當 50 元
    (4) 黑松汽水 20 元      (5) 頻果西打 30 元      (6) 脆迪酥 20 元
    (7) 結算金額
        請輸入選項 =>7

    ***** 購買清單如下 *****
    品名            單價    數量      小計
    味全鮮乳        30       5       150
    御便當          50       2       100
    總計 = 250

 */

import java.util.Scanner;

class Element{     // 宣告一個 class 藍圖 塞以下這些元素再宣告成物件陣列
    String name;   // 商品名稱
    int price;     // 單價
    int PCS;      // 購買數量
    int sum;      // 小計
}

public class StoreSaleSystem_ObjectArray {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        Element[] cust = new Element[20];               //客戶購買產品(物件陣列)  0~19
        int select, k, number, total;                   //利用 k 變數紀錄客戶購買商品的筆數；其初始值為 0。
        Print_menu();                                   //這邊很多人會犯個錯誤唷，記得程式一定有一個執行順序跟流程(先顯示菜單後顯示輸入兩個顛倒是不一樣的結果!!)
        select = keyin.nextInt();


        k=0;                                            //初始值
        while ((select != 7) && (k<20)){                //利用 while 迴圈與 switch/case 判斷選項，構成系統主要執行區域。
            System.out.printf("\t購買數量 =>");
            number = keyin.nextInt();
            switch (select){
                case 1:
                    cust[k] = new Element();             //每次選新的東西都要產生新的物件。變數 k 是紀錄目前存放資料的筆數，又它是由 0 開始計算，因此 k 所指的是下一個資料的位置。此敘述功能是產生一個 Elment 物件後，存入陣列 cust 的第 k 位置（cust[k]）。
                    cust[k].name = "御品便當";
                    cust[k].price = 50;
                    cust[k].PCS = number;
                    k = k+1;
                    break;

                case 2:
                    cust[k] = new Element();
                    cust[k].name = "味全鮮乳";
                    cust[k].price = 30;
                    cust[k].PCS = number;
                    k = k+1;
                    break;

                case 3:
                    cust[k] = new Element();
                    cust[k].name = "可口餅乾";
                    cust[k].price = 20;
                    cust[k].PCS = number;
                    k = k+1;
                break;

                case 4:
                    cust[k] = new Element();
                    cust[k].name = "黑松汽水";
                    cust[k].price = 20;
                    cust[k].PCS = number;
                    k = k+1;
                    break;

                case 5:
                    cust[k] = new Element();
                    cust[k].name = "頻果西打";
                    cust[k].price = 30;
                    cust[k].PCS = number;
                    k = k+1;
                    break;

                case 6:
                    cust[k] = new Element();
                    cust[k].name = "脆迪酥";
                    cust[k].price = 20;
                    cust[k].PCS = number;
                    k = k+1;
                    break;

                    default:
                        System.out.printf("輸入錯誤!! 請重新選擇");
                        break;
            }
            Print_menu();
            select = keyin.nextInt();
        }

        /* 計算各產品小計與購買總金額 */
        total = 0;
        for (int i=0; i<k; i++) {
            cust[i].sum = cust[i].price * cust[i].PCS;
            total = total + cust[i].sum;
        }


        /* 列印購買清單 */
        System.out.printf("***** 購買清單如下 *****\n");
        System.out.printf("品名\t\t\t單價 \t\t數量\t\t 小計\n");

        for (int i=0; i<k; i++) {
            System.out.printf("%s%10d%10d%10d\n", cust[i].name,
                    cust[i].price, cust[i].PCS, cust[i].sum);
        }
        System.out.printf("總計 = %d\n", total);
    }

    /* 顯示客戶購買商品選項 */
    public static void Print_menu(){
        System.out.printf("**** 歡迎光臨 高雄第一生鮮超市 請選擇購買商品  ****\n");
        System.out.printf("(1) 御品便當 50 元\n");
        System.out.printf("(2) 可口餅乾 20 元\t");
        System.out.printf("(3) 味全鮮乳 30 元\t");
        System.out.printf("(4) 黑松汽水 20 元\t");
        System.out.printf("(5) 蘋果西打 30 元\t");
        System.out.printf("(6) 脆迪酥 20 元\n");
        System.out.printf("(7) 結算金額\n");
        System.out.printf("\t請輸入選項 =>");
    }
}

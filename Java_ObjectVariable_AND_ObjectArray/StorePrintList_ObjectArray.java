package Java_ObjectVariable_AND_ObjectArray;

/*
    請擴充 StoreSaleSystem_ObjectArray 『高雄第一生鮮超市』販賣系統的功能，
    除了可由螢幕點選客人購買商品與數量外，最後可由螢幕顯示總購買金額，並印出收據（寫入檔案）。
    假設僅販賣：可口餅乾（20 元）、味全鮮乳（30 元）、御便當（50 元）、黑松汽水（20 元）、頻果西打（30 元）與脆笛酥（20 元），
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StorePrintList_ObjectArray {
    public static void main(String[] args) throws IOException {                             //如果有錯誤就把錯誤訊息丟到 IOEception底下

        /* 宣告輸出檔案物件 */
        String file = "List.data";                                                          //宣告產生一個緩衝器型的輸出檔案物件，指定該檔案名稱為 List.data
        BufferedWriter data = new BufferedWriter(new FileWriter(file));                     //宣告一個BufferWriter的物件叫做 data, 然後產生FileWriter把file丟進去。

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
        System.out.printf("總購買金額文　= %d\n\n",total);
        System.out.printf("** 採購清單列印中 List.data **\n");

        /* 物件陣列寫入檔案 */
        data.write("== 高雄第一生鮮超市 購買清單 歡迎再度光臨 ==\n");
        data.write("品名\t\t單價 \t數量\t 小計\n");
        data.write("--------------------------------------\n");
        for (int i=0; i<k; i++){
            data.write(cust[i].name + "\t");
            data.write(cust[i].price + "\t");
            data.write(cust[i].PCS+ "\t");
            data.write(cust[i].sum + "\t");
        }

        data.write("總購買金額 = "+total+" 元整");
        data.close();
        System.out.printf("** 列印完畢 List.data **\n");



//        這一段可以直接省略，我們不採取直接印出結果而是寫入 List.data 檔案！！
//        /* 列印購買清單 */
//        System.out.printf("***** 購買清單如下 *****\n");
//        System.out.printf("品名\t\t\t單價 \t\t數量\t\t 小計\n");
//
//        for (int i=0; i<k; i++) {
//            System.out.printf("%s%10d%10d%10d\n", cust[i].name,
//                    cust[i].price, cust[i].PCS, cust[i].sum);
//        }
//        System.out.printf("總計 = %d\n", total);
    }

    /* 顯示客戶購買商品選項 */
    public static void Print_menu(){
        System.out.printf("**** 歡迎光臨 高雄第一生鮮超市 請選擇購買商品  ****\n");
        System.out.printf("(1) 御品便當 50 元\t");
        System.out.printf("(2) 可口餅乾 20 元\t");
        System.out.printf("(3) 味全鮮乳 30 元\n");
        System.out.printf("(4) 黑松汽水 20 元\t");
        System.out.printf("(5) 蘋果西打 30 元\t");
        System.out.printf("(6) 脆迪酥 20 元\n");
        System.out.printf("(7) 結算金額\n");
        System.out.printf("\t請輸入選項 =>");
    }
}


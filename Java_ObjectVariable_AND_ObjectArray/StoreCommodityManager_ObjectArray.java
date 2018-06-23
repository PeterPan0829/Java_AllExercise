package Java_ObjectVariable_AND_ObjectArray;

/*
22 3_紀錄檔案的輸入＆輸出運用（專題製作–台北生鮮超市庫存管理系統）_（可以搭配我們在 wiki 的學習講義 - 22-3-5記錄檔案輸出格式_範例：建立一套商品登錄系統)

請幫『台北生鮮超市庫存管理系統 』建立一套商品登錄系統。
該系統功能有『顯示所有資料』、『增加商品資料』、以及『儲存資料』。
庫存資料儲存於 storage.data 檔案內。

"假設" 描述商品屬性（Element_1.java）為：
商品編號（String no）、
商品名稱（String name）、
單價（int price）、
單位（Sting unit）、
庫存量（int stock）與
製造商（String maker）。

至於庫存資料請以 storage.data 檔案名稱儲存。
第一次執行沒有 storage.data 檔案，則利用編輯工具(如：notepad++) 開啟一個新檔，
直接另存新檔並將檔名取 “storage.data”(雙引號要拿掉喔，裡面不要輸入任何內容)，再儲存於本程式的同一目錄下。
*/

import java.io.*;
import java.util.Scanner;

/* 建立Element_1類別 */
class Element_1 {
    String ID;        // 商品編號
    String name;      // 商品名稱
    int price;        // 單價
    String unit;      // 單位
    int stock;        // 庫存數量
    String maker;     // 製造商
}


public class StoreCommodityManager_ObjectArray {

    static Element_1[] commodity;                    // 商品資料的物件陣列
    static int number;                               // 紀錄資料儲存筆數
    static String file_R;                            // 庫存檔案
    static Scanner keyin;                            // 宣告鍵盤輸入物件

    public static void main(String[] args) throws IOException {
        keyin = new Scanner(System.in);
        commodity = new Element_1[50];               // 物件陣列範圍
        number = 0;                                  // 設定紀錄資料儲存筆數
        file_R = "storage.data";                     // 設定庫存檔案
        read_data();                                 // 呼叫執行讀取檔案資料方法
        mainMenu();                                  // 呼叫主功能選單並讀取功能選項（select）
        int select = keyin.nextInt();
        keyin.nextLine();                            // 清除鍵盤緩衝器
        while (select != 5){
            switch (select){
                case 1:         /* 顯示所有資料 */
                    disp_data();
                    break;
                case 2:         /* 增加商品資料 */
                    add_data();
                    break;
                case 3:         /* 修改商品資料 */
                    modify_data();
                    break;
                case 4:         /* 儲存資料 */
                    save_data();
                    break;
                default:
                    System.out.printf("錯誤輸入，請重新選擇\n");
            }
            mainMenu();
            select = keyin.nextInt();
            keyin.nextLine();
        }
    }

    /* 主工作項目選單 */
    public static void mainMenu(){
        System.out.printf("\n ******* 歡迎光臨, 台北生鮮超市庫存管理系統 ******* \n");
        System.out.printf("(1)顯示所有資料\t");
        System.out.printf("(2)增加商品資料\t");
        System.out.printf("(3)修改商品資料\n");
        System.out.printf("(4)儲 存 資 料\t");
        System.out.printf("(5)離 開 系 統");
        System.out.printf("\n\t請輸入選項 =>");
    }

    /* 將 stroage.data 檔案輸入至系統 */
    public static void read_data() throws IOException{
        File fileID = new File(file_R);                     //產生輸入檔案物件並輸入到 file_R庫存檔案
        String inData;
        if (fileID.exists()){                               //如果這份文件存在的話
            BufferedReader data = new BufferedReader(new FileReader(fileID));
            while ((inData = data.readLine()) != null){     //這個方法意思是讀一行，如果不是空的就繼續讀
                Scanner scanner = new Scanner(inData).useDelimiter("\t");  //宣告成 Scanner 物件並設定分界符號（\t），物件名稱為 scanner
                commodity[number] = new Element_1();
                commodity[number].ID = keyin.next();
                commodity[number].name = keyin.next();
                commodity[number].price = keyin.nextInt();
                commodity[number].unit = keyin.nextLine();
                commodity[number].stock = keyin.nextInt();
                commodity[number].maker = keyin.nextLine();
                number = number + 1;
            }
            data.close();
        }
        else {
            System.out.printf("%s 檔案不存在，請先建立它\n",file_R);
            System.out.printf("按 Enter 鍵離開　=>");
            keyin.nextLine();
            System.exit(1); //宣告強制離開
        }
    }


    public static void disp_data(){
        System.out.printf("===列\t印\t所\t有\t商\t品\t資\t料===\n");
        System.out.printf("編號\t\t品名\t\t單價\t\t單位\t\t庫存量\t\t製造商\n");
        for (int i=0; i<number; i++) {
            System.out.printf("%s\t", commodity[i].ID);
            System.out.printf("%s\t\t", commodity[i].name);
            System.out.printf("%d\t\t", commodity[i].price);
            System.out.printf("%s\t\t", commodity[i].unit);
            System.out.printf("%d\t\t\t", commodity[i].stock);
            System.out.printf("%s\n", commodity[i].maker);
        }
    }

    /* 增加商品資料 */
    public static void add_data(){
        int k = number;                                // 設定一個 k 整數變數去存取 "紀錄資料儲存筆數" 然後下面　number = number + 1 是要做累加
        commodity[k] = new Element_1();
        System.out.printf("請輸入商品編號=>");
        commodity[k].ID = keyin.nextLine();
        System.out.printf("請輸入商品名稱=>");
        commodity[k].name = keyin.nextLine();
        System.out.printf("請輸入單價=>");
        commodity[k].price = keyin.nextInt();
        keyin.nextLine();                              // 清除鍵盤緩衝器
        System.out.printf("請輸入單位（個/箱/公斤）=>");
        commodity[k].unit = keyin.nextLine();
        System.out.printf("請輸入庫存量=>");
        commodity[k].stock = keyin.nextInt();
        keyin.nextLine();                              // 清除鍵盤緩衝器
        System.out.printf("請輸入製造商=>");
        commodity[k].maker = keyin.nextLine();
        number = number +1;
    }

    /* 修改商品資料 */
    public static void modify_data(){
        System.out.printf("請輸入欲修改的商品編碼 =>");
        String num = keyin.nextLine();
        int flag = 0, test;         // flag 我把它看成「旗標」，就是找到的目標物(這部份看下面的程式邏輯比較清楚)
        int i = 0;                  // test 我把它看成 "測試是否找到輸入的商品編號" (這需要花時間去理解，要多點耐心!!)

        /* 有找到這筆資料的話 */
        while (i < number){         // i < 紀錄資料儲存筆數
            test = commodity[i].ID.compareTo(num);           //compareTo(String anotherString) 按ASCII碼字典順序比較兩個字串。(官方文件：返回值是整型,它是先比較對應字符的大小(ASCII碼順序),如果第一個字符和參數的第一個字符不等,結束比較,返回他們之間的差值 ,如果第一個字符和參數的第一個字符相等,則以第二個字符和參數的第二個字符做比較,以此類推,直至比較的字符或被比較的字符有一方。)
            if (test == 0){
                flag = 1;
                break;
            }
            i = i + 1;
        }

        /* 沒有找到這筆資料的話 */
        if (flag == 0){
            System.out.printf("沒有 %s 資料，拒絕處理\n",num);
            return;
        }

        System.out.printf("[%s]請輸入商品名稱 =>",commodity[i].name);
        commodity[i].name = keyin.nextLine();
        System.out.printf("[%d]請輸入單價=>",commodity[i].price);
        commodity[i].price = keyin.nextInt();
        keyin.nextLine();
        System.out.printf("[%s]請輸入單位(個/箱/公斤)=>",commodity[i].unit);
        commodity[i].unit = keyin.nextLine();
        System.out.printf("[%d]請輸入庫存量 =>", commodity[i].stock);
        commodity[i].stock = keyin.nextInt();
        keyin.nextLine();
        System.out.printf("[%s]請輸入製造商=>",commodity[i].maker);
        commodity[i].maker = keyin.nextLine();
    }

    /* 儲存商品資料至外部檔案 storage.data */
    public static void save_data() throws IOException{
        BufferedWriter outData = new BufferedWriter(new FileWriter(file_R));  //儲存資料到 storage檔案中所以要寫入 Writer，因為是儲存商品資料至外部檔案 storage.data 所以變數我們寫 outData
        System.out.printf("** 將儲存檔案 (storage.data) **\n");
        for (int i=0; i<number; i++){
            outData.write(commodity[i].ID + "\t");
            outData.write(commodity[i].name + "\t");
            outData.write(commodity[i].price + "\t");
            outData.write(commodity[i].unit + "\t");
            outData.write(commodity[i].stock + "\t");
            outData.write(commodity[i].maker + "\n");
        }
        outData.close();
        System.out.printf("*******　儲存完畢　******\n");
    }
}

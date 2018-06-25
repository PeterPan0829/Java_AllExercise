package Java_ObjectVariable_AND_ObjectArray;

/*
（擴充 StoreCommodityManager_ObjectArray 功能）請幫『台北生鮮超市』建立一套『倉儲管理系統』，可供隨時登錄各連鎖店進出貨量。
系統功能有『顯示所有資料』、『增加商品資料』、『出貨登錄』、『進貨登錄』、以及『儲存資料』。庫存資料儲存於 storage.data 檔案內。
當點選『出貨』或『進貨』功能時，系統會將目前所建立的商品資料顯示於螢幕上，管理者點選產品再輸入數量即可。

產品類別（Element_1.class）為：
商品編號（String no）、商品名稱（String name）、單價（int price）、
單位（Sting unit）、庫存量（int stock）與製造商（String maker）。

本系統大致上與 StoreCommodityManager_ObjectArray 相似，僅增加了『進貨登錄』與『出貨登錄』功能選項。
當執行這兩項功能時，系統必須將目前已登錄產品與數量，顯示於螢幕上；操作者點選後，再輸入進出貨數量。
因此，必須另製作顯示產品名稱與數量，並可選擇輸入的子程式（list_commodity()），
兩功能子程式（commodity_in() 與 commodity_out()）分別呼叫它，再傳回正確的產品選項。

除了 StoreCommodityManager_ObjectArray 的 5 個功能外，還要擴充『進貨資料登錄』與『出貨資料登錄』兩個工作選項：
當選擇『進貨資料登錄』後，系統會出現目前庫存狀況再選擇進貨哪一種商品，並輸入進貨數量。輸入後再選擇『顯示所有資料』(選擇 4與 1)。
當選擇『出貨資料登錄』後，系統同樣會出現目前庫存狀況，再選擇出貨那一種商品與數量。輸入後再選擇『顯示所有資料』(選擇 5與 1)。
離開系統之前，記得『儲存資料』(選項 6)。
 */

import java.io.*;
import java.util.Scanner;

public class WarehouseManagementSystem_ObjectArray {
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
        while (select != 7) {
            switch (select) {
                case 1:         /* 顯示所有資料 */
                    disp_data();
                    break;
                case 2:         /* 增加商品資料 */
                    add_data();
                    break;
                case 3:         /* 修改商品資料 */
                    modify_data();
                    break;
                case 4:         /* 進貨數量登入 */
                    commodity_in();
                    break;
                case 5:         /* 出貨數量登入 */
                    commodity_out();
                    break;
                case 6:         /* 儲存資料 */
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
    public static void mainMenu() {
        System.out.printf("\n ******* 歡迎光臨, 台北生鮮超市倉儲管理系統 ******* \n");
        System.out.printf("(1)顯示所有資料\t");
        System.out.printf("(2)增加商品資料\t");
        System.out.printf("(3)修改商品資料\n");
        System.out.printf("(4)進貨資料登入\t");
        System.out.printf("(5)出貨資料登入\t");
        System.out.printf("(6)儲 存 資 料\t");
        System.out.printf("(7)離 開 系 統\t");
        System.out.printf("\n\t請輸入選項 =>");
    }

    /* 將 stroage.data 檔案輸入至系統 */
    public static void read_data() throws IOException {
        File fileID = new File(file_R);                     //產生輸入檔案物件並輸入到 file_R庫存檔案
        String inData;
        if (fileID.exists()) {                               //如果這份文件存在的話
            BufferedReader data = new BufferedReader(new FileReader(fileID));
            while ((inData = data.readLine()) != null) {     //這個方法意思是讀一行，如果不是空的就繼續讀
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
        } else {
            System.out.printf("%s 檔案不存在，請先建立它\n", file_R);
            System.out.printf("按 Enter 鍵離開　=>");
            keyin.nextLine();
            System.exit(1); //宣告強制離開
        }
    }

    /* 顯示所有資料 */
    public static void disp_data() {
        System.out.printf("===列\t印\t所\t有\t商\t品\t資\t料===\n");
        System.out.printf("編號\t\t品名\t\t單價\t\t單位\t\t庫存量\t\t製造商\n");
        for (int i = 0; i < number; i++) {
            System.out.printf("%s\t", commodity[i].ID);
            System.out.printf("%s\t\t", commodity[i].name);
            System.out.printf("%d\t\t", commodity[i].price);
            System.out.printf("%s\t\t", commodity[i].unit);
            System.out.printf("%d\t\t\t", commodity[i].stock);
            System.out.printf("%s\n", commodity[i].maker);
        }
    }

    /* 增加商品資料 */
    public static void add_data() {
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
        number = number + 1;
    }

    /* 修改商品資料 */
    public static void modify_data() {
        System.out.printf("請輸入欲修改的商品編碼 =>");
        String num = keyin.nextLine();
        int flag = 0, test;         // flag 我把它看成「旗標」，就是找到的目標物(這部份看下面的程式邏輯比較清楚)
        int i = 0;                  // test 我把它看成 "測試是否找到輸入的商品編號" (這需要花時間去理解，要多點耐心!!)

        /* 有找到這筆資料的話 */
        while (i < number) {         // i < 紀錄資料儲存筆數
            test = commodity[i].ID.compareTo(num);           //compareTo(String anotherString) 按ASCII碼字典順序比較兩個字串。(官方文件：返回值是整型,它是先比較對應字符的大小(ASCII碼順序),如果第一個字符和參數的第一個字符不等,結束比較,返回他們之間的差值 ,如果第一個字符和參數的第一個字符相等,則以第二個字符和參數的第二個字符做比較,以此類推,直至比較的字符或被比較的字符有一方。)
            if (test == 0) {
                flag = 1;
                break;
            }
            i = i + 1;
        }

        /* 沒有找到這筆資料的話 */
        if (flag == 0) {
            System.out.printf("沒有 %s 資料，拒絕處理\n", num);
            return;
        }

        System.out.printf("[%s]請輸入商品名稱 =>", commodity[i].name);
        commodity[i].name = keyin.nextLine();
        System.out.printf("[%d]請輸入單價=>", commodity[i].price);
        commodity[i].price = keyin.nextInt();
        keyin.nextLine();
        System.out.printf("[%s]請輸入單位(個/箱/公斤)=>", commodity[i].unit);
        commodity[i].unit = keyin.nextLine();
        System.out.printf("[%d]請輸入庫存量 =>", commodity[i].stock);
        commodity[i].stock = keyin.nextInt();
        keyin.nextLine();
        System.out.printf("[%s]請輸入製造商=>", commodity[i].maker);
        commodity[i].maker = keyin.nextLine();
    }

    /* 進貨數量 */
    public static void commodity_in() {
        int num = list_commodity();
        if (num == 999) {
            return;
        }
        System.out.printf("進貨數量 =>");
        int in = keyin.nextInt();
        keyin.nextLine();
        commodity[num].stock = commodity[num].stock + in;
    }

    /* 出貨數量 */
    public static void commodity_out() {
        int num = list_commodity();
        if (num == 999) {
            return;
        }
        System.out.printf("出貨資料=>");
        int out = keyin.nextInt();
        keyin.nextLine();
        commodity[num].stock = commodity[num].stock - out;
    }

    /* 顯示商品清單及選擇商品子程式 */
    public static int list_commodity() {             //回傳整數型態
        System.out.printf("=== 請點選（進出貨）商品 ===\n");
        for (int i = 0; i < number; i++) {          // i < 設定紀錄資料儲存筆數
            System.out.printf("(%d) %s %d ", i + 1, commodity[i].name, commodity[i].stock);
            if ((i + 1) % 4 == 0) {                  //可整除就換行
                System.out.printf("\n");
            }
        }
            System.out.printf("\n請輸入商品選項 =>");
            int num = keyin.nextInt();
            keyin.nextLine();
            num = num - 1;

            /*
                邏輯運算子 || 說明：
                | 與 || 運算子是邏輯或 (OR) 的意思, 兩個運算元中 只要有一個是 true, 運算結果就是 true,
                只有在兩個 運算元的值都 是 false 的情況下, 運算結果才會是 運算結果才會是 false 。
                || 這一組運算子會在左 邊的運算元就可以決定運算結果的情況下忽略右 邊運算元 。
             */

            if ((num >= number) || (num < 0)) {
                System.out.printf("錯誤輸入!! 按任何鍵回主選單\n");
                keyin.nextLine();
                System.exit(1); //宣告強制離開
                return 999;
            }
            return num;
        }


    /* 儲存商品資料至外部檔案 storage.data */
    public static void save_data() throws IOException {
        BufferedWriter outData = new BufferedWriter(new FileWriter(file_R));  //儲存資料到 storage檔案中所以要寫入 Writer，因為是儲存商品資料至外部檔案 storage.data 所以變數我們寫 outData
        System.out.printf("** 將儲存檔案 (storage.data) **\n");
        for (int i = 0; i < number; i++) {                                    // i < 設定紀錄資料儲存筆數
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
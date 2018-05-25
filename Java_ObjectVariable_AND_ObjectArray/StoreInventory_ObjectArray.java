package Java_ObjectVariable_AND_ObjectArray;
/*
    超商庫存管理系統（運用物件陣列）_（可以搭配我們在 wiki 的學習講義 - 20_物件陣列的運用當中的20_4超商庫存管理系統（運用物件陣列））

    請幫『台北生鮮超市』建立一套庫存管理系統，
    該系統功能有：盤點庫存量（顯示所有商品資料）、進貨登錄功能（點選商品編號、再輸入進貨量）、出貨登錄功能（點選商品編號，再輸入出貨量）。

    假設超商僅有：可口餅乾（編號 A1001）、味全鮮乳（編號 A1002）、御便當（編號 A1003）、黑松汽水（編號 A1004）、頻果西打（編號 A1005）與脆笛酥（編號 A1006）。

    功能如下：

    一、期望操作介面有 5 個功能選項：
    ** 歡迎光臨　台北生鮮超市　庫存管理系統  **
    (1) 盤點庫存量    (2) 進貨登錄系統  (3) 出貨管理系統  (4) 離開系統
        請輸入選項 =>

    二、選擇進貨登錄系統(選擇 2)操作如下：
    (1) 盤點庫存量    (2) 進貨登錄系統  (3) 出貨管理系統  (4) 離開系統
        請輸入選項 =>2

    (1)可口餅乾(A1001)      (2)味全鮮乳(A1002)      (3)御便當  (A1003)
    (4)黑松汽水(A1004)      (5)頻果西打(A1005)      (6)脆迪蘇  (A1006)
        請輸入選項 =>3
        請輸入進貨數量 =>100

    三、選擇盤點庫存量(選擇 1)操作如下：
    (1) 盤點庫存量    (2) 進貨登錄系統  (3) 出貨管理系統  (4) 離開系統
        請輸入選項 =>1
    ***** 盤點庫存量如下 *****
    產品編號        　產品名稱       庫存量
    A1001           可口餅乾        300
    A1002           味全鮮乳        30
    A1003           御便當          100
    A1004           頻果西打        50
    A1005           頻果西打        20
    A1006           脆迪酥          45

    四、選擇出貨管理系統(選擇 3與 1)操作如下：
    ** 歡迎光臨　台北生鮮超市　庫存管理系統  **

    (1) 盤點庫存量    (2) 進貨登錄系統  (3) 出貨管理系統  (4) 離開系統
        請輸入選項 =>3
    (1)可口餅乾(A1001)      (2)味全鮮乳(A1002)      (3)御便當  (A1003)
    (4)黑松汽水(A1004)      (5)頻果西打(A1005)      (6)脆迪蘇  (A1006)
        請輸入選項 =>2
    請輸入出貨數量 =>20

    ** 歡迎光臨  春嬌超商 庫存管理系統  **
    (1) 盤點庫存量    (2) 進貨登錄系統  (3) 出貨管理系統  (4) 離開系統
        請輸入選項 =>1
    ***** 盤點庫存量如下 *****
    產品編號        產品名稱        庫存量
    A1001           可口餅乾        300
    A1002           味全鮮乳        10
    A1003           御便當          100
    A1004           頻果西打        50
    A1005           頻果西打        20
    A1006           脆迪酥          45

    製作技巧提示：
    本系統較特殊的地方是，系統開始時需將所預定的 6 樣產品資料填入物件陣列中，我們利用一個二維陣列（item][]）儲存這些資料，
    再寫一個簡單程式將他複製到物件陣列的產品名稱與編號上。其他程式規劃就較為簡單。

 */


import java.util.Scanner;

class Element_StoreInventory{
    String name;        //商品名稱
    String ID;          //商品編號
    int storage;        //商品庫存量
}


public class StoreInventory_ObjectArray {
    public static void main(String[] args) {
        Element_StoreInventory[] commodity = new Element_StoreInventory[30];          //宣告物件陣列
        Scanner keyin = new Scanner(System.in);

        int select, number, art;

        String[][] item = {{"可口餅乾", "A1001"},
                {"應充油", "A1002"},
                {"御便當  ", "A1003"},
                {"蘋果西打", "A1004"},
                {"芭樂牛雜", "A1005"},
                {"脆迪酥  ", "A1006"}};

        for (int i = 0; i < 6; i++) {                                    //將商品名稱與編號填入物件陣列中
            commodity[i] = new Element_StoreInventory();
            commodity[i].name = item [i][1];
            commodity[i].ID = item [i][0];

        }

        Print_menu();
        select = keyin.nextInt();


        while (select != 4) {
            switch (select) {
                case 1:
                    System.out.printf(" ******* 盤點庫存量如下 ******* \n");
                    System.out.printf("產品編號\t\t\t產品名稱\t\t\t庫存量\n\n");
                    for (int i = 0; i < 6; i++) {
                        System.out.printf("%s\t\t\t%s\t\t\t%d\n", commodity[i].ID, commodity[i].name, commodity[i].storage);
                    }
                    break;

                case 2:
                    Print_Element();
                    System.out.printf("\t請輸入選項 =>");
                    art = keyin.nextInt();
                    System.out.printf("請輸入進貨數量 =>");
                    number = keyin.nextInt();
//                    System.out.printf("請輸入進貨數量 =>");

                    commodity[art-1].storage = commodity[art-1].storage + number;
                    break;

                case 3:
                    Print_Element();
                    System.out.printf("\t請輸入選項 =>");
                    art = keyin.nextInt();
                    System.out.printf("請輸入出貨數量 =>");
                    number = keyin.nextInt();
                    if (number > commodity[art-1].storage)
                        System.out.printf("庫存不足，拒絕出貨！\n");
                    else {
                        commodity[art-1].storage = commodity[art-1].storage - number;
                    }
                    break;

                default:
                    System.out.printf("請重新選擇 \n");
                    break;
            }
            Print_menu();
            select = keyin.nextInt();
        }



    }

    /* 顯示庫存管理系統工作選項 */
    static void Print_menu() {
        System.out.printf("\n ******* 歡迎光臨, 台北生鮮超市庫存管理系統 ******* \n");
        System.out.printf("(1)盤點庫存量\t\t");
        System.out.printf("(2)進貨登錄系統\t");
        System.out.printf("(3)出貨管理系統\t");
        System.out.printf("(4)離開系統\t");
        System.out.printf("\n\t請輸入選項 =>");
    }
    
    /* 顯示庫存產品 */
    static void Print_Element() {
        System.out.printf("\n(1)可口餅乾(A1001)\t\t");
        System.out.printf("(2)應充油　(A1002)\t\t");
        System.out.printf("(3)御便當  (A1003)\t\t\n");
        System.out.printf("(4)蘋果西打(A1004)\t\t");
        System.out.printf("(5)芭樂牛雜(A1005)\t\t");
        System.out.printf("(6)脆迪酥  (A1006)\t\t\n");
    }
}
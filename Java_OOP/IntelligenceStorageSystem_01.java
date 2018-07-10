package Java_OOP;
/*
    『台北連鎖公司』期望建立一套智慧型的庫存管理系統。

    許多經理人都想盡辦法降低庫存量與增加銷售量，來增加公司的獲利，但兩者其實互相衝突。
    當庫存量不足時，可能會嚴重影響到銷售的順暢性，庫存量太高則會積壓公司資金，如何掌握最恰當的庫存量，
    實為考驗經理人能力的關鍵，最簡單的方法是隨時掌握目前庫存金額多寡。因此，『台北連鎖公司』期望建立一套智慧型的庫存管理系統。
    該系統允許選擇商品及進貨或出貨數量，進貨用正號（如 +10）；出貨用減號（如 -10）。
    庫存檔案儲存於 product.data 內，每一商品包含五個欄位：{品名、單價、庫存量、金額、總庫存金額}（如 可口奶滋 ），其中 "金額" 為該項產品庫存金額。
    "總庫存金額" 為所有庫存量的總金額；進出任何商品後，總庫存金額會登錄目前所有金額多寡。除了能滿足一般庫存系統的功能外，也能讓經理人隨時了解目前庫存金額多寡。期望操作介面如下：

    製作技巧研討：
    將 Product 類別中庫存總金額宣告成類別變數（static int total;），當任何一樣產品變更此內容時，所有產品的 total 值隨之改變。
    因此，查閱任何一筆資料都可以知道目前總庫存金額多寡。接著必須利用編輯工具(如 notepad ++) 建立一個 product.data 庫存資料檔，進入系統後它讀取庫存資料。

 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Product{
    String name;          //產品名稱
    int price;            // 單價
    int storage;          // 庫存量
    int deposit;          // 金額
    static int total;     // 庫存總金額(類別變數)
}

public class IntelligenceStorageSystem_01 {
    public static void main(String[] args) throws IOException {
        Product[] commodity = new Product[20];      // 宣告一個物件陣列叫做commodity
        Scanner keyin = new Scanner(System.in);
        String file = "Product.data";               // 請先在此檔案目錄下建立 Product.data 這個檔案
        String inData;
        int k=0, select, count;
        File fileID = new File(file);
        if (fileID.exists()){
            BufferedReader data = new BufferedReader(new FileReader(fileID));
            while ((inData = data.readLine()) != null){
                Scanner scan = new Scanner(inData).useDelimiter("\t");
                commodity[k] = new Product();
                commodity[k].name = scan.next();
                commodity[k].price = scan.nextInt();
                commodity[k].storage = scan.nextInt();
                commodity[k].deposit = scan.nextInt();
                commodity[k].storage = scan.nextInt();
                k = k + 1;
            }
            data.close();
        }
        else {
            System.out.println("%s file not existed\n");
            return;
        }
        System.out.printf("**** 未登錄前庫存量 ***\n");
        System.out.printf("品名\t\t單價\t庫存量\t金額\t總庫存金額\n");

        for (int i=0; i<k; i++){
            System.out.printf("%s\t%d\t%d\t%d\t%d\n", commodity[i].name,
                    commodity[i].price, commodity[i].storage,
                    commodity[i].deposit, commodity[i].total);
        }
        System.out.printf("\n");

        for (int i=0; i<k; i++) {
            System.out.printf("(%d) %s\t", i + 1, commodity[i].name);
        }

        System.out.printf("\n");
        System.out.printf("\t請輸入貨品編號(或大於 5 離開) =>");


        select = keyin.nextInt();

        if (select < 5) {
            System.out.printf("\t 進出貨數量 =>");
            count = keyin.nextInt();
            int s1 = select - 1;
            int m1 = commodity[s1].price * count;

            commodity[s1].storage = commodity[s1].storage + count;
            commodity[s1].deposit = commodity[s1].deposit + m1;
            commodity[s1].total = commodity[s1].total + m1;             //此範例的重點！意思是當我們計算某樣產品的 Total 值, 所有產品的 Total 值也會改變
        }


        System.out.printf("品名\t\t單價\t庫存量\t金額\t總庫存金額\n");

        for (int i=0; i<k; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\n", commodity[i].name,
                    commodity[i].price, commodity[i].storage,
                    commodity[i].deposit, commodity[i].total);
        }
        System.out.printf("總庫存金額(product.total) = %d\n", Product.total);
    }
}

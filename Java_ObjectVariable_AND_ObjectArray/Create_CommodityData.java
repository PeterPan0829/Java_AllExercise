package Java_ObjectVariable_AND_ObjectArray;

/*
    產生商品資料（可以搭配我們在 wiki 的學習講義 - 19_物件的傳統運用當中的19-3_產生商品資料）

    請幫『台北市超市』建立商品資料登錄系統，為了配合倉庫管理系統、銷售管理系統、會計管理系統使用，
    每一商品必需登錄有：編號（String）、名稱（String）、單價（int）、庫存量（int）、單位（String）、製造商（String）、安全庫存量（int）。
    請編寫系統，讓管理員可登錄商品資料，登錄後再由螢幕顯出結果。

    期望操作介面如下：
    
    ***** 輸入商品資料 *****
    請輸入商品編號 =>A10134
    請輸入商品名稱 =>肉燥麵
    請輸入單價 =>20
    請輸入庫存量 =>200
    請輸入安全庫存量 =>50
    請輸入單位 =>包
    請輸入製造商 =>統一食品股份有限公司

    ***** 印出商品資料 *****
    商品編號 = A10134
    商品名稱 = 肉燥麵
    單    價 = 20
    庫 存 量 = 200
    安全庫存量 = 50
    單    位 = 包
    製 造 商 = 統一食品股份有限公司
    
 */

import java.util.Scanner;

class Commodity {
    String ID;                  // 產品編號(key)
    String name;                // 產品名稱
    int price;                  // 單價
    int stogage;                // 庫存量
    int safetyStorage;          // 安全庫存量
    String unit;                // 單位
    String maker;               // 製造商
}


public class Create_CommodityData {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Commodity com = new Commodity();

        System.out.printf("***** 輸入商品資料 *****\n");
        System.out.printf("請輸入商品編號 =>");
        com.ID = keyin.nextLine();
        System.out.printf("請輸入商品名稱 =>");
        com.name = keyin.nextLine();
        System.out.printf("請輸入單價 =>");
        com.price = keyin.nextInt();
        System.out.printf("請輸入庫存量 =>");
        com.stogage = keyin.nextInt();
        System.out.printf("請輸入安全庫存量 =>");
        com.safetyStorage = keyin.nextInt();
        keyin.nextLine();
        System.out.printf("請輸入單位 =>");
        com.unit = keyin.nextLine();
        System.out.printf("請輸入製造商 =>");
        com.maker = keyin.nextLine();

        System.out.printf("\n***** 印出商品資料 *****\n");
        System.out.printf("商品編號 => %s\n",com.ID);
        System.out.printf("商品名稱 => %s\n",com.name);
        System.out.printf("單　　價 => %d\n",com.price);
        System.out.printf("庫 存 量 => %d\n",com.stogage);
        System.out.printf("安全庫存量 => %d\n",com.safetyStorage);
        System.out.printf("單　　位 => %s\n",com.unit);
        System.out.printf("製 造 商 => %s\n",com.maker);
    }
}

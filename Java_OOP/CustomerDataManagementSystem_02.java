package Java_OOP;
/*
   本範例和上一個範例 " 新增物件導向範例：01_規劃通用型人事資料（運用return及物件陣列方式）" 非常類似，如在練習時有遇到問題可以回去看上一個範例。

   『超可愛美容中心』希望建立一套客戶資料管理系統，登錄客戶資料，針對每位客戶包含有下列資料：

    (1) 身分字號（String SID）：須符合標準格式。
    (2) 姓名（String name）
    (3) 性別（String sex）：僅提供女性服務。
    (4) 年齡（int age）
    (5) 地址（String addr）

    請建立一個雛型客戶資料管理系統，測試系統規劃是否完備；該系統允許輸入客戶資料，再顯示是否正確。期望操作介面如下。

    請輸入 客戶姓名 =>張美麗
    請輸入身分字號 = >A277465487
    請輸入性別 =>女
    請輸入年齡 =>30
    請輸入地址 =>苗栗縣龍馬區
    === 列印客戶資料 ===
    身分證號        姓名     性別      年齡       地址
    A277465487    張美麗     女       30      高雄市鳥松區

    如果同學們只是要先做個測試的話, 建議身分證輸入同上 A277465487, 因為有寫特別的驗證方式。

    製作技巧提示：
    本系統最大的特點是，必須偵測所輸入的身分證字號是否正確，由這一點可觀察出客戶所提供的資料是否偽造。
    因此，需在客戶資料類別（Customer.class）必須提供此檢查功能。
    身份證號碼第一個字元 A ~ Z表示地區，第二個字元 1（男性）或 2（女性）表示性別，後面緊接著 7 個數字（0 ~ 9），最後是檢查碼（0~9），總共 10 個字。

    檢查方法如下：
    首先將英文字母以（A=10 B=11 C=12 D=13 E=14 F=15 G=16 H=17 J=18 K=19 L=20 M=21 N=22 P=23
    Q=24 R=25 S=26 T=27 U=28 V=29 W=30 X=31 Y=32 Z=33 I=34 O=35）轉換成數字，與原有數字組成 11 個數字；
    接著，第 1 數乘以 1、第 2 數乘以 9、第 3 個數乘以 8 ，依此類推第 9 個數乘以 2，第 10 個數乘以 1，將上述的結果相加，
    總和的個位數（num），再被 10 減的結果（10-mun），與第 11 個數字相同，則表示正確。

    本系統需要 Customer.java 與 CustomerDataManagementSystem.java 兩類別程式，前者規劃 Customer 類別使用；後者為主類別程式。

    其中, 此範例有使用到一些 library 來完成，詳細介紹我會放在 README 檔案中詳細說明：
    (1)SID_num2[i+1] = Integer.parseInt(SID_num1[i]);   字串轉換成整數
    (2)Sex_female.equals("女")   比較兩個物件是否為相同類型的類別後再比較其內容值是否相同
    (3)temp = Character.getNumericValue(SID_num1[0].charAt(0));    將數字字元，即0~9轉成整數型態
    (4)Scanner keyin = new Scanner(SID_No).useDelimiter("");     分隔號

 */

import java.util.Scanner;

class Customer{
    // Step 1 宣告相關變數


    String name;                    // 客戶姓名
    int age;                        // 年    齡
    String address;                 // 地    址
    private String SID;             // 身分證字號, 須符合格式
    private String sex;             // 性    別, 僅提供女性

    // Step 2 設置方法闡述邏輯
    int setSID(String SID_No){                          // 設定客戶身份證字號方法。如果 SID_No 字號符合標準格式，則執行正常，並回傳 1；否則拒絕操作並回傳 0。
        String[] SID_num1 = new String[10];             // 儲存身分證號字元
        int[] SID_num2 = new int[11];                   // 儲存轉換後數字
        int temp;                                       // 儲存所有字母

        if(SID_No.length() != 10){                      //檢視輸入身證號（SID_No）長度是否 10 個字元，如不是則拒絕操作，中斷並回傳 0。
            System.out.printf("需 10 個字元, 請重新輸入 !!");
            return 0;
        }

        Scanner keyin = new Scanner(SID_No).useDelimiter("");
        for (int i=0; i<10; i++){                       //將輸入身份證字號（SID_No）各個字元取出，並分別存入 SID_num1[] 陣列中。
            SID_num1[i] = keyin.next();
        }

        temp = Character.getNumericValue(SID_num1[0].charAt(0));   //檢視身份正字號的第一個字母（A ~ Z），並轉換成相對應數字。
        if (temp == 18){              // 字母 I, 設定為 34
            temp = 34;
        }
        else if (temp == 24){         // 字母 O, 設定為 35
            temp = 35;
        }
        else if ((temp > 18) || (temp < 24)){  // J ~ N 前進 1 個數
            temp = temp - 1;
        }
        else if (temp > 24){
            temp = temp - 2;                   // P ~ Z 前進 2 個數
        }

        for (int i = 1; i<10; i++){
            SID_num2[i+1] = Integer.parseInt(SID_num1[i]);        //字串轉換成整數（SID_num1是字串） 轉換完丟給 SID_num2　
        }                                                         //流程的解釋就是將其餘身份證號碼，與第一個字母相對應的數字，分別依序存入 SID_num2[] 陣列中。
        SID_num2[0] = temp / 10;
        SID_num2[1] = temp % 10;

        int sum = SID_num2[0];                  // 第 1 個數字乘 1
        int k = 9;                              // 累加計算 SID_num2[] 陣列內的數字。
        for (int i=1; i<10; i++){               // 第 2 ~ 9 數字分別
            sum = sum + SID_num2[i] * k;        // 乘以 9 ~ 1 累加
            k = k-1;
        }

        int check = 10 - (sum % 10);            // 10 減掉累積後的個位數
        if (check == SID_num2[10]){             // 與第 11 個數字比對是否相同，如是的話，格式相符；否則可能該身份證字號是偽造或輸入錯誤。
            SID = SID_No;
            return 1;
        }else {
            System.out.printf("這是偽造的 !! \n");
            return 0;
        }
    }

    String getSID(){                            // 取得客戶身份證字號的方法。
        return SID;
    }

    int setSex(String Sex_female){              //設定客戶性別的方法。如果 Sex_female 為女性則執行正常，並回傳 1；否則拒絕操作回傳 0。
        if (Sex_female.equals("女") || Sex_female.equals("女生")){ //equals在類別為Java原先就存在時，是比較兩個物件是否為相同類型的類別後再比較其內容值是否相同，是就傳回true，否就傳回false。當要測試的類別是自定類別時，要依自定類別所提供的equals來決定如何比較
            sex = Sex_female;
            return 1; 
        }else {
            System.out.printf("僅服務女性 !! 對不起 \n");
            return 0;
        }
    }

    String getSex(){                            // 取得客戶性別的方法。
        return sex;
    }
}

public class CustomerDataManagementSystem_02 {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Customer guest = new Customer();

        int age;
        String id, name, sex, address;

        System.out.printf("**** 超可愛美容中心建立客戶資料 *****\n");
        System.out.printf("請輸入客戶姓名 =>");
        guest.name = keyin.nextLine();

        // id 身分證字號和 sex 性別都是屬於 private, 所以必須透過 method 去取得
        System.out.printf("請輸入身分字號 =>");
        id = keyin.nextLine();
        if (guest.setSID(id) == 0){
            System.out.printf("程式停止運作\n");
            return;
        }

        System.out.printf("請輸入性別 =>");
        sex = keyin.nextLine();
        if (guest.setSex(sex) == 0){
            System.out.printf("程式停止運作\n");
            return;
        }

        System.out.printf("請輸入年齡 =>");
        guest.age = keyin.nextInt();                        //須特別留意，因為我們有從 Customer 這個 class 宣告產生一個物件 guest, 所以這裡輸入我們必須要用 guest.age 不能以 age = keyin.nextline;
        keyin.nextLine();                                   // 清除鍵盤緩衝器
        if (guest.age == 0){
            System.out.printf("程式停止運作\n");
            return;
        }

        System.out.printf("請輸入地址 =>");
        guest.address = keyin.nextLine();
        if (guest.address == ""){
            System.out.printf("程式停止運作\n");
            return;
        }
                System.out.printf("**** 列印客戶資料表 *****\n");
                System.out.printf("身分證字號     　姓名    性別　　年齡　　地址\n");
                System.out.printf("%s\t  ",guest.getSID());
                System.out.printf("%s\t\t",guest.name);
                System.out.printf("%s\t  ",guest.getSex());
                System.out.printf("%d\t",guest.age);
                System.out.printf("%s\t",guest.address);
    }
}

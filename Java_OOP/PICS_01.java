package Java_OOP;

/*
（可以搭配我們在 wiki 的學習講義 - 23_3_物件的產生當中的 23_3_2 物件產生命令 – 範例：規劃通用型人事資料）

諾亞方舟網路行銷公司需要一套較完整的人事資訊系統 PICS，該系統允許編輯員工資料，每一員工的描述屬性有：
(1) 員工代號（ID）：整數。必須高於 1000，且低於 5000。
(2) 姓名（name）：字串。
(3) 部門（depart）：字串。
(4) 底薪（payment）：整數。必須高於最低薪資 15800 元。
(5) 加班時數（extra）：整數。最高 45 小時。

請先建立一雛型程式 EmployeePICS.class 允許輸入員工資料，如輸入資料不符規定，則不予輸入並顯示錯誤原因。
輸入完畢後印出該員工的薪資表，其中加班費計算方式為每小時 = (底薪 / (30 * 8)) * 1.5。

期望操作介面如下：
** 諾亞方舟 建立員工資料 **
請輸入 員工姓名 =>張大得
請輸入員工部門 = >資訊部
請輸入員工代號 =>1201
請輸入員工底薪 =>45000
請輸入員工加班時數 =>23
**** 列印員工薪資表 *****
代號   姓名     部門    本月薪資
1201  張大得   資訊部    49301

(a) 公開變數：有 name(員工姓名) 與 depart(服務部門)等 2 個變數，外部程式可以直接存取(讀或寫)。

(b) 私有變數：有 ID(員工編號)、payment(底薪) 與 extra(加班時數) 等 3 個變數，外部程式不可以直接存取，必須透過輸入/輸出埠口存取，如 setID()、getID()、、、等物件方法。
 */

import java.util.Scanner;

/* 宣告物件成員 */
class EmployeePICS{
    private int ID;             // 員工代號, 介於 1000~5000
    private int payment;        // 底    薪 > 15800
    private int overtime;       // 加班時數 < 45
    public String name;         // 員工姓名
    public String deprat;       // 所屬部門


/* 宣告物件方法 */
    int setID(int i){                   // 設定員工代號方法, 1: 正常, 0: 錯誤
        if ((i > 1000) && (i < 5000)){
            ID = i;
            return 1;
        }
        else{
            System.out.printf("員工代號必須是大於 1000 小於 5000 的範圍!!\n");
            return 0;
        }
    }

    int getID(){                        // 讀取員工代號方法
        return ID;
    }

    int setPayment(int pay){            //設定底薪方法, 1: 正常, 0: 錯誤
        if (pay < 15800){
            System.out.printf("底薪不可低於 15800 元\n");
            return 0;
        }else {
            payment = pay;
            return 1;
        }
    }

    int getPayment(){                   // 讀取底薪方法
        return payment;
    }

    int setOvertime(int over){          // 設定加班時數方法, 1: 正常, 0: 錯誤
        if (over > 45){
            System.out.printf("加班時數不可超過 45 小時\\n");
            return 0;
        }else {
            overtime = over;
            return 1;
        }
    }

    int getOvertime(){                  // 取得加班時數方法
        return overtime;
    }
}

/*
程式重點說明：
        (1) 宣告類別的變數成員，並指定其相關屬性（如 private）。

        (2) 『int setID(int i) { ..}』。
            宣告 setID() 方法成員，該方法被呼叫時，會攜帶參數 i，如果該參數介於 1000 與 5000 之間，則設定員工代號，並回傳一個整數 1；否則拒絕設定回傳 0。

        (3) 『int getID() {…}』。宣告 getID() 方法成員，功能是回傳員工代號（ID）。

        (4) 『int setPayment(int pay) { ..}』。
            功能是設定員工底薪的方法成員；當引數（pay）底薪低於 15800 元，該方法會拒絕輸入，並回傳一個整數 0；否則回傳整數 1。

        (5) 『int getPayment() {…}』。 讀取員工底薪的方法成員。

        (6) 『int setOvertime(int over) { ..}』。輸入員工加班時數的方法成員；當引數超過 45 時，會拒絕輸入並回傳 0；否則回傳 1。

        (7) 『int getOvertime() { … }』。讀取員工加班時數的方法成員。
*/


public class PICS_01 {

    /*
    EmployeePICS.class 於同一目錄下
    製作完成 EmployeePICS 類別之後，我們需要再編寫 main 主程式，引用 EmployeePICS 該類別來產生工作員（worker）。
    針對 worker 物件輸入與輸出資料，證實 EmployeePICS 類別所提供的方法與變數成員是否能滿足所需。

    請建立一套人事資訊系統，該系統允許員工輸入資料，並印出該員工的薪資表
    */
    
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        EmployeePICS worker = new EmployeePICS();           //利用 EmployeePICS 類別產生 worker 物件，則該物件擁有原類別所宣告的方法與變數成員。
        int id, pay, over_hour, pay_total;                  //變數分別是：員工代號、本月固定薪資、加班時數、薪資加上加班費的本月薪資總額

        System.out.printf("** 諾亞方舟 建立員工資料 **\n");
        System.out.printf("請輸入員工姓名 =>");
        worker.name = keyin.nextLine();                     //Worker.name 變數成員屬於 public 的（非 private），可以直接存取。
        System.out.printf("請輸入員工部門 =>");
        worker.deprat = keyin.nextLine();
        System.out.printf("請輸入員工代號 =>");
        id = keyin.nextInt();
        keyin.nextLine();                                   // 清除鍵盤緩衝器
        if (worker.setID(id) == 0){                         //呼叫 worker 物件的 setID() 方法成員，表示透過 setID() 將引數 id 值寫入 ID 變數內。執行後回傳是 0 的話，表示執行不正確。因 worker.ID 是 private 變數，無法直接存取，必須透過其他方法成員才行。
            System.out.printf("程式停止運作\n");
            return;
        }

        System.out.printf("請輸入員工底薪 =>");
        pay = keyin.nextInt();
        keyin.nextLine();                                   // 清除鍵盤緩衝器
        if (worker.setPayment(pay) == 0){                   // 判斷是否正常設定
            System.out.printf("程式停止運作\n");
            return;                                         //理解為什麼要 return !! 詳細介紹我有寫在 wiki 當中，請參考!
        }

        System.out.printf("請輸入員工加班時數 =>");
        over_hour = keyin.nextInt();
        keyin.nextLine();                                   // 清除鍵盤緩衝器
        if (worker.setOvertime(over_hour) == 0) {           // 判斷是否正常設定
            System.out.printf("程式停止運作\n");
            return;
        }

        /*
        驗證直接存取 private ID 的結果

        id = worker.ID;            // 直接存取 private 屬性的變數成員會出現錯誤(可自行嘗試)
        System.out.printf("ID = %d\n", id);

        結束驗證
        */

        System.out.printf("**** 列印員工薪資表 *****\n");
        System.out.printf("代號     姓名    部門    本月薪資\n");
        System.out.printf("%d\t",worker.getID());
        System.out.printf("%s\t",worker.name);
        System.out.printf("%s\t",worker.deprat);
        pay = worker.getPayment();
        pay_total = (int)((double)pay / (30 * 8) * 1.5) * worker.getOvertime(); //加班費計算方式為每小時 = (底薪 / (30 * 8)) * 1.5
        System.out.printf("%d\n",pay + pay_total);
    }
}

package Java_ObjectVariable_AND_ObjectArray;

/*
    請參考 wiki 22-3_紀錄檔案的輸入＆輸出運用當中的22-3-4記錄檔案輸出格式_範例：建立人事管理資訊系統。

    『彼得網路行銷公司』希望建立一個電子化管理系統，其中包含若多個子系統，各子系統所使用的員工資料都能夠統一處理，才不至於發生各系統之間不一致的問題。
    請幫該公司規劃員工資料的屬性，並建立『人事資料管理系統』可讓管理人員『新增』、『修改』與『刪除』員工資料，爾後其他子系統也可引用該資料（Human.data）。
    目前預估員工資料包含有：員工代號、姓名、服務部門、性別、出生、底薪、職務加級等屬性，並由獨立檔案製作而成（BuiltHRsystem_ObjectArray.java），經過編譯後產生 BuiltHRsystem_ObjectArray.class。

    至於員工資料請以 Human.data 檔案名稱儲存。
    第一次執行沒有 Human.data 檔案，則利用編輯工具(如：notepad++) 開啟一個新檔，直接另存新檔並將檔名取 “Human.data”(雙引號包起來，不要輸入任何內容)，再儲存於本程式的同一目錄下即可。

    期望操作介面與執行結果如下：
    (1) 執行該檔案之前，需先建立 Human.data，如果該檔案不在，則會要求先建立後再執行，如下：(系統啟動時，會將 Human.data 檔案內容讀入)
        D:\Java2_book\peter\BuiltHRsystem_ObjectArray>java BuiltHRsystem_ObjectArray
        Human.data 檔案不存在, 請先建立它
        按<enter>鍵離開 =>

    (2) 系統包含 6 個工作選項，無論增加、修改或刪除員工資料之後，都必儲存資料才有效，亦是，離開系統(選項 6) 之前必須儲存資料(選項 5)，選單如下：
        D:\Java2_book\peter\BuiltHRsystem_ObjectArray>java BuiltHRsystem_ObjectArray
        === 人事資料管理系統 ===
        (1) 顯示所有資料        (2) 增加員工資料        (3) 修改員工資料
        (4) 刪除員工資料        (5) 儲 存 資 料        (6) 離 開 系 統
        請選擇工作項目 =>

    (3) 選擇 (1) 表顯示系統內所有員工資料，如下：
        請選擇工作項目 => 1
        = 列印所有員工資料 ==
        代號    姓名    部門    性別       出生    底薪    加級
        101    王力宏  會計課    男      63/12/5  80000   40000
        102    張惠妹  業務課    女      64/3/12  90000   70000
        103    蔡依玲  製造課    女      67/3/15  80000   60000

    (4) 工作選項(2)是增加員工資料，操作介面如下：
        請選擇工作項目 => 2
        請輸入員工編號 =>7106
        請輸入姓名 =>劉有得
        請輸入服務部門 =>資訊部
        請輸入性別 (男/女) =>男
        請輸入生日 (西元/月/日) =>71/09/12
        請輸入底薪 =>54000
        請輸入職務加級 =>11000

    (5) 工作選項(3)是修改員工資料，操作介面如下：
        請選擇工作項目 => 3
        請輸入欲修改員工的代號 =>7105
        請輸入 張有德 姓名 =>張有得
        請輸入 資訊部 服務部門 =>製造部
        請輸入性別 男 (男/女) =>男
        請輸入生日 75/09/23 (年/月/日) =>76/09/23
        請輸入 60000 底薪 =>50000
        請輸入 20000 職務加級 =>20000

    (6) 工作選項(4)是刪除員工資料，操作介面如下：
        請選擇工作項目 => 4
        請輸入欲刪除員工的代號 =>7105
        7105 資料已刪除 !!

    (7) 工作選項(5)是將目前員工資料儲存到檔案內，操作介面如下：
        請選擇工作項目 => 5
        ** 將儲存檔案 (Human.dada) **
        ***** 儲存完畢 ****

    （B）製作技巧研討：
        (1) 建立一個專屬員工資料類別的原始檔案（BuiltHRsystem_ObjectArray.java），類該類別內的變數成員較能符合其他管理系統運用。
        (2) 需要針對 Human.data 檔案宣告產生輸入與輸出物件。
        (3) 可依照本系統所提供的功能，劃分多個子系統再分別實現。為了讓子系統能直接處理員工資料，而將其物件陣列（Personal[] employee;）與登記所儲存資料筆數的變數（int k;），設定成類別靜態變數（static）。
        (4) 主方法（main()）：宣告檔案（Human.data）輸入與輸出物件、儲存資料的物件陣列（employee[]）。讀取 Human.data 檔案內容，並分別將各個欄位內容填入相對應的物件陣列的變數成員內。再利用 while/switch/case 迴圈讀取操作者的工作選項。
        (5) 主選單程式（main_menu()）：顯示本系統所提供的工作項目。
        (6) 顯示資料子程式（disp_data()）：將目前物件陣列（employee[]，靜態變數）登錄的員工資料，輸出顯示到螢幕上。
        (7) 增加資料子程式（add_data()）：可輸入增加一位員工資料到物件陣列（employee[]）上。
        (8) 修改資料子程式（modify_data）：修改物件陣列（employee[]）內某位員工的資料。
        (9) 刪除資料子程式（delete_data）：刪除物件陣列（employee[]）內某位員工的資料。
        (10)儲存資料子程式（save_data）：依序將物件陣列（employee[]）各筆員工資料輸出到檔案（Human.data）上。
 */

import java.io.*;
import java.util.Scanner;

class Personal {
    int ID;             // 員工代號
    String name;        // 員工姓名
    String department;  // 服務部門
    String sex;         // 性    別
    String birth;       // 出生日期
    int payment;        // 底    薪
    int duty;           // 職務加級
}

public class BuiltHRsystem_ObjectArray {
    static Personal[] employee;                                   // 員工資料的物件陣列
    static int k;                                                 // 紀錄儲存筆數
    static Scanner keyin;                                         // 鍵盤輸入物件
    
    public static void main(String[] args) throws IOException {
        keyin = new Scanner(System.in);

        /* 讀取 Human.data 檔案資料, 再存入 employee 物件陣列中 */
        employee = new Personal[50];
        k = 0;                                                    // 讀取資料的筆數
        String inData;
        String file_R = "Human.data";
        File fileID = new File(file_R);                           // 產生輸入檔案物件
        if (fileID.exists()){                                     // 如果這份文件存在的話
            BufferedReader data = new BufferedReader(new FileReader(fileID));
            while ((inData=data.readLine()) != null){             // readLine() 這個方法意思是讀一行，如果不是空的就繼續讀'
                Scanner scanner = new Scanner(inData).useDelimiter("\t");                           //宣告成 Scanner 物件並設定分界符號（\t），物件名稱為 scanner
                employee[k] = new Personal();                                                       //這裡很重要唷！這個 class 當中可以 "呼叫產生" Personal 這個物件變數。白話就是，我宣告產生一個 Personal 的物件名字叫做 employee 同時利用 Personal 這個類別 new 產生物件放到 employee 裡面，所以就能使用 Personal() 這個class 當中的方法成員或物件成員！！看到 "=" 先看等號的右邊！！
                employee[k].ID = scanner.nextInt();                                                 //讀取一整數，再存入陣列物件的變數成員內。以下的順序要注意喔!! 先去讀取員工代號!!
                employee[k].name = scanner.next();
                employee[k].department = scanner.next();
                employee[k].sex = scanner.next();
                employee[k].birth = scanner.next();
                employee[k].payment = scanner.nextInt();
                employee[k].duty = scanner.nextInt();
                k = k + 1;
            }
            data.close();
        }else {
            System.out.printf("%s 檔案不存在, 請先建立它\n", file_R);
            System.out.printf("按任何鍵離開 =>");
            keyin.nextLine();
            System.exit(1);                                                                   //強迫程式結束 System.exit(1); 正常結束 System.exit(0); 使用其他數字，則會關閉應用程式 System.exit(2);
        }
        mainMenu();
        int select = keyin.nextInt();
        while (select != 6){
            switch (select){
                case 1:             /* 顯示員工資料 */
                    disp_data();
                    break;
                case 2:             /* 增加員工資料 */
                    add_data();
                    break;
                case 3:             /* 修改員工資料 */
                    modify_data();
                    break;
                case 4:             /* 刪除資料 */
                    delete_data();
                    break;
                case 5:              /* 儲存資料 */
                    save_data();
                    break;
                default:
                    System.out.printf("錯誤輸入, 請重新選擇 !!\n");
            }
            mainMenu();
            select = keyin.nextInt();
        }
    }
    public static void mainMenu() {
        System.out.printf("\n=== 人事資料管理系統 ===\n");
        System.out.printf("(1) 顯示所有資料\t");
        System.out.printf("(2) 增加員工資料\t");
        System.out.printf("(3) 修改員工資料\n");
        System.out.printf("(4) 刪除員工資料\t");
        System.out.printf("(5) 儲 存 資  料\t");
        System.out.printf("(6) 離 開 系  統\n");
        System.out.printf("請選擇工作項目 => ");
    }

    public static void disp_data() {                                        /* 顯示員工資料 */
        System.out.printf("== 列印所有員工資料 ==\n");
        System.out.printf("代號\t姓名\t部門\t性別\t出生\t底薪\t加級\n");
        for (int i=0; i<k; i++) {
            System.out.printf("%d\t", employee[i].ID);
            System.out.printf("%s\t", employee[i].name);
            System.out.printf("%s\t", employee[i].department);
            System.out.printf("%s\t", employee[i].sex);
            System.out.printf("%s\t", employee[i].birth);
            System.out.printf("%d\t", employee[i].payment);
            System.out.printf("%d\n", employee[i].duty);
        }
}
    public static void add_data() throws IOException{                                           /* 增加員工資料 */
        employee[k] = new Personal();
        System.out.printf("請輸入員工編號 =>");
        employee[k].ID = keyin.nextInt();
        keyin.nextLine();                                                    //清除鍵盤緩衝器
        System.out.printf("請輸入姓名 =>");
        employee[k].name = keyin.nextLine();
        System.out.printf("請輸入服務部門 =>");
        employee[k].department = keyin.nextLine();
        System.out.printf("請輸入性別 (男/女) =>");
        employee[k].sex = keyin.nextLine();
        System.out.printf("請輸入生日 (年/月/日) =>");
        employee[k].birth = keyin.nextLine();
        System.out.printf("請輸入底薪 =>");
        employee[k].payment = keyin.nextInt();
        System.out.printf("請輸入職務加級 =>");
        employee[k].duty = keyin.nextInt();
        k = k + 1;
    }
    public static void modify_data() throws IOException {                     /* 修改員工資料 */
        System.out.printf("請輸入欲修改員工的代號 =>");
        int number = keyin.nextInt();
        keyin.nextLine();          //清除鍵盤緩衝器
        int flag = 0;
        int i = 0;
        while(i < k) {
            if (employee[i].ID == number) {
                flag = 1;
                break;
            }
            i = i + 1;
        }
        if (flag == 0) {
            System.out.printf("test here 5\n");
            System.out.printf("沒有 %d 資料, 拒絕處理 !!\n", number);
            return;
        }
        System.out.printf("請輸入 %s 姓名 =>", employee[i].name);
        employee[i].name = keyin.nextLine();
        System.out.printf("請輸入 %s 服務部門 =>", employee[i].department);
        employee[i].department = keyin.nextLine();
        System.out.printf("請輸入性別 %s (男/女) =>", employee[i].sex);
        employee[i].sex = keyin.nextLine();
        System.out.printf("請輸入生日 %s (年/月/日) =>", employee[i].birth);
        employee[i].birth = keyin.nextLine();
        System.out.printf("請輸入 %d 底薪 =>", employee[i].payment);
        employee[i].payment = keyin.nextInt();
        System.out.printf("請輸入 %d 職務加級 =>", employee[i].duty);
        employee[i].duty = keyin.nextInt();
    }

    public static void delete_data() throws IOException {                      /* 刪除資料 */
        System.out.printf("請輸入欲刪除員工的代號 =>");
        int num = keyin.nextInt();
        int flag = 0, m = 0;
        while(m < k) {
            if (employee[m].ID == num){
                flag = 1;
                break;
            }
            m = m + 1;
        }
        if (flag == 0){
            System.out.printf("沒有 %d 資料, 拒絕處理 !!\n", num);
            return;
        }
        for(int i=m; i<k; i++)
            employee[i]=employee[i+1];
        k = k - 1;
        System.out.printf("%d 資料已刪除 !!\n", num);
    }

    public static void save_data() throws IOException {                         /* 儲存資料 */
        String file = "Human.data";
        BufferedWriter outData = new BufferedWriter(new FileWriter(file));
        System.out.printf("** 將儲存檔案 (Human.dada) **\n");
        for (int i=0; i<k; i++) {
            outData.write(employee[i].ID + "\t");
            outData.write(employee[i].name + "\t");
            outData.write(employee[i].department + "\t");
            outData.write(employee[i].sex + "\t");
            outData.write(employee[i].birth + "\t");
            outData.write(employee[i].payment + "\t");
            outData.write(employee[i].duty + "\n");
        }
        outData.close();
        System.out.printf("***** 儲存完畢 ****\n");
    }
}

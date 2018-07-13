package Java_OOP;
/*
    範例2：儲蓄存款系統

    請幫『藝術銀行』建立一套『儲蓄存款系統』的雛形系統。
    帳戶規格 (Account.class) 經過驗證可行之後，進一步建立儲蓄存款系統。包含有下列功能：
    (1) 讀入現有帳戶資料(deposit.data)。
    (2) 顯示帳戶：顯示系統每一帳戶的姓名、帳號與餘額。
    (3) 存款：客戶提款功能，選擇後會要求輸入客戶帳號，再要求輸入存款金額，執行後會顯示目前餘額。
    (4) 提款：選擇後會要求輸入客戶帳號，再要求輸入提款金額，執行後會顯示目前餘額。
    (5) 查詢餘額：選擇後會要求輸入客戶帳號，再顯示餘額。
    (6) 儲存資料：將資料寫入 deposit.data 檔案內。

    沿用設計完成的 Account.class 類別，並利用它產生一個物件陣列deposit.data，儲存客戶帳戶資料。
    系統啟動時，必須將 deposit.data（必須先在此目錄下新增這個檔案, 空白的沒關係）資料寫入陣列內。
 */

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class CreateDepositSystem4_2 {
    static Account[] customer;                      // 客戶資料的物件陣列
    static int k=0;                                 // 紀錄儲存筆數
    static Scanner keyin;                           // 鍵盤輸入物件（我們把它寫成類別共用的物件變數, 以便其它 method 可以共同使用）
    static String file_R = "deposit.data";

    public static void main(String[] args) throws IOException {
        keyin = new Scanner(System.in);             // 因為我們把 keyin 寫成類別物件變數所以可以在這個 main() 使用
        customer = new Account[50];                 // 最多儲存五十個客戶的資料

        mainMenu();                                 // 呼叫 顯示主選單
        int select = keyin.nextInt();               // 這個 select 其實就是去使用 keyin 這個輸入物件, 在顯示主選單去選取當成遙控而已
        keyin.nextLine();                           // 鍵盤緩衝器
        while (select != 8){
            switch (select){
                case 1:             /* 讀入帳戶資料 */
                    readData();
                    break;
                case 2:
                    addAccount();   /* 新建立帳戶 */
                    break;
                case 3:             /* 顯示所有帳戶 */
                    showData();
                    break;
                case 4:             /* 提款作業 */
                    getMoney();
                    break;
                case 5:             /* 存款作業 */
                    saveMoney();
                    break;
                case 6:             /* 查詢餘額 */
                    checkMoney();
                    break;
                case 7:             /* 儲存帳戶資料 */
                    saveData();
                    break;
                    default:
                        System.out.printf("錯誤輸入, 請重新選擇 !!\n");
            }
            mainMenu();
            select = keyin.nextInt();
            keyin.nextLine();
        }
    }

    /* 顯示主選單 */
    public static void mainMenu() {
        System.out.printf("\n== 藝術銀行 活期儲蓄系統 ==\n");
        System.out.printf("(1) 讀入所有帳戶\t");
        System.out.printf("(2) 建 立 新帳戶\t");
        System.out.printf("(3) 顯示所有帳戶\n");
        System.out.printf("(4) 帳戶提款作業\t");
        System.out.printf("(5) 帳戶存款作業\t");
        System.out.printf("(6) 帳戶查詢餘額\n");
        System.out.printf("(7) 儲 存 資  料\t");
        System.out.printf("(8) 離 開 系  統\n");
        System.out.printf("請選擇工作項目 => ");
    }

    /* 讀取 deposit.data 檔案資料, 再存入 customer 物件陣列中 */
    public static void readData() throws IOException {
        String inData;
        String Write_ID;                  // 讀入帳戶資料獨有的變數
        int money;
        File fIleID = new File(file_R);                 // 產生輸入檔案物件
        if (fIleID.exists()){
            BufferedReader data = new BufferedReader(new FileReader(fIleID));
            while ((inData=data.readLine()) != null){
                Scanner scanner = new Scanner(inData).useDelimiter("\t");
                customer[k] = new Account();
                Write_ID = scanner.next();
                if (customer[k].writeID(Write_ID) == 0){
                    System.out.printf("%s 帳戶不對\n", Write_ID);
                    continue;
                }
                customer[k].name = scanner.next();
                money = scanner.nextInt();
                customer[k].SaveMoney(money);
                k = k + 1;
            }
            data.close();
        }
        else {
            System.out.printf("%s 檔案不存在, 請先建立它\n", file_R);
            System.out.printf("按任何鍵離開 => ");
            keyin.nextLine();
            System.exit(1);
        }
    }

    /* 建立新帳戶 */
    public static void addAccount(){
        String ID_addAccount_Str;               // 建立新帳戶獨有的變數
        customer[k] = new Account();
        System.out.printf("\n***建立新帳戶***\n請輸入姓名=> ");
        customer[k].name = keyin.nextLine();
        System.out.printf("\n請輸入帳號(12 位數字) => ");
        ID_addAccount_Str = keyin.nextLine();
        int flag = customer[k].setID(ID_addAccount_Str);
        if (flag == 0){
            return;
        }
        System.out.printf("\n請輸入存款金額 => ");
        int money = keyin.nextInt();
        int balance = customer[k].SaveMoney(money);
        System.out.printf("餘額 = %d\n", balance);
        k = k + 1;
    }

    /* 顯示所有帳戶 */
    public static void showData(){
        System.out.printf("\n== 列印所有帳戶資料 ==\n");
        System.out.printf("帳號\t\t\t\t姓名\t\t 餘額\n");
        for (int i=0; i<k; i++){
            int[] ID = customer[i].getID();
            for (int j=0; j<13; j++){
                System.out.printf("%d",ID[j]);
            }
            System.out.printf("\t");
            System.out.printf("%s\t", customer[i].name);
            System.out.printf("%d\n", customer[i].checkMoney());
        }
    }

    /* 檢查帳號 */
    public static int checkAccount(String ID_checkAccount_Str){ // 檢查帳號獨有的變數
        int[] ID = new int[13];
        int[] ID_R = new int[13];
        int account, flag=0;
        Scanner scanner = new Scanner(ID_checkAccount_Str).useDelimiter("");
        for (int i=0; i<13; i++){
            ID[i] = scanner.nextInt();
        }

        for (account=0; account<k; account++){
            ID_R = customer[account].getID();
            if (Arrays.equals(ID,ID_R)){    // 比較兩個陣列中的元素值是否全部相等，如果是將傳回true，否則傳回 false*
                flag = 1;
                break;
            }
        }

        if (flag == 0){
            System.out.printf("無此帳號，請離開 !!\n");
            return -1;
        }
        else {
            return account;
        }
    }

    /* 存款作業 */
    public static void saveMoney(){
        int[] ID = new int[13];
        int flag;
        System.out.printf("請輸入提款帳號 => ");
        String ID_saveMoney_Str = keyin.nextLine();               // 存款帳號獨有的變數
        int account = checkAccount(ID_saveMoney_Str);
        if (account < 0){
            System.out.printf("無此帳號，請離開 !!\n");
            return;
        }
        System.out.printf("請輸入存款金額 => ");
        int money = keyin.nextInt();
        int m = customer[account].SaveMoney(money);               // m 是餘額暫存變數
        String name = customer[account].name;
        System.out.printf("帳戶：%s 目前餘額為：%d\n", name, m);
    }

    /* 提款作業 */
    public static void getMoney(){
        System.out.printf("請輸入存款帳號 => ");
        String ID_getmoney_Str = keyin.nextLine();                // 提款帳號獨有的變數
        int account = checkAccount(ID_getmoney_Str);
        if (account < 0){
            System.out.printf("無此帳號，請離開 !!\n");
            return;
        }
        System.out.printf("請輸入提款金額 => ");
        int money = keyin.nextInt();
        int m = customer[account].getMoney(money);     // 餘額暫存變數 (但應該要學會使用"獨立性"的變數名稱比較直觀)
        if (m < 0){
            System.out.printf("存款不足、請離開 !!\n");
            return;
        }
        String name = customer[account].name;
        System.out.printf("帳戶：%s 目前餘額為：%d\n", name, m);
    }

    /* 查詢餘額  */
    public static void checkMoney(){
        System.out.printf("請輸入存款帳號 => ");
        String ID_checkmoney_Str = keyin.nextLine();               // 查詢餘額獨有的變數
        int account = checkAccount(ID_checkmoney_Str);
        if (account < 0){
            System.out.printf("無此帳號，請離開 !!\n");
            return;
        }
        int m = customer[account].checkMoney();
        String name = customer[account].name;
        System.out.printf("帳戶：%s 目前餘額為：%d\n", name, m);
    }

    /* 儲存資料 */
    public static void saveData() throws IOException {
        BufferedWriter outData = new BufferedWriter(new FileWriter(file_R));
        int[] ID_R = new int[13];
        System.out.printf("** 將儲存檔案 (depoist.dada) **\n");
        for (int i=0; i<k; i++){
            long temp = 0;                                         // Java 的整數有 byte, short, int. 數值較大這裡用long
            ID_R = customer[i].getID();
            for (int j=0; j<13; j++){
                temp = temp + ID_R[j];
                temp = temp * 10;
            }
            temp = temp / 10;
            outData.write(temp + "\t");
            outData.write(customer[i].name + "\t");
            outData.write(customer[i].checkMoney() + "\t");
            outData.newLine();
        }
        outData.close();
        System.out.printf("***** 儲存完畢 ****\n");
    }
}

        
    


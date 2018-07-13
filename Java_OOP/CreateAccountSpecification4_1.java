package Java_OOP;

/*
    此為一連串的範例練習，總共有四則我會在檔名附註 4_1, 總共有 4_1 ~ 4_4 四則。
    從這四個範例練習會讓大家知道物件導向每個事項的優勢和限制，那我們該如何做?
    舉例來說，如果變數設置成 private 要如何對這個變數存取? (#物件方法) 對吧?
    這裡會展示所有的功能和物件導向的完整教學!!

    範例1：建立存款帳戶規格

    系統需要建立客戶帳戶。每一存款帳戶包含：姓名（String name）、帳戶（String No）與存款餘額（int balance），各項資料限制如下：
    (1) 帳戶：由 12 個數字與 1 個檢查碼所構成（合計 13 碼），檢查碼計算方式是利用一個加權系列： 1 3 1 3 1 3...等交替變換，
        帳號第一個數字乘以 1、第二位乘以 3、第三位乘以 1...等依此類推，
        再將所乘的結果相加（= total），再取 10 的餘數（value = total % 10），檢查碼即是 10 減該餘數（= 10 - value）。

    (2) 存款餘額：如果取款後，餘額會少於 0，則會拒絕提款。

    請製作一個帳戶類別（Account.class）是其具有上述功能，再製作 主程式main() 引用該類別，驗證是否正常。
    當建立帳戶時，只要輸入 12 個帳號的號碼，系統自動產生檢查碼；處理帳戶而輸入帳號，系統也會檢查檢查碼是否正確。

    期望驗證帳戶類別功能的結果如下：
 */

import java.util.Scanner;

//首先必須建立帳戶類別, 其中 ID 與 balance 為 Private 變數，必須透過物件方法存取
class Account{
    String name;                        // 姓名
    private int[] ID = new int[13];     // 帳戶號碼
    private int balence;                // 餘額

    // 設定帳號
    int setID(String ID_Str) {          // 取得字串 ID_Str 的輸入
        if(ID_Str.length() !=12){
            System.out.printf("需12個字元,請重新輸入!!\n");
            return 0;
        }
        else{
            Scanner scanner = new Scanner(ID_Str).useDelimiter("");     // 如果確定是，我們把它一個個取出來做分隔
            int total = 0;
            for(int i=0; i<12; i++){        // 需要 12 個所以是 < 12
                ID[i]= scanner.nextInt();   // 用整數去取出來然後放到 ID
                if((i+1) % 2 == 0) {
                    total += ID[i];         // 若是偶數我們就加上去
                }else {
                    total += ID[i] * 2;     // 若是基數就 * 2
                }
            }
            ID[12] = (10- (total % 10) );    // 最後算出來第十二位元 total 要取餘數
            System.out.print("\n****建立完成****\n完整的新帳戶(13碼)為 => ");
            for(int i=0;i<13;i++) {
                System.out.print(ID[i]);
            }
            System.out.println();
            return 1;
        }
    }

    // 取得帳號
    int[] getID(){
        return ID;
    }

    /* 寫入帳號、檢查帳號 */
    int writeID(String Write_ID){
        if (Write_ID.length() != 13){       // 如果長度不等於 13 就是錯誤的
            System.out.printf("長度不對\n");
            return 0;
        }
        else {      // 跟上面的設定帳號 setID 很相似都是要去計算然後比對
            Scanner scanner = new Scanner(Write_ID).useDelimiter("");
            int total = 0, check, check_R;
            for (int i=0; i<12; i++){       // 需要 12 個所以是 < 12
                ID[i] = scanner.nextInt();  // 用整數去取出來然後放到 ID
                if ((i+1) %2 == 0)
                    total += ID[i];         // 若是偶數我們就加上去

                else
                    total += ID[i] * 2;     // 若是基數就 * 2

            }

            check_R = scanner.nextInt();
            check = 10 - (total % 10);
            if (check == check_R){          // 比對如果數字一樣　return 1
                ID[12] = check;
                return 1;
            }
            else {                          // 比對如果數字不一樣　return 0
                System.out.printf("檢查碼不對\n");
                return 0;
            }
        }
    }

    // 存款
    int SaveMoney(int money){
        balence = balence + money;
        return balence;
    }

    // 取款
    int getMoney(int money){
        int m = balence - money;
        if (m >= 0){
            balence = m;
            return balence;
        }
        else {
            return -1;
        }
    }

    // 查詢餘額
    int checkMoney(){
        return balence;
    }
}

public class CreateAccountSpecification4_1{
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        String ID_Str;
        Account customer = new Account();       //產生類別變數, 可以使用 customer 類別變數去使用 Account 類別當中的物件方法
        System.out.printf("***建立新帳戶***\n請輸入姓名=>");
        customer.name = keyin.nextLine();
        System.out.printf("請輸入帳號(12 位數字) =>");
        ID_Str = keyin.nextLine();

        int flag = customer.setID(ID_Str);
        if (flag == 0){
            return;
        }
        System.out.printf("\n請輸入存款金額 =>");
        int money = keyin.nextInt();        // 這時候才宣告變數唷!!再把我們輸入的存到這個變數
        int balance = customer.SaveMoney(money);
        System.out.printf("\n餘額 = %d\n",balance);

        /* 列印帳戶清單 */
        System.out.printf("\n***列印帳戶資料***\n");
        System.out.printf("帳戶姓名： %s \n", customer.name);

        int[] ID = customer.getID();
        System.out.printf("帳戶號碼(13 碼)：");
        for (int i=0; i<13; i++){
            System.out.printf("%d",ID[i]);
        }
        System.out.printf("\n");
        System.out.printf("餘額= %d\n", customer.checkMoney());
    }
}

    

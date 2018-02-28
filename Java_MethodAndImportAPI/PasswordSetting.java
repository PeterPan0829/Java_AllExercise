package Java_MethodAndImportAPI;

/*
    一般資訊系統大多利用『帳號/密碼』過濾用戶的身份。
    用戶輸入帳號與密碼，系統檢視密碼是否正確，正確的話，同意用戶登入系統；否則會拒絕登入。
    如此一來，系統需要紀錄用戶密碼，作為判斷用戶身份依據但系統如果以明文儲存用戶密碼，他人只要入侵系統就可以觀察到所有用戶的密碼，
    因此密碼是不可以『明文儲存』的。也就是說，密碼必須經過加密或雜湊計算後，成為一串亂文格式再儲存。
    但密碼如設定太短的話，所產生的亂文變化就不大，有心人還是可以猜測出密碼。但一般人為了方便記憶，又不喜歡設定太長的密碼。

    『醃製法』密碼計算就是為了解決這個問題。醃製法是系統產生一個亂數稱之為『加鹽』，『加鹽』與密碼明文串接成一個較長的字串，
    此新字串經過加密或雜湊演算後，再儲存於系統。請製作一套『醃製法』密碼儲存系統，利用使用者輸入密碼明文後，與系統產生一個『鹽』，
    再將密碼與鹽組合為另一字串，利用此字串產生一個雜湊值，並印出結果；接著，假設使用者想進入系統，如密碼輸入正確，則允許進入系統；
    否則拒絕進入。

    期望操作介面如下：
                    請輸入使用者名稱 =>user01
                    請輸入密碼明文 =>123456
                    產生鹽亂數 = 942 儲存於電腦系統內
                    密碼明文與鹽組合 = 123456942
                    user01 密碼雜湊 = -1867376844

                    請輸入密碼 (驗證密碼是否正確) =>123456
                    由系統中取出鹽 = 942
                    輸入密碼與鹽結合後 = 123456942
                    輸入密碼雜湊值 = -1867376844
                    user01 密碼設定正確，該帳戶可使用


 */

import java.util.Scanner;

public class PasswordSetting {
    public static void main(String[] args) {

        Scanner keyin = new Scanner(System.in);
        String name, key;                                           //登錄使用者名稱, 加鹽
        int hash_pas;                                               //登錄密碼雜湊值
        String password1, password2;                                //輸入密碼明文 & 鹽與密碼明文連結
        int value1, value2;                                         //加鹽亂數 & 密碼雜湊值

            System.out.printf("請輸入使用者名稱 =>");
        name = keyin.nextLine();
            System.out.printf("請輸入密碼明文 =>");
        password1 = keyin.nextLine();
        value1 = (int) (1 + Math.random() * 999);                   //產生加鹽亂數
        key = String.valueOf(value1);                               //轉換鹽亂數成字串
            System.out.printf("產生鹽亂數 = %s 儲存於電腦系統內\n",key);
        password2 = password1.concat(key);                          //鹽與密碼明文連結
            System.out.printf("密碼明文與加鹽組合 = %s\n",password2);
        hash_pas = password2.hashCode();                            //產生密碼雜湊值
            System.out.printf("%s 密碼雜湊 = %d\n",name,hash_pas);

            System.out.printf("\n請輸入密碼（驗證密碼是否正確） =>");     //再次輸入密碼（驗證）
        password1 = keyin.nextLine();
            System.out.printf("由系統中取出鹽 = %s\n",key);
        password2 = password1.concat(key);
            System.out.printf("輸入密碼與鹽結合後 = %s\n",password2);
        value2 = password2.hashCode();
            System.out.printf("輸入密碼雜湊值 = %d\n",value2);

            if (value2 == hash_pas){
            System.out.printf("%s 密碼設定正確，該帳戶可以正常使用\n",name);
        }else
            System.out.printf("%s 密碼設定不正確,請重新設定\n",name);
    }
}
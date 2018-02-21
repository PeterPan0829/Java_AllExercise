package Java_FlowControl;

/*
    評估退休後可過何種生活。系統要求輸入目前年紀與預備每月儲蓄多少錢，預計多少年紀退休，預估可活到 80 歲，
    退休後每月可以開銷多少，來評估爾後的生活，如下：

    (1) 5000 元以下：等待救濟。
    (2) 5000 ~ 10000 元：免強可以湖口。
    (3) 10,000 ~ 20,000：安逸舒適。
    (4) 20,000 ~ 40,000：富貴生活。
    (5) 40,000 以上：遨遊世界。
 */

import java.util.Scanner;

public class DepositAfterRetirement {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        final int limit_age = 80;
        int balance;
        int credit = 0;
        int month, retired_age, age, life;
        double rate;

        System.out.printf("***    評估退休後生活品質系統   ***");
        System.out.printf("\n請輸入幾歲開始儲存退休金(如 30)歲 =>");
        age = keyin.nextInt();
        System.out.printf("請問幾歲準備退休(如 60)歲 =>");
        retired_age = keyin.nextInt();
        System.out.printf("請輸入預估年利率(如 0.14) =>");
        rate = keyin.nextDouble();
        System.out.printf("請輸入預估每月儲蓄(如 10000)元 =>");
        balance = keyin.nextInt();

        month = (retired_age - age) * 12;           //假設五十歲退休三十歲開始存錢且一年十二個月就是 50 - 35 = 15 * 12
//        balance = credit;
        for (int i=0; i<month; i++){
            balance = (int) (balance + (balance * rate/12));
            balance = balance + credit;
        }


        System.out.printf("\n到退休之前可儲存 %d 元\n",credit);

        life = (limit_age - retired_age) * 12 ;
        System.out.printf("平均每個月有 %d 元生活費",life);

        if (credit<5000){
            System.out.printf("等待救濟");

         if (credit>5000 && credit<10000){
            System.out.printf("免強可以湖口");
         }
         if (credit>10000 && credit<20000){
             System.out.printf("安逸舒適");
         }
         if (credit>20000 && credit<40000){
             System.out.printf("富貴生活");
         }
         if (credit > 40000){
             System.out.printf("周遊列國，遨遊世界");
         }
        }
    }
}
//            (1) 5000 元以下：等待救濟。
//            (2) 5000 ~ 10000 元：免強可以湖口。
//            (3) 10,000 ~ 20,000：安逸舒適。
//            (4) 20,000 ~ 40,000：富貴生活。
//            (5) 40,000 以上：遨遊世界。
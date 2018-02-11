package Java_FlowControl;

/*
    利用算盤結算總額最大缺點是客戶購買相同產品時也是需要一個接一個輸入價格。
    目前超商收銀機大多允許輸入單價及數量，它會自動計算並累加總額。
    這裏幫超商建立一套收銀機系統，系統會連續要求輸入貨品單價與數量，
    以及顯示目前總計，如果輸入商品單價為 0 表示結束輸入，之後顯示購買總金額。
 */

import java.util.Scanner;

public class StoreCashDesk {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        long number = 0, total = 0, cost;

        System.out.printf("============歡迎光臨 Longship 超商============\n");
        System.out.printf("\n累計 %d 元, 請輸入商品單價 (0 結束) =>",total);
        cost = keyin.nextInt();


        while (cost > 0){
            System.out.printf("                  請輸入購買數量 =>",number);
            number = keyin.nextInt();
            total = total + (cost * number);
            System.out.printf("累計 %d 元, 請輸入商品單價 (0 結束) =>",total);
            cost = keyin.nextInt();
        }
        System.out.printf("\n今天一共購買了 %d 元",total);
    }
}

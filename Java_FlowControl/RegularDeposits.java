package Java_FlowControl;

/*
    零存整付 Regular deposits
    就是每月按時固定金額存入(例如:每月存5000元)，到期(假設12期)後再一次領回利息及本金。
 */

import java.util.Scanner;

public class RegularDeposits {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int permonth;
        int method;
        double rate;
        int balance = 0;
        int interest;

        System.out.printf("\n======歡迎光臨零存整付試算系統======");
        System.out.printf("\n預定每月儲存金額（例如：10000）=>");
        permonth = keyin.nextInt();
        System.out.printf("\n請選擇存款期限（6,9,12,24）=>");
        method = keyin.nextInt();
        System.out.printf("\n目前儲蓄年利率（例如 0.18）=>");
        rate = keyin.nextDouble();

        for (int i=0; i<method; i++){
            balance = balance + (int) ((balance*rate) / 12);            //利息 = 餘額 * 年利率 / 12
            balance = balance + permonth;                       //第一個月時
        }

        System.out.printf("\n到期可領回 %d 元\n",balance);

        interest = (int) (balance * rate / 12);
        System.out.printf("增加 %d 元利息",interest);
    }
}

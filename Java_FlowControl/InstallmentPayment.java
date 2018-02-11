package Java_FlowControl;

/*
    分期貸款試算系統

    目前銀行大多有提供定額還款的貸款業務，無論客戶承貸多少金額（如 100 萬元），可選擇每個月還款多寡（如 2 萬元），
    其中包含利息（如年利率 4 %），一直到債務還清為止。許多年輕人不瞭解自己還款能力，擴張貸款額度可能造成一輩子的債務人。
    因此，銀行希望製作一套分期貸款試算系統，客戶自行輸入貸款額度，目前年利率、預計每月還款金額；
    因年利率隨時調變，系統僅能輸出大約需要還款多少期（月）。
    如果預估期數超過 20 年（240 期），系統將自動拒絕承做，否則歡迎洽臨行員。

 */


import java.util.Scanner;

public class InstallmentPayment {
    public static void main(String[] args) {
        /* 宣告相關物件與變數 */
        Scanner keyin = new Scanner(System.in);
        final int limit = 240;  //最高期限
        double credit;          // 需要貸款額度(萬)
        double pay;             // 每月攤還金額(萬)
        double rate;            // 年利率
        double balance;         // 目前貸款餘額
        int count=0;            // 累計繳納期數

        /* 讀取客戶輸入資料 */
        System.out.printf("===================歡迎光臨 Peter's BANK===================");
        System.out.printf("\n請輸入貸款金額（萬）=>");
        credit = keyin.nextDouble();
        System.out.printf("\n請輸入年利率 (如0.04)=>");
        rate = keyin.nextDouble();
        System.out.printf("\n期望每月還款金額（萬）=>");
        pay = keyin.nextDouble();

        /* 計算還款期數 */
        balance = credit;
        do {
            balance = balance + (balance * rate) / 12;
            balance = balance - pay;
            count = count + 1;
        }while (balance > 0);
        System.out.printf("\n你需要 %d 期(月) 才可還款完畢\n",count-1);

        /* 超過上限 240 期 */
        if (count > limit){
            System.out.printf("超過上限期數 %d 請另外選擇貸款額度\n",limit);
        } else{
            System.out.printf("Peter's BANK 願意承做, 請洽詢本行經理人");
        }
    }
}

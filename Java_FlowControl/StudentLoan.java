package Java_FlowControl;

import java.util.Scanner;

public class StudentLoan {
    public static void main(String[] args) {

        /* 宣告相關物件與變數 */
        Scanner keyin = new Scanner(System.in);
        double credit = 0;      // 需要貸款額度(萬)
        double pay_month;       // 每月還錢金額(萬)
        double pay;             // ?????????????????????
        double sum = 0;             // 累加產生利息
        double rate;            // 年利率
        double stages = 0;          // 還錢期數
        double balance;         // 目前貸款餘額
        double interest;        // 本月延伸利息
        int count=1;            // 累計繳納期數

        balance = credit;
        pay_month = credit / stages;

        /* 讀取客戶資料 */
        System.out.printf("==============學貸償還試算系統==============");
        System.out.printf("\n請輸入貸款金額（萬）=>");
        credit = keyin.nextDouble();
        System.out.printf("\n請輸入年利率 (如0.04) =>");
        rate = keyin.nextDouble();
        System.out.printf("\n請輸入就讀期間貸款學期數 =>");
        stages = keyin.nextInt();
        System.out.printf("\n前 10 期應繳納金額如下：");

        do {
            interest = (balance * rate) / 12;                              //本月延伸利息
            pay = pay_month + interest;                                    //計算目前該月應繳金額
            balance = balance - pay_month;                                 //計算本月餘額
            count = count + 1;                                             //累加還款期數
            sum = sum + interest;                                          //累加產生利息
            System.out.printf("\n第 %d 期需繳納 %f 萬元",count,pay);        //輸出本月期數、應繳金額
        } while (count < stages);                                          //是否已到期
        System.out.printf("\n到清償為止，總共延伸利息 %f 萬元",interest);
    }
}
//宣告相關物件與變數；
//
//        讀入客戶貸款額度（credit）、年利率（rate）與預計返還期數（stages）；
//        計算每月平均分攤本金（pay_month = credit/stages）；設定初始餘額（balance = credit）；
//        Do {
//        本月延伸利息 (interest = (balance*rate)/12）;
//        計算目前該月應繳金額（pay = pay_month +interest）；
//        計算本月餘額（balance = balance – pay_month）；
//        累加還款期數（count = count + 1）；
//        累加產生利息(sum = sum + interest);
//        輸出顯示本月期數與應繳金額（count, pay）；
//        } while(是否已到期 ( count < stages )；
//        …

//
//        == 學貸償還試算系統 ==
//                請輸入貸款金額 (萬) =>40
//                請輸入年利率 (如0.04) =>0.04
//                償還年限(貸款學期數) =>8
//                前 10 期應繳納金額如下：
//                您第 1 期需繳納 0.55 萬元
//                您第 2 期需繳納 0.55 萬元
//                您第 3 期需繳納 0.55 萬元
//                您第 4 期需繳納 0.55 萬元
//                您第 5 期需繳納 0.54 萬元
//                您第 6 期需繳納 0.54 萬元
//                您第 7 期需繳納 0.54 萬元
//                您第 8 期需繳納 0.54 萬元
//                您第 9 期需繳納 0.54 萬元
//                到清償為止，總共延伸利息 6.47 萬元
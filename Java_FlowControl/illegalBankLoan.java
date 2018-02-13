package Java_FlowControl;

/*
    地下錢莊試算系統

    地下錢莊提供『笨蛋』資金且方便快速放款金額低但利率也比較高，並且須按月繳還利息，否則利息加入下個月的本金(俗稱利息滾本金)。

    (1) 照政府規定年利率不得超過 48 %，即是月利率 4 %(俗稱四分利)。也有 10 天為一期 2 %(俗稱二分利)。
    (2) 照政府規定手續費不得超過 5 %。
    (3) 實際取得金額 = 借貸金額 – 第一個月利息 – 手續費。
    (4) 按月繳交利息，否則加入本金借貸，及下個月是本金=上月本金 + 利息+ 手續費。

    情境：許多人貪一時之快造成滿身債務。政府希望市民能了解此運作情況，建立一套試算系統。
    功能是，市民輸入貸款金額(如10 萬)，實際取得多少錢(扣除第一個月利息與手續費) 爾後每月應繳多少利息？
    如隔多少個月(如 10 個月)未繳利息後，則本金成長為多少？之後每月應繳多少利息。
 */

import java.util.Scanner;

public class illegalBankLoan {
    public static void main(String[] args) {
        /* 宣告相關物件與變數 */

        Scanner keyin = new Scanner(System.in);
        double credit;          //貸款金額（萬）
        double rate;            //月利率
        int num;                //未繳交利息月數
        double total;           //貸款實際取得金額

        /* 讀取客戶貸款資料 */
        System.out.printf("\n======= 歡迎光臨錢莊貸款試算系統 =======");
        System.out.printf("\n請輸入貸款金額（萬）=>");
        credit = keyin.nextDouble();
        System.out.printf("\n請輸入月利率（如 0.04）");
        rate = keyin.nextDouble();
        System.out.printf("\n多少個月沒繳交利息（如 10 個月）=>");
        num = keyin.nextInt();
        System.out.printf("\n列印相關數據如下：\n");
        total = credit - credit * 0.04 - credit * 0.05;                      //手續費 5%
        System.out.printf("實際取得貸款金額 = %.1f 萬元",total);
        System.out.printf("\n每月應繳交利息 = %.1f 萬元",credit*0.04);
        for (int i=0; i<num; i++){
            credit = credit + (credit * 0.04) + (credit * 0.05);                 //手續費 5%
        }
        System.out.printf("\n未繳利息 %d 個月後, 本金累計為 %.1f 萬元\n",num,credit);
        System.out.printf("現在起你每月利息為 %.1f 萬元\n",credit*0.04);
    }

}


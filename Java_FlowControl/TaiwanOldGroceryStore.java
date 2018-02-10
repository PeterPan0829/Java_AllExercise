package Java_FlowControl;

/*
    傳統『柑仔店』

    大多利用算盤計算『人客』購買商品的總額。
    它的計算方法是一筆接一筆輸入購買金額，也一筆一筆累計總額，輸入結束後立即得到購買金額。
    這邊使用可連續輸入購買金額，也能累計總額；再利用輸入價格為『零』，表示結束輸入，並顯示總計金額。

 */

import java.util.Scanner;

public class TaiwanOldGroceryStore {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        long total=0, cost;

        System.out.printf("============歡迎光臨 Peter 雜貨店============\n");
        System.out.printf("已購買 %d 元, 請輸入產品價格 (0 結束) =>\n",total);

        cost = keyin.nextInt();

//      如果沒有設定一個關鍵條件會無止境累加不停，利用 花費cost 為 0 作為停止計算的關鍵因素，
        while (cost > 0){
            total = total + cost;
            System.out.printf("已購買 %d 元, 請輸入產品價格 (0 結束) =>\n",total);
            cost = keyin.nextInt();
        }
        System.out.printf("郎客哩賀！！今天一共購買了 %d 元\n",total);
        System.out.printf("歡喜哩歌來～～");
    }
}

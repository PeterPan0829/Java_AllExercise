import java.util.Scanner;

//記錄球員棒球打擊率
//打擊率 ＝ 打擊次數 / 安打次數
public class BasketballAVG {
    public static void main(String args[]){
        Scanner keyin = new Scanner(System.in);
        System.out.println("**** 記錄棒球打擊率工具 ****\n");


//      初始打擊累積次數
        int total = 50;

//      安打累積次數
        int hits = 15;

//      打擊率
        float batting;

//      每場打擊次數
        int numbers;

//      每場安打次數
        int bingles;

//      計算打擊率
        batting = total / hits;

        System.out.printf("目前打擊 =>%d次, 安打 =>%d支, 打擊率 =>%.4f\n", total, hits, batting);
        System.out.printf("      請輸入第一場（打擊次數、安打次數）=> ");

        numbers = keyin.nextInt();
        bingles = keyin.nextInt();
        total = total + numbers;
        hits = hits + bingles;
        batting = (float)hits / total;

        System.out.printf("目前出場 =>%d次, 安打 =>%d支, 打擊率 =>%.4f\n", total, hits, batting);
        System.out.printf("      請輸入第二場（打擊次數、安打次數）=> ");

        numbers = keyin.nextInt();
        bingles = keyin.nextInt();
        total = total + numbers;
        hits = hits + bingles;

//      求打擊率不能兩數直接相除小數點會不見, 一定要先把安打打擊次數強制轉換成小數。
        batting = (float)hits / total;

//        %.4f取第四位讓數值更清楚
        System.out.printf("目前出場 =>%d次, 安打 =>%d支, 打擊率 =>%.4f\n", total, hits, batting);
    }
}

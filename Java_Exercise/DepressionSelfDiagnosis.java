package Java_Exercise;

import java.util.Scanner;

public class DepressionSelfDiagnosis {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);


        int a, b, c, d, e, f, g, h, i, j; //十種憂鬱症狀況以 a ~ j 十個字母表示

        int sum1, sum2; // 十種憂鬱症狀況的總和

        int k;
        final int weights = k=5,l=4,m=5,n=3,o=2,p=3,q=4,r=2,s=3,t=5; //十種憂鬱症狀況的加權比重



        System.out.println("**** 憂鬱症診斷系統 ****\n");
        System.out.printf("請依序回答下列問題, 相似度 (0 ~ 10)\n ");
        System.out.println("     如：不明顯(0), 稍明顯(2), 明顯(6), 很明顯(10) \n");


        System.out.printf("我常覺得想哭（比重 5）=>");
        a = keyin.nextInt();

        System.out.printf("我覺得心情不好（比重 4）=>");
        b = keyin.nextInt();

        System.out.printf("我覺得比以前更容易發脾氣（比重 5）=>");
        c = keyin.nextInt();

        System.out.printf("我睡不好（比重 3）=>");
        d = keyin.nextInt();

        System.out.printf("我覺得不想吃東西（比重 2）=>");
        e = keyin.nextInt();

        System.out.printf("我覺得想事情或做事情比以前慢（比重 3）=>");
        f = keyin.nextInt();

        System.out.printf("我比較會往壞的方向想（比重 4）=>");
        g = keyin.nextInt();

        System.out.printf("我覺得身體不舒服（比重 2）=>");
        h = keyin.nextInt();

        System.out.printf("我覺得自己很沒用（比重 3）=>");
        i = keyin.nextInt();

        System.out.printf("我很想不開、甚至想死（比重 5）=>");
        j = keyin.nextInt();



        System.out.printf("\n總合計算 (0 ~ 100), 判斷結果: 正常（0 ~ 30）\n");
        System.out.printf("\t輕微憂鬱症（30 ~ 60), 明顯憂鬱症（60 ~ 100）\n");

        sum1 = a+b+c+d+e+f+g+h+i+j;
        System.out.printf("您憂鬱症指數為 =>%d\n",sum1);

        System.out.printf("\n加權指數計算 (0 ~ 10), 判斷結果: 正常（0 ~ 3）\n");
        System.out.printf("\t輕微憂鬱症（3 ~ 6）, 明顯憂鬱症（6~10）\n");

        sum2 = (a*k + b*l + c*m + d*n + e*o + f*p + g*q + h*r + i*s + j*t) / weights;
        System.out.printf("您憂鬱症指數為 =>%.2f\n",(float)sum2 / weights);

    }
}

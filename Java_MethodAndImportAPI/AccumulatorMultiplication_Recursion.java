package Java_MethodAndImportAPI;

/*
    利用呼叫遞迴函數來編寫累乘程式，
    程式只需要輸入一個整數 n，計算並輸出 total = 1 * 2 * 3 * 4 *, …, n（n!）；
    需顯示每次遞迴呼叫的執行內容。

    （這裡的整數 n! 不要印太大的值,先不考慮用 long ）
 */

import java.util.Scanner;

public class AccumulatorMultiplication_Recursion {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int total, num;
        System.out.printf("請輸入一個整數 =>");
        num = keyin.nextInt();
        total = level(num);                         //呼叫遞迴 method, 這裡的 num 就是輸入的數字
        System.out.printf("1 * 2 * 3...,%d = %d\n",num,total);
    }

    static int level(int k){
        int sum;
        if (k <= 1){                                //k 就是我們輸入的數字,假設輸入 5
            return 1;
        }
        else
            sum = k * level(k-1);                //5 * (4)
            System.out.printf("%d * level(%d-1) = %d\n",k,k,sum);
            return sum;
    }
}


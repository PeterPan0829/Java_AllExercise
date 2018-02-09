package Java_FlowControl;

/*
    九九乘法表測試，系統會連續出現 10 題兩個 1 ~ 9 之間亂數，學生輸入自己計算相乘的結果，最後評定學生得分（每題 10 分）。

    系統要求連續出現 10 次九九乘法練習題，可利用 for 迴圈達成，其中，計數器（count）由 1 到 10，每次增量 1（count++，或 count = count + 1）。
    迴圈內必須產生兩個 1 ~ 9 的亂數需要導入 java.util.Random 套件
 */


import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        Random ran = new Random();

        int value1, value2, total, count;
        int answer, correct = 0, grade = 0;


        for (count=1; count<=10; count++){

            value1 = 1 + ran.nextInt(9);
            value2 = 1 + ran.nextInt(9);
            System.out.printf("%d * %d =>",value1,value2);

            total = value1 * value2;

            answer = new Scanner(System.in).nextInt();

            grade = correct * 10;

            if (answer == total){
                correct = count + 1;
            }else {
                System.out.printf("\n答錯了, 正確答案為：%d\n",total);
            }
        }
        System.out.printf("你的成績為：%d",grade);
    }
}
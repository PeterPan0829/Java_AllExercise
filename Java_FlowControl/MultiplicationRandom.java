package Java_FlowControl;

/*
    運用 Random 以及 if...else 做亂數乘法練習
*/


import java.util.Random;
import java.util.Scanner;

public class MultiplicationRandom {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Random random = new Random();

        int ran1 = 1 + random.nextInt(9); //其中數字九表示 0~8 之間, 所以用 1 + 0~9 就是 1~9
        int ran2 = 1 + random.nextInt(9);
        int value1 = ran1 * ran2;

        System.out.printf("請輸入 %d * %d =>",ran1,ran2);
        int value2 = keyin.nextInt();


        if (value1 == value2){
            System.out.printf("答對囉！！");
        }else {
            System.out.printf("答案錯誤喲！答案是 %d 再試一次！！",value1);
        }
    }
}

package Java_FlowControl;

import java.util.Random;
import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {

        Random ran = new Random();

        int value1, value2, total, count;
        int answer, correct = 0;


        for (count=1; count<=10; count++){

            value1 = 1 + ran.nextInt(9);
            value2 = 1 + ran.nextInt(9);
            System.out.printf("%d * %d =>",value1,value2);

            total = value1 * value2;

            answer = new Scanner(System.in).nextInt();

            if (answer == total){
                correct = count + 1;
            }else {
                System.out.printf("\n答錯了, 正確答案為：%d",total);
            }
        }
        System.out.printf("你的成績為：%d * 10",correct);
    }
}
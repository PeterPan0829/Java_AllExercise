package Java_FlowControl;

/*
    while 敘述製作累加/累乘程式
 */

import java.util.Scanner;

public class AccumulatorPlusAndMultiplication {
    public static void main(String[] args) {

        Scanner keyin = new Scanner(System.in);
        long sum = 0, pro = 1, k=1, value;
        
        System.out.printf("請輸入一個整數 =>");
        value = keyin.nextInt();


        while (k <= value){
            sum = sum + k;    //加起來的答案
            pro = pro * k;    //乘出來的答案
            k = k + 1;
        }
        System.out.printf("\n1+2+3+4+...+%d = %d\n",value,sum);
        System.out.printf("\n1*2*3*4+...*%d = %d\n",value,pro);

    }
}
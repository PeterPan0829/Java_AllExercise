package Java_Exercise;

import java.util.Scanner;

//兩數相除結果
public class TwoNumberDivide {
    public static void main(String args[]){
        Scanner keyin = new Scanner(System.in);
        int value1, value2;
        float div;


        System.out.printf("請輸入兩個整數（value1 value2）=>");
        value1 = keyin.nextInt();
        value2 = keyin.nextInt();

        //整數相除得到整數，存入小數變數裡面
        div = value1 / value2;
        System.out.printf("未轉換 => %d/%d = %f\n", value1, value2, div);

        //一個整數轉換成小數除以另一個整數, 得到的結果存到小數變數裡面
        div = (float)value1 / value2;
        System.out.printf("已轉換 => (float)%d/%d = %f\n", value1, value2, div);

        //強迫轉換另一個整數變數
        div = value1/(float)value2;
        System.out.printf("強迫轉換 => %d/(float)%d = %f\n", value1,value2,div);

    }
}

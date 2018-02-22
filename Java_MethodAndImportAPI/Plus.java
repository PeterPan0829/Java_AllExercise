package Java_MethodAndImportAPI;

/*
    加法方法的製作
    在這個 Plus 類別底下有兩個方法：1.Main Method 2.Add Method
 */

import java.util.Scanner;

//類別開始
public class Plus {
    //main方法開始
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int sum;                                            //屬於Main Method的區域變數
        int value1, value2;
        System.out.printf("請輸入第一個整數 =>");
        value1 = keyin.nextInt();
        System.out.printf("請輸入第二個整數 =>");
        value2 = keyin.nextInt();

        //呼叫 Add() 方法
        sum = Add(value1,value2);
        System.out.printf("%d + %d = %d",value1,value2,sum);
    }
    //main方法結束


    //Add() 方法開始
    static int Add(int a, int b){
        int sum;                                            //屬於Add Method的區域變數
        sum = a + b;
        return sum;
    }
    //Add() 方法結束


}
//類別結束
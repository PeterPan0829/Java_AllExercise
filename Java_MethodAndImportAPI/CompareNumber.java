package Java_MethodAndImportAPI;

/*
    製作一套系統，它允許連續輸入五個數字，再輸出其中最大值與最小值的數值。
    系統功能如下：
                請輸入第 1 整數 =>34
                請輸入第 2 整數 =>56
                請輸入第 3 整數 =>12
                請輸入第 4 整數 =>98
                請輸入第 5 整數 =>67
                最大數值是 98
                最小數值是 12
 */

import java.util.Scanner;

//類別開始
public class CompareNumber {
    //main方法開始
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int max=0,min=999;
        int value;
        for (int i=0; i<5; i++){
            System.out.printf("請輸入第 %d 整數 =>",i+1);
            value = keyin.nextInt();

            //呼叫方法
            max = Max(max,value);
            min = Min(min,value);
        }
        System.out.printf("最大數值是 %d\n", max);
        System.out.printf("最小數值是 %d", min);
    }
    //main方法結束

        //宣告 Max 方法
        static int Max(int a, int b){
            if (a>b){
                return a;
            }else
                return b;
        }

        //宣告 Min 方法
        static int Min(int a, int b){
            if (a<b){
                return a;
            }else
                return b;
        }

    }
    //類別結束




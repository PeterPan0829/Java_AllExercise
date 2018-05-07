package Java_ArrayDataStructure;
/*
循序搜尋法(Sequential Search) 即 線性搜尋法(Linear Search)，
從陣列內尋找某一筆資料，最簡單的方法是循序搜尋法；演算法是由陣列的起頭開始比較尋找（比較內容），
如果搜尋到立即停止，否則繼續往下一個元素尋找，一直到陣列結束為止。
簡單來說就是直接用迴圈一個個去比對，找到時就跳出。
 */

import java.util.Scanner;

public class SequentialSearch {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int value, flag=0, i;                                                    //其中 flag 是一個指標用它去做搜尋
        int num[] = {23,54,67,12,88,95,15,78,80,45,};
        System.out.printf("num[] = ");
        
        for (int k=0; k<10; k++){
            System.out.printf("%d　",num[k]);
        }
        System.out.printf("\n");
        
        System.out.printf("\n請輸入一個數值 =>");
        value = keyin.nextInt();
        i=0;
        while (i<10){
            if(value == num[i]){
                flag = 1;
                break;
            }
            i++;                                                               //還沒找到就繼續找
        }
        if (flag ==1){
            System.out.printf("num[%d] = %d 找到囉兄弟！\n",i,value);            //前面的 i 是 num 陣列當中的第幾個位置
        }else
            System.out.printf("%d 不在 num 陣列內",value);
    }
}

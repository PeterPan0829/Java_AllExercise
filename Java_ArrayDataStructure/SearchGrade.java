package Java_ArrayDataStructure;
/*
    一樣利用到 Sequence Search 方式來實踐成績搜尋系統。
    輸入學號作為查詢關鍵，由陣列的起頭到結尾依序比較第 0 個欄位（score[i][0], i=0, 1, 2, …, score.length-1），
    如果相同則印出第 1 個欄位的內容（score[i][1]，成績欄位。


 */

import java.util.Scanner;

public class SearchGrade {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int score[][] = {{411101, 70}, {411102, 80}, {411103, 75}, {411104, 90}, {411105, 85}, {411106, 65}, {411107, 83}, {411108, 78}}; //第一個 row 儲存學號、第二個 column 儲存成績
        int num;                                //讀入查詢學號
        int flag = 0;                           //宣告旗號給予初值 0


        System.out.printf("=====成績搜尋系統=====");
        System.out.printf("\n請輸入學生學號 =>");
        num = keyin.nextInt();

        //只比對學號不比對成績所以[i][0]
        //會結束迴圈有兩種可能：(1)找到後break離開 (2)迴圈內全部跑完break
        for (int i=0; i<score.length; i++){
            if (score[i][0]==num){
                flag = 1;
                System.out.printf("\n學號 = %d 成績 = %d",score[i][0],score[i][1]);
                break;
            }
        }
        if (flag == 0){
            System.out.printf("\n沒有學號 = %d 的資料",num);
        }



    }
}

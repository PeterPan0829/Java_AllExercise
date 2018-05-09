package Java_ArrayDataStructure;

/*
    有序陣列的 二分搜尋法（BinarySearch）。詳細教學請看GitHub_Wiki Data Structure_Binary Search 教學
    用在已排序的一串資料。其原理為將想要搜尋的值，與所有資料的中間值(中位數)做比對。

    數學老師利用一個二維陣列 score[][] 儲存某一班級學生的成績，陣列第一個元素score[k][0] 存放學生學號，由 411101 ~ 411150；
    第二個元素 score[k][1] 存放數學成績，由 00 ~ 100 分，如：{411101, 70}, {411102, 80}, {411103, 75}, {411104, 90}, {411105, 85}, {4111106, 65}, {411107, 83}, {411108, 78}, {411109, 67}, (411110, 72)...等等。陣列是依照學號由低到高排列。

    請編寫程式，允許輸入學生學號則輸出該學生的成績。程式中先寫小程式填入陣列內每一位同學的學號與成績，成績採 00 ~ 100 之間的亂數，之後印出全班成績，接著再編寫一個二分搜尋程式。

    期望操作介面如下：

*/

import java.util.Scanner;

public class Array_Sequence_BinarySearch {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int score[][], value, flag, low, high, mid;
        score = new int[50][2];                             //總共50筆資料,每筆資料兩個欄位（第一個欄位放學號；第二個學號放成績）
        int number = 411101;

        for (int i=0; i<score.length; i++){
            score[i][0] = number + 1;                       //學號
            score[i][1] = (int) (Math.random() * 100);      //分數（使用亂數）
        }

        //列印全班成績
        System.out.printf("==== 411101 ~ 411150 成績列印 ====\n");
        for (int i=0; i<score.length; i=i+1){
            System.out.printf("%4d",score[i][1]);
            if ((i+1) % 10 == 0){                           //每十筆換行
                System.out.printf("\n");
            }
        }

        System.out.printf("\n請輸入想要尋找的學生學號 =>");
        value = keyin.nextInt();

        /* 二分搜尋法 */
        low = 0; high = 49; mid = 0;                        //設定原陣列搜尋範圍
        flag = 0;                                           //設定搜尋旗標為否（還未找到）
        while ((low + 1) < high){                           //43 ~ 55設定是否找到旗標。while((low+1) < high) { ….}』其中 (low+1) < high 表示元素較高的指標 high 還是高於較低的 low，則陣列還未搜尋完畢。
            mid = (low + high) / 2;
            if (value == score[mid][0]){                    //比對陣列中間元素
                flag = 1;                                   //成立的話，表示找到該資料，則設定旗標並中斷離開。
                break;
            }
            else if (value > score[mid][0]){                //在陣列的後半段。如未找到，但比中間值 a[mid] 大的話，則設定搜尋後半段（low = mid，但 high 未改變）。
                low = mid;
            }else                                           //在陣列的前半段
                high = mid;                                 //都不是的話，則設定搜尋前半段（low 未改變）。
        }

        if (flag == 1){
            System.out.printf("學號 %d 成績是 %d\n",score[mid][0],score[mid][1]);
        }else
            System.out.printf("沒有 %d 學號學生，請重新輸入\n",value);
    }
}

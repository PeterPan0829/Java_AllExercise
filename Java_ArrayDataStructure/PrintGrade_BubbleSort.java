package Java_ArrayDataStructure;
/*
    數學老師利用一個二維陣列儲存某一班級學生的成績，score[][] = {{411101, 70}, {411102, 80}, {411103, 75}, {411104, 90}, {411105, 85}, {411106, 65}, {411107, 83}, {411108, 78}, {411109, 67}, {411110, 72}}
    請依照成績由最高排列到最低印出。期望操作介面如下：

    == 列印排序後成績單 ==

    411104 = 90
    411105 = 85
    411107 = 83
    411102 = 80
    411108 = 78
    411103 = 75
    411101 = 70
    411106 = 65

    較特殊的地方是泡沫排序法中兩個元素交換程序，必須整筆資料交換，而不是僅成績交換；因此暫存變數 temp 需宣告成每筆資料的型態（int[2]）
 */

public class PrintGrade_BubbleSort {
    public static void main(String[] args){
        int score[][] = {{411101, 70}, {411102, 80}, {411103, 75}, {411104, 90}, {411105, 85}, {411106, 65}, {411107, 83}, {411108, 78}, {411109, 67}, {411110, 72}};
        int temp[] = new int[2];

        System.out.printf("=====列印排序後成績單=====\n");

        for (int i=0; i<score.length; i++){
            for (int j=i+1; j<score.length; j++){
                if (score[i][1] < score[j][1]){
                    temp = score[i];
                    score[i] = score[j];
                    score[j] = temp;
                }
            }
            System.out.printf("%d = %d \n",score[i][0],score[i][1]);
        }
    }
}

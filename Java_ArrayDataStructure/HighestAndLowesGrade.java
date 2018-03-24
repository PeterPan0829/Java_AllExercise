package Java_ArrayDataStructure;
/*
    數學老師利用一個二維陣列儲存某一班級學生的成績，
    score[][] = {{411101, 70}, {411102, 80}, {411103, 75}, {411104, 90}, {411105, 85}, {4111106, 65}, {411107, 83}, {411108, 78}}。
    請編寫程式列印出該班成績最高與最低分數與姓名

 */

public class HighestAndLowesGrade {
    public static void main(String[] args) {
        int score[][] = {{411101, 70}, {411102, 80}, {411103, 75}, {411104, 90}, {411105, 85}, {411106, 65}, {411107, 83}, {411108, 78}}; //第一個 row 儲存學號、第二個 column 儲存成績
        int max[] = {0,0};
        int min[] = {0,9999};
    
        
        for(int i=0; i<score.length; i++) {                                 //搜尋最高與最低成績者
            if(score[i][1] > max[1])
                max = score[i];
            if(score[i][1] < min[1])
                min = score[i];
        }
        

        System.out.printf("最高者 %d 成績 %d",max[0],max[1]);
        System.out.println();
        System.out.printf("最低者 %d 成績 %d",min[0],min[1]);
        }
    }

package Java_ArrayDataStructure;

/*
    延續 Array_DataStructure 範例，請編寫程式印出總平均分數，由(高至低)順序的成績單‧

    較特殊的地方是泡沫排序法中兩個元素交換程序，必須整筆資料交換，而不是僅成績交換；因此暫存變數 temp 需宣告成每筆資料的型態（int[6]）
 */

public class PrintSortedGrade {
    public static void main(String[] args) {
    
        int temp[] = new int[6];
        int score[][] = {{492101, 80, 90, 78, 72, 0},
                        {492102, 90, 67, 54, 46, 0},
                        {492103, 71, 64, 83, 53, 0},
                        {492104, 68, 89, 73, 73, 0},
                        {492105, 56, 72, 53, 49, 0},
                        {492106, 96, 65, 78, 83, 0},
                        {492107, 49, 62, 91, 68, 0}};
    
        for (int i=0; i<score.length; i++){
            score[i][5] = (score[i][1] + score[i][2] + score[i][3] + score[i][4]) / 4;
        }
    
        // 列印所有學生成績資料
        System.out.printf(" 學號　　　　程式設計　　資訊網路　　資料處理　　統計分析　   總平均\n");
        

        
        for (int i=0; i<score.length; i++){
            for (int j=i+1; j<score.length; j++){
            if (score[i][5] < score[j][5]){
                temp = score[i];
                score[i] = score[j];
                score[j] = temp;
            }
                System.out.printf("%d   \n",score[j][1]);
            }
//            System.out.printf("%d   \n",score[i];
        }

        
    }
}




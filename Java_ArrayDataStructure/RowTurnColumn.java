package Java_ArrayDataStructure;

/*
我們只要將由陣列內容取出的次序轉換就可以，原陣列取出是 score[i][j]，陣列轉成 column 次序是 score[j][i]。
當外迴圈 i=0 時，印出順序 (j=0、1,、2) 是 score[0][0]=1、score[1][0]=4、score[2][0]=7，當 i=1 時，
印出順序是 score[0][1]=2、score[1][1]=5、score[2][1]=8，當 i=2 時，印出順序是 score[0][2]=3、score[1][2]=6、score[2][2]=9。
 */

public class RowTurnColumn {
    public static void main(String[] args) {
        int score[][] = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
    
        System.out.printf("列印原陣列如下：\n");
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf("\t%2d", score[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n陣列轉換成 Column：\n");
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[i].length; j++) {
                System.out.printf("\t%2d", score[j][i]);
            }
            System.out.println();
        }
        System.out.printf("\n");
    
    }
}
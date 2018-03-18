package Java_ArrayDataStructure;

/*
        印出陣列 score [] [] = {{1, 2, 3}, {4, 5, 6},{7, 8, 9}, {10, 11, 12}} 內容並依照相對位置排列（平面形狀）。
         1       2       3
         4       5       6
         7       8       8
        10      11      12
        利用 x 與 y 變數作為陣列位置索引，x 是 Row 指標，y 為 Column 指標，則任何一元素可由 score[x][y] 表示。
        欲平面型態印出陣列內容，則需要二個迴圈敘述，外迴圈標示共計列印幾行（x = 0, 1, …, score.length）；
        內迴圈索引每行的列數（y = 0, 1, 2, …, score[x].length）。
 */

public class TwoDimensionArrays {
    public static void main(String[] args) {
        int num[][] = {{1,2,3},
                       {4,5,6},
                       {7,8,9},
                       {10,11,12}};
        int x,y;
        
        for (x=0; x<num.length; x++){
            for (y=0; y<num[x].length; y++){
                System.out.printf("\t%2d",num[x][y]);
            }
            System.out.printf("\n");
        }
    }
}

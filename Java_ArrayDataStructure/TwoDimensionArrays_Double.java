package Java_ArrayDataStructure;

/*
    我們建構一個比較容易擴充的程式，
    將 num[][] 宣告成類別變數 static，使其允許類別內所有方法使用，又將列印陣列的功能製作成一個獨立的 Show_doubleArrays() 方法。
 */

public class TwoDimensionArrays_Double {
    static int num[][] = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
    
    public static void main(String[] args) {
        System.out.printf("原陣列內容：\n");
        for (int x=0; x<num.length; x++){                                     // Row指標 (外迴圈)
            for (int y=0; y<num[y].length; y++){                              // column指標 (內迴圈)
                System.out.printf("\t%d",num[x][y]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n加倍陣列內容之後：\n");
        Show_doubleArrays();
    }
    
    public static void Show_doubleArrays() {
        for (int x=0; x<num.length; x++){
            for (int y=0; y<num[y].length; y++){
                System.out.printf("\t%d",num[x][y] *2);
            }
            System.out.printf("\n");
        }
    }
}

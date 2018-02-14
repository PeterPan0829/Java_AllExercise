package Java_FlowControl;

/*
    利用星號（*）畫出矩形圖，使用者可以自行輸入長與寬，系統再畫出此大小的矩形圖。

    如果沒有透過特殊繪圖介面（如 Swing 或 Applet），利用文字終端機繪圖的話，僅能一行接一行，由左至右的繪製，就好像鍵盤輸入文字一樣。
    首先採用兩變數作為高與寬的指標，電腦是一行接一行繪出因此外迴圈需利用矩形高的指標（int i）；內迴圈利用寬的指標（int j）。
    每行開始繪製時，先畫出 4 個空格，接著再畫 8 個星號（輸入要求），完成之後，再輸出一個跳行的控制字元（\n）；如此重複畫 5 行（輸入要求）。

 */

import java.util.Scanner;

public class RectanglePicture_NestedLoop {
    public static void main(String[] args) {
//        宣告相關物件和變數
        Scanner keyin = new Scanner(System.in);
        int height;
        int width;

//        要求輸入矩形高與寬
        System.out.printf("\n請書入矩形高度 =>\n");
        height = keyin.nextInt();
        System.out.printf("\n請書入矩形寬度 =>\n");
        width = keyin.nextInt();

//        繪製矩形圖
        for (int i=1; i<=height; i++){
            System.out.printf("     ");
            for (int j=1; j<=width; j++){
                System.out.printf("*");
            }
            System.out.printf("\n");
        }

    }
}

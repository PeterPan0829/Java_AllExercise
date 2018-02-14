package Java_FlowControl;

/*
    利用星號（*）畫出 等齊三角形，高度可以由使用者輸入指定

    需要利用雙重迴圈來製作此程式，外迴圈決定三角形的高度，但需要兩個內迴圈來製作三角形的寬度，一則畫空白；另一迴圈輸出星號。

 */

import java.util.Scanner;

public class TrianglePicture_NestedLoop {
    public static void main(String[] args) {
//        宣告相關物件和變數
        Scanner keyin = new Scanner(System.in);
        int height;
        int width;

//        要求輸入三角形高與寬
        System.out.printf("\n請書入三角形高度 =>");
        height = keyin.nextInt();
        System.out.printf("\n請書入三角形寬度 =>");
        width = keyin.nextInt();

//        繪製等齊三角形圖
        for (int i=1; i<=height; i++){                           // 外迴圈，指定高度
            for (int j=1; j<=(height-i); j++){                   // 第 1 個內迴圈，輸出空格
                System.out.printf(" ");
            }
            for (int k =1; k<=i; k++){                           // 第 2 個內迴圈，輸出星號
                System.out.printf("*");
            }
            System.out.printf("\n");                             // 換行
        }

    }
}

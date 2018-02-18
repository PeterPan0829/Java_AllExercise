package Java_FlowControl;

/*
    運用多重迴圈畫出各種等邊三角形
 */

import java.util.Scanner;

public class AllKindsOfTrianglePicture_NestedLoop {
    public static void main(String[] args) {
        //宣告相關物件、變數
        Scanner keyin = new Scanner(System.in);
        int height;
        int width;

        //要求輸入三角形高與寬
        System.out.printf("\n請輸入三角形高度 =>");
        height = keyin.nextInt();
        System.out.printf("\n請輸入三角形寬度 =>");
        width = keyin.nextInt();

//==================繪製右邊等齊三角形圖==================
//      *
//     **
//    ***
//   ****
//  *****
// ******
        for (int i=1; i<=height; i++){                           // 外迴圈，指定高度
            for (int j=1; j<=(height-i); j++){                   // 第 1 個內迴圈，輸出空格, height-i(1) 表示減掉空白
                System.out.printf(" ");
            }
            for (int k =1; k<=i; k++){                           // 第 2 個內迴圈，輸出星號
                System.out.printf("*");
            }
            System.out.printf("\n");                             // 換行

//==================繪製左邊等邊三角形==================
// *
// **
// ***
// ****
// *****
// ******
// *******
// ********
            for (int i=1; i<=height; i++){
                System.out.printf(" ");
                for (int j=1; j<=i; j++){
                    System.out.printf("*");
                }
                System.out.printf("\n");
            }


//==================繪製反向右邊等邊三角形==================
//********
// *******
//  ******
//   *****
//    ****
//     ***
//      **
//       *
        for (int i=1; i<=height; i++){
            for (int j=1; j<=i-1; j++){
                System.out.printf(" ");
            }
            for (int k=1; k<=height-i; k++){
                System.out.printf("*");
            }
            System.out.printf("\n");
        }


//==================繪製反向左邊等齊三角形圖==================
//********
//*******
//******
//*****
//****
//***
//**
//*
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= (height - i); j++) {
                System.out.printf("*");
            }
            System.out.printf("\n");
    }
}

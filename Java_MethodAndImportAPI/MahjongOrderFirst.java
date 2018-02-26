package Java_MethodAndImportAPI;

/*
    麻將選擇出牌順序
    麻將桌常出現需要玩家擲骰子來決定優先順序，每次擲三個骰子（1 ~ 6），由它們的和計算大小。
    假設有四位牌友（東、西、南、北），分別擲三個骰子，並能選出最大數值。

    介面如下：
            請 東方 擲骰子 (按 Enter 鍵) =>
                擲出 => 6   5   2
                東方擲的是: 13
            請 南方 擲骰子 (按 Enter 鍵) =>
                擲出 => 1   1   5
                南方擲的是: 7
            請 西方 擲骰子 (按 Enter 鍵) =>
                擲出 => 1   3   4
                西方擲的是: 8
            請 北方 擲骰子 (按 Enter 鍵) =>
                擲出 => 1   1   1
                北方擲的是: 3

            擲出最大的是 = 13
 */

import java.util.Random;
import java.util.Scanner;

//類別開始
public class MahjongOrderFirst {
    //main方法開始
    public static void main(String[] args) {
        /* 宣告相關物件、變數*/
        int maxNum;                                 //最大值
        int east, west, south, north;               //東、西、南、北
        Scanner keyin = new Scanner(System.in);
        System.out.printf("請 東方 擲骰子(按 Enter 鍵) =>");
        keyin.nextLine();                           //只是暫停的功能沒有任何作用,nextLine()：取得使用者輸入的字串(包含空白字元、空白鍵、Tab)
        east = game();                              //呼叫 game() 方法
        System.out.printf("\t 東方擲的是: %d",east);

        System.out.printf("\n請 西方 擲骰子(按 Enter 鍵) =>");
        keyin.nextLine();
        west = game();
        System.out.printf("\t 西方擲的是: %d",west);

        System.out.printf("\n請 南方 擲骰子(按 Enter 鍵) =>");
        keyin.nextLine();
        south = game();
        System.out.printf("\t 南方擲的是: %d",south);

        System.out.printf("\n請 北方 擲骰子(按 Enter 鍵) =>");
        keyin.nextLine();
        north = game();
        System.out.printf("\t 北方擲的是: %d\n",north);

        maxNum = max(east, max(west, max(south,north)));
        System.out.printf("\n擲出最大的是 = %d",maxNum);


    }//main方法結束

    //宣告 game 方法, 沒有任何回傳值
    static int game(){
        Random random = new Random();
        int sum = 0;
        int ran;
        System.out.printf("\t 擲出 =>");
        for (int k=1; k<=3; k++){
            ran = 1 + random.nextInt(6);      //輸出三個隨機數字範圍是 1 + 0~5 = 6
            System.out.printf("%d   ",ran);
            sum = sum + ran;
        }
        System.out.println();
        return sum;
    }

    //宣告 max 方法
    static int max(int a, int b){
        if (a > b){
            return a;
        }else
            return b;
    }

}//類別結束
package Java_MethodAndImportAPI;

/*
    擲骰子大吃小搏奕遊戲

    擲骰子賭博大多不喜歡『通吃』規則，為了增加次數與趣味性，都採用大吃小的規則，越多人參與越好玩，擲出最大者吃最小者。
    製作一套大吃小的擲骰子系統，參賭者輸入姓名後擲出 3 個骰子，隨後告知目前領先者與點數。
    直接輸入『Enter』 表示結束參與者，立即顯示出贏家與輸家以及擲出點數。
 */

import java.util.Random;
import java.util.Scanner;

public class ThrowDiceGame {
    //宣告全域變數(類別變數)
    static String MaxName="", MinName="";                           //預防一開始就有人直接輸入 Enter ,名稱初始值設定空的(不是null)
    static int MaxNum=0, MinNum=99;                                 //預防一開始就有人直接輸入 Enter ,最高分和最低分都是以不可能的結果去設想

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);                     //區域物件
        String name;                                                //區域變數
        int number;                                                 //區域變數

        System.out.printf("======歡迎光臨大吃小博奕遊戲======");
        System.out.printf("\n輸入姓名並擲骰子 （若直接輸入 Enter 則結束）=>");
        name = keyin.nextLine();
        while (name.length() != 0){                                 //長度不等於 0 表示不直接輸入 Enter 有正常輸入名字 ; 直接輸入 Enter 就是等於 0
            game(name);
            System.out.printf("領先者：%s, 點數：%d\n",MaxName,MaxNum);
            System.out.printf("最低者：%s, 點數：%d\n",MinName,MinNum);

            System.out.printf("\n輸入姓名並擲骰子 （若直接輸入 Enter 則結束）=>");
            name = keyin.nextLine();
        }

        System.out.printf("贏家：%s, 擲出 %d\n",MaxName,MaxNum);
        System.out.printf("輸家：%s, 擲出 %d\n",MinName,MinNum);
    }

    /*
        宣告擲骰子 game() 但不知道有幾個人要擲骰子所以另外把擲骰子這個動作寫成一個 game method
        擲骰子這個動作不回傳任何值所以用 void 因為是直接把結果寫到 "類別變數"裡面（仔細查看下方判斷式的程式區塊）
    */
    static void game(String name){                                  //這裡的 name 就是我們在 Main() 輸入的 name
        Random random = new Random();
        int ran, sum=0;
        System.out.printf("\t您擲出 =>");
        for (int k=0; k<=3; k++){
            ran = 1 + random.nextInt(6);
            System.out.printf("%d   ",ran);
            sum = sum + ran;
        }
        System.out.printf("合計 = %d\n",sum);

        if (sum > MaxNum){                                          //合計骰子點數如果大於最大值就取代最高分的玩家和分數
            MaxName = name;
            MaxNum = sum;
        }
        if (sum < MinNum){
            MinNum = sum;
            MinName = name;
        }
    }

}

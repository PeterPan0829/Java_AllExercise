package Java_MethodAndImportAPI;

/*
    擲骰子搏奕遊戲
    夜市常出現擲骰子的搏奕遊戲方法是參與賭博者依序擲出三個骰子到碗公內，總數最大者贏了此局。
    程式來取代賭具（碗公與骰子），並假設只有四個人參與賭博。
    程式功能是參與者輸入自己名字，系統立即顯示所擲骰子的總數，最後顯示最高者名字和成績。介面如下：

    請玩家輸入姓名並擲骰子 =>丁一
        您擲出 => 3   1   3   合計: 7
    請玩家輸入姓名並擲骰子 =>劉二
        您擲出 => 6   6   2   合計: 14
    請玩家輸入姓名並擲骰子 =>張三
        您擲出 => 6   2   3   合計: 11
    請玩家輸入姓名並擲骰子 =>李四
        您擲出 => 4   6   1   合計: 11

    恭喜!! 劉二 先生擲出 14 贏得此局

    *程式解析：
            在這個 ThrowDice 類別底下會有 Main()、game() , 把擲骰子這個動作寫成一個 game(),
            Main()會傳送玩家姓名給 game(), 再由 game() 回傳 number 給 Main()


 */

import java.util.Random;
import java.util.Scanner;

public class ThrowDice {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        String maxName = "", name;               //宣告擲出最大數值者姓名並設定空值、玩家姓名
        int maxNum = 0;                          //宣告擲出最大數值並設定初值
        int number;



        for (int i=1; i<=4; i++){                //有四個玩家所以終止條件設定4
            System.out.printf("\n請玩家輸入姓名並擲骰子 =>");
            name = keyin.nextLine();
            number = game();                     //呼叫擲骰子這個 game() 計算的值會儲存給 number

            if (number > maxNum){
                maxNum = number;
                maxName = name;
            }
        }
        System.out.printf("\n恭喜!! %s 玩家擲出 %d 贏得此局",maxName,maxNum);
    }

    //擲骰子動作宣告成 game()
    static int game(){
        Random random = new Random();            //宣告產生亂數物件
        int sum = 0;
        int ran;
        System.out.printf("\t 您擲出 =>");
        for (int i=0; i<3; i++){
            ran = 1 + random.nextInt(6);   //產生並顯示 3 個 1~6 之間亂數
            System.out.printf("%d  ",ran);
            sum = sum + ran;                     //計算總和並回傳
        }
        return sum;
    }
}

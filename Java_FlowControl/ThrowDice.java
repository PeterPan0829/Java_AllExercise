package Java_FlowControl;

/*
    投擲骰子比大小

    想更多了解 BufferedReader 取得輸入可以參考以下教學網址：
    https://openhome.cc/Gossip/JavaGossip-V1/BufferedReader.htm

 */

import java.io.*;
import java.util.Random;

public class ThrowDice {
    public static void main(String[] args) throws IOException {
        BufferedReader keyin = new BufferedReader(
                new InputStreamReader(System.in));
        Random random = new Random();

        int num1 = 1 + random.nextInt(6);
        int num2 = 1 + random.nextInt(6);
        int num3 = 1 + random.nextInt(6);
        int num4 = 1 + random.nextInt(6);
        int num5 = 1 + random.nextInt(6);
        int num6 = 1 + random.nextInt(6);
        int sum1 = num1 + num2 + num3;
        int sum2 = num4 + num5 + num6;

        String user1, user2;



        System.out.printf("請輸入第一個賭徒的姓名： ");
        user1 = keyin.readLine();
        System.out.printf("%s 先生/小姐擲骰子是 %d %d %d 合計：%d\n",user1,num1,num2,num3,sum1);

        System.out.printf("\n請輸入第二個賭徒的姓名： ");
        user2 = keyin.readLine();
        System.out.printf("%s 先生/小姐擲骰子是 %d %d %d 合計：%d\n",user2,num4,num5,num6,sum2);

        if (sum1 >= sum2){
            System.out.printf("\n%s 比 %s大, %s 是本局最大贏家！",user1,user2,user1);

        }else {
            System.out.printf("\n%s 比 %s大, %s 是本局最大贏家！",user2,user1,user2);
        }







    }
}

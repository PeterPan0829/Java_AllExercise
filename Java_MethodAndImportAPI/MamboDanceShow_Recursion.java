package Java_MethodAndImportAPI;

/*
    曼波舞步的步法是進一步再退一步、進兩步再退兩步、進三步再退三步，依此類推。
    前進多少步則相對應後退多少步，當然不會直線進退，可選擇任何路徑進行；又此可見，連續越多步法越困難。請製作一套曼波舞步表演系統，並可隨觀眾喜好選擇表演級數。
    期望操作系統介面如下：

    == 曼波舞步表演系統 ==

    請輸入表演級數 =>4
    第 1 階舞步 =>1 1
    第 2 階舞步 =>1 2 2 1
    第 3 階舞步 =>1 2 3 3 2 1
    第 4 階舞步 =>1 2 3 4 4 3 2 1
    謝謝參觀

    前進寫一個 method, 後退寫一個 method

 */

import java.util.Scanner;

public class MamboDanceShow_Recursion {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int step;

        System.out.printf("== 曼波舞步表演系統 ==");
        System.out.printf("\n請輸入表演級數 =>");         //假設是5
        step = keyin.nextInt();

        for (int k=1; k<=step; k++){                   //小於我們的輸入數字
            System.out.printf("第 %d 階舞步 =>",k);
            front_dance(k);                            //前進 x 步, 這裡的 x 以上面的輸入數字 5
            back_dance(k);                             //後退 x 步
        }


    }

    /*
        兩個前進後退的 method 差別在於 back_dance 的 else 是先印出來再減
    */

    static void front_dance(int k){
        if (k<=1){
            System.out.printf("1 ");
        }
        else
            front_dance(k-1);
            System.out.printf("%d",k);
    }

    static void back_dance(int k){
        if (k<=1){
            System.out.printf("1 ");
        }
        else
            System.out.printf("%d",k);
            back_dance(k-1);
    }
}

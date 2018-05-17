package Java_ArrayDataStructure;

/*
 走迷宮演練(驗證 Stack 功能)

 談到堆疊(Stack)大多人都會想到走迷宮的問題，但其實它應用非常廣泛，譬如導航系統一定都會用到。
 利用堆疊記錄過去走的路徑，當須退回原處時，再依照堆疊內記錄退回原處，就不會迷路了。
 
 圖 http://www.tsnien.idv.tw/Java2_WebBook/插圖/chap4/圖%204-21.png 是迷宮地圖，將地圖中每一個節點都用座標表示，
 橫座標由 A ~ Q，縱座標由 0 ~9，位置由 A0 ~ Q9，並所有路徑(或位置)都可以通過。假設，我們由 D9 開始，經過圖中節點到達 Q0，
 回程由 Q0 是否可以回到 D9。

 編寫程式依照圖中路徑行走，完畢後再顯示所經過的節點如何，接著再依照走過的記錄是否可以回到原點，驗證走迷宮的初步構想。

 push() 算是去程；pop() 是回程

 期望功能如下：

 == 歡迎光臨 走迷宮演練 ==
 (1) 列印以走過的路線
 (2) 迷宮去程開始
 (3) 迷宮回程開始
 (4) 離開系統
         請輸入工作選項 =>


 系統分析：
 首先我們宣告陣列 path[]，並依照上圖 路徑位置填入該陣列。
 前進時，由 path[] 中讀取下一個路徑位置，並將該位置推入(Push)堆疊內，一直到讀取完畢，表示已走完所有路徑，堆疊內也記錄所有走過的節點。
 回程時，再一個接一個位置由堆疊內擠出(Pop)，依照擠出位置行走，就可以回到原點。

 我們將 Push 與 Pop 製作成獨立的方法，可利用他們對 Stack 做推入與擠出的操作。
 */


import java.util.Scanner;

public class Array_Stack_MazeGame {

    static int Top;                                         //宣告當前位置　
    static String Stack[] = new String [50];                //宣告 Stack 空間

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Top = -1;                                           //宣告當前位置為空值
        String step;
        String path[] = {"D0", "D9", "D8", "D7", "E7",
                        "F7", "G7", "H7", "I7", "J7",
                        "K7", "K6", "L6", "L5", "L4",
                        "L3", "L2", "M2", "N2", "N3",
                        "N4", "N5", "N6", "N7", "N8",
                        "O8", "P8", "P7", "P6", "P5",
                        "P4", "P3", "P2", "P1", "Q1"};
        int select;
        Print_menu();
        select = keyin.nextInt();
        while (select != 4){
            switch (select){
                case 1:
                    Print_Stack();
                    break;
                case 2:
                    //去程 push()
                    for (int i=0; i<path.length; i++){
                        step = path[i];
                        if (push(step)){
                            System.out.printf("%s ==>",step);
                        }else {
                            System.out.printf("目前路徑已滿，回頭吧！\n");
                            break;
                        }
                        if ((i+1) %5 == 0){
                            System.out.printf("\n");
                        }
                    }
                    System.out.printf("總共走了 %d 路徑\n",Top+1);
                    break;
                case 3:
                    //回程 pop()
                    int k = 0;
                    while (Top >= 0){
                        step = pop();
                        System.out.printf("%s ==>",step);
                        k = k + 1;
                        if (k%5 == 0){
                            System.out.printf("\n");
                        }
                    }
                    System.out.printf("回程路徑已結束\n");
                    break;
                    default:
                        System.out.printf("輸入錯誤!!請重新輸入\n");
            }
            Print_menu();
            select = keyin.nextInt();
        }

    }

    // 列印功能表
    static void Print_menu(){
        System.out.printf("\n== 歡迎光臨 走迷宮演練 ==\n");
        System.out.printf("(1) 列印已走過的路線\n");
        System.out.printf("(2) 迷宮去程開始\n");
        System.out.printf("(3) 迷宮回程開始\n");
        System.out.printf("(4) 離開系統\n");
        System.out.printf("\t 請輸入工作選項 =>");
    }

    // 列印 Stack 內容（目前走過的路徑）
    static void Print_Stack(){
        System.out.printf("\n== 到目前為止經過 %d 個路徑 ==\n",Top+1);
        for (int i=0; i<=Top; i++){
            System.out.printf("(%d)%s ",i+1,Stack[i]);
            if ((i+1) %5 ==0){
                System.out.printf("\n");
            }
        }
    }

    // 加入 Push 元素
    static boolean push(String step){
        if (Top >= 50){
            return false;
        }else {
            Top = Top +1;
            Stack[Top] = step;
            return true;
        }
    }

    // 彈出(反向) pop 元素
    static String pop(){
        String step = Stack[Top];
        Top = Top - 1;
        return step;
    }
}

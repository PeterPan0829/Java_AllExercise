package Java_ArrayDataStructure;

import java.util.Random;
import java.util.Scanner;

/*
    無序陣列範例
    建立一個無序陣列，儲存空間為 50 筆，並具有插入與列印資料的功能
    
 */
public class Array_NonSequence {
    static int num[] = new int[50];                          //宣告無序陣列空間  0~49
    static int point;                                        //宣告游標變數
    
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Random random = new Random();
        
        int value;                                           //輸入元素
        int select;                                          //功能選擇
        point = -1;                                          //游標初值（表示空的,不是0因為我們插入的元素是 1個元素, 要預留位置所以 - 1）
        
        for(int i=0; i<30; i++){                             //表示要列印出來的數字總數有多少
            value = random.nextInt(100);              // 0 ~ 99
            point = point + 1;
            num[point] = value;                              //把 value 放到類別變數 num[] 當中, 抓point 的值
        }
        
        //顯示菜單
        print_menu();
        
        //讀取我們的選擇(1 2 3)
        select = keyin.nextInt();
        while (select != 3){                                //這邊算是一個小技巧, 如果我一開始進去輸入 3 表示直接離開（但這裡我們沒寫任何動作程式會自己離開
            switch (select){
                case 1:
                    print_array();
                    break;
                case 2:
                    if (point >= 50){                       //插入的數字
                        System.out.printf("此陣列已經無法插入!!");
                    }else {
                        System.out.printf("請插入元素 =>");
                        value = keyin.nextInt();
                        num[point] = value;                 //這邊要特別注意, 如果是先執行游標元素 +1 再塞進去（num[point] = value）會是錯誤,大家可以把這行和下面那行對調試試看
                        point = point + 1;                  //游標元素 + 1

                    }
                    break;
                default:
                    System.out.printf("\n輸入錯誤囉～～～請重新輸入！\n");
            }
            print_menu();
            select = keyin.nextInt();
        }
        
    
    }
    
    //列印菜單
    static void print_menu() {
        System.out.printf("\n== 歡迎光臨無序陣列管理系統 ==\n");
        System.out.printf("\n(1) 列印無序陣列內容\n");
        System.out.printf("(2) 插入陣列元素\n");
        System.out.printf("(3) 離開系統\n");
        System.out.printf("\t請輸入工作選項\t=>");
        
    }
    
    //列印陣列的內容
    static void print_array() {
        System.out.printf("\n== 列　印　無　序　陣　列　內　容 ==\n");
        for (int i=0; i<point; i++){
            System.out.printf("%3d　　",num[i]);                 //其中 3d 的 3表示空格, 可以試試
            if ((i+1) % 5 == 0){                                //每五筆換行
                System.out.printf("\n");
            }
        }
    }
}

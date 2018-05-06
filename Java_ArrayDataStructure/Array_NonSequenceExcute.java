package Java_ArrayDataStructure;

import java.util.Random;
import java.util.Scanner;

public class Array_NonSequenceExcute {
    static int num[] = new int[50];                          //宣告無序陣列空間  0~49
    static int point;                                        //宣告游標變數

    
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Random random = new Random();
        
        int value;                                           //輸入元素
        int select;                                          //功能選擇
        
        
        point = -1;                                          //游標初值（表示空的,不是0因為我們插入的元素是 1個元素, 要預留位置所以 - 1）
        
        for (int i = 0; i < 30; i++) {                             //表示要列印出來的數字總數有多少
            value = random.nextInt(100);              // 0 ~ 99
            point = point + 1;
            num[point] = value;                              //把 value 放到類別變數 num[] 當中, 抓point 的值
        }
        
        //顯示菜單
        print_menu();
        
        //讀取我們的選擇(1 2 3 4)
        select = keyin.nextInt();
        while (select != 4) {                                //這邊算是一個小技巧, 如果我一開始進去輸入 4 表示直接離開（但這裡我們沒寫任何動作程式會自己離開
            switch (select) {
                case 1:
                    print_array();
                    break;
                case 2:                                      //插入元素
                    if (point >= 50) {
                        System.out.printf("此陣列已經無法插入!!");
                    } else {
                        System.out.printf("請插入元素 =>");
                        value = keyin.nextInt();
                        num[point] = value;                 //這邊要特別注意, 如果是先執行游標元素 +1 再塞進去（num[point] = value）會是錯誤,大家可以把這行和下面那行對調試試看
                        point = point + 1;                  //插入一筆資料後 point = point + 1　
                        
                    }
                case 3:                                     //刪除元素
                    System.out.printf("\n請輸入想刪除的元素 =>\n");
                    value = keyin.nextInt();
                    int location = Linear_search(value);
//                    int location = Linear_search(value);
                    if(location == -1){
                        System.out.printf("陣列內沒有 %d 元素\n",value);
                    }else {
                        for (int i=location; i<point; i++){
                            num[i] = num[i+1];
                        }
                    }
                    point = point-1;                        //如果 point 是 -1 代表裡面是空的
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
        System.out.printf("(3) 刪除陣列元素\n");
        System.out.printf("(4) 離開系統\n");
        System.out.printf("\t請輸入工作選項\t=>");
        
    }
    
    //列印陣列的內容
    static void print_array() {
        System.out.printf("\n== 列　印　無　序　陣　列　內　容 ==\n");
        for (int i = 0; i < point; i++) {
            System.out.printf("%3d　　", num[i]);                 //其中 3d 的 3表示空格, 可以試試
            if ((i + 1) % 5 == 0) {                                //每五筆換行
                System.out.printf("\n");
            }
        }
    }
    
    static int Linear_search(int value){
        int i=0 , flag = 0;
        
        while (i<10)
        if (value == num[i]){
            flag = 1;
            break;
        }
        i++;
    
        if (flag ==1){
            System.out.printf("num[%d] = %d 找到囉兄弟！\n",i,value);            //前面的 i 是 num 陣列當中的第幾個位置
        }else
            System.out.printf("%d 不在 num 陣列內",value);

    
//        return value;
        return i;
    }
}
package Java_ArrayDataStructure;

/*
    醫院掛號系統採用 Queue FIFO 方法完成，可以先到 wiki 看教學文章有詳細說明再實做體會更深刻!!
    
    甄美麗美容中心需要一套掛號系統，功能是記錄客戶掛號的先後順序，功能如下：

    (1) 具有顯示目前掛號客戶順序、登錄客戶掛號之功能，選單如下：
    
    == 歡迎光臨 甄美麗掛號系統 ==
    (1) 列印目前掛號客戶名單
    (2) 客戶掛號
    (3) 離開系統
         請輸入工作選項 =>
 */

import java.util.Scanner;

public class Array_Queue_HSRegister {

    static String Queue[] = new String[5];                         //宣告 Queue 空間
    static int Front = 0;                                           //宣告 Queue 前端(出口)
    static int Rear = -1;                                           //宣告 Queue 後端(入口) & 把插入設為空值

    public static void main(String[] args) {
        int select;
        String customer;
        Scanner keyin = new Scanner(System.in);
        Print_menu();
        select = keyin.nextInt();

        while (select != 3){
            switch (select){
                case 1:
                    Print_Queue();
                    break;
                case 2:
                    System.out.printf("請輸入客戶姓名 =>>");
                    customer = keyin.next();
                    if (enQueue(customer)){                             //呼叫 enQueue() 帶入 customer
                        System.out.printf("%s 已掛號成功!!\n",customer);
                    }else {
                        System.out.printf("目前掛號已滿請稍候再次掛號!!\n");
                    }
                    break;
                    default:
                        System.out.printf("輸入錯誤 !! 請重新輸入\n");
                    }
                    Print_menu();
                    select = keyin.nextInt();
            }
        }
        


    //列印選單
    static void Print_menu(){
        System.out.printf("\n== 歡迎光臨, 甄美麗掛號系統 ==\n");
        System.out.printf("(1) 列出目前掛號客戶名單\n");
        System.out.printf("(2) 客戶掛號\n");
        System.out.printf("(3) 離開系統\n");
        System.out.printf("　　請輸入工作選項 =>>");
    }

    //列印 Queue
    static void Print_Queue(){
        System.out.printf("\n== 目前有 %d 位客戶掛號 ==\n", Rear+1);
        for (int i=0; i<=Rear; i++){
            System.out.printf("(%d)%s \n",i+1,Queue[i]);
        }
    }

    //加入 Queue 元素
    static boolean enQueue(String customer){
        if (Rear >= 50){
            return false;
        }else {
               Rear = Rear + 1;
               Queue[Rear] = customer;
               return true;
        }
    }
}

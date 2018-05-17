package Java_ArrayDataStructure;
/*
    醫生看診系統(包含客戶掛號與醫生看診順序的功能)

    甄美麗美容中心除了客戶掛號功能外，還需要醫生看診系統，擴充 Array_Queue_HSRegister 系統的功能，讓醫生看診順序的功能。
    基本上，醫生看診是依照客人先來先看(Queue 功能)。當醫生選擇一位客戶時，則由掛號系統 "刪除" 該客戶排隊，其他客戶往前移一位，功能如下：

    系統分析：
    醫生叫診是依照先進先出的規則，每叫一個客戶則由 Queue 內刪除一個元素，因此，僅依照 Array_Queue_HSRegister 擴充刪除佇列元素的功能即可。
    增加了 emptyQueue() 與 deQueue() 兩個方法，前者是測試 Queue 是否為空值狀態，表示有沒有掛號中的客戶；後者是醫生叫號後，刪除前面的客戶。

    == 歡迎光臨 甄美麗掛號系統 ==
    (1) 列印目前掛號客戶名單
    (2) 客戶掛號
    (3) 醫生看診客戶
    (4) 離開系統
         請輸入工作選項 =>

    本次教學範例重點在於　deQueue() 能夠叫病人看診並且刪除進入看診室的客戶！

    選擇醫生看診客戶姓名並觀察客戶掛號名單(選擇 3 與 1)，如下：
        請輸入工作選項 =>3
    請 劉真立 先生/小姐進入看診室
    == 歡迎光臨 甄美麗掛號系統 ==
    (1) 列印目前掛號客戶名單
    (2) 客戶掛號
    (3) 醫生看診客戶
    (4) 離開系統
         請輸入工作選項 =>1

    == 目前有 1 位客戶掛號 ==
    (1)張真真

    
 */

import java.util.Scanner;

public class Array_Queue_HSRegister_Excute {
    static String Queue[] = new String[5];                          //宣告 Queue 空間
    static int Front = 0;                                           //宣告 Queue 前端(出口)
    static int Rear = -1;                                           //宣告 Queue 後端(入口) & 把插入設為空值

    public static void main(String[] args) {
        int select;
        String customer;
        Scanner keyin = new Scanner(System.in);
        Print_menu();
        select = keyin.nextInt();

        while (select != 4){
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
                case 3:
                    if (emptyQueue()){                                  //直接帶入 emptyQueue() 來判斷是不是空值
                        System.out.printf("目前沒有客戶掛號\n");
                    }else {
                        customer = deQueue();                           //有掛號就叫客戶進房看診，並刪除以進房看診的病人
                        System.out.printf("請 %s 先生小姐進入看診室\n",customer);
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
        System.out.printf("(3) 醫生看診客戶\n" );
        System.out.printf("(4) 離開系統\n");
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

    //確認 Queue 是否為空值狀態
    static boolean emptyQueue(){
        if (Rear < 0){
            return true;
        }else {
            return false;
        }
    }

    //刪除 Queue 元素
    static String deQueue(){
        String customer = Queue[Front];
        for (int i=Front; i<Rear; i++){
            Queue[i] = Queue[i+1];
            Rear = Rear -1;
        }
        return customer;
    }

}

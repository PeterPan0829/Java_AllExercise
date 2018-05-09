package Java_ArrayDataStructure;

/*
    建立一個可供插入元素的 "有序" 陣列。
 */


import java.util.Scanner;
public class Array_Sequence_insert {

    static int num[] = new int[50];                     // 宣告陣列空間
    static int point;                                   // 宣告游標變數

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        point = -1;                                     // 設置空值
        int select, k, item;                            //插入元素 item

        for (int i=0; i<30; i++){                       //給予陣列初值
            num[i] = (i+1) *2;                          //存入有序資料
            point = point +1;                           //游標指示目前位置 (移 1 位)
        }

        print_menu();
        select = keyin.nextInt();
        while (select != 3){
            switch (select){
                case 1:
                    print_array();
                    break;

                case 2:
                    if (point >=50){
                        System.out.printf("陣列元素滿囉！已經無法插入了！！\n");
                    }else {
                        System.out.println("請輸入想插入的元素 ==>");
                        item = keyin.nextInt();
                        point = point +1;
                        k = point;
                        while (true){
                            if (num[k-1] > item){
                                num[k] = num[k-1];
                                k = k - 1;
                            }else {
                                break;
                            }
                            num[k] = item;
                        }
                    }
                    break;
                    default:
                        System.out.printf("輸入錯誤！請重新輸入唷！！\n");
            }
            print_menu();
            select = keyin.nextInt();

        }


    }

    //列印菜單內容
    static void print_menu() {
        System.out.printf("====歡迎光臨有序陣列管理系統====\n");
        System.out.printf("(1)列印有序陣列內容\n");
        System.out.printf("(2)插入陣列元素\n");
        System.out.printf("(3)離開系統\n");
        System.out.printf("\t請輸入工作項目 ==>");
    }

    //列印陣列內容
    static void print_array(){
        System.out.printf("\n==== 目前有序陣列內容共有 %d 筆資料 ====\n",point+1);
        for (int i=0; i <= point; i++){
            System.out.printf("%3d",num[i]);
            if ((i+1) % 10 == 0){                           //列印10筆, 換行
                System.out.printf("\n");
            }
        }
        System.out.printf("\n");

    }



}

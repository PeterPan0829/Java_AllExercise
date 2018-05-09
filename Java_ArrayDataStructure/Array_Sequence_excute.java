package Java_ArrayDataStructure;

import java.util.Scanner;

public class Array_Sequence_excute {

    static int num[] = new int[50];
    static int point;

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        point = -1;                                     //設置空值
        int select, k, item;                            //插入元素 item

        for (int i=0; i<50; i++){
            num[i] = (i+1) * 2;
            point = point + 1;
        }
        print_menu();
        select = keyin.nextInt();
        while (select != 4){
            switch (select){
                case 1:
                    print_array();
                    break;
                case 2:
                    if (point >= 50){
                        System.out.printf("陣列已滿無法插入!!\\n");
                    }else {
                        System.out.printf("請輸入欲插入元素 =>");
                        item = keyin.nextInt();
                        point = point + 1;
                        k = point;
                        while (true){
                            if (num[k-1] > item){
                                num[k] = num[k-1];
                                k = k -1;
                            }else {
                                break;
                            }
                        }
                        num[k] = item;
                    }
                    break;
                case 3:
                    System.out.printf("請輸入想刪除的元素 =>");
                    item = keyin.nextInt();
                    int location = Binary_search(item);             //把 location 這個變數新增在 case3當中就好
                    if (location == -1){                            //如果 location 這個變數是空值
                        System.out.printf("陣列內沒有 %d 元素",item);
                    }else {
                        for (int i=location; i<point; i++){
                            num[i] = num[i+1];
                        }
                    }
                    point = point - 1;
                    break;
                    default:
                        System.out.printf("輸入錯誤 !! 請重新輸入\\n");
            }
            print_menu();
            select = keyin.nextInt();
        }




    }

    //列印菜單內容
    static void print_menu(){
        System.out.printf("====歡迎光臨有序陣列管理系統====\n");
        System.out.printf("(1)列印有序陣列內容\n");
        System.out.printf("(2)插入陣列元素\n");
        System.out.printf("(3)刪除陣列元素\n");
        System.out.printf("(4)離開系統\n");
        System.out.printf("\t請輸入工作項目 ==> ");
    }

    //列印陣列內容
    static void print_array(){
        System.out.printf("\n==== 目前有序陣列有 %d 筆資料 ====\n",point+1);
        for (int i=0; i<point; i++){
            System.out.printf("%2d ",num[i]);
            if ((i+1) % 10 == 0){
                System.out.printf("\n");
            }
        }
        System.out.printf("\n");
    }


    //列印刪除元素（二分搜尋法）
    static int Binary_search(int item){
        int location = -1;
        int low=0, high=49, mid=0;
        while ((low+1) < high){
            mid = (low + high) / 2;
            if (item == num[mid]){
                location = mid;
                break;
            }
            else{
                if (item > num[mid]){
                    low = mid;
                }else {
                    high = mid;
                }
            }
        }
        return location;
    }
}

package Java_ArrayDataStructure;


import java.util.Scanner;

public class Array_Sequence_excute {

    static int num[] = new int[50];                     // 宣告陣列空間
    static int point;                                   // 宣告游標變數

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        point = -1;                                     //設置空值
        int select, k, item;                            //插入元素 item

        for (int i=0; i<30; i++){                       //給予陣列初值
            num[i] = (i+1) * 2;                         //存入有序資料
            point = point + 1;                          //游標指示目前位置 (移 1 位)
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
                        System.out.printf("陣列已滿無法插入!!\n");
                    }else {
                        System.out.printf("請輸入欲插入元素 =>");
                        item = keyin.nextInt();
                        point = point + 1;                //做移位的動作
                        k = point;                        //表示原來指標的位置
                        while (true){
                            if (num[k-1] > item){         //在陣列插入元素的下方(原本的值)大於我們插入的元素
                                num[k] = num[k-1];        //做移位的動作
                                k = k -1;                 //移位完這裡就是換下一個指標
                            }else {
                                num[k] = item;            //插入元素
                                break;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.printf("請輸入想刪除的元素 =>");
                    item = keyin.nextInt();                         //輸入我們要刪除的元素
                    int location = Binary_search(item);             //把 location 這個變數新增在 case3當中就好, 然後讀 item 的值去尋找有沒有這個元素
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
        int location = -1;                                 //設定空值
        int low=0, high=49, mid=0;                         //設定原陣列搜尋範圍
        while ((low+1) < high){                            //陣列是否搜尋完. while((low+1) < high) { ….}』其中 (low+1) < high 表示元素較高的指標 high 還是高於較低的 low，則陣列還未搜尋完畢。
            mid = (low + high) / 2;
            if (item == num[mid]){                         //比對陣列中間元素
                location = mid;
                break;
            }
            else{
                if (item > num[mid]){                      //在陣列的後半段
                    low = mid;
                }else {
                    high = mid;                            //在陣列的前半段
                }
            }
        }
        return location;                                    //如果有找到位置就要回傳，開始做 case3 的 for迴圈讓位置往前面移。
    }
}

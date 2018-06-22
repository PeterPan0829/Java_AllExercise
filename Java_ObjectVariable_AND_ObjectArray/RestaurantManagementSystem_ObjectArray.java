package Java_ObjectVariable_AND_ObjectArray;

import java.util.Scanner;

//我們在同一個 package 下面新增過 Item、Fare_item 的 class 可以直接在下方實作就好，因為 Item、Fare_item class 權限是開放的！後續我們會再談到唷！


//class Item{         //菜單內容
//    int price;      //價格
//    int calorie;    //熱量
//    String name;    //菜名
//}

//class Fare_item{    //顧客點餐的內容（動態新增菜單）
//    int No;         //桌次號碼
//    String name;    //菜名
//    int price;      //價格
//    int calorie;    //熱量
//}

public class RestaurantManagementSystem_ObjectArray {

    static Item[] Menu = new Item[100];                     //菜單價目表
    static int Item_no = 0;                                 //菜單項目數量
    static Fare_item[] Fare = new Fare_item[20];            //顧客點菜項目
    static int Fare_no = 0;                                 //顧客點菜項目數量
    static Scanner keyin = new Scanner(System.in);
    static int table_No;                                    //table_No桌次第五個系統選項會計作業也需要用到固我們設置成全域變數

    public static void main(String[] args) {

        int select;
        selectMenu();
//        printSelect();
        select = keyin.nextInt();

        while (select != 7){
            switch (select){
                case 1:
                    selectMenu();           //1.匯入菜單項目
                    break;
                case 2:
                    addItemtoMenu();        //2.新增菜單項目
//                    select = keyin.nextInt();
                    break;
                case 3:
                    printMenu();            //3.印出所有菜單
                    break;
                case 4:
                    addFare();              //4.顧客點菜作業
                    break;
                case 5:
                    AccountingWork();       //5.會計收款作業
                    break;
                case 6:
                    printFare();            //6.列印所有點菜
                    break;
                    default:
                        System.out.printf("輸入錯誤，請重新選擇！！\n");
                        break;
            }
            selectMenu();
//            printSelect();
            select = keyin.nextInt();
        }

    }

    //1.餐廳管理系統項目選擇清單（非菜色的菜單）
    static void selectMenu(){
        System.out.printf("\n****** 台北美食餐廳　管理系統 ******\n");
        System.out.printf("(1) 系統選擇清單\n");
        System.out.printf("(2) 新增菜單項目\n");
        System.out.printf("(3) 列印所有菜單\n");
        System.out.printf("(4) 顧客點菜作業\n");
        System.out.printf("(5) 會計收款作業\n");
        System.out.printf("(6) 列印所有點菜\n");
        System.out.printf("(7) 結 束 作 業\n");
        System.out.printf("\t請輸入選擇　==>");
    }

    //2.新增菜單項目
    static void addItemtoMenu(){
//        以下註解省略（測試用）
//        int value, tax, k=0;                //『int k=0;』。利用變數 k 紀錄目前資料的比數有多寡；宣告時給予初始值 0。
//        String sel;
        Scanner keyin = new Scanner(System.in);
        Menu[Item_no] = new Item();
//        Menu[Fare_no] = new Item();
        System.out.printf("請輸入菜單名稱 =>");
        Menu[Item_no].name = keyin.nextLine();

        System.out.printf("請輸入價格 =>");
        Menu[Item_no].price = keyin.nextInt();

        System.out.printf("請輸入熱量 =>");
        Menu[Item_no].calorie = keyin.nextInt();

        Item_no = Item_no + 1;

//        以下註解省略（測試用）
//        Item_no = Item_no + 1;
//        for (int i=0; i<name
//        Menu[Item_no].name = Menu[Item_no].name + 1;
//        Fare_no = Fare_no + 1;
//            Fare_no = Fare_no +1;
        }

    //3.印出所有菜單
    static void printMenu() {
        // 給予菜單初值
        String name[] = {"蠔油香菇", "蒜泥白肉", "筍干扣肉", "五味花枝",
                "紅燒鮮魚", "麻婆豆腐", "白玉珍丸", "快炒青菜",
                "鮑 魚 湯", "水晶蝦餃", "紅油炒手",
                "叉 燒 酥", "藕斷絲連", "龍門米粉",
                "瑤柱炒飯", "龍蝦鮮麵", "白    飯", "足料觀湯",
                "酸黃瓜湯", "海 鮮 湯", "清    湯",
                "西 米 露"};

        int price[] = {300, 250, 320, 200, 400, 100, 150, 100, 100,
                200, 200, 200, 200, 300, 300, 400, 20, 500,
                200, 200, 20, 150};

        int calorie[] = {800, 500, 700, 600, 600, 200, 300, 150, 100,
                300, 400, 400, 300, 500, 500, 400, 100, 800,
                300, 300, 10, 200};


        //印出目前有幾道菜
        for (int i=0; i<name.length; i++){
            Item_no = Item_no +1;
        }
        System.out.printf("目前有：%d\n", Item_no);

        //印出菜單內容（菜單、價格、卡路里）
        for (int i=0; i<name.length; i++){
            Menu[i] = new Item();
            Menu[i].name = name[i];
            Menu[i].price = price[i];
            Menu[i].calorie = calorie[i];
        }
        System.out.printf("  菜單\t\t價格\t\t卡路里\n");
        for (int i=0; i<name.length; i++) {
            Item_no = Item_no +1;
            System.out.printf("%s\t\t", Menu[i].name);
            System.out.printf("%d\t\t", Menu[i].price);
            System.out.printf("%d\t", Menu[i].calorie);
            System.out.printf("\n");
        }
    }

        //4.顧客點菜作業
        static void addFare(){

            // 給予菜單初值
            String name[] = {"蠔油香菇","蒜泥白肉","筍干扣肉","五味花枝",
                    "紅燒鮮魚","麻婆豆腐","白玉珍丸","快炒青菜",
                    "鮑 魚 湯", "水晶蝦餃", "紅油炒手",
                    "叉 燒 酥","藕斷絲連","龍門米粉",
                    "瑤柱炒飯", "龍蝦鮮麵","白    飯","足料觀湯",
                    "酸黃瓜湯","海 鮮 湯", "清    湯",
                    "西 米 露"};

            int price[] = {300,250,320,200,400,100,150,100,100,
                    200, 200,200,200,300, 300,400,20,500,
                    200,200,20,150};

            int calorie[] = {800,500,700,600,600,200,300,150, 100,
                    300,400,400,300,500, 500,400,100,800,
                    300,300,10,200};

            for (int i=0; i<name.length; i++){
                Menu[i] = new Item();
                Menu[i].name = name[i];
                Menu[i].price = price[i];
                Menu[i].calorie = calorie[i];
            }

            // 給予菜單初值結束、點菜作業開始
            // int table_No, count, item;              //table_N桌次, item菜名,
            int count, item;              //table_No桌次第五個系統選項會計作業也需要用到固我們設置成全域變數, item菜名,
            int total_money=0, total_calorie=0;     //總金額、總熱量

            System.out.printf("請輸入桌次 =>>");
            table_No = keyin.nextInt();

            IniMenu();

            System.out.printf("(0)結束點菜\n");
            System.out.printf("請輸入菜名編號 =>");
            item = keyin.nextInt();

            /* 點菜累加消費金額及卡路里 */
            count = 0;

            while (item != 0 ){
                Fare[Fare_no] = new Fare_item();
                Fare[Fare_no].No = table_No;
                Fare[Fare_no].name = Menu[item-1].name;
                Fare[Fare_no].price = Menu[item-1].price;
                Fare[Fare_no].calorie = Menu[item-1].calorie;
                total_money = total_money + Fare[Fare_no].price;
                total_calorie = total_calorie + Fare[Fare_no].calorie;
                Fare_no = Fare_no + 1;
                count = count + 1;
                System.out.printf("累計%d元，%d卡路里、請輸入菜名的編號　=>>",total_money,total_calorie);
                item = keyin.nextInt();
            }

            //顯示第幾桌、菜單內容和總金額
            System.out.printf("\n%d 桌顧客菜單如下：\n",table_No);
            System.out.printf("　菜名\t\t價格\t\t熱量\n");
            for (int i=0; i<count; i++){
                System.out.printf("%s\t\t%3d\t\t%3d\n",Fare[i].name,Fare[i].price,Fare[i].calorie);
            }
            System.out.printf("總計\t\t總價格：%d\t\t總熱量：%d\n\n",total_money,total_calorie);

            //顯示廚房增加的菜單（桌號、菜名）
            System.out.printf("\n廚房增加菜單如下：\n");
            for (int i=0; i<count; i++){
                System.out.printf("%3d桌\t%s\n",Fare[i].No,Fare[i].name);
            }
        }

        //5.會計收款作業
        static void AccountingWork(){
            int tableNo_accounting, count;
            int total_money=0;

            /* 點菜累加消費金額及卡路里 */
            count = 0;

            System.out.printf("請輸入買單桌號　=>");
            tableNo_accounting = keyin.nextInt();

//            total_money = Fare + total_money;

//            第一種方法
            for (int i=0; i<=Fare_no; i++) {
                Fare[i].price = Menu[i].price;
                total_money = Fare[i].price + total_money;
                Fare_no = Fare_no + 1;
                count = count + 1;
            }

//            第二種方法
//            while (tableNo_accounting != 0){
//                Fare[Fare_no] = new Fare_item();
//                Fare[Fare_no].No = table_No;
//                Fare[Fare_no].price = Menu[Fare_no].price;
//                total_money = Fare[Fare_no].price + total_money;
//                Fare_no = Fare_no + 1;
//                count = count + 1;
//            }


            //顯示會計處收款菜單（菜名、單價、合計金額）
            for (int i=0; i<count; i++){
                System.out.printf("菜名：%s\t\t單價：%s\n",Fare[i].name,Fare[i].price);

//                System.out.printf("%3d桌\t%s\n",Fare[i].No,Fare[i].name);
            }
            System.out.printf("合\t計 = %d",total_money);

        }

        //6.列印所有點菜
        static void printFare(){
            int count=0;
            System.out.printf("桌次\t 菜單項目\n");
            for (int i=0; i<count; i++){
                System.out.printf("%3d桌\t%s\n",Fare[i].No,Fare[i].name);
            }


//            for (int i=0; i<)

            System.out.printf("\n廚房增加菜單如下：\n");
            for (int i=0; i<count; i++){
                System.out.printf("%3d桌\t%s\n",Fare[i].No,Fare[i].name);
            }
        }


    static void IniMenu() {


        for (int i=0; i<Fare.length; i++){          //小於菜單項目數量
            System.out.printf("(%d)%s  ", (i+1), Menu[i].name);
            if ((i+1)%5 == 0){                      //可以整除就做斷行
                System.out.printf("\n");
            }
        }


//        for (int i=0; i< i++) {
//
//            Menu[i] = new Item();
//
//            Menu[i].name = name[i];
//
//            Menu[i].price = price[i];
//
//            Menu[i].calory = calory[i];
//
//            Item_No = Item_No + 1;

        }

    }




package Java_ObjectVariable_AND_ObjectArray;

/*
延續 TaipeiRestaurant_ObjectArray 台北餐廳_菜單價目表，請建立一套點餐系統，系統允許客戶以選單方式，選擇所喜歡的菜色。
客戶點餐之前需輸入所在桌次，再依序選擇菜單，完畢後系統會印出菜單、總價與本桌包含熱量多寡。

顧客對『菜單價目表』感到滿意之後，接下來需製作『顧客點菜系統』，可以由顧客自行點菜或由服務生經手。
顧客點菜過程中，會隨時累計 "消費金額" 與 "卡洛里" ，完成後，除了會列印點菜清單給客戶之外，也會列印一張菜單給廚房準備上菜。

系統分析：
我們引用 TaipeiRestaurant_ObjectArray 繼續擴充。
我們類別 Fare_item 來宣告客戶每點一樣菜的物件，並利用 Fare[] 物件陣列來儲存所有顧客所點的菜單。並宣告 Item_No 與 Fare_No 兩個類別變數來記錄目前菜單與客人點菜的數目有多寡。

期望操作介面如下：

請輸入桌次 =>5         【輸入顧客桌次】
(1)蠔油香菇  (2)蒜泥白肉  (3)筍干扣肉  (4)五味花枝  (5)紅燒鮮魚
(6)麻婆豆腐  (7)白玉珍丸  (8)快炒青菜  (9)青菜豆腐湯  (10)水晶蝦餃
(11)紅油炒手  (12)蜜汁叉燒酥  (13)藕斷絲連  (14)龍門炒米粉  (15)瑤柱炒飯
(16)龍蝦鮮麵  (17)白    飯  (18)足料觀湯  (19)香菜皮蛋湯  (20)酸辣海鮮湯
(21)清    湯  (22)南瓜西米露  (0) 結束點菜

請輸入菜名的編號 =>1      【輸入菜單】
累計300元，800 卡洛里、請輸入菜名的編號 =>5     【輸入菜單】
累計700元，1400 卡洛里、請輸入菜名的編號 =>3    【輸入菜單】
累計1020元，2100 卡洛里、請輸入菜名的編號 => 20   【輸入菜單】
累計1220元，2400 卡洛里、請輸入菜名的編號 =>0    【結束點菜】

5 桌顧客菜單如下：
  菜名          價格    熱量
蠔油香菇        300     800
紅燒鮮魚        400     600
筍干扣肉        320     700
酸辣海鮮湯      200     300
總計            總價格:1220     總熱量:2400

廚房增加菜單如下：
5桌次  蠔油香菇
5桌次  紅燒鮮魚
5桌次  筍干扣肉
5桌次  酸辣海鮮湯
 */

//class Item{               我們在同一個 package 下面新增過 Item class 可以直接在下方實作就好，因為 Item class 權限是開放的！
//    int price;            後續我們會再談到唷！
//    int calorie;
//    String name;
//}

import java.util.Scanner;

class Fare_item{
    int No;         //桌次號碼
    String name;    //菜名
    int price;      //價格
    int calorie;    //熱量
}

public class OrderList_ObjectArray {

    static Item[] Menu = new Item[100];                 //菜單價目表
//    static int Item_No = 0;                             //菜單項目數量
    static Fare_item[] Fare = new Fare_item[20];        //顧客點菜項目
    static int Fare_No = 0;                             //顧客點菜項目數量

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

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
        int table_No, count, item;         //table_N桌次, item菜名,
        int total_money=0, total_calorie=0;     //總金額、總熱量

        System.out.printf("請輸入桌次 =>>");
        table_No = keyin.nextInt();

        print_menu();

//        ** self-method **
//        for (int i=0; i<Fare.length; i++){          //小於菜單項目數量
//            System.out.printf("(%d)%s  ", (i+1), Menu[i].name);
//            if ((i+1)%5 == 0){                  //可以整除就做斷行
//                System.out.printf("\n");
//            }
//        }

        System.out.printf("(0)結束點菜\n");
        System.out.printf("請輸入菜名編號 =>");
        item = keyin.nextInt();

        /* 點菜累加消費金額及卡路里 */
        count = 0;

        while (item != 0 ){
            Fare[Fare_No] = new Fare_item();
            Fare[Fare_No].No = table_No;
            Fare[Fare_No].name = Menu[item-1].name;
            Fare[Fare_No].price = Menu[item-1].price;
            Fare[Fare_No].calorie = Menu[item-1].calorie;
            total_money = total_money + Fare[Fare_No].price;
            total_calorie = total_calorie + Fare[Fare_No].calorie;
            Fare_No = Fare_No + 1;
            count = count + 1;
            System.out.printf("累計%d元，%d卡路里、請輸入菜名的編號　=>>",total_money,total_calorie);
            item = keyin.nextInt();
        }

        //顯示第幾桌、菜單內容和總金額
        System.out.printf("%d 桌顧客菜單如下：\n",table_No);
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

    //顯示菜單（獨立出一個 method 讓 Main method 去呼叫就好）
    static void print_menu(){
        for (int i=0; i<Fare.length; i++){          //小於菜單項目數量
            System.out.printf("(%d)%s  ", (i+1), Menu[i].name);
            if ((i+1)%5 == 0){                      //可以整除就做斷行
                System.out.printf("\n");
            }
        }
    }
}

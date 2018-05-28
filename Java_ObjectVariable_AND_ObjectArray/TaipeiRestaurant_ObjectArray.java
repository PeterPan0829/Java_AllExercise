package Java_ObjectVariable_AND_ObjectArray;

/*
    21_物件陣列的運用（專題製作 – 台北餐廳）_（可以搭配我們在 wiki 的學習講義 - 21_物件陣列的運用（專題製作 – 台北餐廳）)

    公司接受『台北餐廳』委託建立菜單管理系統。
    起初雙方溝通很困難，因此公司希望一步一步的建立，每建立一個步驟後雙方達成共識後再繼續下一個步驟，以下是依照業者需求按步驟完成。

    請幫他建立一套『菜單價目表』（enu）,
    請製作一個菜單項目 Item 再產生 Menu 物件陣列，並給予下列初值內容，再依照設計格式印出價目表）

    系統分析：
    首先我們針對菜單內項目做一個 Item 類別，在主類別內宣告一個以 Item 物件為元素的 Menu 陣列，
    並預留 100 個空間。其實 Menu 菜單是由後台輸入的，為了方便驗證系統的正確性，我們給予初值。
    系統將菜單初值(name[]、price[]、colary[]) 讀入後，再分項印出即可。

 */


class Item{
    int price;
    int calorie;
    String name;
}



public class TaipeiRestaurant_ObjectArray {

    static Item[] menu = new Item[100];  //還記得為什麼要加上 static 嗎? 仔細看! 我是宣告在 main 以外, 所以要成為全域變數(類別變數)一定要加上 static

    public static void main(String[] args) {
        
        
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

        //接下來一筆一筆讀進來，然後塞到陣列裡面
        for (int i=0; i<name.length; i++){
            menu[i] = new Item();
            menu[i].name = name[i];
            menu[i].calorie = calorie[i];
            menu[i].price = price[i];
        }

        System.out.printf("  菜單\t\t價格\t\t卡路里\n");

        for (int i=0; i<name.length; i++){
            System.out.printf("%s\t\t",menu[i].name);
            System.out.printf("%d\t\t",menu[i].price);
            System.out.printf("%s\t",menu[i].calorie);
            System.out.printf("\n");
        }
    }
}

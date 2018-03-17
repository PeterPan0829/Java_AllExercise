package Java_ArrayDataStructure;


/*
    紀錄股票最近三十天的收盤價格


    不同方法之間變數要互相引用時，必須將其宣告成『靜態or類別變數』（static variable）

 */
import java.util.Scanner;

public class RecordOneMonthStock {

    static double Stock[] = {95,44,12,55,36,76,75,
                             83,45,75,16,84,53,80,
                             73,95,39,22,11,42,77,
                             99,60,87,29,72,97,57,
                             87,59};


    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        double cost;
        int select;
        show_menu();
        select = keyin.nextInt();

        while (select != 3){
            switch (select){
                case 1:
                    show_stock();
                    break;

                case 2:
                    System.out.printf("請登錄當日收盤股價 =>");
                    cost = keyin.nextDouble();

                    //這個 for 迴圈單純做移位的動作，非常重要！
                    for (int i=(30-1); i>=1; i--){
                        Stock[i] = Stock[i-1];              //28塞給29
                    Stock[0] = cost;
                    break;

                    }
                default:
                    System.out.printf("輸入錯誤！請重新輸入");
            }
        }
        show_menu();
        select = keyin.nextInt();
    }

    static void show_menu() {
        System.out.println("== 歡迎光臨股票走勢分析系統 ==\n");
        System.out.println("(1) 印出 30 日歷史收盤價格");
        System.out.println("(2) 登入當日收盤價格");
        System.out.println("(3) 離開系統");
        System.out.printf("\n請輸入上述選項 ->");
    }

    static void show_stock(){
        System.out.println("印出 30 日歷史收盤價格\n");
        for (int i=0; i<Stock.length; i++){
            System.out.printf("%.2f", Stock[i]);
            if ((i+1) % 5 == 0){                         //列印五筆,換行
                System.out.printf("\n");
            }
            System.out.printf("\n");                    //列印完畢,換行
        }
    }
}

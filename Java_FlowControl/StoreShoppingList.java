package Java_FlowControl;

/*
    超商列印購物清單

    item1,2,3 分別代表三個品項
    sum1,2,3 代表三個品項的價格
    total 代表sum1,2,3 的總和


 */

import java.util.Scanner;

public class StoreShoppingList {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int item1, item2, item3;
        int total, sum1, sum2, sum3;

        System.out.printf("百事可樂(每瓶 15 元) 購買數量 =>");
        item1 = keyin.nextInt(); sum1 = item1 * 15;

        System.out.printf("國民便當(每盒 45 元) 購買數量 =>");
        item2 = keyin.nextInt(); sum2 = item2 * 45;

        System.out.printf("約翰走路(每瓶 312 元) 購買數量 =>");
        item3 = keyin.nextInt(); sum3 = item3 * 312;

        total = sum1 + sum2 + sum3;
        System.out.printf("\n *** 列印購物清單 ***\n");
        System.out.printf("------------------------------------------------------------------\n");
        System.out.printf("|\t 品名  \t|    單價   \t|    數量  \t|  小計 \t |\n");
        System.out.printf("------------------------------------------------------------------\n");
        System.out.printf("|   百事可樂\t|    15  \t|     %d  \t|   %d   |\n",item1,sum1);
        System.out.printf("|   國民便當\t|    45  \t|     %d  \t|   %d   |\n",item2,sum2);
        System.out.printf("|   約翰走路\t|   312  \t|     %d  \t|   %d   |\n",item3, sum3);
        System.out.printf("------------------------------------------------------------------\n");
        System.out.printf("|   總   計\t|   %d     \t               \t |\n",total);
        System.out.printf("------------------------------------------------------------------\n");
    }
}

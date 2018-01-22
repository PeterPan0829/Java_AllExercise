package Java_FlowControl;

import java.util.Scanner;


/*
    規劃客戶資料

    變數以直觀的命名方式
 */

public class PlanCustomerData {
    public static void main(String[] args) {
        String name;
        String address;
        int age,sex;
        float height, weight;

        Scanner keyin = new Scanner(System.in);

        System.out.printf("請輸入客戶姓名 =>");
        name = keyin.nextLine();

        System.out.printf("請輸入客戶性別 : 男(0),女(1) =>");
        sex = keyin.nextInt();

        System.out.printf("請輸入客戶年齡 =>");
        age = keyin.nextInt();

        System.out.printf("請輸入客戶身高 =>");
        height = keyin.nextFloat();

        System.out.printf("請輸入客戶體重 =>");
        weight = keyin.nextFloat();

        System.out.printf("請輸入客戶地址 =>\n");
        address = keyin.nextLine();

        System.out.printf("\n列印客戶資料如下：\n");
        System.out.printf("客戶姓名 = %s\n",name);
        System.out.printf("性別 = %d 男(0),女(1)\n",sex);
        System.out.printf("年齡 = %d\n",age);
        System.out.printf("身高 = %f\n",height);
        System.out.printf("體重 = %f\n",weight);
        System.out.printf("地址 = %s\n",address);
    }
}

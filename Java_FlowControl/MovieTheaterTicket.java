package Java_FlowControl;

/*
    電影院售票系統

 */


import java.util.Scanner;

public class MovieTheaterTicket {

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        int Adult,Children,Seniors; // 三種票用輸入的方式
        int A=250, C=200, S=150; // 三種票的價錢
        int handre, fifty = 0, ten = 0, five, one; //找錢

        int value, value1; // value要找給客戶的錢, value1是找錢過程累加的變數

        int CustomerPrice; // 客戶繳納金額

        System.out.printf("購買成人票張數 (250元) =>");
        Adult = keyin.nextInt();

        System.out.printf("購買兒童票張數 (200元) =>");
        Children = keyin.nextInt();

        System.out.printf("購買老人票張數 (150元) =>");
        Seniors = keyin.nextInt();

        System.out.print("\n請輸入顧客繳納金額 =>\n");
        CustomerPrice = keyin.nextInt();

        System.out.printf("成人票 %d 兒童票 %d 老人票 %d",Adult,Children,Seniors);

        int TicketTotalPrice = (Adult*A) + (Children*C) + (Seniors*S); //三種票總計的價格

        if (CustomerPrice > TicketTotalPrice){
            value = CustomerPrice - TicketTotalPrice;
            value1 = value;
            handre = value / 100;
            value = value - handre * 100;
            five = value/5;
            value = value - five * 5;
            one = value;

            System.out.printf("\n總計: %d 您繳納金額: %d ",TicketTotalPrice,CustomerPrice);
            System.out.printf("\n應找金額 = %d 找零錢數量如下\n",value1);
            System.out.printf("100塊紙鈔 = %d 張\n",handre);
            System.out.printf("50元硬幣 = %d 個\n",fifty);
            System.out.printf("10元硬幣 = %d 個\n",ten);
            System.out.printf("5元硬幣 = %d 個\n",five);
            System.out.printf("1元硬幣 = %d 個\n",one);

        } else {
            System.out.printf("總計: %d 您繳納金額為: %d\n",TicketTotalPrice,CustomerPrice);
            System.out.printf("金額不足，請跟蔡英文喊加薪下次再來～");
        }
    }
}

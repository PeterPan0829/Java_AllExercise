package Java_FlowControl;

/*
    停車場收費系統，計算方式為 0.5 小時內不計費，
    2 小時內為 50 元，超過 2 小時後，每一小時 20 元計算，
    不足1 小時以 1 小時計算。

    如果3小時 = 70
    如果2.6小時 = 70

 */


import java.util.Scanner;

public class ParkingCost {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        double hours;
        int cost;

        System.out.printf("請輸入停車時間(小時) =>");
        hours = keyin.nextDouble();

        if (hours <0.5){
            System.out.printf("\n不足半小時不收費!!\n");
        } else if (hours < 2 ){
            System.out.printf("\n2小時以內皆為50元!!\n");
        } else if (hours > 2){
            cost = 50 + (int) ((hours - 2) / 1) * 20;
            System.out.printf("費用為 = %d",cost);
        }
    }
}

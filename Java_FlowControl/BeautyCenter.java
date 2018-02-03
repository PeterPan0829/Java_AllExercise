package Java_FlowControl;

import java.util.Scanner;

public class BeautyCenter {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        int money;
        double height, weight, bmi;


        System.out.printf("請輸入身高 =>");
        height = keyin.nextDouble();

        System.out.printf("\n請輸入體重 =>");
        weight = keyin.nextDouble();

        bmi = weight / (height * height); //計算 BMI 的公式

        if (bmi < 18.5){

            System.out.printf("你身材太瘦過輕, 增重吧！\n");
        }
        else if (bmi > 18.5 && bmi < 24){
            System.out.printf("你身材為理想體重");
        }
        else if (bmi > 23.0 && bmi < 24.9 ) {
            money = (int)(( bmi - 0 ) / 0.5) * 10000;
            System.out.printf("\n屬於過重（輕度增加）,需花費 %d 萬元打造夢想身材喲～",money);
        }
        else if (bmi > 25.0 && bmi < 29.9){
            money = (int)(( bmi - 0 ) / 0.5) * 10000;
            System.out.printf("\n屬於第一度肥胖（中度增加）,需花費 %d 萬元打造夢想身材喲～",money);
        }
        else if (bmi > 30.0 && bmi < 34.9){
            money = (int)(( bmi - 0 ) / 0.5) * 10000;
            System.out.printf("\n屬於第二度肥胖（重度增加）,需花費 %d 萬元打造夢想身材喲～",money);
        }
        else  {
            money = (int)(( bmi - 0 ) / 0.5) * 10000;
            System.out.printf("\n屬於第三度肥胖（病態肥胖）,需花費 %d 萬元打造夢想身材喲～",money);
        }
    }
}

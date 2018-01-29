package Java_FlowControl;


/*
    BMI（體重（kg）/身高2（m））
    正常值為 18 ~ 24；低於 18 則太瘦，高於 24 則太胖。
    系統會要求輸入體重與身高，則輸出印出 BMI 值，並告知太胖、太瘦或標準體材。

 */


import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        double height, weight, bmi;
        final double normal = 18.0, overheight = 24.0;

        System.out.printf("== 歡迎使用 BMI 評估系統(18 ~ 24) ==\n");

        System.out.printf("請輸入客戶身高(公分) =>");
        height = keyin.nextDouble() / 100; //因為是用 m 不是 cm, 要/100

        System.out.printf("請輸入客戶體重(公斤) =>");
        weight = keyin.nextDouble();

        bmi = weight / (height * height); //計算 BMI 的公式

        System.out.printf("\n您的 BMI 值為：%.4f\n",bmi);

        if (bmi <= normal){
            System.out.printf("太瘦了！增重點會更健康！！\n");
        } else if (bmi >= overheight){
            System.out.printf("快要跟小恩一樣肥胖了啊！！快減肥！！！\n");
        } else {
            System.out.printf("身材很棒, 繼續維持唷！！\n");
        }

        System.out.printf("\n== BMI 系統結束 ==");








    }
}

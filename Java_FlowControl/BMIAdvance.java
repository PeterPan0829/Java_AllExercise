package Java_FlowControl;


/*
    和 BMI 類似的練習, 不過這個進階系統會給客戶回饋增重、減重的具體公斤數

    公式如下：

    (1) 太胖（BMI > 24）：減重量 = 原體重 – 24*身高*身高；
    (2) 太瘦（BMI < 18）：增重量= 18*身高*身高 – 原體重；

 */



import java.util.Scanner;

public class BMIAdvance {
    public static void main(String[] args) {
            Scanner keyin = new Scanner(System.in);
            double height, weight, bmi;
            double AddWeight, LoseWeight;
            final double normal = 18.0, overheight = 24.0;

            System.out.printf("== 歡迎使用 BMI 評估系統(18 ~ 24) ==\n");

            System.out.printf("請輸入客戶身高(公分) =>");
            height = keyin.nextDouble() / 100; //因為是用 m 不是 cm, 要/100

            System.out.printf("請輸入客戶體重(公斤) =>");
            weight = keyin.nextDouble();

            bmi = weight / (height * height); //計算 BMI 的公式

            System.out.printf("\n您的 BMI 值為：%.4f\n",bmi);

            if (bmi <= normal){
                AddWeight = 18 * height * height - weight;
                System.out.printf("太瘦了！建議增重 %.1f 公斤！！\n",AddWeight);

            } else if (bmi >= overheight){
                LoseWeight = weight - 24 * height * height;
                System.out.printf("快要跟小恩一樣肥胖了啊！建議減重 %.1f 公斤！！！\n",LoseWeight);

            } else {
                System.out.printf("身材很棒, 繼續維持唷！！\n");
            }

            System.out.printf("\n== BMI 系統結束 ==");

    }
}

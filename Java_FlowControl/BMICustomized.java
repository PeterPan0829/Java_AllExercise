package Java_FlowControl;

/*
    利用 BMI 判別身材還是有缺點，男女身材標準本來就有所差異，利用相同的公式計算並不合理。
    簡單計算方法如下：男生標準體重 ＝ （身高 - 80）*0.7； 女生標準體重 = （身高 - 70）*0.6。
    製作一套工具，可以輸入客戶性別、身高、體重，再輸出體重是否合乎標準，以及應該減少或增加多少體重。
 */

import java.util.Scanner;

public class BMICustomized {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        String sex;
        double normal = 0, height, weight;  //normal 正常標準體重

        System.out.printf("請輸入性別（男/女）=>");
        sex = keyin.next();

        System.out.printf("\n請輸入身高（cm）=>");
        height = keyin.nextDouble();

        System.out.printf("請輸入體重（kg）=>");
        weight = keyin.nextDouble();

        if (sex.equals("男")) {
            normal = (height - 80) * 0.7;   //正常男生的標準
        } if (weight < normal){
            System.out.printf("你過輕, 應該增重 %.2f公斤\n",normal-weight);
        }
        else if (weight > normal){
            System.out.printf("你過重, 應該減肥 %.2f公斤\n",weight-normal);
        }


        if (sex.equals("女")) {
            normal = (height - 70) * 0.6;   //正常女生的標準
        } if (weight < normal){
            System.out.printf("你過輕, 應該增重 %.2f公斤\n",normal-weight);
        }
        else if (weight > normal){
            System.out.printf("你過重, 應該減肥 %.2f公斤\n",weight-normal);
        }
        else {
            System.out.printf("你的體重符合標準!!\n");
        }
    }
}
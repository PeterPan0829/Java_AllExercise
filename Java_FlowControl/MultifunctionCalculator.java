package Java_FlowControl;

/*
    運用 Switch_Case 做一個多功能計算機
 */


import java.util.Scanner;

public class MultifunctionCalculator {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        float num1, num2, result=0F;
        String st;
        char oper;

        System.out.printf("======= 歡迎使用多功能 ( + - x / ) 計算機 =======\n");
        System.out.printf("\n請輸入 ＥＸ:99 + 29（切記數學運算子和數字之間要有空白區隔）=>\n");

        num1 = keyin.nextFloat();   //輸入的第一個數字
        st = keyin.next();          //輸入第一個數字後的空白
        oper = st.charAt(0);        //輸入數學運算子
        num2 = keyin.nextFloat();   //輸入的第二個數字

        switch (oper){
            case '+' :
                result = num1 + num2;
                break;

            case '-' :
                result = num1 - num2;
                break;

            case '*' :
                result = num1 * num2;
                break;

            case '/' :
                result = num1 / num2;
                break;

            default :
                System.out.printf("輸入錯誤唷\n");
        }
        System.out.printf("%.2f %s %.2f = %.2f\n",num1,oper,num2,result);
    }
}

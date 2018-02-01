package Java_FlowControl;

/*

    數字轉換國字系統

 */



import java.util.Scanner;

public class NumberTransformChinese {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        int num;
        String Chinese = "錯誤唷！";

        System.out.printf("== 歡迎使用數字轉換國字系統 ==\n");
        System.out.printf("請輸入一個整數數字（Ex:3、6）=>");
        num = keyin.nextInt();

        switch (num){
            case 1 :
                Chinese = "壹";
                break;

            case 2 :
                Chinese = "貳";
                break;

            case 3 :
                Chinese = "參";
                break;

            case 4 :
                Chinese = "肆";
                break;

            case 5 :
                Chinese = "伍";
                break;

            case 6 :
                Chinese = "陸";
                break;

            case 7 :
                Chinese = "柒";
                break;

            case 8 :
                Chinese = "捌";
                break;

            case 9 :
                Chinese = "玖";
                break;

            case 10 :
                Chinese = "拾";
                break;

            case 0 :
                Chinese = "零";
                break;
                
                
                default:
                    System.out.printf("輸入錯誤唷！\n");

        }

        System.out.printf("\n %d => %s ",num,Chinese);
        
    }
}

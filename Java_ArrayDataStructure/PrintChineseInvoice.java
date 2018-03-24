package Java_ArrayDataStructure;
/*
    本範例較困難的地方是數字轉換國字後，如何寫入適當的位置。
    我們設定一個範圍，比較容易設計列印格式，因此假設捐款最高為 9 千萬餘元（99999999，超過則另開收據）
    另外，我們可以利用整數相除得到某一位數（百位、十位、個位），再利用餘數運算，得到取出某一位數後的剩餘值；
    另選一個陣列（int num[]）存放每一位數的數字，仟 佰 拾 萬 仟 佰 拾 元。
    讀取輸入捐款金額後（value），除以 1 千萬（10000000）得到千萬位的數字，
    再利用相同的數經過餘數運算，則扣除千萬位數，得到百萬以下的數值，依此類推則可得到相對位數的數字，並依序存入 num[] 陣列內。
    同時，選用 chinese[] 陣列存放每種數字的相對應國字，chinese[0] 存『零』（0）、chinese[1] 存『壹』（1）...等依此類推。
 */

import java.util.Scanner;

public class PrintChineseInvoice {
    public static void main(String[] args) {
        String name;                                                                          //捐款姓名
        int value;                                                                            //讀取捐款額
        
        Scanner keyin = new Scanner(System.in);
        System.out.printf("請先生小姐輸入您的姓名 =>");
        name = keyin.nextLine();
    
        System.out.printf("請輸入捐款金額 =>");
        value = keyin.nextInt();
        
        int value1 = value;                                                                   //備份捐款額
        
        String chinese[] = {"零","壹","貳","參","肆","伍","陸","柒","捌","玖"};               //宣告國字數字陣列
        String doll[] = {"仟","佰","拾", "萬", "仟", "佰", "拾" ,"元"};                       //宣告列印格式陣列
        int num[] = new int[9];                                                               //宣告位數數字陣列 0~8
        long base = 10000000;                                                                 //宣告最高數字變數 一千萬

        //取出各個位數的數字(最高8位數)
        for (int i=0; i<8; i++){
            num[i] = (int) (value / base);
            value = (int) (value % base);
            base = base/10;
        }
    
        System.out.printf("\n*******老德記遊民收容所 捐款收據如下*******\n");
    
        System.out.printf("\n感謝 %s 先生/小姐贊助捐款",name);
        System.out.printf("\n本次捐款為 %d 元",value1);
        
        System.out.printf("\n總計 = ");
        for (int i=0; i<8; i++){
            System.out.printf("%s%s ", chinese[num[i]],doll[i]);                              //印出 chinese 陣列中的 num[i]
        }                                                                                    //也可以解讀是 印出chinese 陣列中的 num[多少多少]
        System.out.printf("整");
    }
}

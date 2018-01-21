
        import java.io.*;
        import java.util.Scanner;

public class CashDesk {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
            //這段意思就像是 int total =0;  int item = 0;
            int total = 1, item = 0;

            System.out.printf("小北百貨收銀機 = %d\n", total);
            System.out.printf("請輸入商品金額 => ");

            item = keyin.nextInt();
            total = total + item;

            System.out.printf("\t目前累積金額為 =%d\n", total);
            System.out.printf("請輸入商品金額 => ");

            keyin.close();
        }
    }



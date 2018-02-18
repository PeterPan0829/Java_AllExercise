package Java_FlowControl;

/*
    運用 break 尋找 100 以內的質數
    質數：大於1的自然數中，除了1和1本身之外無法被其他自然數整除的數
    例如 2 只能被 1 和 2 整除所以是質數，3 5 7 也是～
 */
public class PrimeNumber {
    public static void main(String[] args) {
        final int ilimit = 100;                                 //設定要尋找的最高質數
        int prime;                                              //質數
        int i = 1;
        int count = 0;
        System.out.printf("列印出 1~100 之間的質數如下：\n");

        while (i<=ilimit){
            prime = 1;
            int j = 2;
            while (j<=i-1){
                if ((i%j)==0){                                  //判斷是否可以整除
                    prime = 0;
                    break;
                }j++;
            }
            if (prime == 1){
                System.out.printf("%d ",i);
                count = count +1;
                if (count%10 ==0){                              //每 10 個數換行
                    System.out.println();
                }
            }i++;
        }
    }
}

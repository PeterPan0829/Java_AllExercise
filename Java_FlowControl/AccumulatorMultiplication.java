package Java_FlowControl;

/*
    其實，連續累乘與累加非常相同，都是利用一個累加器 Accumulator，連續累積或累乘進入；
    兩者之間最大不同是，累加程式的累加器初始值必須設定為 0（sum = 0）；
    累乘的累加器必須設定為 1（total = 1），否則任何數與 0 相乘結果都是 0。
 */

public class AccumulatorMultiplication {
    public static void main(String[] args) {

        int total = 1, count;

        for (count=1; count<=10; count++ ){
            total = total * count;
            System.out.printf("total*1 = %d \n",total);
        }
    }
}

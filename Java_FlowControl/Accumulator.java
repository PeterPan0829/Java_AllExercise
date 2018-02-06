package Java_FlowControl;

/*
    連續累加程式

 */

public class Accumulator {
    public static void main(String[] args) {
        int sum = 0, count;

        for (count=1; count <=10; count=count+1){
            sum = sum + count;
        }
        System.out.printf("1 + 2 + .. + 10 = %d",sum);
    }
}

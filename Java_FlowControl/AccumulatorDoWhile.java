package Java_FlowControl;

public class AccumulatorDoWhile {
    public static void main(String[] args) {
        int sum = 0, limit=100, count;
        count = limit;

        do {
            sum = sum + count;
            count = count - 1;

        }while (count > 0);
        System.out.printf("\n%d + 99 + 98 ..... + 1 = %d",limit,sum);
    }
}


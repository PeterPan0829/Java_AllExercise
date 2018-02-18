package Java_FlowControl;

/*
    九九乘法表_for雙重迴圈
 */

public class Multiplication_NestLoop {
    public static void main(String[] args) {


        for (int i=2; i<=9; i++){
            for (int j=1; j<=9; j++){
                System.out.printf("%d * %d = %d\t",i,j,j*i);
            }
            System.out.println();
        }
    }
}

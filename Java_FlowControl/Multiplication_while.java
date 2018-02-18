package Java_FlowControl;

/*
    while 雙重迴圈列印九九乘法表
 */


public class Multiplication_while {
    public static void main(String[] args) {
        int i=2;
        while (i<=9){
            int j = 1;
            while (j<=9){
                System.out.printf("%d * %d = %d\t",i,j,i*j);
                j++;
            }
            i++;
            System.out.println();
        }
    }
}



import java.io.*;
import java.util.Scanner;

public class CountCircle {
    public static void main(String[] args) throws IOException {
        Scanner key = new Scanner(System.in);
        try {

            final double Pi = 3.14;
            double radius, area, circum, volume;

            System.out.printf("圓參數計算工具\n");
            System.out.printf("請輸入圓的半徑 =>");

            radius = key.nextDouble();
            area = Pi * radius * radius;
            circum = 2 * Pi * radius;
            volume = 3.0 / 4.0 * Pi * radius * radius * radius;

            System.out.printf("圓半徑 = %2f 的相關參數如下：\n", radius);
            System.out.printf("圓周長 = %2f\n", circum);
            System.out.printf("圓面積 = %2f\n", area);
            System.out.printf("圓體積 = %2f\n", volume);
        } finally {
            key.close();
        }
    }

}


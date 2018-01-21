

import java.util.Scanner;

public class DiceCompare {
  public static void main(String a[]){
      Scanner keyin = new Scanner(System.in);
      int east, west, south, north;
      int max;

      System.out.printf("請輸入 東方 所擲數目（3~18）=>\n");
      System.out.printf("請輸入 西方 所擲數目（3~18）=>\n");
      System.out.printf("請輸入 南方 所擲數目（3~18）=>\n");
      System.out.printf("請輸入 北方 所擲數目（3~18）=>\n");

      east=keyin.nextInt();
      west=keyin.nextInt();
      south=keyin.nextInt();
      north=keyin.nextInt();

      max = Math.max(Math.max(west,south),Math.max(north,east));

      System.out.printf("最大數目為：%d\n",max);




  }
}

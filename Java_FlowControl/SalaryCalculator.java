package Java_FlowControl;

import java.util.Scanner;

/*
    薪資計算系統

    變數有名稱、薪資、加班時數、加班費、當月薪資
    輸入部分用 Scanner 方式 keyin

    if 當中如果遇上薪資、加班時數不符合規定,政府強制公司要付基本薪資（希望他媽的台灣有天能做到r 耖！）
 */

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        String name;
        int salary, overtimehours, overtimepay, monthpay;

        System.out.printf("請輸入員工姓名 => ");
        name = keyin.nextLine();

        System.out.printf("請輸入底薪 => ");
        salary = keyin.nextInt();
        if (salary < 36790){
            salary = 36790;
        }

        System.out.printf("請輸入加班時數 => ");
        overtimehours = keyin.nextInt();
        if (overtimehours > 5){
            overtimehours = 5;
        }


        overtimepay = (int)((double)salary / (30 * 8) * 1.333 * overtimehours ); // 30天 * 8h
        monthpay = salary + overtimepay;

        System.out.printf("\n列印員工薪資如下 : \n");
        System.out.printf("員工姓名 = %s \n",name);
        System.out.printf("底薪 = %d \n",salary);
        System.out.printf("加班費 = %d \n",overtimepay);
        System.out.printf("本月薪資 = %d \n",monthpay);
    }
}

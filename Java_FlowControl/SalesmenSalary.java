package Java_FlowControl;


/*
    一般銷售人員除了基本薪資（16500 元）外，
    大多採用銷售額來計算獎金多寡，每月銷售金額 10 萬元以內不給予將金，
    超過 10 萬元，給予 5000 元獎金，以後每增加 5 萬元，給予 5000 元獎金。
    系統要求某一員工的銷售額後，計算並輸出該月的薪資多寡。


 */
import java.util.Scanner;

public class SalesmenSalary {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        String name;                        //名字

        final int salary = 16500;
        int bonus = 0, sales = 0;           //獎金、銷售額
        int total = salary + bonus + sales; //本月總薪資

        System.out.printf("請輸入業務員姓名 =>");
        name = keyin.nextLine();

        System.out.printf("請輸入業務員銷售金額(萬元) =>");
        sales = keyin.nextInt();

        if (sales < 10){
            System.out.printf("\n列印員工薪資如下:");
            System.out.printf("\n員工姓名 = %s",name);
            System.out.printf("\n底薪 = %s",salary);
            System.out.printf("\n獎金 = %d",bonus);
            System.out.printf("\n本月薪資 = %d",total);
        } else if (sales > 10){

            bonus = 5000;
            

            System.out.printf("\n列印員工薪資如下:");
            System.out.printf("\n員工姓名 = %s",name);
            System.out.printf("\n底薪 = %s",salary);
            System.out.printf("\n獎金 = %d",bonus);
            System.out.printf("\n本月薪資 = %d",total);


        }


//            列印員工薪資如下:
//
//                    員工姓名 = 張先生
//
//        底薪 = 16500
//
//        獎金 = 0
//
//        本月薪資 = 16500

    }
}

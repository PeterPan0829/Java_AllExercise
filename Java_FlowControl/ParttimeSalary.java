package Java_FlowControl;

/*
    許多 PT 員工都是用時薪來計算薪資，

    每個月工作時數 160 小時(每周 40 小時)內以基本時薪（105元/小時）計算； 161 ~ 205 小時，時薪的 1.5 倍計算，
    超過 205 小時的工作時間違反勞基法，直接給你十萬，並且讓你老闆進去蹲到死。
 */



import java.util.Scanner;

public class ParttimeSalary {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        int salary, overtimepay = 0, hours, totalsalary, bonus, PTsalary = 105;


        System.out.printf("請輸入該月工作時數 =>");
        hours = keyin.nextInt();


        if (hours <= 160){
            //105 是 一小時的時薪
            salary = hours * 105;

            System.out.printf("\n本月基本薪資如下：");
            System.out.printf("\n薪資：%d",salary);
            System.out.printf("\n加班費：%d",overtimepay);
            System.out.printf("\n總共薪資：%d",salary);
        }

        else if (hours > 160 && hours < 205){
            salary = hours * 105;
            System.out.printf("\n本月基本薪資如下：");
            System.out.printf("\n薪資：%d\n",salary);

            //超過160小時 時薪 / (總時數 * 1.5)（倍)
            overtimepay = (int) ((PTsalary - 160 ) / (hours * 1.5));
            System.out.printf("\n加班費：%d",overtimepay);

            totalsalary = salary + overtimepay;
            System.out.printf("\n總共薪資：%d",totalsalary);
        }

            else if (hours >= 205){

            bonus = 100000;
            System.out.printf("\n恭喜！你老闆被關了");
            System.out.printf("\n薪資+獎金 = %d",bonus);
        }
    }
}

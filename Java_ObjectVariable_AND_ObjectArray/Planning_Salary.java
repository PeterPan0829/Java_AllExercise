package Java_ObjectVariable_AND_ObjectArray;

/*
    規劃員工薪資資料（可以搭配我們在 wiki 的學習講義 - 19_物件的傳統運用當中的19-1_規劃員工薪資資料）


    『志明電器公司』希望建立電子化企業管理系統，人事部門所需的薪資管理子系統，
    需要規劃員工薪資資料，其中包含有：員工代號、姓名、部門、底薪與職務加級。
    我們需要設計相關資料型態，並測試輸入/輸出結果，

    期望操作介面如下：
    
    ***** 輸入員工資料 *****
    輸入員工姓名 =>張大名
    輸入員工所屬部門 =>資訊部
    輸入員工代號 =>430
    輸入員工底薪 =>25000
    輸入薪資加級 =>12000

    ***** 印出員工資料 *****
    員工代號 = 430
    員工姓名 = 張大名
    所屬部門 = 資訊部
    底    薪 = 25000
    職務加級 = 12000
    
 */

import java.util.Scanner;

class Employee{
    int ID;                         //員工代號（Key）
    String name;                    //員工姓名
    String department;              //部門
    int payment;                    //底薪
    int duty;                       //職務加給
}

public class Planning_Salary {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        /*　產生物件變數　Object Variable */
        Employee emp = new Employee();          //這裡很重要唷！意思是在 Planning_Salary 的 class 當中可以 "呼叫產生" Employee 這個物件變數。白話就是，我宣告產生一個 Employee 的物件名字叫做 emp 同時利用 Employee 這個類別 new 產生物件放到 emp 裡面，所以就能使用 Employee() 這個class 當中的方法成員或物件成員！！看到 "=" 先看等號的右邊！！
        System.out.printf("***** 輸入員工資料 *****\n");
        System.out.printf("輸入員工姓名 =>");
        emp.name = keyin.nextLine();
        System.out.printf("輸入員工所屬部門 =>");
        emp.department = keyin.nextLine();
        System.out.printf("輸入員工代號 =>");
        emp.ID = keyin.nextInt();
        System.out.printf("輸入員工底薪 =>");
        emp.payment = keyin.nextInt();
        System.out.printf("輸入職務薪資加給 =>");
        emp.duty = keyin.nextInt();

        System.out.printf("\n***** 印出員工資料 *****\n");
        System.out.printf("員工代號 = %d\n",emp.ID);
        System.out.printf("員工姓名 = %s\n", emp.name);
        System.out.printf("所屬部門 = %s\n", emp.department);
        System.out.printf("底    薪 = %d\n", emp.payment);
        System.out.printf("職務加級 = %d\n", emp.duty);
    }

    
}

package Java_ObjectVariable_AND_ObjectArray;

/*
    薪資扣繳所得稅（引用現有類別-Employee.class）

    Ps. Employee.class 類別可與其他程式共用。（可以搭配我們在 wiki 的學習講義 - 19_物件的傳統運用當中的19-2_薪資扣繳所得稅）

    『志明電器公司』會計部門需要幫每位同仁預扣所得稅，稅額是總領薪資的 10%，製作一套薪資扣繳所得稅系統，期望操作介面如下：

    ***** 列印員工稅額 *****
    員工代號= 43210 姓名= 張大名 部門= 製造部 薪資= 65000 預扣稅額= 6500

    製作技巧研討：
    利用原來薪資管理系統 class Planning_Salary 所建立的 Employee.class 類別，再來製作薪資扣繳所得稅系統。
    於同一電子化企業系統內，使用相同型態的物件變數，資料較能保持一致性，但類別檔案必須存放於相同目錄下，否則必須用 import 導入。
 */


public class SalaryWithholding_IncomeTax {
    public static void main(String[] args) {
        int tax;                                //所得稅

        /* new 產生物件變數 */
        Employee emp = new Employee();
        emp.name = "渴蚊摺";
        emp.department = "製造部";
        emp.ID = 43210;
        emp.payment = 50000;
        emp.duty = 15000;

        System.out.printf("\n***** 列印員工稅額 *****\n");
        System.out.printf("員工代號 => %d\n", emp.ID);
        System.out.printf("姓名 => %s\n", emp.name);
        System.out.printf("部門 => %s\n", emp.department);
        System.out.printf("薪資 => %d\n", emp.payment+emp.duty);
        tax = (int)((emp.payment+emp.duty)*0.1);                //稅額是總領薪資的 10% 所以 *0.1，會有小數點所以就強制轉型為整數int
        System.out.printf("\n預扣稅額 => %d\n", tax);
    }
}

package Java_ObjectVariable_AND_ObjectArray;

/*
    簡單薪資管理系統（運用物件陣列）_（可以搭配我們在 wiki 的學習講義 - 20_物件陣列的運用當中的20_2簡單薪資管理系統（運用物件陣列））

    請幫志明電器公司建立一套薪資管理系統，允許輸入多筆員工資料（員工代號、姓名、服務部門、底薪與職務加級），
    並印出員工薪資表，包含有：員工代號、姓名、服務部門、薪資總額、扣繳稅額（= 總額 * 0.1）與應領金額（= 薪資總額 – 扣繳稅額）。

    製作技巧研討：
    首先必須設計員工薪資各種屬性的資料型態，並將其宣告成類別（class Employee {…}），經過編譯後會產生一個獨立的中介碼（Employee.class）。
    再利用此類別宣告產生物件陣列（worker[]），期望員工資料儲存每一行表示一筆員工資料，各個欄位表示所描述員工的屬性，但並非二維陣列的元素，而是描述員工物件的變數成員。

    假設系統最高可以儲存 20 筆員工資料，又系統可選擇連續輸入多筆資料，
    因此我們必須利用 while 迴圈判斷是否超過界線，或繼續輸入資料；另外利用 k 變數紀錄目儲存了幾筆資料，
    或願意繼續輸入資料的話，則再產生一個物件變數填入 k 所指的陣列元素上（worker[k] = new Employee();）。
    輸入完畢後，再依照 k 所紀錄的資料數量，分別計算薪資總額（= 底薪 + 職務加級）、扣繳稅額（= 薪資總額 * 0.1）與應領薪資（= 薪資總額 – 扣繳稅額），並輸出到螢幕上。

    期望操作介面如下：

    是否繼續輸入員工資料 (yes/no) =>yes
    ***** 輸入員工資料 *****
    輸入員工姓名 =>羅大仙
    輸入所屬部門 =>製造課
    輸入員工代號 =>720
    輸入員工底薪 =>50000
    輸入薪資加級 =>12000
    是否繼續輸入員工資料 (yes/no) =>yes

    ***** 輸入員工資料 *****
    輸入員工姓名 =>張真人
    輸入所屬部門 =>業務課
    輸入員工代號 =>610
    輸入員工底薪 =>70000
    輸入薪資加級 =>12000
    是否繼續輸入員工資料 (yes/no) =>no

    ***** 印出員工薪資表 *****
    員工資料               薪資總額        預扣稅額        應領薪資
    羅大仙 (720 製造課)      62000         6200            55800
    張真人 (610 業務課)      82000         8200            73800
 */

import java.util.Scanner;

class Employee_Member{              //員工資料類別
    int ID;                         //員工代號
    String name;                    //員工姓名
    String department;              //員工部門
    int payment;                    //員工底薪
    int duty;                       //員工職務加給
}

public class Planning_Salary_ObjectArray {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Employee_Member[] worker;           //宣告一個 Employee 物件叫做 worker
        worker = new Employee_Member[20];   //幫 worker 預留二十個空間 0 ~ 19
        int value, tax, k=0;                //『int k=0;』。利用變數 k 紀錄目前資料的比數有多寡；宣告時給予初始值 0。
        String sel, temp;

        System.out.printf("是否繼續輸入員工資料 (yes/No) =>");
        sel = keyin.nextLine();

        while (sel.equals("yes") && (k<20)) {       //這裡很特別的用法之前沒用過，&& 大家可以去翻一下筆記或是谷哥大神。意思是當輸入 yes 和　k<20 兩個條件都滿足才做接下來的事情。
            worker[k] = new Employee_Member();      //new Employee_Member(); 這個物件然後把它放到 worker物件陣列的[k] 當中
            System.out.printf("***** 輸入員工資料 *****\n");
            System.out.printf("輸入員工姓名 =>");
            worker[k].name = keyin.nextLine();
            System.out.printf("輸入所屬部門 =>");
            worker[k].department = keyin.nextLine();
            System.out.printf("輸入員工代號 =>");
            worker[k].ID = keyin.nextInt();
            System.out.printf("輸入員工底薪 =>");
            worker[k].payment = keyin.nextInt();
            System.out.printf("輸入薪資加級 =>");
            worker[k].duty = keyin.nextInt();
            keyin.nextLine();

            System.out.printf("是否繼續輸入員工資料 (yes/No) =>");
            sel = keyin.nextLine();
            k = k+1;
        }

        System.out.printf("    ***** 印出員工薪資表 *****\n");
        System.out.printf(" 員工資料\t\t\t\t\t薪資總額\t\t預扣稅額\t\t應領薪資\n");
        for (int i=0; i<k; i++){            // k 有多筆資料要一筆一筆印出來!!
            System.out.printf(" %s ",worker[i].name);
            System.out.printf("(%d ",worker[i].ID);
            System.out.printf("%s)\t",worker[i].department);
            value = worker[i].payment + worker[i].duty;     //應領薪資
            System.out.printf("    %d\t\t",value);
            tax = (int)(value * 0.1);                       //稅金(取整數)
            System.out.printf("%d\t\t",tax);
            value = value - tax;                            //實際領到的薪資
            System.out.printf("%d\n",value);
        }
    }
}

/*
    &&(Short-circuit AND)：也是一個二位元的運算符號。因為AND的特
    性只要1個運算元為False，整個式子就為假，因此&&(Short-circuit AND)
    的運算就是，假如第一個運算元的資料已經為False了，它就不會再判別第
    二個運算元資料，直接輸出False。
 */
package Java_ObjectVariable_AND_ObjectArray;

/*
    擴充 SignUpEmployee_ObjectArray 程式功能。
    請幫公司建立一套人事管理系統，該系統允許輸入員工資料並儲存於資料檔案內（Human.data）。
    當輸入完畢之後，再由檔案內讀出並顯示螢幕上，觀察資料是否建立正確。
    假設登錄員工資料包含有：員工代號（int）、姓名（String）、工作部門（String）、底薪（int）、職務加級（int）；

    期望操作介面，以及檔案輸出結果如下：
    是否繼續輸入員工資料 (yes/no) =>yes
    ***** 輸入員工資料 *****
    輸入員工姓名 =>張志明
    輸入所屬部門 =>製造課
    輸入員工代號 =>71209
    輸入員工底薪 =>40000
    輸入薪資加級 =>15000

    是否繼續輸入員工資料 (yes/no) =>yes
    是否繼續輸入員工資料 (yes/no) =>no
    ** 將資料輸出到 Human.dada 檔案內 **

    ***** 輸出完畢 ****

    == 由 Human.data 讀取並顯示 ==
    代號    姓名    部門    底薪    加級
    71209   張志明  製造課  40000   15000
    71210   羅大仙  製造課  43000   16800
    71214   陳名郎  生管課  28000   12000
    71219   蔡中心  倉管課  32000   17000
    71242   劉新明  行銷課  28000   15000
    == Human.data 輸入完畢 ==
 */

import java.io.*;
import java.util.Scanner;

public class BuiltEmployeeSalary_ObjectArray {
    public static void main(String[] args) throws IOException {                         //如果有錯誤就把錯誤訊息丟到 IOEception底下
        Scanner keyin = new Scanner(System.in);
        Employee_1[] worker = new Employee_1[20];

        /* 宣告輸出檔案物件 */
        String file = "Human.data";                                                     //宣告產生一個緩衝器型的輸出檔案物件，指定該檔案名稱為 Human.data
        BufferedWriter data = new BufferedWriter(new FileWriter(file, true));    //宣告一個BufferWriter的物件叫做 data, 然後產生FileWriter把file丟進去。
        int k = 0;                                                                      //讀取幾筆資料我們用一個變數，而且是一個全域變數要讓任何物件、方法都可以使用它
        String select;                                                                  //宣告一個 select 去做選擇 yse/no

        /* 讀入資料並存入物件陣列內 */
        System.out.printf("是否繼續輸入員工資料(yes/no) =>");
        select = keyin.nextLine();
        while (select.equals("yes") && (k<20)){                                         //如果輸入 yes 而且 k<20兩個條件都達成就可以寫入
            worker[k] = new Employee_1();
            System.out.printf("*****輸入員工資料*****\n");
            System.out.printf("輸入員工姓名 =>");
            worker[k].name = keyin.nextLine();
            System.out.printf("輸入所屬部門 =>");
            worker[k].department = keyin.nextLine();
            System.out.printf("輸入員工代號 =>");
            worker[k].ID = keyin.nextInt();
            System.out.printf("輸入員工薪資 =>");
            worker[k].payment = keyin.nextInt();
            System.out.printf("輸入職務加給 =>");
            worker[k].duty = keyin.nextInt();
            keyin.nextLine();                                                           //清除鍵盤輸入
            System.out.printf("是否繼續輸入員工資料 (yes/no) =>");
            select = keyin.nextLine();
            k = k + 1;                                                                  //如果都完成寫入會加上1，可以持續輸入最多20個資料為止
        }

        /* 物件讀完要把它寫入檔案內 */
        System.out.printf("*** 將員工資料輸出到 Human.dada 檔案內 **\n");
        for (int i=0; i<k; i++){                                                        // 將物件陣列內資料一筆接一筆連續寫入 data 檔案物件；其中 data.write() 為檔案物件的寫入方法。資料屬性之間以『tab』鍵空格位置（\t）最後屬性輸出後跳至下一行（\n）。i < k, 因為k會不斷地讀入我們輸入的資料一定會比 i 大。
            data.write(worker[i].ID + "\t");
            data.write(worker[i].name + "\t");
            data.write(worker[i].department + "\t");
            data.write(worker[i].payment + "\t");
            data.write(worker[i].duty + "\n");
        }
        data.close();                                                                   //寫入完成記得要關閉，目的是強迫將緩衝器內容輸出到檔案上
        System.out.printf("***** 輸出完畢 ****\n");

        /* 檔案輸出程式, 每次讀取一筆資料 */
        System.out.printf("\n== 由 Human.data 讀取並顯示 ==\n");
        String inData;
        File fileID = new File(file);                                                   //開啟 Human.data 檔案
        if (fileID.exists()){                                                           //判斷 fileID 存不存在
            BufferedReader data_R = new BufferedReader(new FileReader(fileID));
            System.out.printf("代號\t姓名\t部門\t底薪\t加級\n");
            while ((inData = data_R.readLine()) != null);{                              //如果data_R 讀進來不是空值表示有資料
            System.out.printf("%s\n",inData);
            } 
            data_R.close();                                                             //如果是空值就結束掉
        }else {
            System.out.printf("%s 檔案讀取錯誤\n",file);
            System.out.printf("== Human.data 輸入完畢 ==\n");
        }
    }
}

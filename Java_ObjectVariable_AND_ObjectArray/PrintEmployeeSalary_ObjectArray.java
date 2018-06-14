package Java_ObjectVariable_AND_ObjectArray;

/*
    請參考 wiki 22-3_紀錄檔案的輸入＆輸出運用當中的22-3-3記錄檔案輸出格式_範例：列印公司員工薪資表。

    列印公司員工薪資表，延用 BuiltEmployeeSalary_ObjectArray class 的 Human.data 檔案。
    請編寫一套程式可供列印公司所有員工的薪資表，員工資料直接由 Human.data 檔案讀取。
    薪資表包含員工代號、姓名、服務部門，薪資總額（= 底薪 + 職務加級）、預扣稅額（= 薪資總額 * 0.1）與應領薪資（薪資總額 – 預扣稅額）。

    製作技巧研討：
    本範例最大的特點是，每筆資料由檔案讀入後，如何儲存於物件陣列內。
    首先系統利用 readLine() 方法讀入整筆資料後儲存於 inData 變數內，該資料還是屬於字串格式（String）。
    接著將 inData 導入 Scanner 類別，宣告其物件（data_R），其中必須設定字串資料之中各個欄位的『分界符號』（Demiliter），
    再利用 Scanner 物件方法，分別讀取各欄位資料再寫入陣列物件的變數成員內。

    相關之物件及其方法如下：
    inData=data.readLine() 由檔案讀取一筆資料。
    Scanner s = new Scanner(inData).useDelimiter("\t"); 宣告成 Scanner 物件並設定分界符號（\t），物件名稱為 scanner。
    worker[k].ID = s.nextInt(); 讀取一整數，再存入陣列物件的變數成員內。

 */


import java.io.*;
import java.util.Scanner;

public class PrintEmployeeSalary_ObjectArray {
    public static void main(String[] args) throws IOException {
        Employee[] worker = new Employee[20];
        String file = "Human.data";
        String inData;
        int k=0;
        File fileID = new File(file);

        if (fileID.exists()){                                                               //如果這份文件存在的話
            /* 宣告讀取的物件 由 Humam.data 讀取員工資料並存入 worker[] 陣列 */
            BufferedReader data = new BufferedReader(new FileReader(fileID));
            while ((inData = data.readLine()) != null){                                     //readLine() 這個方法意思是讀一行，如果不是空的就繼續讀'
                Scanner scanner = new Scanner(inData).useDelimiter("\t");                   //宣告成 Scanner 物件並設定分界符號（\t），物件名稱為 scanner
                worker[k] = new Employee();                                                 //這裡很重要唷！意思是在 Planning_Salary 的 class 當中可以 "呼叫產生" Employee 這個物件變數。白話就是，我宣告產生一個 Employee 的物件名字叫做 emp 同時利用 Employee 這個類別 new 產生物件放到 emp 裡面，所以就能使用 Employee() 這個class 當中的方法成員或物件成員！！看到 "=" 先看等號的右邊！！
                worker[k].ID = scanner.nextInt();                                           //讀取一整數，再存入陣列物件的變數成員內。以下的順序要注意喔!! 先去讀取員工代號!!
                worker[k].name = scanner.next();                                            //讀取一字串.next，再存入陣列物件的變數成員內。
                worker[k].department = scanner.next();                                      //以此類推～～帶入型態去解讀
                worker[k].payment = scanner.nextInt();
                worker[k].duty = scanner.nextInt();
                k = k + 1;
            }
            data.close();

            /*計算並列印薪資*/
            System.out.printf("== 公司員工薪資表 ==\n");
            System.out.printf("員工資料\t\t\t薪資總額　　　預扣稅款　應領薪資\n");
            int tax, sum, total=0, net, tax_total=0;                                        // tax稅, sum是薪資+職務加給, total是累計, tax_total是總稅額
            for (int i=0; i<k; i++){                                                        // 將物件陣列內資料一筆接一筆連續寫入 data 檔案物件；其中 data.write() 為檔案物件的寫入方法。資料屬性之間以『tab』鍵空格位置（\t）最後屬性輸出後跳至下一行（\n）。i < k, 因為k會不斷地讀入我們輸入的資料一定會比 i 大。
                sum = worker[i].payment + worker[i].duty;                                   //薪資 + 職務加給
                total = total + sum;
                tax = (int)(sum * 0.1);                                                     //稅 = 薪資 * 0.1
                net = sum - tax;
                tax_total = tax + tax_total;
                System.out.printf("%s(%d %s)\t",worker[i].name, worker[i].ID, worker[i].department);
                System.out.printf("%d\t\t%d\t%d\n",sum, tax, net);
            }

            System.out.printf("\n薪資總額 = %d 元整　\n",total);
            System.out.printf("總稅額　＝　%d 元整　\n",tax_total);
            System.out.printf("應領薪資　＝　%d 元整　\n",total-tax_total);

        }else {
            System.out.printf("%s 檔案不存在\n",file);
        }
    }
}

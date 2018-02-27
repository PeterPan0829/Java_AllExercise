package Java_MethodAndImportAPI;

/*
    製作工程計算機

    本系統需引用包含有三角函數的數學套件（java.lang.Math），與允許鍵盤輸入套件 java.util.Scanner；當然採用 java.io 套件亦可。
    另外，系統希望能重複選擇輸入使用，需利用 while 迴圈判斷是否結束，與 switch/case 判斷選擇項目，並處理相關事項。
    選單視窗會重複出現，可將其編寫成函數呼叫（disp_menu()）；但它僅輸出顯示，則沒有引數與傳回值。


 */

import java.lang.*;                             //導入子套件（包含 Math 類別）
import java.util.Scanner;                       //僅導入 java.util 套件下 Scanner 類別，其他未被導入可減少佔用記憶體空間。


public class EngineeringCalculator {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in); //利用 Scanner 類別宣告產生 keyin 物件，keyin 物件繼承了 Scanner 類別的所有方法成員（Method member）。
        double value, ans=0;                    //value 輸入要計算的值 ; ans 是計算完的值
        int select;                             //一開始選擇計算機1～7的功能
        disp_menu();                            //一開始隨即呼叫 menu(), 呼叫 disp_mem() 函數，該函數無傳回值（void）也不需要傳任何引數。

        select = keyin.nextInt();               //呼叫引用 keyin 的物件方法 nextLine()

        while (select !=7){
            System.out.printf("請輸入一個數值（注意三角函數範圍）=>");
            value = keyin.nextDouble();         //呼叫引用 keyin 的物件方法 nextDouble()
            switch (select){
                case 1:
                    //直接引用 Math 的類別 log() 方法
                    ans = Math.log(value);
                    System.out.printf("log(%.2f) = %.2f\n",value,ans);
                    break;

                case 2:
                    ans = Math.log10(value);
                    System.out.printf("log10(%.2f) = %.2f\n",value,ans);
                    break;

                case 3:
                    ans = Math.sqrt(value);
                    System.out.printf("sqrt(%.2f) = %.2f\n",value,ans);
                    break;

                case 4:
                    ans = Math.sin(value);
                    System.out.printf("sin(%.2f) = %.2f\n",value,ans);
                    break;

                case 5:
                    ans = Math.cos(value);
                    System.out.printf("cos(%.2f) = %.2f",value,ans);
                    break;

                case 6:
                    ans = Math.tan(value);
                    System.out.printf("tan(%.2f) = %.2f",value,ans);
                    break;

                default:
                    System.out.printf("輸入錯誤！！\n");
            }
            disp_menu();                        //While 判斷跑完之後再次呼叫一次 menu
            select = keyin.nextInt();           //再次做選擇
        }
        System.out.printf("\n===== 歡迎下次再次使用 =====");
    }

    //宣告 disp_menu 方法輸出顯示沒有引數與傳回值。
    static void disp_menu() {
        System.out.printf("\n***** 工程計算機提供下列功能 *****\n");
        System.out.printf("(1)log 函數\t(2)log10() 函數\n");
        System.out.printf("(3)sqrt 函數\t(4)sin() 函數\n");
        System.out.printf("(5)cos 函數\t(6)tan() 函數\n");
        System.out.printf("(7) 離開系統\n");
        System.out.printf("\n請選擇輸入 =>");
    }
}
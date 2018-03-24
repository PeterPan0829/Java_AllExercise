package Java_ArrayDataStructure;
/*
    請製作一套唐詩列印系統，功能是能將所輸入的唐詩（五言四句），分別以橫式與直式印出。期望操作介面如下：
    
== 五言四句唐詩 列印 ==
請輸入第 1 句(五個字) =>山中相送罷
請輸入第 2 句(五個字) =>日幕掩柒扉
請輸入第 3 句(五個字) =>春草明年綠
請輸入第 4 句(五個字) =>王孫歸不歸

== 橫式列印唐詩 ==
山  中  相  送  罷
日  幕  掩  柒  扉
春  草  明  年  綠
王  孫  歸  不  歸

== 直式列印唐詩 ==
山  日  春  王
中  幕  草  孫
相  掩  明  歸
送  柒  年  不
罷  扉  綠  歸


其中運用.useDelimiter可以參考以下：
https://stackoverflow.com/questions/28766377/how-do-i-use-a-delimiter-in-java-scanner　


*/

import java.util.Scanner;

public class PrintStraightTangPoems {
    public static void main(String[] args) {
        String poem[][] = new String[4][5];                                                  // Row_4, Column_5
        String num ="";
        Scanner keyin = new Scanner(System.in);
        
        System.out.printf("＝＝五言四句唐詩列印＝＝\n");
        
        //讀入五言四句唐詩：
        for (int i=0; i<4; i++){
            System.out.printf("請輸入第 %d 句（五個字） =>",i+1);                             //因為原本 i 是0,但我們要用第一句開始就要加 1
            num = keyin.next();                                                              //讀取 num 這個空字串
            Scanner s = new Scanner(num).useDelimiter("");                                   //沒有分隔的方法
            for (int j=0; j<5; j++){                                                         //分別讀取詩句中每一個文字（五言）
                poem[i][j] = s.next();
            }
        }
    
        System.out.printf("\n列印橫式唐詩：\n");
        for (int i=0; i<4; i++){                                                             //列印 4 行
            for (int j=0; j<5; j++){                                                         //每行 5 個字
                System.out.printf("%s　",poem[i][j]);
            }
            System.out.printf("\n");
        }
    
        System.out.printf("\n列印直式唐詩：\n");
        for (int j=0; j<5; j++){                                                             // 列印 5 行
            for (int i=0; i<4; i++){                                                         // 每行 4 個字
                System.out.printf("%s　",poem[i][j]);
            }
            System.out.printf("\n");
        }
    }
}

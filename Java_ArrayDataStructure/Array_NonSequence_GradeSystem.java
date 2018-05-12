package Java_ArrayDataStructure;

/*
    無序成績管理系統
    三民國中的張老師希望在電腦上管理班級同學(以學號登錄)的分數，班上課程有：國文、英文、數學、理化與自然，期望有下列功能：

    (1) 具有顯示全班成績
    (2) 新增學生成績
    (3) 刪除學生成績
    (4) 查詢學生成績
    (5) 更新學生成績
    (6) 依平均成績高低列印
    (7) 離開系統

    系統分析：
    我們需要一個 50*7 的二維陣列來儲存，
    假設全班人數最高為 50 位，每位學生需 7 個欄位來存放學號、國文、英文、數學、理化、自然與平均分數。
    為了讓使用者方便測試系統的正確性，程式內先產生 10 位學生的資料，都是由亂數產生。另外，學號並沒有按照大小順序排列。

    程式架構：
    main() 內除了產生學生資料的初始值外，也提供各項功能的輸入選單。
    print_menu() 與 print_course() 是顯示功能選單與學生成績資料顯示。
    Linear_Search() 功能是搜尋到想要處理資料的位置；Buffer_sort() 功能是依照平均分數排列。

 */

import java.util.Random;
import java.util.Scanner;

public class Array_NonSequence_GradeSystem{

    static int course[][] = new int[50][7];                                  //宣告無序陣列空間成績總共有 50 筆, 7個欄位 50*7
    static String name[]={"學號","國文","英文","數學","理化","自然","平均"};      //陣列欄位名稱
    static int point;                                                        //指標位置

    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        Random random = new Random();
        int value;                                                          //輸入元素
        int select;                                                         //功能選擇
        point = -1;                                                         //游標初始值(空值)
        int location;

        for (int i=0; i<10; i++){
            course[i][0] = random.nextInt(50);
            for (int j=1; j<=5; j++){
                course[i][j] = 30 + random.nextInt(70);
            }
            point = point + 1;
        }

        print_menu();
        select = keyin.nextInt();
        while (select != 7){
            switch (select){
                case 1:
                    print_course();
                    break;
                case 2:
                    if (point >= 50){
                        System.out.printf("陣列已滿無法插入\n");
                    }else {
                        point = point + 1;
                        System.out.printf("請輸入學生學號(2位數) =>");
                        course[point][0] = keyin.nextInt();
                        System.out.printf("請輸入國文成績 =>");
                        course[point][1] = keyin.nextInt();
                        System.out.printf("請輸入英文成績 =>");
                        course[point][2] = keyin.nextInt();
                        System.out.printf("請輸入數學成績 =>");
                        course[point][3] = keyin.nextInt();
                        System.out.printf("請輸入理化成績 =>");
                        course[point][4] = keyin.nextInt();
                        System.out.printf("請輸入自然成績 =>");
                        course[point][5] = keyin.nextInt();
                    }
                    System.out.printf("目前學生人數為 %d\n",point);
                    break;
                case 3:
                    System.out.printf("請輸入想刪除學生的學號 =>");
                    value = keyin.nextInt();
                    location = Linear_Search(value);
                    if (location == -1){
                        System.out.printf("沒有此 %d 學號的學生\n",value);
                    }else {
                        for (int i=location; i<=point; i++){
                            course[i] = course[i+1];
                        }
                    }
                    point = point-1;
                    System.out.printf("%d 學生已刪除成功\n",value);
                    System.out.printf("目前學生人數為 %d\n",point);
                    break;
                case 4:
                    System.out.printf("請輸入想查詢的學號 =>");
                    value = keyin.nextInt();
                    location = Linear_Search(value);
                    if (location == -1){
                        System.out.printf("沒有此 %d 學號的學生\n",value);
                    }else {
                        for (int i=0; i<=6; i++){
                            System.out.printf("%s=%d\t",name[i],course[location][i]);
                        }
                        System.out.printf("\n");
                    }
                    break;
                case 5:
                    System.out.printf("請輸入想更新學生成績的學號 =>");
                    value = keyin.nextInt();
                    location = Linear_Search(value);
                    if (location == -1){
                        System.out.printf("沒有此 %d 學號的學生\n",value);
                    }else {
                        System.out.printf("更新 %d 學生的成績 =>\n",course[location][0]);
                        System.out.printf("請更新國文成績(%d) =>", course[location][1]);
                        course[location][1] = keyin.nextInt();
                        System.out.printf("請更新英文成績(%d) =>", course[location][2]);
                        course[location][2] = keyin.nextInt();
                        System.out.printf("請更新數學成績(%d) =>", course[location][3]);
                        course[location][3] = keyin.nextInt();
                        System.out.printf("請更新理化成績(%d) =>", course[location][4]);
                        course[location][4] = keyin.nextInt();
                        System.out.printf("請更新自然成績(%d) =>", course[location][5]);
                        course[location][5] = keyin.nextInt();
                    }
                    break;
                case 6:
                    int sum;
                    for (int i=0; i<=point; i++){
                        sum = 0;
                        for (int j=0; j<=5; j++){
                            sum = sum + course[i][j];
                            course[i][6] = sum / 5;
                        }
                    }
                    Bubble_Sort();
                    print_course();
                    break;
                    default:
                        System.out.printf("輸入錯誤!! 請重新輸入!!\n");
            }
            print_menu();
            select = keyin.nextInt();
        }
    }

    //列印清單選項
    static void print_menu(){
        System.out.printf("\n== 三民國中 張老師成績管理系統 ==\n");
        System.out.printf("(1) 列印全班成績\n");
        System.out.printf("(2) 新增學生成績\n");
        System.out.printf("(3) 刪除學生成績\n");
        System.out.printf("(4) 查詢學生成績\n");
        System.out.printf("(5) 更新學生成績\n");
        System.out.printf("(6) 依平均成績高低列印\n");
        System.out.printf("(7) 離開系統\n");
        System.out.printf("\t 請輸入工作選項 =>");

    }

    //顯示全班各科成績
    static void print_course(){
        System.out.printf("\n== 列印全班各科成績 ==\n");
        for (int i=0; i<name.length; i++){                              //先顯示科目
            System.out.printf("%s　",name[i]);
        }
        System.out.printf("\n");
        for (int i=0; i<=point; i++){                                   //顯示科目後再顯示分數
            for (int j=0; j<course[i].length; j++){
                System.out.printf("%3d  ",course[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");                                        // 列印完畢, 換行


    }

    //新增、刪除學生的成績
    static int Linear_Search(int value){
        int flag = 0;
        int i = 0;
        int location = -1;
        while (i <= point){
            if (value == course[i][0]){
                flag = 1;
                location = i;
                break;
            }
            i = i + 1;
        }
        if (flag == 1){
            return location;
        }else {
            return -1;
        }
    }

    //依照成績高低作排序
    static void Bubble_Sort(){
        int temp[] = new int[7];
        for (int i=0; i<=point; i++){
            for (int j=0; j<=point; j++){
                if (course[i][6] < course[j][6]){
                    temp = course[i];
                    course[i] = course[j];
                    course[j] = temp;
                }
            }
        }
    }
}

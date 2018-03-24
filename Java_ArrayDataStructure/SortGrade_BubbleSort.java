package Java_ArrayDataStructure;
/*
    利用一維陣列存放了班上數學成績，陣列內容為a [] = {45, 12, 89, 76, 34, 65, 77, 93, 70, 65, 45, 89}
    請利用泡沫排序法編寫程式由高到低排列，並印出每回合排列的結果；期望操作介面如下：

    陣列內容 : 45  12  89  76  34  65  77  93
    第 0 回合: 93  12  45  76  34  65  77  89
    第 1 回合: 93  89  12  45  34  65  76  77
    第 2 回合: 93  89  77  12  34  45  65  76
    第 3 回合: 93  89  77  76  12  34  45  65
    第 4 回合: 93  89  77  76  65  12  34  45
    第 5 回合: 93  89  77  76  65  45  12  34
    第 6 回合: 93  89  77  76  65  45  34  12
    第 7 回合: 93  89  77  76  65  45  34  12


 */

public class SortGrade_BubbleSort {
    public static void main(String[] args) {
        int number[] = {45,12,89,76,34,65,77,93};
        int temp;                                             //這個變數算是一個空值可以讓我們暫存資料

        System.out.printf("陣 列 內 容：");                        //先顯示原來還沒進行排序的陣列內容
        for (int i=0; i<number.length; i++){
            System.out.printf("%d   ",number[i]);
        }
        System.out.println();

        for (int i=0; i<number.length; i++){                  //第一層迴圈是先跑整個尚未排序的陣列
            for (int j=i+1; j<number.length; j++){            //排序的動作一定是和下一個數字去比對,所以要用1去比對
                    if (number[i] < number[j]){               //原本的內容i < 要排序的內容 j 這裡也可以解釋成 j>i, 如果有j>i就做排序
                        temp = number[i];
                        number[i] = number[j];
                        number[j] = temp;
                    }
            }
            System.out.printf("第  %d 回合：",i);
            for (int j=0; j<number.length; j++){
                System.out.printf("%d   ",number[j]);
            }
            System.out.println();

        }

    }
}

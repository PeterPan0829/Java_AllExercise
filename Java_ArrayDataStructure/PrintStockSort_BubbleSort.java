package Java_ArrayDataStructure;
/*
    #掌握技巧：(1)小～大、大～小排序 (2)如何每十個數字換行

    利用陣列 stock[] = {78, 72, 61, 56, 87, 66, 74, 88, 76, 58, 65, 57, 90, 78, 67, 89, 56, 77, 56, 87, 67, 80, 77, 86, 67, 75, 86, 98, 88, 78};
    儲存台積電最近 30 個交易日的收盤價，請依照價格高低順序（由最低到最高順序）印出其內容；期望操作介面如下：

    原股票排序順序 :
    78.0  72.0  61.0  56.0  87.0  66.0  74.0  88.0  76.0  58.0
    65.0  57.0  90.0  78.0  67.0  89.0  56.0  77.0  56.0  87.0
    67.0  80.0  77.0  86.0  67.0  75.0  86.0  98.0  88.0  78.0

    排序後股票順序:
    56.0  56.0  56.0  57.0  58.0  61.0  65.0  66.0  67.0  67.0
    67.0  72.0  74.0  75.0  76.0  77.0  77.0  78.0  78.0  78.0
    80.0  86.0  86.0  87.0  87.0  88.0  88.0  89.0  90.0  98.0

 */
public class PrintStockSort_BubbleSort {

    //宣告類別陣列變數、暫存變數
    static double stock[] = {78, 72, 61, 56, 87, 66, 74, 88, 76, 58, 65, 57, 90, 78, 67, 89, 56, 77, 56, 87, 67, 80, 77, 86, 67, 75, 86, 98, 88, 78};
    static double temp;

    //main() 主要做呼叫其他兩個()
    public static void main(String[] args) {
        showStock();
        swap();
    }

    //呼叫列印陣列函數
    static void showStock() {
        System.out.printf("原股票排序：\n");
        for (int i=0; i<stock.length; i++){
            System.out.printf("%.1f  ",stock[i]);
            if ((i+1) % 10 == 0){                               //每10個數字換行
                System.out.printf("\n");
            }
        }

    }

    //呼叫泡沫排序演算法
    static void swap() {
        System.out.printf("\n排序後股票：\n");
        for (int x=0; x<stock.length; x++){
            for (int j=x+1; j<stock.length; j++){               //排序的動作一定是和下一個數字去比對,所以要用1去比對
                if (stock[x] > stock[j]){
                    temp = stock[x];
                    stock[x] = stock[j];
                    stock[j] = temp;
                }
            }
            System.out.printf("%.1f  ",stock[x]);
            if ((x+1) % 10 == 0){
                System.out.printf("\n");
            }
        }
    }

}

//    這是由高到低的排序方法請仔細看大於等於小於之間的變換，非常有意思！
//    static void swap() {
//        System.out.printf("\n排序後股票：\n");
//        for (int x=0; x<stock.length; x++){
//            for (int j=x+1; j<stock.length; j++){
//                if (stock[x] < stock[j]){
//                    temp = stock[x];
//                    stock[x] = stock[j];
//                    stock[j] = temp;
//                }
//            }
//            System.out.printf("%.1f  ",stock[x]);
//            if ((x+1) % 10 == 0){
//                System.out.printf("\n");
//            }
//        }
//    }
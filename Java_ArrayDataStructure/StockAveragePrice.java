package Java_ArrayDataStructure;

public class StockAveragePrice {
    public static void main(String[] args) {
        double sum = 0, average;
        double StockPrice[] = {78.8, 72.3, 61, 56, 87, 66.3, 74.5, 88, 76, 58};

        for (int i=0; i<StockPrice.length; i++){
            System.out.printf("%.2f ",StockPrice[i]);
            sum = sum + StockPrice[i];
        }
        System.out.println();
        average = sum / StockPrice.length;
        System.out.printf("最近 10 天的股票平均價格 = %.2f",average);

    }
}

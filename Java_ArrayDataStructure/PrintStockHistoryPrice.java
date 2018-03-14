package Java_ArrayDataStructure;

public class PrintStockHistoryPrice {
    public static void main(String[] args) {
        double[] StockPrice = {78.8, 72.3, 61, 56, 87, 66.3, 74.5, 88, 76, 58};

        for (int i=0; i<StockPrice.length; i++){
            System.out.printf("%.2f",StockPrice[i]);
            System.out.printf("\t");
        }

    }
}

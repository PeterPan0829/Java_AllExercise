package Java_ArrayDataStructure;

/*
    股票最近十天的最高和最低價

 */

public class StockPriceHighestAndLowest {
    public static void main(String[] args) {

        double Max=0.0, Min=99999.9;  //這是不可能發生的事情，但要用後面的值去取代
        double StockPrice[] = {78.8, 72.3, 61, 56, 87, 66.3, 74.5, 88, 76, 58};

        for (int i=0; i<StockPrice.length; i++){
            System.out.printf("%.2f ",StockPrice[i]);

            if (Max < StockPrice[i]){
                Max = StockPrice[i];
            }if (Min > StockPrice[i]){
                Min = StockPrice[i];
            }
        }

        System.out.printf("\n最近10天的最高價格 = %.2f",Max);
        System.out.printf("\n最近10天的最低價格 = %.2f",Min);

    }
}

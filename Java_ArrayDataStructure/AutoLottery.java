package Java_ArrayDataStructure;
/*
    此範例也是運用到 Sequential Search，請多加練習!!
    
    編寫一個產生 6 個隨機亂數的程式並不困難，但如果要這 6 個亂數不重複的話，不加點小技巧是不行的。
    首先準備一個 6 個元素的陣列（int[] num = new int[6];），每次隨機選出號碼後，立即比較陣列內是否有重複號碼（之前所取的），如果沒有則加入該陣列內。
    第 1 次選出號碼（i=0），陣列還是空的（j=0），則幾乎不用比對；如已選出 3 個號碼，下一個選出號碼就必須比對之前 3 個號碼是否有重複，依此類推。
    最後再印出以選出的 6 個號碼。
 */
public class AutoLottery {
    public static void main(String[] args) {
        int value, flag;                                                    //隨機存取號碼、判斷有無重複是用 flag
        int num[] = new int[6];                                             //儲存選取號碼 6 位
        int i = 0;                                                          //i只是表示在第幾個號碼,因為下面我們設 while(i<6)
        while (i<6){
            flag = 0;
            value = 1 + (int) (Math.random() * 49);                         //這一期的樂透就是在1~49
            for (int j=0; j<i; j++){                                        //檢視已選出的號碼
                if (value == num[j]){                                       //比對號碼是否有相同,有的話設為1
                    flag = 1;                                               //重複則 break 離開 for 迴圈再次重來
                    break;
                }
            }
            if(flag == 0){                                                  //等於 0 表示沒重複就填入陣列
                num[i]  = value;
                i = i + 1;
            }
        } //結束又再回到 While 迴圈當中判斷是不是小於 6
    
        System.out.printf("幸運號碼是：");
        for (i=0; i<6; i++){
            System.out.printf("%d　",num[i]);
        }
        System.out.printf("\n");
    }
}

package Java_ArrayDataStructure;

/*
此教學專注在 "有序" 實作。

資料在陣列中存放有依照某一個關鍵字(或稱主鍵)的大小排列。
這種排列方式的搜尋速度會比無序排列快許多。如果資料沒有依照大小排序，
搜尋某一筆資料必須採用『線性搜尋法』，也就是由資料最前頭，一筆接一筆的比對，找出所要資料的位置。
如果資料有一萬筆，運氣好第一筆就找到，運氣不好，找了一萬筆都沒有找到(速度為 n)。

如果採用 "有序陣列" 排序的話，可以採用『二分搜尋法』，詳細教學請看另一個教學 Array_Sequence_BinarySearch.java
平均搜尋的速度是 log2n，n 表示資料筆數，如此速度就比有無序排序快許多。
但因資料有依照主鍵大小排序，在作插入的時候，必須找到適當位置才可插入，而且必須經過適當的移位，
才可以移動出一個空間，這遠比無序排列困難許多。
 */


public class Array_Sequence {


    public static void main(String[] args) {
         int num[] = new int[50];                        // 0 ~ 49
         int point;                                      // 游標

        point = -1;                                      // point -1 表示游標是空值 (不設0）

        for (int i=0; i<40; i++){                        //給予陣列初值
            num[i] = (i+1) * 2;                          //存入有序陣列資料
            point = point + 1;                           //游標指示目前位置
        }

        //列印陣列資料內容
        System.out.printf("\n======目前有序陣列有　%d 筆資料======\n",point+1);
        for (int i=0; i<point; i++){
            System.out.printf("%d ",num[i]);
            if ((i+1) % 10 == 0){                        //列印十筆換行
                System.out.printf("\n");
            }
        }
        System.out.printf("\n");
    }
}

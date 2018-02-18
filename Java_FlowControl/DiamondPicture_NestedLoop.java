package Java_FlowControl;

/*
    使用雙重迴圈畫菱形圖形
 */

public class DiamondPicture_NestedLoop {
    public static void main(String[] args) {


//首先。把菱形看成上下兩部分，上五下四，所以，第一個for迴圈有5次，第二個for迴圈有4次
        for( int i = 1; i <= 5; i++){
            //將空格和*分開看，看" "的變化i=1時，它是4，2的時候是3，找規律
            for( int j = 1; j <= 5-i ; j++){
                System.out.print(" ");
            }
            for( int k = 1; k <= 2*i-1 ; k++){//找規律，i是 1 3 5 7 9基數
                System.out.print('*');
            }
            //換一行
            System.out.println();
        }
        for( int i = 1; i <= 4; i++){
            for( int j = 1;j <= i; j++){//空格 1 2 3 4 so
                System.out.print(" ");
            }
            for( int k = 1; k <= 2*(4 - i + 1 )-1; k++){//* 7 5 3 1 倒著來的基數
                System.out.print('*');
            }
            System.out.println();
        }
    }
}


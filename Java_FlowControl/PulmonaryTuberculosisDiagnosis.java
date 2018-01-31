package Java_FlowControl;

/*
    肺結核診斷系統

    有一點專家系統的感覺, 把肺結核領域的知識寫在程式裡面去做判斷
    這裡運用蜂巢式 if..else 來完成, 不過有更好的寫法！
    if..else 太多層到後面不太直觀, 程式看起來像是一個 > 在縮回來 希望後續有機會分享～


 */


import java.util.Scanner;

public class PulmonaryTuberculosisDiagnosis {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        int status; //狀態累積
        String key; // 字串變數輸入


        System.out.printf("歡迎使用肺結核自我診斷系統, 請回答下列問題 \n");
        System.out.printf("===================================== \n");
        System.out.printf("\n======= 感染期現象詢問 =======\n");
        status = 0;

        System.out.printf("最近有無咳嗽現象？ (y/n) =>");
        key = keyin.nextLine();
        if (key.equals("y")) {
            status = status + 1;
            System.out.printf("最近有無咳痰現象？ (y/n) =>");
            key = keyin.nextLine();
        }
        if (key.equals("y")) {
            status = status + 1;
            System.out.printf("最近有無疲倦現象？ (y/n) =>");
            key = keyin.nextLine();
        }
        if (key.equals("y")) {
            status = status + 1;
            System.out.printf("最近有無體重持續下降？ (y/n) =>");
            key = keyin.nextLine();
        }
        if (key.equals("y")) {
            status = status + 1;
        }
        if (status >= 3) {
            System.out.printf("\n感染期診斷結果：");
            System.out.printf("進入感染期, 持續幫你進階診斷有無發病\n");

            System.out.printf("\n======= 發病期現象詢問 =======\n");
            System.out.printf("最近是否胸悶現象？ (y/n) =>");
            key = keyin.nextLine();
            if (key.equals("y")) {
                status = status + 1;
                System.out.printf("最近是否胸痛現象？ (y/n) =>");
                key = keyin.nextLine();
            }
            if (key.equals("y")) {
                System.out.printf("最近是否呼吸困難現象 (y/n) =>");
                key = keyin.nextLine();
            }
            if (key.equals("y")) {
                status = status + 1;
            }
            if (status < 2) {
                System.out.printf("僅受感染,盡快就醫");
            } else {
                System.out.printf("\n感染期診斷結果：");
                System.out.printf("進入發病期, 持續幫你進階診斷有無危險\n");

                System.out.printf("\n======= 危險期現象詢問 =======\n");
//                status = 0;
                System.out.printf("最近是否午後發燒現象？ (y/n) =>");
                key = keyin.nextLine();
                //檢查一下括號
                if (key.equals("y")) {
                    status = status + 1;
                    System.out.printf("最近晚上有無一直冒汗？ (y/n) =>");
                    key = keyin.nextLine();
                }
                if (key.equals("y")) {
                    status = status + 1;
                    System.out.printf("最近是否呼吸咳血現象？ (y/n) =>");
                    key = keyin.nextLine();
                }
                if (key.equals("y")) {
                    status = status + 1;
                }
                if (status < 3) {
                    System.out.printf("您已進入發作期, 儘快就醫\n");
                } else {
                    System.out.printf("您已進入危險期, 必須隔離並儘快就醫\n");
                }
            }
        }
    }
}

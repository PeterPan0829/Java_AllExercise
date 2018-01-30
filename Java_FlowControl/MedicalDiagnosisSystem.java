package Java_FlowControl;

/*
    醫療診斷系統

    有一點專家系統的感覺, 把醫療領域的知識寫在程式裡面去做判斷
    這裡運用蜂巢式 if..else 來完成, 不過有更好的寫法！
    if..else 太多層到後面不太直觀, 後續再分享囉～


 */

import java.util.Scanner;

public class MedicalDiagnosisSystem {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);

        String key; // 字串變數輸入 y 或 n


        System.out.printf("歡迎使用醫療診斷系統,  請依序回答問題 \n");
        System.out.printf("===================================== \n");
        System.out.printf("請問最近是否發燒 (y/n) =>");

        key = keyin.nextLine();

        if (key.equals("y")) {
            System.out.printf("請問最近是否咳嗽 (y/n) =>");
            key = keyin.nextLine();
            if (key.equals("y")) {
                System.out.printf("請問最近是否感覺疲倦 (y/n) =>");
                key = keyin.nextLine();
                if (key.equals("y")) {
                    System.out.printf("你已經感冒了, 讓我治療你!!! \n");
                }
                else {
                    System.out.printf("請問是否血壓升高 (y/n) =>");
                    key = keyin.nextLine();
                    if (key.equals("y")) {
                        System.out.printf("請問最近有覺得口乾嗎？ (y/n) =>");
                        key = keyin.nextLine();
                        if (key.equals("y")) {
                            System.out.printf("哎呀！可能得肝病, 快去看醫生 !!! \n");
                        }
                        else {
                            System.out.printf("有可能只是感冒而已, 多喝熱水！ \n");
                        }
                    }
                    else {

                        System.out.printf("請問最近是否一直冒汗？ (y/n) =>");
                        key = keyin.nextLine();
                        if (key.equals("y")) {
                            System.out.printf("你可能得肺病, 快去看醫生!!! \n");

                        }
                        else {
                            System.out.printf("需要由其他系統進一步檢查 !!! \n");
                        }
                    }
                }
                    } else {
                System.out.printf("有發燒無咳嗽, 請到別科門診 !!!\n");
            }
        }
        else {
                System.out.printf("沒事拉！你應該是健康身體,多慮了：） \n");
            }
        }
    }

package Java_FlowControl;


/*
    使用 if/else 完成學期總成績自動蓋章評分

    日後會繼續做一個評量學期成績等級

    製作評量學生學期成績的工具，
    使用者輸入期中考（30%）、期末考（30%）、以及平時成績（40%）後，系統會依學期總平均評量其等級，
    如學期總成績高於 90 分則輸出 A 級、80 ~ 90 分為 B 級、80 ~ 70 為 C 級、70 ~ 60 為 D 級，60 分以下為 E 級。

 */
import java.util.Scanner;

public class SemesterGrade {
    public static void main(String[] args) {
        Scanner keyin = new Scanner(System.in);
        double score;

        System.out.printf("請輸入學期總成績 =>");
        score = keyin.nextDouble();

        if (score <= 100 && score >=90){
            System.out.printf("本學期等級為 A");
        } else if (score < 90 && score >= 80){
            System.out.printf("本學期等級為 B");
        } else if (score < 80 && score >= 70){
            System.out.printf("本學期等級為 C");
        } else if (score < 70 && score >= 60){
            System.out.printf("本學期等級為 D");
        } else if (score < 60){
            System.out.printf("本學期等級為 E, 參加重補修吧！");
        }
    }
}

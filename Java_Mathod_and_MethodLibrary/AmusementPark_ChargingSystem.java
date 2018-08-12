package Java_Mathod_and_MethodLibrary;

/*
    『Taipei AmusementPark 遊戲』採用按上線時間收費方法，遊戲者上線後開始計時，下線後在計算上線時間多寡計費，以每 30 秒 1 元計算。
    該公司需要一套收費資訊系統，因此在網路公開招標，期望參與投標者需製作一套雛型管理系統，
    應具有：設定目前時間、顯示上線遊戲者、開始遊戲、結束遊戲等功能；期望操作介面如下：

    ** Taipei AmusementPark 線上遊戲系統  0 時 0 分 0 秒 **
    (1) 設定目前時間         (2) 顯示上線遊戲者
    (3) 開始遊戲, 計費開始   (4) 結束遊戲, 繳費出場
    (5) 離開系統
    目前線上 0 請輸入工作選項 =>1
    請輸入目前時刻(時/分/秒) =>9/12/30


    ** Taipei AmusementPark 線上遊戲系統  9 時 12 分 30 秒 **
    (1) 設定目前時間         (2) 顯示上線遊戲者
    (3) 開始遊戲, 計費開始   (4) 結束遊戲, 繳費出場
    (5) 離開系統
    目前線上 0 請輸入工作選項 =>3
    參與玩家暱名 (英文) =>Peter


    ** Taipei AmusementPark 線上遊戲系統  9 時 12 分 30 秒 **
    (1) 設定目前時間         (2) 顯示上線遊戲者
    (3) 開始遊戲, 計費開始   (4) 結束遊戲, 繳費出場
    (5) 離開系統
    目前線上 1 請輸入工作選項 =>2
    姓名            開始時間
    Peter          9 時 12 分 30 秒


    ** Taipei AmusementPark 線上遊戲系統  9 時 12 分 30 秒 **
    (1) 設定目前時間         (2) 顯示上線遊戲者
    (3) 開始遊戲, 計費開始   (4) 結束遊戲, 繳費出場
    (5) 離開系統
    目前線上 1 請輸入工作選項 =>1
    請輸入目前時刻(時/分/秒) =>10/23/30


    ** Taipei AmusementPark 線上遊戲系統  10 時 23 分 30 秒 **
    (1) 設定目前時間         (2) 顯示上線遊戲者
    (3) 開始遊戲, 計費開始   (4) 結束遊戲, 繳費出場
    (5) 離開系統
    目前線上 1 請輸入工作選項 =>3

    製作技巧提示：
    系統必須提供登錄每位遊戲者上線的起始時間。
    當某位遊戲者下線時，計算當時時間與他的起始之間的相差值，得到他上線的時間，依此計算出上線費用。
    我們可利用 Time_CalTools 範例所建立的 Time_CalTools（timeInterval() 方法）物件來計算兩點差距的差距。
    （Time.class 與 time_CalTools.class 需與主程式存在於相同目錄下）
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Games{
    String ul_name;                    // 遊戲者匿名
    Time start = new Time();           // 遊戲者上線時間
}

public class AmusementPark_ChargingSystem {
    static BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in)); // 這是要去做讀取, 靜態鍵盤輸入物件
    static String time_readIn;                             // 讀入時間字串
    static Time now = new Time();                          // 儲存目前時間 (其實就是引用 Time class 產生一個物件變數)
    static Time time_T = new Time();                       // 時間暫存變數
    static Time time_B = new Time();                       // 時間暫存變數
    static Time_CalTools tool = new Time_CalTools();       // 產生時間工具物件物件(產生工具, 包含 4 種方法)
    static int number;                                     // 參與遊戲人數
    static Games[] players;                                // 紀錄遊戲者資料(嫟名, 入場時間)

    public static void main(String[] args) throws IOException {

        tool = new Time_CalTools();
        now = new Time();

        number = 0;                     // 紀錄目前上線者 0
        players = new Games[20];        // 儲存遊戲者陣列


        int select = get_menu();
//      keyin.read();

        while (select != 5) {
            switch (select) {
                case 1:
                    setNowTime();        // 設定目前時間
                    break;
                case 2:
                    dispGamePlayer();    // 顯示目前參與遊戲者
                    break;
                case 3:
                    startGame();         // 開始遊戲
                    break;
                case 4:
                    stopGame();          // 停止遊戲
                    break;
                default:
                    System.out.printf("\n錯誤輸入，請重新選擇\n");
            }
            select = get_menu();
//            select = keyin.read();
//            keyin.readLine();
        }
    }

        /* 主功能表選單 */
        static int get_menu() throws IOException {
            System.out.printf("\n ** Taipei AmusementPark 線上遊戲系統  %d 時 %d 分 %d 秒 ** \n", now.hour, now.minute, now.second);
            System.out.printf("(1) 設定目前時間         (2) 顯示上線遊戲者\n");
            System.out.printf("(3) 開始遊戲, 計費開始    (4) 結束遊戲, 繳費出場\n");
            System.out.printf("(5) 離開系統\n");
            System.out.printf("目前上線人數共 %d 位, 請輸入工作選項 =>", number);

            int select = keyin.read();
            keyin.read();
            return select;
        }

        // (1)設定目前時間
        static void setNowTime () throws IOException {
            System.out.printf("\n請輸入目前時刻(時 / 分 / 秒) =>\n");
            time_readIn = keyin.readLine();                 // 這邊是去做 readLine 讀取你所輸入的時分秒
            now = tool.getTime(time_readIn);                // 我們用一個從 Time Class 產生的物件變數 now 然後去取得從 Time_CarTools 產生的物件變數 tool 去取得物件方法 getTime()
            keyin.readLine();
            return;
        }

        // (2)顯示目前參與遊戲者
        static void dispGamePlayer () {
            System.out.printf("\n姓名\t\t開始時間\n");
            for (int i = 0; i < players.length; i++) {
                System.out.printf("%s\t\t%d 時 %d 分 %d 秒", players[i], now.hour, now.minute, now.second);
            }
        }

        // (3)開始遊戲
        static void startGame () throws IOException {
            Games players = new Games();
            System.out.printf("\n參與玩家姓名(英文) =>\n");
            players.ul_name = keyin.readLine();
            number = number + 1;
            keyin.readLine();
        }

        // (4)停止遊戲
        static void stopGame () throws IOException {
            System.out.printf("\n按 Enter 鍵離開　=>");
            keyin.readLine();
            System.exit(1); //宣告強制離開
        }
    }


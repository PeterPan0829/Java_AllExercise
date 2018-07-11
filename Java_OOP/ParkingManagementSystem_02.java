package Java_OOP;
import java.util.Scanner;

/*
    （可以搭配我們在 wiki 的學習講義 - 24_4_靜態變數的應用 當中的 24-4-3 類別變數 static 範例研討：停車場管理系統）

    範例研討：停車場管理系統

    高雄市政府公告『鳥松區立體停車場管理系統』招標事項，該系統需具有下列功能：（假設範例）
    (1) 顯示目前停車車輛：顯示目前每部車子的停車票號碼與進場時間。
    (2) 車輛進入取票：車輛進入停車場時，會給予車子一個停車票，其中包含停車票號碼與進場時間。停車號碼由 1 開始累增。
    (3) 車輛出場繳費：車輛離開時，需繳交停車票；系統搜尋該車輛紀錄時間，並計算停車費用（每 30 分鐘 20 元）。
    (4) 還未安裝計時時鐘，時鐘的時間由人工輸入設定。

    參與投標者須建立一套模擬系統，除了可提供上述功能之外，為增加現場臨場感，
    需增加一項設定目前時間的功能，作為計算停車費的依據。期望雛型模擬系統具有下列操介面：

    (A)主選單有 5 個選項，選項 1 為顯示目前停車場各輛車的進場時間、選項 2 為模擬計時器，
    利用人工輸入目前時間、選項 3 是車輛進入停車場，取票與開始計時、選項 4 是車輛離開時，繳費與刪除，如下：
    ** 鳥松區立體停車場 管理系統 目前時間 0 時 0 分 **
    (1) 顯示目前停車      (2) 設定目前時間
    (3) 車輛進入取票      (4) 車輛出場繳費
    (5) 離開系統
    目前車輛 0 請輸入工作選項 =>

    製作技巧提示：
    製作此系統時需考慮車輛進出口並不一定會相同，即是系統可能由：
    入口（車輛進入取票功能）、出口（車輛出場繳費功能）、與管理處（顯示目前停車功能）等 3 個地方同時操作。
    因此需將儲存停車資料檔案設定成共享資料，為了方便系統設計，我們採用物件導向設計理念，請參考 wiki 資料流程概念圖。
    首先我們宣告停車票類別（carTicket），描述每張停車票的內容：ticket 與 enterTime[2]，前者為停車票號碼、後者為車輛進場時間（時與分）。
    另外，製作一個停車票紀錄類別 Cars，期望它是共用屬性，因此宣告成靜態類別，所有程式都可直接存取。
    Cars 類別包含：car[] 與 number，前者紀錄每張停車票的資料，後者紀錄目前停車場的車輛數目。本系統也須設定一個靜態時間類別 Clock，紀錄目前時間。

    相關類別設計：
    依照上述的規劃，我們需要 3 個類別，將其製作於 carTicket.java 檔案，
    編譯後會分別產生下列 3 個類別檔案，功能如下：
    (1) carTicket.class：停車票類別。功能是記錄停車票號碼，以及車輛進場時間；成員如下：
        (a) int setTicket()：設定停車票號碼的方法。
        (b) int getTicket()：取得停車票號碼的方法。
        (c) enterTime[]：儲存車輛進入時間的變數，可任意存取。

    (2) Cars.class：儲存停車票的類別變數，包含有：
        (a) static carTicket[] car：進入車輛的停車票記錄（靜態變數）。由此記錄可知該車輛何時進入停車場，可做收費的依據。
        (b) static int number：紀錄目前停車場的車輛數（靜態變數）。

    (3) Clock.class：主時鐘的類別變數。記錄目前時間，包含有：
        (a) Static int clock：目前幾點鐘（時數，靜態變數）。
        (b) Static int minute：目前幾分鐘（分鐘數，靜態變數）。
 */

/* 停車票  */
class carTicket{
    private static int count=0;                     // 現在號碼第幾號，初始值給它0
    private int ticket;                             // 停車票號碼
    int[] enterTime = new int[2];                   // 進入停車場時間, 長度為 2 是因為只有存取 時、分兩個

    int setTicket(){                                // 設定停車票號碼
        count++;
        ticket = count;
        return ticket;
    }

    int getTicket(){                                // 取得停車票號碼
        return ticket;
    }
}

/* 目前停放車輛 */
class Cars{
    static carTicket[] car = new carTicket[100];    // 宣告物件陣列的類別變數(static)，假設可以停一百輛車子
    static int number;                              // 要取得目前停車車輛就是直接對 Cars 這個類別取得 number 就好
}

/*公眾計時器 (利用設定輸入) */
class Clock{
    static int hour;
    static int minute;
}


public class ParkingManagementSystem_02 {

    /*
    請建立一套停車場管理系統，功能有：顯示目前停車車輛、車輛進入取票、車輛出場繳費
   */

    static Scanner keyin = new Scanner(System.in);  // 在此宣告為類別變數、全域變數讓每個 method 都能夠使用
    public static void main(String[] args) {
        Cars.number = 0;
        int select = get_menu();
        while (select != 5){
            switch (select){
                case 1:
                    show_cars();
                    break;
                case 2:
                    set_time();
                    break;
                case 3:
                    enter_car();
                    break;
                case 4:
                    outer_car();
                    break;
                    default:
                        System.out.printf("錯誤選擇, 請重新輸入\\n");
            }
            select = get_menu();
        }
    }

    /* 主功能表選單 */
    static int get_menu(){
        System.out.printf("\n** 高雄市鳥松區立體停車場 管理系統 目前時間");
        System.out.printf(" %d 時 %d 分 **\n",Clock.hour,Clock.minute);
        System.out.printf("(1) 顯示目前停車      (2) 設定目前時間\n");
        System.out.printf("(3) 車輛進入取票      (4) 車輛出場繳費\n");
        System.out.printf("(5) 離開系統\n");
        System.out.printf("目前車輛 %d 請輸入工作選項 =>>",Cars.number);
        int select = keyin.nextInt();
        keyin.nextLine();
        return select;
    }

    /* 顯示目前停車車輛 */
    static void show_cars(){
        System.out.printf("停車票號碼\t\t進入時間\n");
        for (int i=0; i<Cars.number; i++){
            System.out.printf("\t%d\t\t  ",Cars.car[i].getTicket());
            System.out.printf("%d 時 %d 分\n",Cars.car[i].enterTime[0],Cars.car[i].enterTime[1]);
        }
    }

    /* 設定目前公用時間 */
    static void set_time(){
        System.out.printf("請輸入目前時間(時：分) =>");
        String now = keyin.nextLine();
        Scanner scanner = new Scanner(now).useDelimiter(":");
        Clock.hour = scanner.nextInt();
        Clock.minute = scanner.nextInt();
    }

    /* 車輛進場 */
    static void  enter_car(){
        Cars.car[Cars.number] = new carTicket();
        Cars.car[Cars.number].setTicket();
        Cars.car[Cars.number].enterTime[0] = Clock.hour;    // 記錄"時"
        Cars.car[Cars.number].enterTime[1] = Clock.minute;  // 記錄"分"
        int ticket = Cars.car[Cars.number].getTicket();
        System.out.printf("請按 <Enter> 鍵取票（號碼：%d）=>",ticket);
        keyin.nextLine();
        Cars.number = Cars.number + 1;                      // 下一輛車的號碼
    }


    /* 車輛出場, 繳費 */
    static void outer_car(){
        System.out.printf("請出示停車票 =>");
        int ticket = keyin.nextInt();
//        keyin.nextLine();
        int flag = 0, i;
        for (i=0; i<Cars.number; i++){                      // 搜尋該停車號
            if (ticket == Cars.car[i].getTicket()){
                flag = 1;
                break;
            }
        }

        if (flag == 0){
            System.out.printf("查無此車輛 \n");
            return;
        }

        int hour = Clock.hour - Cars.car[i].enterTime[0];
        int minute = Clock.minute - Cars.car[i].enterTime[1];
        minute = minute + hour * 60;
        int tax = (minute / 30) * 20;                       // 每 30 分鐘 20 元

        for (int j=i; j<Cars.number; j++)                 // 刪除該車票紀錄
            Cars.car[j] = Cars.car[j+1];
        

        Cars.number = Cars.number - 1;                      // 停車數 - 1
        System.out.printf("請繳交 %d 元停車費 (按 <Enter> 鍵) =>",tax);
        keyin.nextLine();
    }
}

# 方法與方法庫產生  
  
### Java_ObjectMethod (物件方法)
  
到目前為止，我們對物件的概念大多僅限於描述真實環境的應用，它使所描述的『事件』資料，具有主動處理能力。  
基本上，**物件包含變數與方法兩種成員**， **『變數成員』描述真實環境的屬性，『方法成員』為存取變數成員的途徑。**  

* Ex：一位學生的**屬性**有學號、姓名、班級、地址等等。

如果擴充方法成員，使用具有某一通用性的專屬功能（增強功能），也使變數成員成為區域變數（削弱功能）又展開了物件的另一種運用。  
**其實我們可針對某些特殊運用發展出工具套件，並且可被引用產生另一個專屬工具，該物件工具則成為『物件方法庫』（Object Library）**，如下圖所示；本章就針對**方法與方法庫產生**的運用來加以說明。  
  
* Ex：實際的例子，在 Java_AllExercise 持續做練習的話可以知道，在 24-1 開始提及物件導向，在一系列的練習之下我們都有寫自己要用的 Method() 再利用 main() 去實作它，只要看到程式開頭有出現 **import** ... 就是一種引用 Java 的 Library。其實在更早大家已經開始使用了外部的 Object Library 像是 random、Scanner等，Object Library 就很像是這樣的概念喔～  

```Java
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
```

  
  
  
![Library的演變](http://www.tsnien.idv.tw/Java2_WebBook/插圖/chap8/圖%208-1.png)  
_圖（Library的演變）_  

  
  
### 『物件方法庫』（Object Library）是一個『工具』  
  
之後有機會再另外用我在部落格分享的知識模型和大家分享學習知識個架構方法，在此先不贅述，但 Object Library 是一個『工具』這觀念很重要！而 **library 可以自己寫也可以引用外部的**。  
  
利用物件導向技巧所發展出來的方法庫（Method Library）可區分為下列兩大類：
1. 物件方法：利用類別描述技巧，包裝多個方法成員於某一類別內，而此類別**必須經由 new 產生物件後，才可引用物件內的方法**，該物件內的方法則稱為 **『物件方法』（Object method）** 。

2. 類別方法：利用類別建構技巧，包裝多個方法於某一類別內。此類別可不用經由 new 產生物件，即可引用類別內方法，該類別內方法則稱之為『類別方法』（Class method）。

其實，類別方法就像靜態變數一樣，都是屬於靜態的（後續說明）。宣告語法也類似，只要將 static 關鍵字加諸於方法名稱的前面即可。以下分別介紹這兩方法的產生與運用。
  
  
  
# 物件方法宣告與產生  
  
**這部分之前有提過很多次了，但因為提到 library 就一定跟物件方法宣告與產生有很大的關係**  
  
將一些常用的程式整合於某一類別內，類別內每一方法成員，實現某一專屬功能的程式，讓其他類別（或物件）可以直接呼叫使用。  
這種做法很像傳統語言的『庫存函數』（Library），但 Java 物件方法必須經過 new 命令產生另一個物件實體，再引用物件內的方法成員。  
  
**宣告語法如下：**  
  
```
                             宣告語法                                        範     例


類別內物件方法宣告             class class_name {                             class self_math {
                                   return_type method_name() {                    int getMax( intx, int y) {
                                        method_body;                                   物件方法內容…..
                                   }                                              }
                                   …..                                            …..
                              }                                              }



物件產生                      class_name object_1 = new class_name();        self_math u1_math = new self_math();


物件方法引用                  object1.method_name();                          u1_math.getMath();
```
  
如同一般類別的宣告語法，可以將 **類別** 宣告成私有性（private class）或公有性（public class），也可將 **方法成員** 宣告成私有性（private static）或公有性（public static） 。  
  
#### 我們會用幾個範例和大家分享，請確實實作並且理解當中的 **philosophy (The Rule)**


# 詳細說明 Library 方法：

## Integer.parseInt(); 字串轉換成整數  
  
將字串 String 轉換成整數 int, 有兩個方法：  
(1). int i = Integer.parseInt([String]); 或 i = Integer.parseInt([String],[int radix]);  
  
(2). int i = Integer.valueOf(my_str).intValue();  
  
  
## 比較兩個物件是否為相同類型的類別後再比較其內容值是否相同  
  
在Java裡，**equals** 和 **＝＝** 常令程式設計師困惑，這裡簡單說明如下 :  
1. ==  
測試物件參考時，**唯有當兩個參考指向同一物件時，==運算子的結果才為true**，同樣的，唯有當兩個參考指向不同物件時，!=運算子的結果才為true，這兩個運算子的處理與物件的內容無關。需要特別注意的是，在String中使用==，因為Java為節省記憶體，會在某一輪調區中維護唯一的String物件，所以如果在類別裡使用同一字串，Java只會建立一個唯一的字串而已。
  
2. equals  
另一種測試的做法是equals，**equals在類別為Java原先就存在時，是比較兩個物件是否為相同類型的類別後再比較其內容值是否相同，是就傳回true，否就傳回false。當要測試的類別是自定類別時，要依自定類別所提供的equals來決定如何比較**，如果自定類別沒有覆蓋Object的equals類別的話，就以Object的equals來比較，Object的equals的比較方式如同==。
  
  
## 將數字字元，即 0~9 轉成整數型態  
  
在Java中，若要將數字字元即0~9轉成整數型態，若用強制型別轉換，因為數字字元的ascii碼是從48開始，所以會產生錯誤。  
而我們要解決這個困難則有兩種方法可以實做，一種是靠我們**手動寫程式**，另一種是靠**JAVA的Character類別**所提供的方法。  
  
(1) 其中數字字元表示 0~9。  
*int num = '數字字元'- '0';*
  
(2) 第二種方法則是使用Character類別中的getNumericValue方法，用法如下：  
*public static int getNumericValue(char ch);  
public static int getNumericValue(int codePoint)*
  
其中ch為要轉換的字元。所以，如果我們要將字元轉換成數字，則可以使用下列方法：  
*Character.getNumericValue(ch)*
  
其中，ch可接受的範圍為0-9、A-Z、a-z。  
而你一定會很好奇的是，字元輸入的是A、B…等英文字母，那會轉成什麼呢？答案是若是**英文單字A，則會轉成10，Z則會轉成35**，而英文字母是不分大小寫的。
  
另外，你也可以用codePoint，即ascii碼來轉，以下為他的範例：  
*Character.getNumericValue(codepoint)*
  
其中codepoint為整數，可接受的範圍為「48~57」，「48對應到0」，「49對應到1」等，以此類推，「57會對應到9」。  
而這僅僅適用於字元轉成數字，但不適用於字串轉成數字喔！  
  
  
## 分隔號
  
.useDelimiter("") --> 用來自訂分隔符號  
  
以我們 **CustomerDataManagementSystem_02** 這個範例來解釋：  
將輸入身份證字號（SID_No）**各個字元取出**，並分別存入 SID_num1[] 陣列中。  
  
```java
Scanner keyin = new Scanner(SID_No).useDelimiter("");
    for (int i=0; i<10; i++){                       
        SID_num1[i] = keyin.next();
    }                  
```


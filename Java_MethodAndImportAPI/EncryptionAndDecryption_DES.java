//package Java_MethodAndImportAPI;
///*
//    請製作 DES (Data Encryption Standard) 密碼系統加密/解密功能的雛形工具，
//    系統允許使用者輸入明文與產生鑰匙元素後，即顯示加密後密文，以及解密後明文。
//    操作介面如下：
//                請輸入明文 =>大家恭喜、新年快樂
//                請輸入密碼元素(8 個字元) =>12345678
//                密碼元素：12345678
//                明文：大家恭喜、新年快樂
//                加密後密文：h\吘$:?!廄礓v?JX5Q?
//                解密後明文：大家恭喜、新年快樂
//
//    ＊要將 DES 密碼系統演算法轉換為程式，是一件不容易的工作，我們可利用 Javax.crypto 套件下的類別程式來完成。
// */
//
//import com.sun.org.apache.xpath.internal.operations.String;
//
//import java.security.SecureRandom;
//import java.util.Scanner;
//import javax.crypto.Cipher;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
//
//public class EncryptionAndDecryption_DES {
//    private static byte[] content;
//
//    public static void main(String[] args) {
//
//        java.lang.String plain;
//        java.lang.String key;
//
//        Scanner keyin = new Scanner(System.in);
//            System.out.printf("請輸入明文 =>");
//        plain = keyin.nextLine();
//            System.out.printf("請輸入密碼元素（8個字元）=>");
//        key = keyin.nextLine();
//            System.out.printf("密碼元素：%s",key);
//            System.out.printf("明文：%s",plain);
//        byte[] cipher = encrypt(plain,key);
//            System.out.printf("加密後密文：%s",(cipher));
//        String cipher_n = decrypt(cipher,key);
//            System.out.printf("解密後明文：%s",cipher_n);
//
//    }
//
//
//
//    //DES 加密方法
//    public static byte[] encrypt(String plain, String key) {
//        try {
//
//            SecureRandom random = new SecureRandom();
//            DESKeySpec desKey = new DESKeySpec(key.getBytes());
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            SecretKey securekey = keyFactory.generateSecret(desKey);
//            Cipher cipher = Cipher.getInstance("DES");
//            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
//            byte[] result;
//            result = cipher.doFinal(plain.getBytes());
//            return result;
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    //DES 解密方法
//    public static String decrypt(byte[] cipher, String key) {
//        try {
//            SecureRandom random = new SecureRandom();
//            DESKeySpec desKey = new DESKeySpec(key.getBytes());
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            SecretKey securekey = keyFactory.generateSecret(desKey);
//            Cipher cipher = Cipher.getInstance("DES");
//            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
//            byte[] result = cipher.doFinal(content);
//            return new String(result);
//        } catch (Throwable e) {
//
//            e.printStackTrace();
//
//        }
//        return null;
//    }
//}
//

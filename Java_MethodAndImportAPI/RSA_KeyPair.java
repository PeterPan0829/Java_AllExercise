package Java_MethodAndImportAPI;

/*
    主要在於應用 Java 當中的套件讓大家知道套件的優點可以加速開發，詳細的說明會在之後上傳跟大家分享～

    製作一套 1024 位元的 RSA 鑰匙配對產生工具，每次執行時會產生不同的鑰匙配對(公開鑰匙與私有鑰匙)，
    利用 Java.scurity 套件內，產生 RSA 鑰匙配對方法。期望操作介面如下：

    產生RSA 鑰匙配對中

    將鑰匙配對寫入檔案，並顯示於螢幕
    Public Key: 30819f300d06092a864886f70d010101050003818d003081890281810094be1274ff
                cd65be48bc02a96fabf8bc5a614b715ff24bdf46afddca2ae5f3ab24a32bc6304699

    Private Key: 30820275020100300d06092a864886f70d01010105000482025f3082025b0201000
                 281810094be1274ffcd65be48bc02a96fabf8bc5a614b715ff24bdf46afddca2ae5

    由檔案讀出 RSA 鑰匙配對，並顯示於螢幕
    Public Key: 30819f300d06092a864886f70d010101050003818d003081890281810094be1274ff
                cd65be48bc02a96fabf8bc5a614b715ff24bdf46afddca2ae5f3ab24a32bc6304699

    Private Key: 30820275020100300d06092a864886f70d01010105000482025f3082025b0201000
                 281810094be1274ffcd65be48bc02a96fabf8bc5a614b715ff24bdf46afddca2ae5
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSA_KeyPair {
    public static void main(String[] args) {

        myKeyPair adam = new myKeyPair();
        try {

            String path = ".";

            // Generate the key pair (public key and private key)
            KeyPairGenerator keygen = KeyPairGenerator.getInstance("RSA");   // 產生鑰匙配對
            SecureRandom random = new SecureRandom();                        // 產生亂數

            // 給與亂數因子，指定鑰匙長度，再產生鑰匙
            System.out.println("產生RSA 鑰匙配對中");
            random.setSeed("seedVaule".getBytes());                          // 把字串 seedVaule 轉換成 Byte
            keygen.initialize(1024, random);                          // Generate 1024-bit keys
            KeyPair generatedKeyPair = keygen.generateKeyPair();

            // 儲存鑰匙配對
            System.out.println("將鑰匙配對寫入檔案，並顯示於螢幕");
            adam.dumpKeyPair(generatedKeyPair);                              // Print the generated keys
            adam.SaveKeyPair(path, generatedKeyPair);                        // Store the keys into two files

            // 讀取鑰匙配對
            System.out.println("\n由檔案讀出 RSA 鑰匙配對，並顯示於螢幕");
            KeyPair loadedKeyPair = adam.LoadKeyPair(path, "RSA");  // Load the keys from files

            adam.dumpKeyPair(loadedKeyPair);                                 // Print the loaded keys
        } catch (Exception e) {
            e.printStackTrace();                                             // 其中，如果有錯誤的話要印出來
            return;
        }
    }
}


// 列印鑰匙配對方法
class myKeyPair {

    public void dumpKeyPair(KeyPair keyPair) {
        PublicKey pub = keyPair.getPublic();
        System.out.println("Public Key: " + getHexString(pub.getEncoded()));
        PrivateKey priv = keyPair.getPrivate();
        System.out.println("Private Key: " + getHexString(priv.getEncoded()));
    }

    //2進位轉換成16進位
    public String getHexString(byte[] b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length; i++)
            result.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }



    // 將鑰匙配對寫入檔案方法
    public void SaveKeyPair(String path, KeyPair keyPair) throws IOException {
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // 儲存公開鑰匙
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        FileOutputStream fos = new FileOutputStream(path + "/public.key");
        fos.write(x509EncodedKeySpec.getEncoded());
        fos.close();

        // 儲存私有鑰匙
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        fos = new FileOutputStream(path + "/private.key");
        fos.write(pkcs8EncodedKeySpec.getEncoded());
        fos.close();
    }



    // 由檔案中讀取鑰匙配對方法（其中KeyPair是一個資料結構，這邊利用到物件儲存方式）
    public KeyPair LoadKeyPair(String path, String algorithm)
        throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

        // 讀取公開鑰匙
        File filePublicKey = new File(path + "/public.key");
        FileInputStream fis = new FileInputStream(filePublicKey);
        byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
        fis.read(encodedPublicKey);
        fis.close();

        // 讀取私有鑰匙方法
        File filePrivateKey = new File(path + "/private.key");
        fis = new FileInputStream(filePrivateKey);
        byte[] encodedPrivateKey = new byte[(int) filePrivateKey.length()];
        fis.read(encodedPrivateKey);
        fis.close();


        // Generate KeyPair.
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
        return new KeyPair(publicKey, privateKey);
    }
}
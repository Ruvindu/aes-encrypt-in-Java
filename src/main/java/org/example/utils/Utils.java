package org.example.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.security.KeyStore;

public class Utils {
    /* Load the (Symmetric) Key */
    public static SecretKey loadSecretKey(String keyStoreFile, String keyStorePassword, String keyAlias) throws Exception {
        FileInputStream keyStoreStream = new FileInputStream(keyStoreFile);
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(keyStoreStream, keyStorePassword.toCharArray());
        SecretKey secretKey = (SecretKey) keyStore.getKey(keyAlias, keyStorePassword.toCharArray());
        keyStoreStream.close();

        return secretKey;
    }

    /* Encrypt the data with Symmetric Key (Symmetric Encryption) */
    public static byte[] encryptWithSecretKey(SecretKey secretKey, byte[] dataToEncrypt) throws Exception {
        Cipher symmetricCipher = Cipher.getInstance("AES");
        symmetricCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = symmetricCipher.doFinal(dataToEncrypt);

        return encryptedData;
    }

    /* Decrypt the encrypted data with Symmetric Key (Symmetric Decryption) */
    public static byte[] decryptWithSecretKey(SecretKey secretKey, byte[] dataToDecrypt) throws Exception {
        Cipher symmetricCipher = Cipher.getInstance("AES");
        symmetricCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedDataWithSecretKey = symmetricCipher.doFinal(dataToDecrypt);

        return decryptedDataWithSecretKey;
    }
}

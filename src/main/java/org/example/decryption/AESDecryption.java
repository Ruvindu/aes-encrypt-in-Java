package org.example.decryption;

import org.example.utils.Utils;

import javax.crypto.SecretKey;
import java.util.Base64;

public class AESDecryption {
    public static void decrypt(String encodedEncryptedData) throws Exception {
        String keyStoreFile = "src/main/resources/keystore.jks";
        String keyPassword = "123456";
        String keyAlias = "secretKey";

        // Step 1: Decode Base64 to get the encrypted bytes
        byte[] encryptedData = Base64.getDecoder().decode(encodedEncryptedData);

        // Step 2: Load the Symmetric Key from the KeyStore
        SecretKey secretKey = Utils.loadSecretKey(keyStoreFile, keyPassword, keyAlias);

        // Step 3: Decrypt with the Symmetric Key (Symmetric Decryption)
            byte[] decryptedDataWithSecretKey = Utils.decryptWithSecretKey(secretKey, encryptedData);

        System.out.println("\n--------------------------------");
        System.out.println("\nDecryption Process...");
        System.out.println("\nEncoded Encrypted Data: " + encodedEncryptedData);
        System.out.println("\nEncrypted Data: " + new String(encryptedData));
        System.out.println("\nDecrypted Data With Secret Key: " + new String(decryptedDataWithSecretKey));
        System.out.println("\nOriginal Data: " + new String(decryptedDataWithSecretKey));
    }
}

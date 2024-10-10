package org.example.encryption;

import org.example.utils.Utils;

import javax.crypto.SecretKey;
import java.util.Base64;

public class AESEncryption {
    public static String encrypt(String dataToEncrypt) throws Exception {
        String keyStoreFile = "src/main/resources/keystore.jks";
        String keyPassword = "123456";
        String keyAlias = "secretKey";

        // Step 1: Load the Symmetric Key from the KeyStore
        SecretKey secretKey = Utils.loadSecretKey(keyStoreFile, keyPassword, keyAlias);

        // Step 4: Encrypt the data with Symmetric Key (Symmetric Encryption)
        byte[] encryptedData = Utils.encryptWithSecretKey(secretKey, dataToEncrypt.getBytes());

        // Step 5: Encode in Base64 for easy representation/storage
        String encodedEncryptedData = Base64.getEncoder().encodeToString(encryptedData);

        System.out.println("\nEncryption Process...");
        System.out.println("\nData to Encrypt: " + dataToEncrypt);
        System.out.println("\nEncrypted Data With Public Key: " + new String(encryptedData));
        System.out.println("\nEncoded Encrypted Data: " + encodedEncryptedData);

        return encodedEncryptedData;
    }
}

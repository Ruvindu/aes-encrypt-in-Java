package org.example;

import org.example.decryption.AESDecryption;
import org.example.encryption.AESEncryption;

public class Main {
    public static void main(String[] args) throws Exception {
        String dataToEncrypt = "1234";
        String encodedEncryptedData = AESEncryption.encrypt(dataToEncrypt);

//        String encodedEncryptedData = "cs+bkZ46iTQGjy6yVonbqQ==";
        AESDecryption.decrypt(encodedEncryptedData);
    }
}

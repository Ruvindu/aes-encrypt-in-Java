# Implementing Encryption Using Symmetric Keys in Java

## 1. Generate KeyStore

You can use the Java `keytool` command to generate KeyStore.

```shell
keytool -genseckey -alias secretKey -keyalg AES -keysize 256 -keystore keystore.jks
```

This command generates a symmetric key and stores it in the `keystore.jks`.
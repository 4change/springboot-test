package com.fly.test.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public final class DESUtils {

    public static final String DES = "DES";

    public static String genKeyDES() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(DES);
        keyGenerator.init(56);
        SecretKey key = keyGenerator.generateKey();
        return BASE64Utils.byte2base64(key.getEncoded());
    }

    public static SecretKey loadKeyDES(String base64Key) throws IOException {
        byte[] bytes = BASE64Utils.base642byte(base64Key);
        return new SecretKeySpec(bytes, DES);
    }

    public static byte[] encryptDES(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    public static byte[] decryptDES(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(DES);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    public static void main(String[] args) throws Exception {
        String key = genKeyDES();
        SecretKey secretKey = loadKeyDES(key);
        String source = "sdfafasdfasdfasdfasdfasfasfsdhsdvzxasdfvdheqbgegsvssdvfdasfs";
        byte[] bytes = encryptDES(source.getBytes(StandardCharsets.UTF_8), secretKey);
        byte[] bytes1 = decryptDES(bytes, secretKey);
        System.out.println(new String(bytes1));
    }

}

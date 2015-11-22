package com.elte.cs.crypto.fpe.algorithms;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/*
Source: https://gist.github.com/bricef/2436364
*/
public class AES {

    private static String IV = "AAAAAAAAAAAAAAAA";

    public static void setIV(String iv) {
        IV = iv;
    }

    public static String encrypt(String plainText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        byte[] encryptedTextBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        return new Base64().encodeAsString(encryptedTextBytes);
    }

    public static String decrypt(String cipherText, String encryptionKey) throws Exception {
        byte[] encryptedTextBytes = new Base64().decodeBase64(cipherText);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(cipher.doFinal(encryptedTextBytes), "UTF-8");
    }
}

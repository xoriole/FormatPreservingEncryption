package com.elte.cs.crypto.fpe.algorithms;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sandip Pandey
 */
public class AESTests {

    String key;
    String message;

    @Before
    public void setUp() {
        key = "0123456789abcdef";
        message = "This is test message";
    }

    @Test
    public void testEncryptionAndDecryption() {
        try {

            String cipher = AES.encrypt(message, key);
            String decrypted = AES.decrypt(cipher, key);

            System.out.println("plain   :  " + message);
            System.out.println("cipher  :  " + cipher);
            System.out.println("decrypt :  " + decrypted);

            assertEquals(message, decrypted);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

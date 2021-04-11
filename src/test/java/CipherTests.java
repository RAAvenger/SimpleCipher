import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.security.Key;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CipherTests {
    private final Cipher cipher;

    public CipherTests() {
        cipher = new Cipher();
        cipher.key = new HashMap<>();
        cipher.key.put('a', 'A');
        cipher.key.put('b', 'B');
        cipher.key.put('c', 'C');
    }

    @Test
    void encryptPlainTextTest() {
        String expectedResult = "BBAACAB";
        cipher.plainText = "bbaacab";
        String testResult = cipher.encryptPlainText();
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void decryptCipherTextTest() {
        String expectedResult = "BBAACAB";
        cipher.cipherText = "bbaacab";
        String testResult = cipher.decryptCipherText();
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void decryptTest() {
        CPK expectedResult = new CPK("bbaacab", "BBAACAB", cipher.key, false);
        CPK testResult = Cipher.decrypt(expectedResult.cipherText, expectedResult.key);
        Assertions.assertEquals(expectedResult, testResult);
    }
}
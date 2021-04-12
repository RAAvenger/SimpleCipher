import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CipherSimpleSubstitutionTests {
    private final CipherSimpleSubstitution cipher;

    public CipherSimpleSubstitutionTests() {
        cipher = new CipherSimpleSubstitution();
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
        var expectedResult = CipherSimpleSubstitution.encrypt("bbaacab");
        var testResult = CipherSimpleSubstitution.decrypt(expectedResult.cipherText, expectedResult.key);
        Assertions.assertEquals(expectedResult, testResult);
    }
}
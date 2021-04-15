import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CipherComplexTests {
    private final CipherComplex cipher;

    public CipherComplexTests() {
        cipher = new CipherComplex();
    }

    @Test
    void joinKeysTest() {
        var expectedResult = "12385214,azesxdcfgv";
        var testResult = cipher.joinKeys("azesxdcfgv", "12385214");
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void decryptTest() {
        var expectedResult = cipher.encrypt("this is a test text!");
        var testResult = cipher.decrypt(expectedResult.cipherText, expectedResult.key);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void extractTranspositionKeyTest() {
        var expectedResult = "12385214";
        var testResult = cipher.extractTranspositionKey("12385214,azesxdcfgv");
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void extractSubstitutionKey() {
        var expectedResult = "azesxdcfgv";
        var testResult = cipher.extractSubstitutionKey("12385214,azesxdcfgv");
        Assertions.assertEquals(expectedResult, testResult);
    }
}
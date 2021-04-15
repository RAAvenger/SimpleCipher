import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CipherSimpleTranspositionTests {
    CipherSimpleTransposition cipher;

    public CipherSimpleTranspositionTests() {
        cipher = new CipherSimpleTransposition();
    }

    @Test
    void getPageSizeTest() {
        var expectedResult = 3;
        var testResult = cipher.calculatePageSize(12);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void textTranspositionTest() {
        var expectedResult = "this ts iest";
        cipher.pageSize = 3;
        var testResult = cipher.textTransposition("this is test", Arrays.asList(0, 2, 1, 3));
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void decryptTest() {
        var expectedResult = cipher.encrypt("this is test");
        var testResult = cipher.decrypt(expectedResult.cipherText, expectedResult.key);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void generateDecryptionPageOrderTest() {
        var expectedResult = Arrays.asList(0, 2, 1, 3);
        var testResult = cipher.generateDecryptionPageOrder(Arrays.asList(0, 2, 1, 3));
        Assertions.assertEquals(expectedResult, testResult);
    }
}
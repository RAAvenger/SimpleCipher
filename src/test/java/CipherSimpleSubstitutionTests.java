import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CipherSimpleSubstitutionTests {
    private final CipherSimpleSubstitution cipher;
    private final HashMap<Character, Character> key;

    public CipherSimpleSubstitutionTests() {
        cipher = new CipherSimpleSubstitution();
        key = new HashMap<>();
        key.put('a', 'A');
        key.put('b', 'B');
        key.put('c', 'C');
    }

    @Test
    void replaceCharactersUsingKeyTest() {
        String expectedResult = "BBAACAB";
        String testResult = cipher.replaceCharactersUsingKey("bbaacab", key);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void keyToStringTest() {
        String expectedResult = "aAbBcC";
        HashMap<Character, Character> key = new HashMap<>();
        key.put('a', 'A');
        key.put('b', 'B');
        key.put('c', 'C');
        String testResult = cipher.keyToString(key);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void decryptTest() {
        var expectedResult = cipher.encrypt("bbaacab");
        var testResult = cipher.decrypt(expectedResult.cipherText, expectedResult.key);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void extractDescriptionKeyTest() {
        var testResult = cipher.extractDescriptionKey("AaBbCc");
        Assertions.assertEquals(key, testResult);
    }
}
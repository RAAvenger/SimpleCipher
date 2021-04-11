import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CPKTests {
    private static CPK cpk;

    @BeforeAll
    public static void setup() {
        cpk = new CPK("", "", null, true);
    }

    @Test
    void keyToStringTestIsEncryptionKey() {
        String expectedResult = "aAbBcC";
        HashMap<Character, Character> key = new HashMap<>();
        key.put('a', 'A');
        key.put('b', 'B');
        key.put('c', 'C');
        String testResult = cpk.keyToString(key, true);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void keyToStringTestIsNotEncryptionKey() {
        String expectedResult = "aAbBcC";
        HashMap<Character, Character> key = new HashMap<>();
        key.put('A', 'a');
        key.put('B', 'b');
        key.put('C', 'c');
        String testResult = cpk.keyToString(key, false);
        Assertions.assertEquals(expectedResult, testResult);
    }
}
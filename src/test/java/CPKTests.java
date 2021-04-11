import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

class CPKTests {
    private final CPK cpk;

    public CPKTests() {
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

    @Test
    void testEqualsTestSameObject() {
        Assertions.assertEquals(cpk, cpk);
    }

    @Test
    void testEqualsTestNull() {
        Assertions.assertFalse(cpk.equals(null));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(Objects.hash("", "", ""), cpk.hashCode());
    }
}
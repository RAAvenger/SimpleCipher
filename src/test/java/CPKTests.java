import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Objects;

class CPKTests {
    private final CPK cpk;

    public CPKTests() {
        cpk = new CPK("", "", null);
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
import java.util.HashMap;
import java.util.Objects;

public class CPK {
    public String plainText;
    public String cipherText;
    public String key;

    public CPK(String cipherText, String plainText, String key) {
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CPK cpk = (CPK) o;
        return plainText.equals(cpk.plainText) && cipherText.equals(cpk.cipherText) && key.equals(cpk.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plainText, cipherText, key);
    }
}

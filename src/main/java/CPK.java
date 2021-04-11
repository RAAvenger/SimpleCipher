import java.util.HashMap;
import java.util.Objects;

public class CPK {
    public String plainText;
    public String cipherText;
    public String key;

    public CPK(String cipherText, String plainText, HashMap<Character, Character> key, boolean keyIsEncryptionKey) {
        if (key == null)
            key = new HashMap<>();
        this.plainText = plainText;
        this.cipherText = cipherText;
        this.key = keyToString(key, keyIsEncryptionKey);

    }

    protected String keyToString(HashMap<Character, Character> key, boolean orderIsKeyThenValue) {
        StringBuilder sb = new StringBuilder();
        for (char c : key.keySet()) {
            if (orderIsKeyThenValue) {
                sb.append(c);
                sb.append(key.get(c));
            } else {
                sb.append(key.get(c));
                sb.append(c);
            }
        }
        return sb.toString();
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

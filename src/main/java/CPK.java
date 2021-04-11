import java.util.HashMap;

public class CPK {
    private String plainText;
    private String cipherText;
    private String key;

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
}

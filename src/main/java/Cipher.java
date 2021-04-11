import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Cipher {
    protected String plainText;
    protected String cipherText;
    protected HashMap<Character, Character> key;

    protected Cipher() {
    }

    public static CPK encrypt(String plainText) {
        Cipher cipher = new Cipher();
        cipher.plainText = plainText;
        cipher.key = cipher.generateKey();
        cipher.cipherText = cipher.encryptPlainText();
        return new CPK(cipher.plainText, cipher.cipherText, cipher.key, true);
    }

    private HashMap<Character, Character> generateKey() {
        Alphabet alphabet = new Alphabet();
        List<Character> textChars = alphabet.ExtractTextCharacterList(this.plainText);
        List<Character> chars = alphabet.createCharacterList(textChars);
        Random random = new Random(new Date().getTime());
        HashMap<Character, Character> key = new HashMap<>();
        for (char character : textChars) {
            int index = random.nextInt(chars.size());
            key.put(character, chars.get(index));
            chars.remove(index);
        }
        return key;
    }

    protected String encryptPlainText() {
        StringBuilder cipherText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            cipherText.append(key.get(c));
        }
        return cipherText.toString();
    }

    public static CPK decrypt(String cipherText, String key) {
        Cipher cipher = new Cipher();
        cipher.cipherText = cipherText;
        cipher.key = cipher.extractKey(key);
        cipher.plainText = cipher.decryptCipherText();
        return new CPK(cipher.cipherText, cipher.plainText, cipher.key, false);
    }

    private HashMap<Character, Character> extractKey(String keyString) {
        HashMap<Character, Character> key = new HashMap<>();
        char[] keyChars = keyString.toCharArray();
        for (int i = 0; i < keyChars.length - 1; i += 2) {
            key.put(keyChars[i + 1], keyChars[i]);
        }
        return key;
    }

    protected String decryptCipherText() {
        StringBuilder plainText = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            plainText.append(key.get(c));
        }
        return plainText.toString();
    }
}

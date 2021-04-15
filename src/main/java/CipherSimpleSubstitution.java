import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CipherSimpleSubstitution implements Cipher {
    @Override
    public CPK encrypt(String plainText) {
        var key = generateEncryptionKey(plainText);
        var cipherText = replaceCharactersUsingKey(plainText, key);
        var keyString = keyToString(key);
        return new CPK(cipherText, plainText, keyString);
    }

    /**
     * Generate a random key for encryption.
     *
     * @return Map of character to character as encryption key.
     */
    private HashMap<Character, Character> generateEncryptionKey(String plainText) {
        Alphabet alphabet = new Alphabet();
        List<Character> textChars = alphabet.ExtractTextCharacterList(plainText);
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

    /**
     * Replace plainText characters with their sign using key.
     *
     * @return The given text that its characters replaced with their sign using key.
     */
    protected String replaceCharactersUsingKey(String plainText, HashMap<Character, Character> key) {
        StringBuilder cipherText = new StringBuilder();
        for (char c : plainText.toCharArray()) {
            cipherText.append(key.get(c));
        }
        return cipherText.toString();
    }

    protected String keyToString(HashMap<Character, Character> key) {
        StringBuilder sb = new StringBuilder();
        for (char c : key.keySet()) {
            sb.append(c);
            sb.append(key.get(c));
        }
        return sb.toString();
    }

    @Override
    public CPK decrypt(String cipherText, String keyString) {
        var key = extractDescriptionKey(keyString);
        var plainText = replaceCharactersUsingKey(cipherText, key);
        return new CPK(cipherText, plainText, keyString);
    }

    /**
     * Extract description key from encryption key string.
     *
     * @param keyString The encryption( output ) key.
     * @return Map of character to character as decryption key.
     */
    protected HashMap<Character, Character> extractDescriptionKey(String keyString) {
        HashMap<Character, Character> key = new HashMap<>();
        char[] keyChars = keyString.toCharArray();
        for (int i = 0; i < keyChars.length - 1; i += 2) {
            key.put(keyChars[i + 1], keyChars[i]);
        }
        return key;
    }
}

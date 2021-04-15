public interface Cipher {
    /**
     * Encrypt given text using new generated key.
     *
     * @param plainText The text to be encrypted.
     * @return A new CPK object containing plain text, cipher text and key.
     */
    CPK encrypt(String plainText);


    /**
     * Decrypt given text using given key.
     *
     * @param cipherText The text to decrypt.
     * @param key        The key to decrypt text with it.
     * @return A new CPK object containing plain text, cipher text and key.
     */
    CPK decrypt(String cipherText, String key);
}

public class CipherComplex implements Cipher {

    @Override
    public CPK encrypt(String plainText) {
        var cipherSimpleSubstitution = new CipherSimpleSubstitution();
        var substitutionEncodeResult = cipherSimpleSubstitution.encrypt(plainText);
        var cipherSimpleTransposition = new CipherSimpleTransposition();
        var transpositionEncodeResult = cipherSimpleTransposition.encrypt(substitutionEncodeResult.cipherText);
        var key = joinKeys(substitutionEncodeResult.key, transpositionEncodeResult.key);
        return new CPK(transpositionEncodeResult.cipherText, plainText, key);
    }

    /**
     * Join simple substitution encryption Key and simple transposition encryption Key and make a complex key.
     *
     * @param substitutionKey  Output key of encrypting by simple substitution cipher.
     * @param transpositionKey Output key of encrypting by simple transposition cipher
     * @return The complex key.
     */
    protected String joinKeys(String substitutionKey, String transpositionKey) {
        return transpositionKey + "," + substitutionKey;
    }

    @Override
    public CPK decrypt(String cipherText, String key) {
        var cipherSimpleTransposition = new CipherSimpleTransposition();
        var transpositionKey = extractTranspositionKey(key);
        var transpositionDecryptionResult = cipherSimpleTransposition.decrypt(cipherText, transpositionKey);
        var cipherSimpleSubstitution = new CipherSimpleSubstitution();
        var substitutionKey = extractSubstitutionKey(key);
        var substitutionDecryptionResult = cipherSimpleSubstitution.decrypt(transpositionDecryptionResult.plainText, substitutionKey);
        return new CPK(cipherText, substitutionDecryptionResult.plainText, key);
    }

    /**
     * Extract transposition key from complex key.
     *
     * @param key The complex key.
     * @return The transposition key.
     */
    protected String extractTranspositionKey(String key) {
        var separatorIndex = key.indexOf(',');
        return key.substring(0, separatorIndex);
    }

    /**
     * Extract substitution key from complex key.
     *
     * @param key The complex key.
     * @return The substitution key.
     */
    protected String extractSubstitutionKey(String key) {
        var separatorIndex = key.indexOf(',');
        return key.substring(separatorIndex + 1);
    }
}

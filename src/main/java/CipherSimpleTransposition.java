import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CipherSimpleTransposition implements Cipher {
    protected int pageSize;
    protected long key;

    @Override
    public CPK encrypt(String plainText) {
        pageSize = calculatePageSize(plainText.length());
        key = new Date().getTime();
        List<Integer> pageOrder = generateEncryptionPageOrder(plainText.length());
        String cipherText = textTransposition(plainText, pageOrder);
        return new CPK(cipherText, plainText, Long.toString(key));
    }

    /**
     * Calculate page size for given text.
     *
     * @param textLength Length of text that we want to calculate suitable page size for it.
     * @return A suitable page size for given text.
     */
    protected int calculatePageSize(int textLength) {
        for (int i = 3; ; i++)
            if (textLength % i == 0)
                return i;
    }

    /**
     * Generate a random page order for given text.
     *
     * @param textLength Length of the text that we want to generate page order for.
     * @return A page order for encrypting text.
     */
    protected List<Integer> generateEncryptionPageOrder(int textLength) {
        List<Integer> pageIndexes = new ArrayList<>();
        for (int i = 0; i < textLength / pageSize; i++)
            pageIndexes.add(i);
        Random random = new Random(key);
        List<Integer> orderedPageIndexes = new ArrayList<>();
        while (pageIndexes.size() != 0) {
            int i = random.nextInt(pageIndexes.size());
            int c = pageIndexes.get(i);
            pageIndexes.remove(i);
            orderedPageIndexes.add(c);
        }
        return orderedPageIndexes;
    }

    /**
     * Change order of text pages using page order.
     *
     * @param text      The text that we want to break it to pages and change order of the pages.
     * @param pageOrder New order of text pages.
     * @return new text created from given page using given page order.
     */
    protected String textTransposition(String text, List<Integer> pageOrder) {
        StringBuilder sb = new StringBuilder();
        for (Integer pageNumber : pageOrder) {
            int start = pageNumber * pageSize;
            int end = start + pageSize;
            sb.append(text, start, end);
        }
        return sb.toString();
    }

    @Override
    public CPK decrypt(String cipherText, String key) {
        pageSize = calculatePageSize(cipherText.length());
        this.key = Long.parseLong(key);
        List<Integer> pageOrder = generateEncryptionPageOrder(cipherText.length());
        pageOrder = generateDecryptionPageOrder(pageOrder);
        String plainText = textTransposition(cipherText, pageOrder);
        return new CPK(cipherText, plainText, key);
    }

    /**
     * Generate decryption page order from encryption page order.
     *
     * @param encryptionPageOrder The encryption page order that we want to change it to decryption page order.
     * @return decryption page order generated from encryption page order.
     */
    protected List<Integer> generateDecryptionPageOrder(List<Integer> encryptionPageOrder) {
        List<Integer> decryptPageOrder = new ArrayList<>();
        for (int i = 0; i < encryptionPageOrder.size(); i++) {
            decryptPageOrder.add(encryptionPageOrder.indexOf(i));
        }
        return decryptPageOrder;
    }
}

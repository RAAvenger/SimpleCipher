import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CipherSimpleTransposition {
    protected int pageSize;
    protected long key;

    public static CPK encrypt(String plainText) {
        CipherSimpleTransposition cipher = new CipherSimpleTransposition();
        cipher.pageSize = cipher.getPageSize(plainText);
        cipher.key = new Date().getTime();
        List<Integer> pageOrder = cipher.generateEncryptionPageOrder(plainText.length());
        String cipherText = cipher.textTransposition(plainText, pageOrder);
        return new CPK(cipherText, plainText, Long.toString(cipher.key));
    }

    protected int getPageSize(String text) {
        for (int i = 3; ; i++)
            if (text.length() % i == 0)
                return i;
    }

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

    protected String textTransposition(String plainText, List<Integer> pageOrder) {
        StringBuilder sb = new StringBuilder();
        for (Integer pageNumber : pageOrder) {
            int start = pageNumber * pageSize;
            int end = start + pageSize;
            sb.append(plainText, start, end);
        }
        return sb.toString();
    }

    public static CPK decrypt(String cipherText, String key) {
        CipherSimpleTransposition cipher = new CipherSimpleTransposition();
        cipher.pageSize = cipher.getPageSize(cipherText);
        cipher.key = Long.parseLong(key);
        List<Integer> pageOrder = cipher.generateEncryptionPageOrder(cipherText.length());
        pageOrder = cipher.generateDecryptionPageOrder(pageOrder);
        String plainText = cipher.textTransposition(cipherText, pageOrder);
        return new CPK(cipherText, plainText, key);
    }

    protected List<Integer> generateDecryptionPageOrder(List<Integer> encryptPageOrder) {
        List<Integer> decryptPageOrder = new ArrayList<>();
        for (int i = 0; i < encryptPageOrder.size(); i++) {
            decryptPageOrder.add(encryptPageOrder.indexOf(i));
        }
        return decryptPageOrder;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Alphabet {
    /**
     * Create list of characters.
     *
     * @param extraCharacters Extra characters that you like to add to the list.
     * @return List of characters containing default characters and given extra characters.
     */
    public List<Character> createCharacterList(List<Character> extraCharacters) {
        HashSet<Character> chars = new HashSet<>(this.createCharacterList());
        chars.addAll(extraCharacters);
        return new ArrayList<>(chars);
    }

    /**
     * Create list of default characters.
     *
     * @return List of default characters.
     */
    public List<Character> createCharacterList() {
        List<Character> chars = new ArrayList<>();
        addLowerCaseAlphabet(chars);
        addUpperCaseEnglishCharacters(chars);
        addOtherCharacters(chars);
        return chars.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Add lowercase english alphabet to list of characters.
     *
     * @param characters List of characters that we add english lowercase characters to it.
     */
    private void addLowerCaseAlphabet(List<Character> characters) {
        for (char character = 'a'; character <= 'z'; character++) {
            characters.add(character);
        }
    }

    /**
     * Add uppercase english alphabet to list of characters.
     *
     * @param characters List of characters that we add english uppercase characters to it.
     */
    private void addUpperCaseEnglishCharacters(List<Character> characters) {
        for (char character = 'A'; character <= 'Z'; character++) {
            characters.add(character);
        }
    }

    /**
     * Add non-alphabet characters to list of characters.
     *
     * @param characters List of characters that we add non-alphabet characters to it.
     */
    private void addOtherCharacters(List<Character> characters) {
        characters.addAll(Arrays.asList(' ', '.', ',', '_', '(', ')'));
    }


    /**
     * Extract all characters from given text.
     *
     * @param text The text that you want to extract its characters.
     * @return List of all text's characters.
     */
    public List<Character> ExtractTextCharacterList(String text) {
        HashSet<Character> chars = new HashSet<>();
        for (char c : text.toCharArray()) {
            chars.add(c);
        }
        return new ArrayList<>(chars).stream().sorted().collect(Collectors.toList());
    }
}

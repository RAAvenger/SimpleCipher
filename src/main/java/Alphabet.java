import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Alphabet {
    public List<Character> createCharacterList(List<Character> textCharacters) {
        HashSet<Character> chars = new HashSet<>(this.createCharacterList());
        chars.addAll(textCharacters);
        return new ArrayList<>(chars);
    }

    public List<Character> createCharacterList() {
        List<Character> chars = new ArrayList<>();
        addLowerCaseAlphabet(chars);
        addUpperCaseAlphabet(chars);
        addOtherCharacters(chars);
        return chars.stream().sorted().collect(Collectors.toList());
    }

    private void addLowerCaseAlphabet(List<Character> chars) {
        for (char character = 'a'; character <= 'z'; character++) {
            chars.add(character);
        }
    }

    private void addUpperCaseAlphabet(List<Character> chars) {
        for (char character = 'A'; character <= 'Z'; character++) {
            chars.add(character);
        }
    }

    private void addOtherCharacters(List<Character> chars) {
        chars.addAll(Arrays.asList(' ', '.', ',', '_', '(', ')'));
    }

    public List<Character> ExtractTextCharacterList(String text) {
        HashSet<Character> chars = new HashSet<>();
        for (char c : text.toCharArray()) {
            chars.add(c);
        }
        return new ArrayList<>(chars).stream().sorted().collect(Collectors.toList());
    }
}

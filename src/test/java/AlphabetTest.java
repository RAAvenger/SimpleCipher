import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AlphabetTest {
    private static Alphabet alphabet;
    private static List<Character> alphabetChars;

    @BeforeAll
    static void setup() {
        alphabet = new Alphabet();
        alphabetChars = Stream.of(
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z', ' ', '.', ',', '_', '(', ')'
        ).sorted().collect(Collectors.toList());
    }

    @Test
    void createCharacterListTestWithoutTextCharacters() {
        List<Character> expectedResult = alphabetChars;
        List<Character> testResult = alphabet.createCharacterList();
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void createCharacterListTestWithUniqueTextCharacters() {
        List<Character> expectedResult = new ArrayList<>(alphabetChars);
        List<Character> textCharacters = Arrays.asList('!', '@', '#', '$');
        expectedResult.addAll(textCharacters);
        expectedResult = expectedResult.stream().sorted().collect(Collectors.toList());
        List<Character> testResult = alphabet.createCharacterList(textCharacters);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void createCharacterListTestWithNotUniqueTextCharacters() {
        List<Character> expectedResult = new ArrayList<>(alphabetChars);
        List<Character> textCharacters = Arrays.asList('a', 'b', 'C', 'D');
        List<Character> testResult = alphabet.createCharacterList(textCharacters);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void extractTextCharacterListTestWithUniqueCharacters() {
        List<Character> expectedResult = Stream.of('h', 'i', 'H', 'o').sorted().collect(Collectors.toList());
        List<Character> testResult = alphabet.ExtractTextCharacterList("hiHo");
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void extractTextCharacterListTestWithNotUniqueCharacters() {
        List<Character> expectedResult = Stream.of('h', 'i', 'H', 'o').sorted().collect(Collectors.toList());
        List<Character> testResult = alphabet.ExtractTextCharacterList("hiHohiHo");
        Assertions.assertEquals(expectedResult, testResult);
    }
}
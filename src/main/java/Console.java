import java.text.Format;
import java.util.Scanner;

public class Console {
    private final Scanner scanner;

    public static void main(String[] args) {
        var console = new Console();
        System.out.println("Hello dear user!");
        try {
            var startEncodeRoutine = console.getUserChoice();
            if (startEncodeRoutine) {
                console.encodeRoutine(console);
            } else {
                console.decodeRoutine(console);
            }
        } catch (Exception exception) {
            System.out.println("Sorry something went wrong!");
        }
    }

    public Console() {
        scanner = new Scanner(System.in);
    }

    private boolean getUserChoice() {
        var userInput = "";
        do {
            System.out.println("What do you want to do?( 'encode' or 'e' / 'decode' or 'd' )");
            userInput = scanner.nextLine();
        } while (!userInput.equals("encode") && !userInput.equals("e") && !userInput.equals("decode") && !userInput.equals("d"));
        return userInput.startsWith("e");
    }

    private void encodeRoutine(Console console) {
        var plainText = console.getText("Plain text");
        var cipher = new CipherComplex();
        var result = cipher.encrypt(plainText);
        console.showCPK(result);
    }

    private String getText(String name) {
        var userInput = "";
        do {
            System.out.println(String.format("Write your %s:", name));
            userInput = scanner.nextLine();
        } while (userInput.isBlank());
        return userInput;
    }

    private void showCPK(CPK cpk) {
        System.out.println(String.format("Plain text is: %s", cpk.plainText));
        System.out.println(String.format("Cipher text is: %s", cpk.cipherText));
        System.out.println(String.format("Key is: %s", cpk.key));
        System.out.println("Keep your key safe!");
    }

    private void decodeRoutine(Console console) {
        var cipherText = console.getText("Cipher text");
        var key = console.getText("Key");
        var cipher = new CipherComplex();
        var result = cipher.decrypt(cipherText, key);
        console.showCPK(result);
    }
}

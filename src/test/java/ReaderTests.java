import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

class ReaderTests {
    private final static String directoryPath = "ReaderTestFiles";
    private final static String filePath = directoryPath + "/testFile.txt";

    @BeforeAll
    static void setUp() {
        try {
            File directory = new File(directoryPath);
            File file = new File(filePath);
            if (directory.mkdir() && file.createNewFile()) {
                FileWriter writer = new FileWriter(file);
                writer.write("this is test text!");
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void readFromFileTest() {
        String expectedResult = "this is test text!";
        String testResult = Reader.readFromFile(filePath);
        Assertions.assertEquals(expectedResult, testResult);
    }

    @Test
    void readFromFileTestInvalidPath() {
        String expectedResult = null;
        String testResult = Reader.readFromFile("bad path");
        Assertions.assertEquals(expectedResult, testResult);
    }

    @AfterAll
    static void tierDown() {
        File directory = new File(directoryPath);
        try {
            FileUtils.deleteDirectory(directory);
        } catch (Exception e) {
            System.out.println("tierDown failed");
            System.out.println(e.getMessage());
        }
    }
}
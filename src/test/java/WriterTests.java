import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class WriterTests {
    private final static String directoryPath = "WriterTestFiles";

    @BeforeAll
    static void setup() {
        File directory = new File(directoryPath);
        directory.mkdir();
    }

    @Test
    void writeToFileTest() {
        String expectedResult = "hi!";
        String path = directoryPath + "/WriteTestFile1";
        try {
            if (Writer.writeToFile(path, expectedResult)) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                String testResult = bufferedReader.readLine();
                bufferedReader.close();
                Assertions.assertEquals(expectedResult, testResult);
            } else
                throw new Exception("Writing failed!");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    void writeToFileTestFileAlreadyExists() {
        boolean expectedResult = false;
        String path = directoryPath + "/WriteTestFile2";
        try {
            if (Writer.writeToFile(path, "")) {
                boolean testResult = Writer.writeToFile(path, "");
                Assertions.assertEquals(expectedResult, testResult);
            } else
                throw new Exception("Writing failed!");
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @AfterAll
    static void tierDown() {
        File directory = new File(directoryPath);
        try {
            FileUtils.deleteDirectory(directory);
        } catch (Exception e) {
            System.out.println("tierDown failed!");
            System.out.println(e.getMessage());
        }
    }
}
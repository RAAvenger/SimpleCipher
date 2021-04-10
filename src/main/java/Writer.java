import java.io.File;
import java.io.FileWriter;

public class Writer {
    /**
     * Write your text to given file path.
     *
     * @param path Path to out file.
     * @param text The content to be written to file.
     * @return If writing was successful "true", otherwise "false".
     */
    public static boolean writeToFile(String path, String text) {
        FileWriter fileWriter = null;
        try {
            File file = new File(path);
            if (file.createNewFile()) {
                fileWriter = new FileWriter(file);
                fileWriter.write(text);
                fileWriter.close();
                return true;
            } else
                throw new Exception("File already exists!");
        } catch (Exception e) {
            System.out.print("Writing to \"" + path + "\" failed: \n\t");
            System.out.println(e.getMessage());
            return false;
        }
    }
}

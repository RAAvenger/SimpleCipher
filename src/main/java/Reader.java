import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Reader {
    /**
     * Read file in the given path.
     *
     * @param path Path to the file.
     * @return If path is valid return file's text, otherwise null.
     */
    public static String readFromFile(String path) {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            fileReader.close();
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.print("Reading from \"" + path + "\" failed: \n\t");
            System.out.println(e.getMessage());
            return null;
        }
    }
}

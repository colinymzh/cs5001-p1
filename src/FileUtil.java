import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Read the file and create a String array that store each of the paragraph.
 *
 * @author 230028529
 * @version 1.0
 * @since 19/09/2023 21:16
 */
public class FileUtil {

    private ArrayList<String> content = new ArrayList<String>();
    /**
     * Reads the content of the specified file and returns it as an array of strings,
     * with each string representing a line in the file.
     * This method utilizes the {@code FileUtil} utility class to handle file reading operations.
     *
     * @param filename the name or path of the file to be read.
     * @return an array of strings representing the content of the file, split by line.
     */

    public static String[] readFile(String filename) {
        FileUtil fileUtil = new FileUtil();
        return fileUtil.readAndReturnFileContent(filename);
    }

    private String[] readAndReturnFileContent(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bfr = new BufferedReader(fr);
            String eachParagraph = "";
            while ((eachParagraph = bfr.readLine()) != null) {
                content.add(eachParagraph);
            }
            return content.toArray(new String[content.size()]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Oops: " + e.getMessage());
        } finally {
            if (content.isEmpty()) {
                content.add("");
            }
        }
        String[] str = new String[0];
        return content.toArray(str);
    }

}

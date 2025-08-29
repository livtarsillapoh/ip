package java.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class of helper functions used across other classes
 */
public class HelperFunctions {

    /**
     * Removes the first word and first space or an empty string if no space is found
     * @param string
     * @return string without first word and space
     */
    public static String removeFirstWord(String string) {
        int i = string.indexOf(" ");
        if (i != -1) {
            return string.substring(i + 1).trim();  // Trim to handle any extra spaces
        }
        return "";  // Return empty string if no space is found
    }

    /**
     * Uses a FileWriter object to write to a file
     * @param filePath
     * @param textToAdd
     * @throws IOException
     */
    private static void writeToFile(String filePath, String textToAdd) throws IOException {
        File f = new File(filePath);
        File parent = f.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        if (!f.exists()) {
            f.createNewFile();
        }
        FileWriter fw = new FileWriter(f, true); // append mode
        fw.write(textToAdd);
        fw.close();
    }


}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class implementing the TextAlignerStrategy interface to
 * provide right-aligned text.
 *
 * @author 230028529
 * @version 2.0
 * @since 21/09/2023 21:58
 */

public class RightAligner implements TextAlignerStrategy {

    /**
     * Aligns the given paragraph to the right.
     *
     * @param paragraph   The input paragraph to be aligned
     * @param lineLength  The maximum number of characters in a line
     * @return A string representation of the right-aligned paragraph
     */
    @Override
    public String align(String paragraph, int lineLength) {

        String alignedText = "";
        String currentLine = "";
        Queue<String> wordsQueue = new LinkedList<>(Arrays.asList(paragraph.split(" ")));

        // Process words until the queue is empty
        while (wordsQueue.size() > 0) {
            String word = wordsQueue.remove();

            // If exceeds the line length
            if (currentLine.length() + word.length() > lineLength) {
                // Calculate the number of spaces required
                int spaceCount = lineLength - currentLine.trim().length();
                String spaces = "";
                for (int i = 0; i < spaceCount; i++) {
                    spaces = spaces + " ";
                }

                // Add the spaces at the beginning of the line to achieve right alignment
                alignedText = alignedText + spaces + currentLine.trim() + "\n";
                currentLine = "";
            }

            currentLine = currentLine + word + " ";
        }

        // Process the last line
        if (currentLine.length() > 0) {
            int spaceCount = lineLength - currentLine.trim().length();
            String spaces = "";
            for (int i = 0; i < spaceCount; i++) {
                spaces = spaces + " ";
            }
            alignedText = alignedText + spaces + currentLine.trim();
        }

        return alignedText;
    }
}

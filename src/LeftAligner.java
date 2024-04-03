import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The {@code LeftAligner} class implements the {@code TextAlignerStrategy} interface
 * and make the text left-align based on the specified line length.
 *
 * @author 230028529
 * @version 1.0
 * @since 21/09/2023 21:57
 */


public class LeftAligner implements TextAlignerStrategy {

    /**
     * Aligns the given paragraph to the left based on the specified line length.
     *
     * @param paragraph the text to be left-aligned
     * @param lineLength the maximum characters a line can have
     * @return A string representation of the left-aligned paragraph
     */

    @Override
    public String align(String paragraph, int lineLength) {
        // Final aligned text
        String alignedText = "";

        // Temporarily store the current line
        String currentLine = "";

        // Split the paragraph into individual words using space split
        Queue<String> wordsQueue = new LinkedList<>(Arrays.asList(paragraph.split(" ")));

        // Process words until the queue is empty
        while (wordsQueue.size() > 0) {
            String word = wordsQueue.poll();
            // If exceed the allowed line length
            if (currentLine.length() + word.length() > lineLength) {
                // Append the current line to the aligned text and add a new line
                alignedText = alignedText + currentLine.trim() + "\n";
                // Reset
                currentLine = "";
            }

            // If not exceed, add the word into current line
            currentLine = currentLine + word + " ";
        }

        // Handle the last line
        if (currentLine.length() > 0) {
            alignedText = alignedText + currentLine.trim();
        }

        return alignedText;
    }

}

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of the TextAlignerStrategy interface for center-aligned text formatting.
 *
 * @author 230028529
 * @version 3.0
 * @since 21/09/2023 22:00
 */

public class CenterAligner implements TextAlignerStrategy {

    /**
     * Aligns the given paragraph to the center.
     *
     * @param paragraph   The input paragraph to be aligned
     * @param lineLength  The maximum number of characters in a line
     * @return A string representation of the center-aligned paragraph
     */
    @Override
    public String align(String paragraph, int lineLength) {
        String alignedText = "";
        String currentLine = "";
        Queue<String> wordsQueue = new LinkedList<>(Arrays.asList(paragraph.split(" ")));

        // Process words until the queue is empty
        while (!wordsQueue.isEmpty()) {
            String word = wordsQueue.peek();

            if (currentLine.length() + word.length() <= lineLength) {
                currentLine = currentLine + wordsQueue.remove() + " ";
            } else {
                if (!currentLine.trim().isEmpty()) {
                    // Center align the current line first
                    int totalSpaceCount = lineLength - currentLine.trim().length();
                    int rightSpacesCount = totalSpaceCount / 2;
                    int leftSpacesCount = totalSpaceCount - rightSpacesCount;
                    String leftSpaces = String.join("", Collections.nCopies(leftSpacesCount, " "));
                    String rightSpaces = String.join("", Collections.nCopies(rightSpacesCount, " "));
                    alignedText = alignedText + leftSpaces + currentLine.trim() + rightSpaces + "\n";
                    currentLine = "";
                }

                // Then, handle the long word if it's longer than lineLength
                if (word.length() > lineLength) {
                    alignedText = alignedText + wordsQueue.remove() + "\n";
                    continue;
                }
            }
        }

        // Process the last line
        if (!currentLine.trim().isEmpty()) {
            int totalSpaceCount = lineLength - currentLine.trim().length();
            int rightSpacesCount = totalSpaceCount / 2;
            int leftSpacesCount = totalSpaceCount - rightSpacesCount;
            String leftSpaces = String.join("", Collections.nCopies(leftSpacesCount, " "));
            String rightSpaces = String.join("", Collections.nCopies(rightSpacesCount, " "));
            alignedText = alignedText + leftSpaces + currentLine.trim() + rightSpaces;
        }

        return alignedText;
    }

}

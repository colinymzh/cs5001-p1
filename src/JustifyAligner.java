/**
 * Provides an implementation of the {@code TextAlignerStrategy} interface for
 * justified-aligned text formatting, ensuring even spacing between words across each line.
 *
 * @author 230028529
 * @version 8.0
 * @since 21/09/2023
 */

public class JustifyAligner implements TextAlignerStrategy {

    /**
     * Aligns the given paragraph with justified alignment.
     *
     * @param paragraph   The input paragraph to be aligned
     * @param lineLength  The maximum number of characters in a line
     * @return A string representation of the justified-aligned paragraph
     */
    @Override
    public String align(String paragraph, int lineLength) {
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();

        // Splitting the paragraph into individual words
        String[] words = paragraph.split(" ");

        // Iterating over each word in the paragraph
        for (String word : words) {
            // While there's any portion of the word left to process
            while (!word.isEmpty()) {
                // If the current word (with a space) fits in the remaining space of the current line
                if (currentLine.length() + word.length() <= lineLength) {
                    currentLine.append(word).append(" ");
                    break;
                } else {
                    // Calculate the remaining space on the current line
                    int remainingSpace = lineLength - currentLine.length();
                    // If there's more than one character of space left
                    if (remainingSpace > 1) {
                        currentLine.append(word.substring(0, remainingSpace - 1)).append("-");
                        word = word.substring(remainingSpace - 1);
                    }
                    // Add the current line to the result and move to the next line
                    result.append(currentLine.toString().trim()).append("\n");
                    currentLine.setLength(0);
                }
            }
        }

        // Handle the last line
        if (currentLine.length() > 0) {
            result.append(currentLine.toString().trim());
        }

        return result.toString();
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * This class provides functionality to align text paragraphs from a file.
 * This class leverages the strategy pattern via the {@code ParagraphAligner}
 * and {@code TextAlignerStrategy} implementations.
 *
 * @author 230028529
 * @version 1.0
 * @since 19/09/2023 21:17
 */
public class TextAligner {
    private ParagraphAligner paragraphAligner;
    private int lineLength;

    /**
     * Initializes a new instance of the {@code TextAligner} with a specified line length.
     *
     * @param lineLength The maximum length of a line in characters
     */
    public TextAligner(int lineLength) {
        this.lineLength = lineLength;
        this.paragraphAligner = new ParagraphAligner(lineLength);
    }

    /**
     * Aligns all the paragraphs from the specified file.
     *
     * @param filename       The path of the file
     * @param alignmentType  The type of alignment to apply
     * @return A string array containing aligned paragraphs
     */
    public String[] alignTextFromFile(String filename, AlignmentType alignmentType) {
        // Read paragraphs from the file using FileUtil class
        String[] paragraphs = FileUtil.readFile(filename);
        List<String> alignedParagraphs = new ArrayList<>();

        for (String paragraph : paragraphs) {
            // Align each paragraph using the ParagraphAligner
            String alignedParagraph = paragraphAligner.align(paragraph, alignmentType);
            alignedParagraphs.add(alignedParagraph);
        }

        // Convert the list of aligned paragraphs to an array and return
        return alignedParagraphs.toArray(new String[alignedParagraphs.size()]);
    }
}

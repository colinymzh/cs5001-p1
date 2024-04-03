/**
 * This class is responsible for aligning a given paragraph
 * based on the specified alignment type.
 *
 * @author 230028529
 * @version 6.0
 * @since 19/09/2023 23:56
 */

public class ParagraphAligner {

    /** The maximum length for a line in the paragraph. */
    private int lineLength;

    /**
     * Constructs a new {@code ParagraphAligner} with the specified line length.
     *
     * @param lineLength the maximum number of characters in a line.
     */
    public ParagraphAligner(int lineLength) {
        this.lineLength = lineLength;
    }

    /**
     * Aligns the given paragraph based on the specified alignment type.
     *
     * @param paragraph The paragraph to be aligned
     * @param alignmentType The type of alignment to be applied
     * @return The aligned paragraph
     */
    public String align(String paragraph, AlignmentType alignmentType) {
        return alignmentType.getStrategy().align(paragraph, lineLength);
    }

}

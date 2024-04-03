/**
 * Enum representing different text alignment types and
 * each alignment type has a corresponding strategy.
 *
 * @author 230028529
 * @version 3.0
 * @since 19/09/2023 21:17
 */

public enum AlignmentType {
    /**
     * Represents left-aligned text formatting.
     */
    LEFT(new LeftAligner()),
    /**
     * Represents right-aligned text formatting.
     */
    RIGHT(new RightAligner()),
    /**
     * Represents center-aligned text formatting.
     */
    CENTER(new CenterAligner()),
    /**
     * Represents justified-aligned text formatting.
     */
    JUSTIFY(new JustifyAligner());
    private TextAlignerStrategy strategy;

    AlignmentType() {

    }

    AlignmentType(TextAlignerStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets the alignment strategy.
     *
     * @param strategy the {@code TextAlignerStrategy} instance to be set.
     */
    public void setStrategy(TextAlignerStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Retrieve the text alignment strategy associated with this alignment type.
     *
     * @return The associated text alignment strategy
     */
    public TextAlignerStrategy getStrategy() {
        return this.strategy;
    }
}

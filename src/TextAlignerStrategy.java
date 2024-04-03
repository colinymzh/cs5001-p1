/**
 * Interface of 4 text alignment methods.
 *
 * @author 230028529
 * @version 1.0
 * @since 21/09/2023 21:59
 */
interface TextAlignerStrategy {
    String align(String paragraph, int lineLength);
}

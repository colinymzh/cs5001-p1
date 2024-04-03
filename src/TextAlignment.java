/**
 * This class provides a command-line interface to align text paragraphs
 * from a given file based on specified alignment type (LEFT, RIGHT, CENTER, JUSTIFY) and line length.
 * Usage: java TextAlignment <filename> <alignmentType> <lineLength>
 * Where:
 *   {@code <filename>} is the path to the input file containing the text paragraphs
 *   {@code <alignmentType>} can be one of: left, right, center, or justify
 *   {@code <lineLength>} is the maximum length of a line in characters
 *
 * @author 230028529
 * @version 3.0
 * @since 19/09/2023 21:11
 */


public class TextAlignment {
    /**
     * Entry point for the text alignment application.
     * This program reads text from a specified file and aligns it based on the provided
     * alignment type and line length. The accepted alignment types are "left", "right",
     * "center" (or "centre"), and "justify".
     * {@code filename} - Name of the file containing the text to be aligned.
     * {@code alignment_type} - Type of alignment to be applied. Accepted values: "left", "right", "center"/"centre", "justify".
     * {@code line_length} - Maximum number of characters per line in the aligned output.
     * If the command line arguments are invalid or incorrect, a usage message will be displayed.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Check for correct number of command line arguments
        if (args.length != 3) {
            printUsage();
            return;
        }

        // Parse command line arguments
        String filename = args[0];
        String alignmentTypeStr = args[1].toLowerCase();
        int lineLength;

        // Try to parse the lineLength argument to an integer
        try {
            lineLength = Integer.parseInt(args[2]);
            // Ensure line length is positive
            if (lineLength <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            // In case of invalid line length
            printUsage();
            return;
        }

        AlignmentType alignmentType;
        // Determine alignment type from the provided argument
        switch (alignmentTypeStr) {
            case "left":
                alignmentType = AlignmentType.LEFT;
                break;
            case "right":
                alignmentType = AlignmentType.RIGHT;
                break;
            case "center":
                alignmentType = AlignmentType.CENTER;
                break;
            case "centre":
                alignmentType = AlignmentType.CENTER;
                break;
            case "justify":
                alignmentType = AlignmentType.JUSTIFY;
                break;
            default:
                // In case of invalid alignment type
                printUsage();
                return;
        }

        // Create a new TextAligner instance and get the aligned text
        TextAligner textAligner = new TextAligner(lineLength);
        String[] alignedText = textAligner.alignTextFromFile(filename, alignmentType);

        for (int i = 0; i < alignedText.length; i++) {
            System.out.println(alignedText[i]);
        }
    }

    /**
     * A method to print the correct usage of the program to the console.
     *
     */
    private static void printUsage() {
        System.out.println("usage: java TextAlignment <filename> <alignmentType> <lineLength>");
    }
}

# TextAlignment Tool

This tool provides a command-line interface for aligning text paragraphs from a given file based on specified alignment type and line length.



## Classes and Interfaces Overview

### 1. `TextAlignment` class:

**Description**: Main entry point for the program. It provides the command-line interface to align text paragraphs from an input file.

**Usage**:

```java
java TextAlignment <filename> <alignmentType> <lineLength>
```

Where:

- `<filename>`: Path to the input file containing the text paragraphs.
- `<alignmentType>`: Can be one of the following: `left`, `right`, `center/centre`, or `justify`.
- `<lineLength>`: Maximum length of a line in characters.

### 2. `Alignment Type` class:

**Description**: An enum representing different text alignment types. Each alignment type has its own corresponding alignment strategy.

### 3. `FileUtil` class:

**Description**: Utilities to read the file and produce a String array, with each element storing an individual paragraph from the file.

### 4. `ParagraphAligner` class:

**Description**: Responsible for aligning individual paragraphs based on the specified alignment type.

### 5. `TextAligner` class:

**Description**: Align entire text paragraphs sourced from a file. This class works with `ParagraphAligner` and adheres to the `TextAlignerStrategy` implementations.

### 6. `TextAlignerStrategy` Interface:

**Description**: A strategy interface for aligning text. The following classes implement this interface to provide specific alignment types:

- `LeftAligner`: Aligns text to the left.
- `RightAligner`: Aligns text to the right.
- `CenterAligner`: Centers the text.
- `JustifyAligner`: Justifies the text, ensuring even spacing between words.

## How to use

1. Compile all the classes.
2. Run the `TextAlignment` class from the command line with appropriate arguments.
3. View the aligned text output.
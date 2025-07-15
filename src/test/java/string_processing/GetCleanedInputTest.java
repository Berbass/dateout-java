package test.java.string_processing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static utils.StringProcessing.getCleanedInput;

class GetCleanedInputTest {
    @Test
    void testCleaningMultipleSpaces() {
        // Test the getCleanedInput method
        String input = "  Hello   World!  ";
        String expectedOutput = "Hello World!";

        String actualOutput = getCleanedInput(input);

        assertEquals(expectedOutput, actualOutput, "The cleaned input should match the expected output.");
    }

    @Test
    void testCleaningHyphensAndUnderscores() {
        // Test the getCleanedInput method with hyphens and underscores
        String input = "Hello-World_Example";
        String expectedOutput = "Hello World Example";

        String actualOutput = getCleanedInput(input);

        assertEquals(expectedOutput, actualOutput, "The cleaned input should match the expected output.");
    }

    @Test
    void testCleaningSlashes() {
        // Test the getCleanedInput method with slashes
        String input = "Hello/World/Example";
        String expectedOutput = "Hello World Example";

        String actualOutput = getCleanedInput(input);

        assertEquals(expectedOutput, actualOutput, "The cleaned input should match the expected output.");
    }

    @Test
    void testCleaningDotsAndCommas() {
        // Test the getCleanedInput method with dots and commas
        String input = "Hello. World,Example";
        String expectedOutput = "Hello World Example";

        String actualOutput = getCleanedInput(input);

        assertEquals(expectedOutput, actualOutput, "The cleaned input should match the expected output.");
    }
}

package utils;

public class StringProcessing {
    public static String getCleanedInput(String input) {
        // Remove leading and trailing whitespace
        String cleanedInput = input.trim();

        // Replece multiple spaces, -, _, and / with a single space
        cleanedInput = cleanedInput.replaceAll("[\\s\\-_\\/,\\.]+", " ");

        return cleanedInput;
    }
}

/**
 * ====================================================
 * MAIN CLASS - UseCase10PalindromeCheckerApp
 * ====================================================
 *
 * Use Case 10: Case-Insensitive & Space-Ignored Palindrome
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string by removing non-alphanumeric characters
 * and converting to lowercase.
 *
 * Normalization includes:
 * - Removing spaces and symbols
 * - Converting to lowercase
 *
 * Example:
 * "A man a plan a canal Panama" -> "amanaplanacanalpanama" -> palindrome
 *
 * @author Developer
 * @version 10.0
 */

public class UseCase10PalindromeCheckerApp {

    /**
     * Normalize the input by removing non-alphanumeric characters and
     * converting to lowercase, then check palindrome using two-pointer.
     *
     * @param input original string
     * @return true if normalized input is palindrome
     */
    public static boolean isPalindromeNormalized(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("      UC10 - NORMALIZED (CASE-INSENSITIVE + SPACE-IGNORED)");
        System.out.println("====================================================");
        System.out.println();

        String input = "A man a plan a canal Panama";
        boolean result = isPalindromeNormalized(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println();

        // Additional tests
        String[] tests = {
            "No lemon, no melon",
            "Was it a car or a cat I saw",
            "Hello World",
            "RaceCar",
            "",
            null
        };

        for (String t : tests) {
            System.out.println("Input : " + t + " | palindrome? " + isPalindromeNormalized(t));
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println("Application completed UC10.");
        System.out.println("====================================================");
    }
}

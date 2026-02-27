/**
 * ====================================================
 * MAIN CLASS - UseCase11PalindromeCheckerApp
 * ====================================================
 *
 * Use Case 11: Object-Oriented Palindrome Service
 *
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design. The palindrome logic is
 * encapsulated inside a `PalindromeService` class.
 *
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 *
 * @author Developer
 * @version 11.0
 */

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("      UC11 - OBJECT-ORIENTED PALINDROME SERVICE");
        System.out.println("====================================================");
        System.out.println();

        PalindromeService service = new PalindromeService();

        String input = "racecar";
        boolean result = service.checkPalindrome(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result);
        System.out.println();

        String[] tests = {"madam", "hello", "level", "world", "radar"};
        for (String t : tests) {
            System.out.println("Input : " + t + " | palindrome? " + service.checkPalindrome(t));
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println("Application completed UC11.");
        System.out.println("====================================================");
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome using
     * an internal character array (two-pointer technique).
     *
     * @param input input string
     * @return true if palindrome, false otherwise
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        int start = 0;
        int end = input.length() - 1;
        char[] chars = input.toCharArray();

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

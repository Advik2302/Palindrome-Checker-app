/**
 * ====================================================
 * PALINDROME CHECKER APPLICATION
 * ====================================================
 *
 * Main Application Class: PalindromeCheckerApp
 *
 * Description:
 * This class serves as the entry point for the
 * Palindrome Checker Application. It demonstrates
 * core Java fundamentals and data structure concepts.
 *
 * Multiple Use Cases are implemented in this single class:
 * 1. UC1 - Application Entry & Welcome Message
 * 2. UC2 - Hardcoded Palindrome Check
 * 3. UC3 - User Input Palindrome Check
 * (More use cases to be added...)
 *
 * @author Developer
 * @version 2.0
 */

public class PalindromeCheckerApp {

    /**
     * ====================================================
     * UC1 - APPLICATION ENTRY & WELCOME MESSAGE
     * ====================================================
     * 
     * Goal: Display a welcome message and app details at startup
     * 
     * Actor: User
     * 
     * Flow:
     * 1. Program starts
     * 2. JVM invokes the main() method
     * 3. Application name is displayed
     * 4. Application version is displayed
     * 5. Program continues to next use case or exits
     * 
     * Key Concepts:
     * - Class: Acts as a container for application logic
     * - Main Method: Entry point with signature
     *   public static void main(String[] args)
     * - Static Keyword: Allows JVM to invoke main() without 
     *   creating an object
     * - Console Output: System.out.println() displays messages
     */

    /**
     * ====================================================
     * UC2 - HARDCODED PALINDROME VALIDATION
     * ====================================================
     * 
     * Goal: Display whether a hardcoded string is a palindrome
     * 
     * Actor: User
     * 
     * Flow:
     * 1. Program starts
     * 2. Hardcoded string is checked
     * 3. Result is printed
     * 4. Program exits
     * 
     * Key Concepts:
     * - String: Built-in Java class to store and manipulate textual data
     * - String Literal: Text enclosed within double quotes ("madam")
     * - Conditional Statement (if-else): Evaluates palindrome condition
     * - Loop: Compares characters from both ends of the string
     * - Comparison Logic: Checks if characters match symmetrically
     * 
     * Data Structure: String
     */

    /**
     * Helper method to check if a string is a palindrome.
     *
     * A palindrome is a word that reads the same forwards and backwards.
     * Example: "madam", "racecar", "noon"
     *
     * Algorithm:
     * - Compare characters from both ends moving towards the center
     * - Loop only till half the string length
     * - If any character mismatch found, return false
     * - If all characters match, return true
     *
     * @param input The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String input) {
        // Loop only till half of the string length
        for (int i = 0; i < input.length() / 2; i++) {
            // Compare character from start with character from end
            // Character from start: input.charAt(i)
            // Character from end: input.charAt(input.length() - 1 - i)
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;  // Characters don't match, not a palindrome
            }
        }
        return true;  // All characters matched, it's a palindrome
    }

    /**
     * Application entry point.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // ========== UC1: APPLICATION ENTRY & WELCOME MESSAGE ==========
        // Display the application header
        System.out.println("====================================================");
        System.out.println("      PALINDROME CHECKER APPLICATION");
        System.out.println("====================================================");
        System.out.println();
        
        // Display welcome message
        System.out.println("Welcome to the Palindrome Checker!");
        System.out.println();
        
        // Display application details
        System.out.println("Application Name: Palindrome Checker App");
        System.out.println("Version: 2.0");
        System.out.println("Author: Developer");
        System.out.println("Batch: B1P17");
        System.out.println("Registration No: RA2411026010336");
        System.out.println();
        
        // ========== UC2: HARDCODED PALINDROME VALIDATION ==========
        System.out.println("====================================================");
        System.out.println("      UC2 - HARDCODED PALINDROME VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        // Define a hardcoded string to check
        String input = "madam";
        
        // Call the helper method to check if it's a palindrome
        boolean result = isPalindrome(input);
        
        // Display the result
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? " + result);
        System.out.println();
        
        // Additional test cases
        System.out.println("====== Additional Test Cases ======");
        
        String[] testCases = {"racecar", "hello", "noon", "world", "level"};
        
        for (String testWord : testCases) {
            boolean isPalin = isPalindrome(testWord);
            System.out.println("Input text: " + testWord + " | Is it a Palindrome? " + isPalin);
        }
        
        System.out.println();
        
        // Display footer
        System.out.println("====================================================");
        System.out.println("Application completed successfully!");
        System.out.println("====================================================");
    }
}

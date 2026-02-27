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
 * @version 1.0
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
     * Application entry point.
     *
     * This is the first method executed by the JVM
     * when the program starts.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
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
        System.out.println("Version: 1.0");
        System.out.println("Author: Developer");
        System.out.println("Batch: B1P17");
        System.out.println("Registration No: RA2411026010336");
        System.out.println();
        
        // Display footer
        System.out.println("====================================================");
        System.out.println("Application started successfully!");
        System.out.println("====================================================");
    }
}

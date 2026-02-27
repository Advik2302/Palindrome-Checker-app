/**
 * ====================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ====================================================
 *
 * Use Case 12: Strategy Pattern For Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete StackStrategy
 * - Implements a concrete DequeStrategy
 * - Injects the strategy at runtime
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 * The goal is to teach extractable algorithm design.
 *
 * @author Developer
 * @version 12.0
 */

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("      UC12 - STRATEGY PATTERN FOR ALGORITHMS");
        System.out.println("====================================================");
        System.out.println();

        String input = "level";

        // ===== Using Stack Strategy =====
        System.out.println("--- Using Stack Strategy ---");
        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeChecker checker1 = new PalindromeChecker(stackStrategy);
        boolean result1 = checker1.check(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result1);
        System.out.println();

        // ===== Using Deque Strategy =====
        System.out.println("--- Using Deque Strategy ---");
        PalindromeStrategy dequeStrategy = new DequeStrategy();
        PalindromeChecker checker2 = new PalindromeChecker(dequeStrategy);
        boolean result2 = checker2.check(input);
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + result2);
        System.out.println();

        // ===== Test with multiple inputs =====
        System.out.println("--- Testing with multiple inputs (Stack Strategy) ---");
        String[] tests = {"madam", "hello", "racecar", "world"};
        for (String t : tests) {
            System.out.println("Input : " + t + " | palindrome? " + checker1.check(t));
        }

        System.out.println();
        System.out.println("--- Testing with multiple inputs (Deque Strategy) ---");
        for (String t : tests) {
            System.out.println("Input : " + t + " | palindrome? " + checker2.check(t));
        }

        System.out.println();
        System.out.println("====================================================");
        System.out.println("Application completed UC12.");
        System.out.println("====================================================");
    }
}

/**
 * ====================================================
 * INTERFACE - PalindromeStrategy
 * ====================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {
    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input the string to validate
     * @return true if palindrome, false otherwise
     */
    boolean check(String input);
}

/**
 * ====================================================
 * CLASS - StackStrategy
 * ====================================================
 *
 * This class provides a Stack based implementation
 * of the PalindromeStrategy interface.
 *
 * It uses LIFO behavior to reverse characters
 * and compare them with the original sequence.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using stack.
     *
     * @param input input String to validate
     * @return true if palindrome, false otherwise
     */
    @Override
    public boolean check(String input) {
        if (input == null) return false;

        // Create a stack to store characters
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push each character of the input string onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop characters from the stack and compare with original sequence
        for (char c : input.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }

        return true;
    }
}

/**
 * ====================================================
 * CLASS - DequeStrategy
 * ====================================================
 *
 * This class provides a Deque (Double Ended Queue)
 * based implementation of the PalindromeStrategy interface.
 *
 * Characters are added to deque and compared by
 * removing from both ends until fewer than two elements remain.
 */
class DequeStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using deque.
     *
     * @param input input String to validate
     * @return true if palindrome, false otherwise
     */
    @Override
    public boolean check(String input) {
        if (input == null) return false;

        // Create a deque to store characters
        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        // Add each character to the deque
        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        // Compare characters removed from both ends
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

/**
 * ====================================================
 * CLASS - PalindromeChecker
 * ====================================================
 *
 * This class acts as the context in the Strategy Pattern.
 * It holds a reference to a PalindromeStrategy and
 * delegates the checking logic to the strategy.
 *
 * The strategy can be injected at construction time.
 */
class PalindromeChecker {

    private PalindromeStrategy strategy;

    /**
     * Constructor that injects the strategy.
     *
     * @param strategy the PalindromeStrategy to use
     */
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sets a new strategy (allows runtime switching).
     *
     * @param strategy the new PalindromeStrategy
     */
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Delegates the palindrome check to the injected strategy.
     *
     * @param input string to check
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {
        return strategy.check(input);
    }
}

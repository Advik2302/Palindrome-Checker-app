/**
 * ====================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ====================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of different palindrome validation
 * algorithms. It uses System.nanoTime() to capture
 * precise execution times.
 *
 * At this stage, the application:
 * - Runs a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("      UC13 - PERFORMANCE COMPARISON");
        System.out.println("====================================================");
        System.out.println();

        // Test string
        String input = "racecar";
        int iterations = 100000;

        System.out.println("Input: " + input);
        System.out.println("Iterations: " + iterations);
        System.out.println();

        // Create strategy implementations
        PalindromeStrategy simpleStrategy = new SimpleStrategy();
        PalindromeStrategy stackStrategy = new StackStrategyV2();
        PalindromeStrategy dequeStrategy = new DequeStrategyV2();

        // Benchmark each strategy
        System.out.println("===== BENCHMARKING RESULTS =====");
        System.out.println();

        benchmarkStrategy("Simple Two-Pointer Strategy", simpleStrategy, input, iterations);
        benchmarkStrategy("Stack-Based Strategy", stackStrategy, input, iterations);
        benchmarkStrategy("Deque-Based Strategy", dequeStrategy, input, iterations);

        System.out.println();
        System.out.println("====================================================");
        System.out.println("Application completed UC13.");
        System.out.println("====================================================");
    }

    /**
     * Benchmarks a palindrome strategy by running it
     * multiple times and measuring total execution time.
     *
     * @param strategyName name of the strategy
     * @param strategy the PalindromeStrategy to benchmark
     * @param input test input string
     * @param iterations number of times to run
     */
    private static void benchmarkStrategy(
        String strategyName,
        PalindromeStrategy strategy,
        String input,
        int iterations
    ) {
        // Capture start time in nanoseconds
        long startTime = System.nanoTime();

        // Run the strategy multiple times
        for (int i = 0; i < iterations; i++) {
            strategy.check(input);
        }

        // Capture end time in nanoseconds
        long endTime = System.nanoTime();

        // Calculate total execution duration
        long durationNanos = endTime - startTime;
        double durationMillis = durationNanos / 1_000_000.0;
        double durationSeconds = durationMillis / 1_000.0;

        // Display benchmarking results
        System.out.println("Strategy: " + strategyName);
        System.out.println("  Total Time: " + durationNanos + " ns");
        System.out.println("  Total Time: " + durationMillis + " ms");
        System.out.println("  Total Time: " + durationSeconds + " s");
        System.out.println("  Avg Time per call: " + (durationNanos / (double) iterations) + " ns");
        System.out.println();
    }
}

/**
 * ====================================================
 * INTERFACE - PalindromeStrategy
 * ====================================================
 *
 * Defines contract for palindrome checking algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * ====================================================
 * CLASS - SimpleStrategy
 * ====================================================
 *
 * Implements palindrome validation using simple
 * two-pointer technique without extra data structures.
 * This is typically the fastest approach.
 */
class SimpleStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

/**
 * ====================================================
 * CLASS - StackStrategyV2
 * ====================================================
 *
 * Implements palindrome validation using a Stack.
 * Typically slower due to object allocation and LIFO operations.
 */
class StackStrategyV2 implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

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
 * CLASS - DequeStrategyV2
 * ====================================================
 *
 * Implements palindrome validation using a Deque.
 * Performance sits between simple two-pointer and stack.
 */
class DequeStrategyV2 implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;

        java.util.Deque<Character> deque = new java.util.ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

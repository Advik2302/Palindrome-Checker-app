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
 * 3. UC3 - Reverse String Palindrome Check
 * 4. UC4 - Character Array Palindrome Check
 * 5. UC5 - Stack Based Palindrome Check
 * 6. UC6 - Queue + Stack Fairness Check
 * 7. UC7 - Deque Based Optimized Palindrome Check
 * 8. UC8 - Linked List Based Palindrome Checker
 * 9. UC9 - Recursive Palindrome Checker
 * (More use cases to be added...)
 *
 * @author Developer
 * @version 9.0
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
     * Helper method to reverse a string.
     *
     * This method demonstrates transformation-based validation
     * by building a reversed version of the input string using a
     * loop that iterates from the last character to the first.
     *
     * @param input The string to reverse
     * @return A new string which is the reverse of the input
     */
    public static String reverseString(String input) {
        String reversed = "";
        // Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        return reversed;
    }

    /**
     * Helper method using character array and two-pointer technique.
     *
     * Converts the string to a char[], then compares characters
     * at start and end positions moving inward. This avoids creating
     * extra string objects and demonstrates efficient primitive use.
     *
     * @param input The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeCharArray(String input) {
        char[] chars = input.toCharArray();          // convert to char array
        int start = 0;                              // pointer at beginning
        int end = chars.length - 1;                 // pointer at end
        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;                      // mismatch found
            }
            start++;                                // move inward
            end--;
        }
        return true;                               // all matched
    }

    /**
     * Helper method using a stack to check palindrome.
     *
     * The stack pushes each character of the string and then
     * pops them to obtain the reversed sequence. Comparison with
     * the original string validates palindrome property using
     * LIFO (Last In First Out) behavior.
     *
     * @param input The string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeUsingStack(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        // push characters
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        // pop and compare
        for (char c : input.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper for UC6 – queue vs stack fairness check.
     *
     * Enqueues all chars into a FIFO queue and pushes them into a
     * LIFO stack. Then dequeues and pops in parallel comparing values.
     * If any mismatch occurs, string is not palindrome.
     *
     * @param input The string to evaluate
     * @return true if queue and stack outputs match throughout
     */
    public static boolean queueStackFairness(String input) {
        java.util.Queue<Character> queue = new java.util.LinkedList<>();
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            queue.add(c);         // FIFO
            stack.push(c);        // LIFO
        }
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper using a deque for optimized palindrome check.
     *
     * Characters are added to a Deque and then compared by
     * removing from both ends until fewer than two elements remain.
     * This provides a front-to-back traversal without reversal.
     *
     * @param input string to evaluate
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeDeque(String input) {
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

    /**
     * Helper method using a custom singly linked list.
     *
     * Builds a linked list of characters, uses fast/slow pointers to
     * locate the middle, reverses the second half in-place, and then
     * compares corresponding nodes from both halves.
     * Demonstrates node traversal and in-place reversal.
     *
     * @param input The string to check
     * @return true if palindrome, false otherwise
     */
    private static class Node {
        char val;
        Node next;
        Node(char v) { val = v; next = null; }
    }

    public static boolean isPalindromeLinkedList(String input) {
        Node head = null, tail = null;
        for (char c : input.toCharArray()) {
            Node n = new Node(c);
            if (head == null) head = tail = n;
            else { tail.next = n; tail = n; }
        }
        // find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse second half
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        // compare halves
        Node p1 = head, p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     * Recursive palindrome check helper.
     *
     * Compares characters at start and end indices, recursing inward.
     * Base case: start >= end or mismatch.
     *
     * @param s the string
     * @param start beginning index
     * @param end ending index
     * @return true if palindrome
     */
    public static boolean isPalindromeRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRecursive(s, start+1, end-1);
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
        System.out.println("Version: 9.0");
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
        
        // ========== UC3: PALINDROME VIA STRING REVERSAL ==========
        System.out.println("====================================================");
        System.out.println("      UC3 - PALINDROME CHECK (REVERSE STRING)");
        System.out.println("====================================================");
        System.out.println();
        
        String input3 = "racecar";                       // hardcoded for demo
        String reversed = reverseString(input3);          // build reversed string
        boolean check3 = input3.equals(reversed);        // compare content
        
        System.out.println("Input text: " + input3);
        System.out.println("Reversed text: " + reversed);
        System.out.println("Is it a Palindrome? " + check3);
        
        // additional examples
        String[] more = {"level", "java", "madam"};
        for (String word : more) {
            String rev = reverseString(word);
            System.out.println("Input text: " + word + " | reversed: " + rev + " | palindrome? " + word.equals(rev));
        }
        
        System.out.println();
        
        // ========== UC4: CHAR ARRAY PALINDROME CHECK ==========
        System.out.println("====================================================");
        System.out.println("      UC4 - CHAR ARRAY PALINDROME VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        String input4 = "radar";                        // hardcoded example
        boolean check4 = isPalindromeCharArray(input4);
        System.out.println("Input text: " + input4);
        System.out.println("Is it a Palindrome? " + check4);
        
        // more examples
        String[] tests4 = {"level", "hello", "world"};
        for (String word : tests4) {
            boolean pal = isPalindromeCharArray(word);
            System.out.println("Input text: " + word + " | palindrome? " + pal);
        }
        
        System.out.println();
        
        // ========== UC5: STACK BASED PALINDROME CHECK ==========
        System.out.println("====================================================");
        System.out.println("      UC5 - STACK BASED PALINDROME VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        String input5 = "noon";                         // hardcoded example
        boolean check5 = isPalindromeUsingStack(input5);
        System.out.println("Input text: " + input5);
        System.out.println("Is it a Palindrome? " + check5);
        
        // more stack tests
        String[] tests5 = {"palin", "level", "racecar"};
        for (String word : tests5) {
            boolean pal = isPalindromeUsingStack(word);
            System.out.println("Input text: " + word + " | palindrome? " + pal);
        }
        
        System.out.println();
        
        // ========== UC6: QUEUE + STACK FAIRNESS CHECK ==========
        System.out.println("====================================================");
        System.out.println("      UC6 - QUEUE + STACK FAIRNESS VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        String input6 = "civic";
        boolean fairness = queueStackFairness(input6);
        System.out.println("Input text: " + input6);
        System.out.println("Fairness check (queue vs stack): " + fairness);
        
        String[] tests6 = {"level", "abc", "madam"};
        for (String word : tests6) {
            System.out.println("Input text: " + word + " | fairness? " + queueStackFairness(word));
        }
        
        System.out.println();
        
        // ========== UC7: DEQUE BASED OPTIMIZED CHECK ==========
        System.out.println("====================================================");
        System.out.println("      UC7 - DEQUE BASED PALINDROME VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        String input7 = "refer";
        boolean check7 = isPalindromeDeque(input7);
        System.out.println("Input text: " + input7);
        System.out.println("Is it a Palindrome? " + check7);
        
        String[] tests7 = {"radar", "hello", "level"};
        for (String word : tests7) {
            System.out.println("Input text: " + word + " | palindrome? " + isPalindromeDeque(word));
        }
        
        System.out.println();
        
        // ========== UC8: LINKED LIST PALINDROME VALIDATION ==========
        System.out.println("====================================================");
        System.out.println("      UC8 - LINKED LIST PALINDROME VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        String input8 = "level";
        boolean check8 = isPalindromeLinkedList(input8);
        System.out.println("Input text: " + input8);
        System.out.println("Is it a Palindrome? " + check8);
        
        String[] tests8 = {"hello", "racecar", "abc"};
        for (String word : tests8) {
            System.out.println("Input text: " + word + " | palindrome? " + isPalindromeLinkedList(word));
        }
        
        System.out.println();
        
        // ========== UC9: RECURSIVE PALINDROME CHECK ==========
        System.out.println("====================================================");
        System.out.println("      UC9 - RECURSIVE PALINDROME VALIDATION");
        System.out.println("====================================================");
        System.out.println();
        
        String input9 = "madam";
        boolean check9 = isPalindromeRecursive(input9, 0, input9.length()-1);
        System.out.println("Input text: " + input9);
        System.out.println("Is it a Palindrome? " + check9);
        
        String[] tests9 = {"level", "hello", "racecar"};
        for (String word : tests9) {
            System.out.println("Input text: " + word + " | palindrome? " + isPalindromeRecursive(word,0,word.length()-1));
        }
        
        System.out.println();
        
        // Display footer
        System.out.println("====================================================");
        System.out.println("Application completed successfully!");
        System.out.println("====================================================");
    }
}

package stack;

import java.util.Stack;

public class Problem5 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Agar opening bracket hai toh stack mein push kar do
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            // Agar closing bracket hai
            else {
                // Agar stack khali hai toh invalid (mtlb koi open bracket nahi mila)
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // Check matching pair
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Last mein agar stack khali hai toh sab sahi se close ho gaye
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test1 = "()[]{}";
        String test2 = "([)]";
        String test3 = "{[]}";
        String test4 = "(";

        System.out.println("Test 1: " + test1 + " -> " + isValid(test1)); // Expected: true
        System.out.println("Test 2: " + test2 + " -> " + isValid(test2)); // Expected: false
        System.out.println("Test 3: " + test3 + " -> " + isValid(test3)); // Expected: true
        System.out.println("Test 4: " + test4 + " -> " + isValid(test4)); // Expected: false
    }
}

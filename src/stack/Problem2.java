//Given a string s, repeatedly remove adjacent duplicate characters until no such duplicates exist.
package stack;
import java.util.Stack;

class RemoveAdjacentDuplicates {

    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // If stack not empty and top equals current char → remove
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            // Otherwise push current char
            else {
                stack.push(ch);
            }
        }

        // Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca")); // ca
        System.out.println(removeDuplicates("azxxzy")); // ay
        System.out.println(removeDuplicates("aabbcc")); // empty string
    }
}

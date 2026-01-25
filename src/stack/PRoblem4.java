package stack;
import java.util.Stack;
public class PRoblem4 {
    public static void main(String[] args) {
        String str = "hello";
        Stack<Character> stack = new Stack<>();

        // Step 1: Push characters into stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Step 2: Pop characters to reverse string
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println(reversed.toString());
    }
}

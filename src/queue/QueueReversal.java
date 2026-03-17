package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {

    /**
     * Reverses the given queue using a stack.
     * @param queue The queue to be reversed.
     * @return The reversed queue.
     */
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Push all elements of the queue into the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Pop all elements from the stack back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println("Original Queue: " + q);

        reverse(q);

        System.out.println("Reversed Queue: " + q);
    }
}

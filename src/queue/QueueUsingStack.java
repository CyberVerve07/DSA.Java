package queue;

import java.util.Stack;

/**
 * Implementation of a Queue using two Stacks.
 * This implementation follows the FIFO (First-In-First-Out) principle.
 */
public class QueueUsingStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /**
     * Enqueue an element into the queue.
     * Time Complexity: O(1)
     */
    public void enqueue(int data) {
        s1.push(data);
    }

    /**
     * Dequeue an element from the queue.
     * Time Complexity: Amortized O(1)
     */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        // If s2 is empty, move all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }

    /**
     * Peek the front element of the queue.
     */
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }

    /**
     * Check if the queue is empty.
     */
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front element: " + q.peek()); // Should be 1
        System.out.println("Dequeued: " + q.dequeue());   // Should be 1
        System.out.println("Dequeued: " + q.dequeue());   // Should be 2

        q.enqueue(4);
        System.out.println("Dequeued: " + q.dequeue());   // Should be 3
        System.out.println("Dequeued: " + q.dequeue());   // Should be 4
        System.out.println("Is queue empty? " + q.isEmpty()); // Should be true
    }
}

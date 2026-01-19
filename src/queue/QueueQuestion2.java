package queue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Arrays;

public class QueueQuestion2 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove out-of-window indices
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Window complete
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] res = maxSlidingWindow(
                new int[]{1,3,-1,-3,5,3,6,7}, 3
        );
        System.out.println(Arrays.toString(res));
        // [3,3,5,5,6,7]
    }
}

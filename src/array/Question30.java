import java.util.*;

// ============================================
// Q2. Move All Zeroes to End  (LC #283)
// ============================================
// Logic: Non-zero elements ko aage rakho,
//        baaki jagah zeros fill karo
// Time: O(n) | Space: O(1)
// ============================================

public class Question30 {

    public static void moveZeroes(int[] nums) {
        int pos = 0; // yahan non-zero element rakhenge

        // Step 1: Saare non-zero elements aage le aao
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        // Step 2: Baaki positions mein zero bhar do
        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Q2: Move Zeroes to End ===\n");

        int[] arr1 = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(arr1));
        moveZeroes(arr1);
        System.out.println("After : " + Arrays.toString(arr1));
        // Output: [1, 3, 12, 0, 0]

        System.out.println();

        int[] arr2 = {0, 0, 1, 0, 2, 0, 3};
        System.out.println("Before: " + Arrays.toString(arr2));
        moveZeroes(arr2);
        System.out.println("After : " + Arrays.toString(arr2));
        // Output: [1, 2, 3, 0, 0, 0, 0]
    }
}
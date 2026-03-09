=import java.util.Arrays;

/**
 * LeetCode #977: Squares of a Sorted Array
 *
 * Yeh class ek sorted array (jo negative numbers bhi contain kar sakta hai)
 * ke elements ka square karke ek nayi sorted array return karti hai.
 */
public class SortedSquares {

    /**
     * Array ke har element ka square karke ek nayi sorted array banata hai.
     * @param nums Sorted integer array.
     * @return Naya array jismein squares ho aur sorted order mein ho.
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // Result array same size ka banayein
        int[] result = new int[n];

        // Two Pointers Technique
        // 'left' pointer array ke shuruat par
        int left = 0;
        // 'right' pointer array ke end par
        int right = n - 1;

        // 'k' pointer naye result array ko fill karne ke liye. Hum end se fill karenge.
        int k = n - 1;

        // Jab tak left pointer right se aage nahi aa jaata
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            // Check karo kaunsa square bada hai
            if (leftSq > rightSq) {
                // Left ka square bada hai, toh use result array mein 'k' position par daalo
                result[k] = leftSq;
                k--; // Result pointer ko peeche le jao
                left++; // Left pointer ko aage badhao
            } else {
                // Right ka square bada hai ya barabar hai, toh use result array mein 'k' position par daalo
                result[k] = rightSq;
                k--; // Result pointer ko peeche le jao
                right--; // Right pointer ko peeche le jao
            }
        }

        // Loop khatam hone ke baad, 'result' array completely filled aur sorted ho jaayega.
        return result;
    }

    /**
     * Main method: Yaha hum function ko test karenge.
     */
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println("--- Test Case 1 ---");
        System.out.println("Original Array: " + Arrays.toString(nums1));
        int[] result1 = sortedSquares(nums1);
        System.out.println("Squares of Sorted Array: " + Arrays.toString(result1));
        System.out.println(); // Empty line for readability


        // Test Case 2
        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println("--- Test Case 2 ---");
        System.out.println("Original Array: " + Arrays.toString(nums2));
        int[] result2 = sortedSquares(nums2);
        System.out.println("Squares of Sorted Array: " + Arrays.toString(result2));
    }
}

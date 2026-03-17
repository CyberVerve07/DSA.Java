import java.util.*;
package array;
class ThreeSum {

    /**
     * Problem: 3Sum
     * Given an integer array nums of length n, return all unique triplets
     * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
     * and nums[i] + nums[j] + nums[k] == 0.
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(1) excluding the output array
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // If current number is positive, no triplet can sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate elements to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 3: Use two pointers to find the other two numbers
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + threeSum(nums1));
        System.out.println();

        // Test Case 2
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + threeSum(nums2));
        System.out.println();

        // Test Case 3
        int[] nums3 = {-2, 0, 1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums3));
        System.out.println("Output: " + threeSum(nums3));
        System.out.println();

        // Test Case 4
        int[] nums4 = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println("Input: " + Arrays.toString(nums4));
        System.out.println("Output: " + threeSum(nums4));
    }
}
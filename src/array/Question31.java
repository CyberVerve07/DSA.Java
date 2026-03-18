package array;

import java.util.*;

/**
 * Question 31: 3Sum
 * 
 * Problem Statement:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Approach: Two-Pointer Method
 * 1. Sort the input array.
 * 2. Iterate through the array with an index 'i'.
 * 3. For each 'i', use two pointers ('left' and 'right') to find pairs that sum to -nums[i].
 * 4. Skip duplicate elements at each step to ensure unique triplets.
 * 
 * Complexity:
 * - Time Complexity: O(n²) where n is the number of elements in the array.
 * - Space Complexity: O(1) or O(log n) depending on the sorting implementation (excluding result list).
 */
class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If current number is positive, no triplet can sum to 0
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

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

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

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("       3Sum Problem Solver             ");
        System.out.println("========================================\n");

        runTest(new int[]{-1, 0, 1, 2, -1, -4}, "Example 1");
        runTest(new int[]{0, 1, 1}, "Example 2");
        runTest(new int[]{0, 0, 0}, "Example 3");
        runTest(new int[]{-2, 0, 1, 1, 2}, "Custom Test 1");
        runTest(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}, "Large Test");
    }

    private static void runTest(int[] nums, String testName) {
        System.out.println("Test Case: " + testName);
        System.out.println("Input: " + Arrays.toString(nums));
        List<List<Integer>> result = threeSum(nums);
        System.out.println("Output: " + result);
        System.out.println("----------------------------------------");
    }
}
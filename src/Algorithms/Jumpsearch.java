package Algorithms;

import java.lang.Math;

/**
 * Jump Search Algorithm
 * Sirf SORTED array par kaam karta hai.
 * Time Complexity: O(√n)
 */
 class JumpSearch {

    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int n = arr.length;
        // Block size ka int step rakho, usually square root of n
        int step = (int) Math.sqrt(n);

        // Pehla block jahan target ho sakta hai, usse dhundo
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1; // Element nahi hai
            }
        }

        // Ab jo block mila hai, uske andar linear search karo
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1; // Element nahi hai
            }
        }

        // Agar element mil gaya toh index return karo
        if (arr[prev] == target) {
            return prev;
        }

        return -1; // Element nahi hai
    }

    // Yeh method code ko run karne ke liye hai
    public static void main(String[] args) {
        // IMPORTANT: Array MUST be sorted for Jump Search
        int[] sortedNumbers = {1, 5, 9, 13, 17, 21, 25, 29, 33, 37, 41, 45};
        int targetToFind = 25;
        int targetNotFound = 30;

        System.out.println("Sorted Array: [1, 5, 9, 13, 17, 21, 25, 29, 33, 37, 41, 45]");

        // Test Case 1: Element hai
        int resultIndex = search(sortedNumbers, targetToFind);
        if (resultIndex != -1) {
            System.out.println("Element " + targetToFind + " found at index: " + resultIndex);
        } else {
            System.out.println("Element " + targetToFind + " not found.");
        }

        // Test Case 2: Element nahi hai
        resultIndex = search(sortedNumbers, targetNotFound);
        if (resultIndex != -1) {
            System.out.println("Element " + targetNotFound + " found at index: " + resultIndex);
        } else {
            System.out.println("Element " + targetNotFound + " not found.");
        }
    }
}

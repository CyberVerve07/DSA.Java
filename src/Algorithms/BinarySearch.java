package Algorithms;
/**
 * Binary Search Algorithm
 * Sirf SORTED array par kaam karta hai.
 * Time Complexity: O(log n)
 */
public class BinarySearch {

    // Yeh method sorted array mein target element ko dhundhne ke liye hai
    public static int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        // Jab tak low se high chota ya barabar hai
        while (low <= high) {
            // Mid index calculate karo (Overflow se bachne ke liye ye formula use karo)
            int mid = low + (high - low) / 2;

            // Agar mid element target hai toh mid return karo
            if (arr[mid] == target) {
                return mid;
            }

            // Agar target mid element se chota hai, toh left side par dhundo
            if (target < arr[mid]) {
                high = mid - 1;
            }
            // Agar target mid element se bada hai, toh right side par dhundo
            else {
                low = mid + 1;
            }
        }

        // Agar element nahi mila
        return -1;
    }

    // Yeh method code ko run karne ke liye hai
    public static void main(String[] args) {
        // IMPORTANT: Array MUST be sorted for Binary Search
        int[] sortedNumbers = {3, 9, 10, 17, 25, 48};
        int targetToFind = 17;
        int targetNotFound = 40;

        System.out.println("Sorted Array: [3, 9, 10, 17, 25, 48]");

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


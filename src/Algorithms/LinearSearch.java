/**
 * Linear Search Algorithm
 * Har element  se check karta hai.
 * Time Complexity: O(n)
 */

public class LinearSearch {

    // Yeh method array mein target element ko dhundhne ke liye hai
    public static int search(int[] arr, int target) {
        // Agar array khali hai toh -1 return karo (element nahi mila)
        if (arr == null || arr.length == 0) {
            return -1;
        }

        // Loop har element par chalega
        for (int i = 0; i < arr.length; i++) {
            // Agar current element target ke barabar hai, toh uska index return karo
            if (arr[i] == target) {
                return i;
            }
        }

        // Agar loop khatam ho gaya aur element nahi mila, toh -1 return karo
        return -1;
    }

    // Yeh method code ko run karne ke liye hai
    public static void main(String[] args) {
        int[] numbers = {10, 25, 3, 48, 17, 9};
        int targetToFind = 48;
        int targetNotFound = 99;

        System.out.println("Array: [10, 25, 3, 48, 17, 9]");

        // Test Case 1: Element hai
        int resultIndex = search(numbers, targetToFind);
        if (resultIndex != -1) {
            System.out.println("Element " + targetToFind + " found at index: " + resultIndex);
        } else {
            System.out.println("Element " + targetToFind + " not found.");
        }

        // Test Case 2: Element nahi hai
        resultIndex = search(numbers, targetNotFound);
        if (resultIndex != -1) {
            System.out.println("Element " + targetNotFound + " found at index: " + resultIndex);
        } else {
            System.out.println("Element " + targetNotFound + " not found.");
        }
    }
}

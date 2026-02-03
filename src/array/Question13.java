//Problem: Check if an Array is Sorted (Using Recursion
package array;
public class Question13 {

    public static boolean isSorted(int[] arr, int index) {
        // Base case: single element or end of array
        if (index == arr.length - 1) {
            return true;
        }

        // If current element > next element → not sorted
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Recursive call
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 4, 3, 8};

        System.out.println(isSorted(arr1, 0)); // true
        System.out.println(isSorted(arr2, 0)); // false
    }
}

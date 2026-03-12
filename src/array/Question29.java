import java.util.*;
// ============================================
// Q1. Find Maximum and Minimum in an Array
// ============================================
// Logic: Ek baar array traverse karo,
//        har element se max aur min compare karo
// Time: O(n) | Space: O(1)
// ============================================

public class Question29 {

    public static void findMaxMin(int[] arr) {
        int max = arr[0];  // pehle element ko max maano
        int min = arr[0];  // pehle element ko min maano

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];   // naya max mila
            }
            if (arr[i] < min) {
                min = arr[i];   // naya min mila
            }
        }

        System.out.println("Array  : " + Arrays.toString(arr));
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
    }

    public static void main(String[] args) {
        System.out.println("=== Q1: Max & Min in Array ===\n");

        int[] arr1 = {3, 5, 1, 8, 2, 9, 4};
        findMaxMin(arr1);
        // Max = 9, Min = 1

        System.out.println();

        int[] arr2 = {-3, -1, -7, -2};
        findMaxMin(arr2);
        // Max = -1, Min = -7
    }
}
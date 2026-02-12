//Problem
//
//You are building a search system.
//Different data structures search differently, but the interface is same.
//
//Base class: Search
//
//Derived classes:
//
//LinearSearch
//
//BinarySearch
// Base abstract class
// Base abstract class
abstract class Search {
    abstract int search(int[] arr, int target);
}

// Linear Search implementation
class LinearSearch extends Search {
    @Override
    int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

// Binary Search implementation
class BinarySearch extends Search {
    @Override
    int search(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Search searchAlgo = new BinarySearch(); // runtime polymorphism

        int[] arr = {1, 3, 5, 7, 9};
        int result = searchAlgo.search(arr, 7);

        System.out.println(result);
    }
}

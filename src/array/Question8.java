//Find the Missing and Repeating Number
//Problem Statement
//You are given an array nums of size n containing numbers from 1 to n.
//One number is missing
//One number is repeating
//You must find both
// No sorting
// No extra array / hashmap
package array;
public class Question8 {

    public static void findNumbers(int[] nums) {
        int repeating = -1;
        int missing = -1;

        // Step 1: Mark visited
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                repeating = index + 1;
            } else {
                nums[index] = -nums[index];
            }
        }

        // Step 2: Find missing
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        System.out.println("Repeating = " + repeating);
        System.out.println("Missing = " + missing);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 3};
        findNumbers(nums);
    }
}

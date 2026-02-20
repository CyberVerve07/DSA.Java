package array;

import java.util.Arrays;

public class Question23 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    // 🔥 ENTRY POINT
    public static void main(String[] args) {
        Question23 obj = new Question23();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        obj.rotate(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}
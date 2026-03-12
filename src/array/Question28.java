import java.util.Arrays;

 class SortedSquare {

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;
        int k = n - 1;

        while (left <= right) {
            int leftSq  = nums[left]  * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                result[k] = leftSq;
                left++;
            } else {
                result[k] = rightSq;
                right--;
            }
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums1)));
        // Output: [0, 1, 9, 16, 100]

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares(nums2)));
        // Output: [4, 9, 9, 49, 121]
    }
}
import java.util.Arrays;

/**
 * LeetCode #26: Remove Duplicates from Sorted Array
 *
 * Yeh class ek sorted array se duplicates ko in-place remove karti hai
 * aur nayi length return karti hai.
 */
 class RemoveDuplicates {

    /**
     * Array se duplicate elements hata kar nayi length return karta hai.
     * @param nums Sorted integer array jismein duplicates ho sakte hain.
     * @return Duplicates hataane ke baad array ki length.
     */
    public static int removeDuplicates(int[] nums) {
        // Agar array empty hai toh length 0 hai
        if (nums.length == 0) {
            return 0;
        }

        // 'i' pointer unique elements ka track rakhega. Ye slow pointer hai.
        int i = 0;

        // 'j' pointer array ko scan karega. Ye fast pointer hai.
        for (int j = 1; j < nums.length; j++) {
            // Agar 'j' wali element 'i' wali se alag hai, toh nayi unique element mili.
            if (nums[j] != nums[i]) {
                // 'i' ko agle position par le jao (kayunki nayi jagah milegi unique element ke liye)
                i++;
                // Us nayi unique element ko 'i' ki nayi position par copy karo
                nums[i] = nums[j];
            }
            // Agar elements same hain, toh sirf 'j' aage badhega. 'i' wahi rahega.
        }

        // Loop khatam hone ke baad, array ke '0' se 'i' index tak elements unique hain.
        // Nayi length 'i' ka +1 hai (kyunki 'i' index hai, count se ek kam hai).
        return i + 1;
    }

    /**
     * Main method: Yaha hum function ko test karenge.
     */
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("--- Test Case 1 ---");
        System.out.println("Original Array: " + Arrays.toString(nums1));

        int newLength1 = removeDuplicates(nums1);
        System.out.println("New Length: " + newLength1);

        // Array ke first 'newLength' elements print karte hain
        System.out.print("Array after removing duplicates: [");
        for (int k = 0; k < newLength1; k++) {
            System.out.print(nums1[k] + (k < newLength1 - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println(); // Empty line for readability


        // Test Case 2
        int[] nums2 = {1, 1, 2};
        System.out.println("--- Test Case 2 ---");
        System.out.println("Original Array: " + Arrays.toString(nums2));

        int newLength2 = removeDuplicates(nums2);
        System.out.println("New Length: " + newLength2);
        System.out.print("Array after removing duplicates: [");
        for (int k = 0; k < newLength2; k++) {
            System.out.print(nums2[k] + (k < newLength2 - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}

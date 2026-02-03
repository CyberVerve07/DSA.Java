//Check if Array is Sort
class CheckSorted {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 5, 4};
        boolean sorted = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            System.out.println("Sorted");
        } else {
            System.out.println("Not Sorted");
        }
    }
}

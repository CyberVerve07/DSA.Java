package array;
public class Question25 {

    public static int findNthDigit(int nInput) {

        long n = nInput;

        int digitLength = 1;
        long count = 9;
        int start = 1;

        while (n > digitLength * count) {
            n -= digitLength * count;
            digitLength++;
            count *= 10;
            start *= 10;
        }

        int number = start + (int)((n - 1) / digitLength);
        int digitIndex = (int)((n - 1) % digitLength);

        return Integer.toString(number).charAt(digitIndex) - '0';
    }

    public static void main(String[] args) {

        int n = 11;

        System.out.println(findNthDigit(n));
    }
}
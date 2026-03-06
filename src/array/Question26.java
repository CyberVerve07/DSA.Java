//LeetCode #900 - RLE Iterator)
/**
 * LeetCode 900. RLE Iterator
 * Run-Length Encoded Iterator ko implement karta hai.
 */
package array;
class RLEIterator {

    // Original encoded array ko store karne ke liye
    private int[] encoding;

    // Current position jis hum hai (ye hamesha count ko point karega)
    private int index;

    // Current block mein kitni elements abhi bhi baaki hain
    private int currentCount;

    /**
     * Constructor: Iterator ko initialize karta hai encoding array se.
     */
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.index = 0; // Shuruat mein pehle block par hain
        this.currentCount = this.encoding.length > 0 ? this.encoding[0] : 0;
    }

    /**
     * Iterator ko n steps aage badhata hai.
     * @param n - Aage badhne ke liye steps
     * @return - Wo number jispar hum pahuche, ya -1 agar elements khatam ho jaayein
     */
    public int next(int n) {
        int lastConsumedValue = -1; // Jo return karna hai, default -1 rakho

        // Jab tak hume n steps consume karne hain
        while (n > 0) {
            // Agar array hi khatam ho gayi, toh aur nahi consume kar sakte
            if (index >= encoding.length) {
                return -1;
            }

            // Agar current block ka count 0 hai, toh agle block par chalo
            if (currentCount == 0) {
                index += 2; // Agle (count, value) pair par jump karo
                if (index < encoding.length) {
                    currentCount = encoding[index];
                }
                continue; // Loop phir se chalao, nayi position se check karo
            }

            // Ab hum ek valid block mein hain jisme items baaki hain
            int currentValue = encoding[index + 1];
            lastConsumedValue = currentValue;

            if (n <= currentCount) {
                // Hum zaroorat ki takaat se kaam steps consume kar sakte hain is block se
                currentCount -= n;
                n = 0; // Humara kaam ho gaya
            } else {
                // Is poori block ko consume karna hoga aur agle block par jana hoga
                n -= currentCount;
                currentCount = 0; // Yeh block ab khatam ho gaya
            }
        }

        return lastConsumedValue;
    }
}

/**
 * Test Case ke liye main function
 */
public class Main {
    public static void main(String[] args) {
        // Example from LeetCode problem
        int[] initialEncoding = {3, 8, 0, 9, 2, 5};
        RLEIterator rleIterator = new RLEIterator(initialEncoding);

        // Expected Output: 8
        // Explanation: iterator moves 2 steps. [8, 8, 8, 5, 5]. Last element is 8.
        System.out.println("next(2) -> " + rleIterator.next(2));

        // Expected Output: 8
        // Explanation: iterator moves 1 more step. [8, 8, 8, 5, 5]. Last element is 8.
        System.out.println("next(1) -> " + rleIterator.next(1));

        // Expected Output: 5
        // Explanation: iterator moves 2 more steps. [8, 8, 8, 5, 5]. Last element is 5.
        System.out.println("next(1) -> " + rleIterator.next(1));

        // Expected Output: -1
        // Explanation: iterator moves 2 more steps. But only one 5 is left. So it runs out.
        System.out.println("next(2) -> " + rleIterator.next(2));
    }
}

import java.util.*;

// ============================================
// Q3. Best Time to Buy & Sell Stock (LC #121)
// ============================================
// Logic: Sabse sasta din dhundo khareedne ke liye,
//        uske baad sabse mahenga din bechne ke liye
//        Ek hi pass mein dono track karo!
// Time: O(n) | Space: O(1)
// ============================================

 class Q3_BuySellStock {

    public static int maxProfit(int[] prices) {
        int minPrice  = prices[0]; // aaj tak ka sabse sasta din
        int maxProfit = 0;         // aaj tak ka sabse zyada munafa

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                // Sasta din mila! Yahan se khareedhenge
                minPrice = prices[i];

            } else {
                // Aaj bechne par kitna profit?
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit; // naya best profit!
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=== Q3: Best Time to Buy & Sell Stock ===\n");

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Prices    : " + Arrays.toString(prices1));
        System.out.println("Max Profit: " + maxProfit(prices1));
        // Buy at 1, Sell at 6 => Profit = 5

        System.out.println();

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Prices    : " + Arrays.toString(prices2));
        System.out.println("Max Profit: " + maxProfit(prices2));
        // Price hamesha girta raha, koi profit nahi => 0

        System.out.println();

        int[] prices3 = {2, 4, 1, 7};
        System.out.println("Prices    : " + Arrays.toString(prices3));
        System.out.println("Max Profit: " + maxProfit(prices3));
        // Buy at 1, Sell at 7 => Profit = 6
    }
}
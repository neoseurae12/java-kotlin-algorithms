package ch07_array;

/* Trial 0

- 브루트 포스 (Brute-Force)
    - 시간복잡도: O(n^2) => Time Limit Exceeded 발생. 즉, 본 Trial 0 풀이는 Submit 불가.
 */

public class BestTimeToBuyAndSellStockJ {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}

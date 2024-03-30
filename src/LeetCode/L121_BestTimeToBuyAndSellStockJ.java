package LeetCode;

// Array, Two Pointers

/*
- sellTime의 증감 작업을 단지 코드 앞쪽에서 뒤쪽으로 옮기기만 해도 시간복잡도나 코드의 간결성에서 차이를 보임.
- Math.max() 함수만 잘 써도, 두 수의 크기 비교하는 if문 코드를 훨씬 단축시킬 수 있음.
 */

public class L121_BestTimeToBuyAndSellStockJ {
    public int maxProfit(int[] prices) {
        int buyTime = 0;
        int sellTime = 0;
        int maxProfit = 0;

        while (sellTime < prices.length) {
            if (prices[buyTime] >= prices[sellTime]) {
                // buyTime => 단지 buyTime++(1만큼만 증가) 하는 것이 아닌 아예 sellTime과 같게 업데이트 해야 함
                buyTime = sellTime;
            } else {
                int newProfit = prices[sellTime] - prices[buyTime];
                maxProfit = Math.max(maxProfit, newProfit);
            }
            sellTime++;
        }

        return maxProfit;
    }
}

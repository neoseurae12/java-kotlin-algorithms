package ch07_array;

/* Trial 1

- 최저점 이후의 가격 - 최저점
    - 시간복잡도: O(n)
- 기술 통계학 (Descriptive Statistics)
    - 그래프 등을 통해 값을 '시각화' 하는 방법
    - 어려운 문제의 풀이에 대한 직관이 생길 수 있다.
- Math 클래스의 max(), min() 메서드의 적절한 사용
- 방향성 반영 (일방/양방)
 */

public class BestTimeToBuyAndSellStockJ_1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        // 방향성 반영 (→→)
        for (int price : prices) {
            // 지금까지의 최저점 갱신
            minPrice = Math.min(price, minPrice);
            // 최대 이익 (= 최저점 이후의 가격 - 최저점) 갱신
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}

package ch07_array

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- [차이점] 최댓값, 최솟값 구하기
  - 자바
    - Math.max(), Math.min()
  - 코틀린
    - coerceAtLeast(), coerceAtMost()
    - import 없이 간단히 처리 가능
- 카데인 알고리즘(Kadane's Algorithm) 의 응용 문제
  - 시간 복잡도: O(n)
  - 53. Maximum Subarray[https://leetcode.com/problems/maximum-subarray/description/] 문제와 유사
    - 컴퓨터과학 분야에서 매우 유명한 유서 깊은 문제
    - 카데인 알고리즘(Kadane's Algorithm) 의 정통 문제
    - 시간 복잡도: O(n)
 */

class BestTimeToBuyAndSellStockK {
  fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = prices[0]

    for (price in prices) {
      minPrice = minPrice.coerceAtMost(price)
      maxProfit = maxProfit.coerceAtLeast(price - minPrice)
    }

    return maxProfit
  }
}
package ch07_array

/* Trial 3
- Trial 1에 대한 코틀린 풀이

- coerceAtLeast(minimumValue: T) 함수
  - Ensures that this value is not less than the specified minimumValue
  - 사실상 Math.max() 함수와 같은 역할 수행
  - 코틀린에서 '최댓값'을 구할 때 주로 이용하는 함수
  - [장점]
    - 별도의 import 가 필요 없음
    - 확장 함수로 편리하게 이용 가능
 */

class TrappingRainWaterK {
  fun trap(height: IntArray): Int {
    var volume = 0
    var left = 0
    var right = height.size - 1
    var leftMax = height[left]
    var rightMax = height[right]

    while (left < right) {
      leftMax = height[left].coerceAtLeast(leftMax)
      rightMax = height[right].coerceAtLeast(rightMax)

      if (leftMax >= rightMax) {
        volume += rightMax - height[right]
        right--
      } else {
        volume += leftMax - height[left]
        left++
      }
    }

    return volume
  }
}
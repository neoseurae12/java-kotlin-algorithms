package ch07_array

/* Trial 3
- Trial 2에 대한 코틀린 풀이

- MutableList & List => '순수함'을 강조하는 함수형 언어의 중요한 특징
- [차이점] 자바 Arrays.asList() vs. 코틀린 listOf()
 */

import java.util.*

class ThreeSumK {
  fun threeSum(nums: IntArray): List<List<Int>> {
    val results: MutableList<List<Int>> = mutableListOf()
    var left: Int
    var right: Int
    var threeSum: Int

    Arrays.sort(nums)

    for (first in 0 until nums.size - 2) {
      if (first > 0 && nums[first] == nums[first - 1])
        continue

      left = first + 1
      right = nums.size - 1

      while (left < right) {
        threeSum = nums[first] + nums[left] + nums[right]

        if (threeSum > 0) {
          right--
        } else if (threeSum < 0) {
          left++
        } else {
          results.add(listOf(nums[first], nums[left], nums[right]))

          while (left < right && nums[left] == nums[left + 1])
            left++
          while (left < right && nums[right] == nums[right - 1])
            right--

          left++
          right--
        }
      }
    }

    return results
  }
}
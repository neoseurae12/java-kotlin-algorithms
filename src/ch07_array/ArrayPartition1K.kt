package ch07_array

/* Trial 3
- Trial 0, 2에 대한 코틀린 풀이

- [차이점] 정렬 -- 자바 vs. 코틀린
  - 자바
    - int[] => '원시형'
    - Arrays.sort(배열)
  - 코틀린
    - 코틀린에서의 모든 변수 => '참조형'
    - 배열.sort()
 */

class ArrayPartition1K {
  fun arrayPairSum(nums: IntArray): Int {
    var sum = 0

    nums.sort()

    for (i in nums.indices step 2) {
      sum += nums[i]
    }
    /* 또는
    for ((i, n) in nums.withIndex()) {
      if (i % 2 == 0) {
        sum += n
      }
    }
     */

    return sum
  }
}
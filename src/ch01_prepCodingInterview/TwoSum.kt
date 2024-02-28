package ch01_prepCodingInterview

class TwoSum {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsMap: MutableMap<Int, Int> = mutableMapOf()
    // 하나의 for 루프로 통합
    for ((i, num) in nums.withIndex()) {
      // target에서 num을 뺀 값이 nums에 존재할 경우 => 정답으로 리턴
      if (numsMap.containsKey(target-num)) {
        return intArrayOf(numsMap[target-num]!!, i)
      }
      numsMap[num] = i
    }
    // 항상 정답 존재 O => 이 값이 리턴되는 경우는 없음
    // "may NOT use the same element twice"
    return intArrayOf(0, 0)
  }
}
package ch07_array

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- [차이점-1] 정수 배열에 대한 선언
  - 자바
    - int[] result = new int[nums.length];
  - 코틀린
    - val result = IntArray(nums.size);
- [차이점-2] for loop 의 앞 순회, 뒤 순회
  - 앞 순회
    - 자바: for (int i = 0; i < nums.length; i++)
    - 코틀린: for (i in nums.indices)
  - 뒤 순회
    - 자바: for (int i = nums.length - 1; i >= 0; i--)
    - 코틀린: for (i in nums.indices.reversed())
  - 코틀린의 방식이 더 직관적이고 가독성이 좋음
 */

class ProductOfArrayExceptSelfK {
  fun productExceptSelf(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var p = 1
    for (i in nums.indices) {
      result[i] = p
      p *= nums[i]
    }

    p = 1
    for (i in nums.indices.reversed()) {
      result[i] *= p
      p *= nums[i]
    }

    return result
  }
}
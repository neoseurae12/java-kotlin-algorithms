package ch07_array

/* Trial 4
- Trial 2에 대한 코틀린 풀이

- withIndex() => 인덱스 & 값 동시 추출
- 엘비스 연산자 => NPE 방지, 기본값 설정
- [차이점] 삼항 연산자 (자바) vs. 엘비스 연산자 (코틀린)
  - 삼항 연산자 (자바)
    - rand() 를 매번 다른 값을 랜덤으로 생성하는 함수라고 가정할 시, 삼항 연산자를 사용하면서 rand() 를 "2번" 호출하게 되면 첫 번째와 두 번째가 다른 값이 나오게 된다.
    - 1번만 호출하는 형태로 처리하려면 불필요한 변수를 선언하게 된다.
  - 엘비스 연산자 (코틀린)
    - 2번 호출 여부를 신경 쓸 필요가 없다.
    - 불필요한 변수 선언이 필요 없다.
    - 가독성이 좋아진다.
    - 코드 줄 수가 훨씬 줄어든다.
 */

class TwoSumK {
  fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsMap: MutableMap<Int, Int> = mutableMapOf()

    for ((i, num) in nums.withIndex()) {  // withIndex() => 인덱스 & 값 동시 추출 가능
      val firstNum = target - num
      if (numsMap.containsKey(firstNum)) {
        return intArrayOf(numsMap[firstNum] ?: 0, i)  // 엘비스 연산자 => NPE 방지, 기본값 설정
      }

      numsMap[num] = i
    }

    return intArrayOf(0, 0)
  }
}
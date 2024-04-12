package ch06_processingString

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- var 타입으로 별도 재선언 해주기
  - Kotlin 에서 '파라미터'는 val 타입으로 수정이 불가하게 막아놨기 때문이다.
  - [배경] Java 의 문제점
    - Java 는 '값에 의한 호출'만 가능하다.
    - 하지만 파라미터가 '참조 자료형'일 때는 그 객체를 바라보는 참조 값 자체가 넘어가기 때문에 마치 참조에 의한 호출인 것처럼 개발자를 착각하게 만든다.
  - [해결] Kotlin 의 해결책
    - 함수에서 파라미터로 넘겨받은 값은 모두 '읽기 전용'이며, 수정할 수 없도록 하였다.
    - 값을 수정하고 싶다면, var 를 이용해 별도의 변수를 선언해 할당한 다음, 그 변수를 수정해야 한다.
    - 개발자에게 혼란을 줄 여지 자체를 아예 제거
  - [장점]
    - 값의 변화를 쉽게 추적할 수 있다 => 쉬운 디버깅
    - 높은 코드 가독성
- [차이점] 참조에 의한 호출 vs. 값에 의한 호출
  - 참조에 의한 호출 (Call by Reference)
    - 메모리에 저장되어있는 값 자체를 변경한다.
  - 값에 의한 호출 (Call by Value)
    - 값만 받아오는 것일 뿐, 메모리에 접근하진 않는다.
 */

class LongestPalindromeSubstringK {
  var maxLen = 0
  var start = 0

  fun extendPalindrome(s: String, j: Int, k: Int) {
    // var 타입으로 별도 선언
      // 파라미터 => val 타입 => 수정 불가
    var subStart = j
    var subEnd = k

    while (subStart >= 0 && subEnd < s.length && s[subStart] == s[subEnd]) {
      subStart--
      subEnd++
    }

    val subLen = subEnd - subStart - 1
    if (subLen > maxLen) {
      maxLen = subLen
      start = subStart + 1
    }
  }

  fun longestPalindrome(s: String): String {
    if ( s.length < 2) return s

    for (i in 0 until  s.length - 1) {
      extendPalindrome(s, i, i + 1)  // 짝수 길이의 팰린드롬
      extendPalindrome(s, i, i + 2)  // 홀수 길이의 팰린드롬
    }

    return s.substring(start, start + maxLen)
  }
}
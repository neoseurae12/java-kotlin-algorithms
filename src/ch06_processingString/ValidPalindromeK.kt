package ch06_processingString

/* Trial 3
- Trial 1에 대한 코틀린 풀이

- when 표현식
- 문자 추출 방식 => 훨씬 더 간단 (s.charAt(6) -> s[6])

- 원시 자료형인 char가 아닌 참조형인 코틀린 클래스 Char 사용 -- 그럼에도 속도 문제는 발생하지 않는다
 */

class ValidPalindromeK {
  fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1

    while (start < end) {
      // when 표현식 => 깔끔하게 처리 가능
      when {
        !Character.isLetterOrDigit(s[start]) -> start++
        !Character.isLetterOrDigit(s[end]) -> end--
        else -> {
          if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end]))
            return false
          start++
          end--
        }
      }
    }
    return true
  }
}
package ch06_processingString

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- also => 더 우아한 스왑(Swap) in 코틀린
 */

class ReverseStringK {
  fun reverseString(s: CharArray): Unit {
    var start = 0
    var end = s.size - 1;
    while (start < end) {
      // also => 더 우아한 스왑(Swap) in 코틀린
      s[start] = s[end].also { s[end] = s[start] }

      start++
      end--
    }
  }
}
package ch09_stack_queue

/* Trial 3

- Trial 2에 대한 코틀린 풀이
- 자바 코드(Trial 2)와 다른 부분 (3가지)
  1. MutableMap 형 변수들의 선언 부분
    - MutableMap 의 구현체로 `mutableMapOf()` 대신 `HashMap()` 사용
    - `mutableMapOf()` => LinkedHashMap => 순서 보장 O
    - 여기서는 굳이 순서를 보장할 필요 없음 => `HashMap()`
  2. 문자별 개수를 계산하는 부분
    - getOrDefault() 함수
  3. 카운터에서 -1 을 하는 부분
    - !! 로 간단히 처리
    - BUT 실무에서는 NPE 방지를 위한 널 처리 필요
 */

import java.util.Deque
import java.util.ArrayDeque

class RemoveDuplicateLettersK {
  fun removeDuplicateLetters(s: String): String {
    val counter: MutableMap<Char, Int> = HashMap()
    val seen: MutableMap<Char, Boolean> = HashMap()
    val stack: Deque<Char> = ArrayDeque()

    for (c in s) {
      counter[c] = counter.getOrDefault(c, 0) + 1
    }

    for (c in s) {
      counter[c] = counter[c]!! - 1
      if (seen[c] == true)
        continue

      while (!stack.isEmpty() && stack.peek() > c && counter[stack.peek()]!! > 0)
        seen[stack.pop()] = false
      stack.push(c)
      seen[c] = true

      //println(stack)  // 디버깅
    }

    val sb = StringBuilder()
    while (!stack.isEmpty())
      sb.append(stack.pollLast())

    return sb.toString()
  }
}

/* 디버깅
fun main() {
  RemoveDuplicateLettersK().removeDuplicateLetters("cbacdcbc")
}
 */
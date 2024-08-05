package ch09_stack_queue

/* Trial 2

- Trial 1에 대한 코틀린 풀이

- LeetCode 상의 컴파일 에러 발생
  - 발생 지점: `val stack: Deque<Char> = ArrayDeque()`
    - IntelliJ 상의 경우
      - 임포트 구문을 `import java.util.*`로만 써도 ArrayDeque 를 java.util.ArrayDeque 로 컴파일함
    - LeetCode 상의 경우
      - 임포트 구문을 `import java.util.*`로만 쓰면 ArrayDeque 를 kotlin.collections.ArrayDeque 로 컴파일해서 아래와 같은 에러가 발생하게 됨
        - `error: type mismatch: inferred type is ArrayDeque<???> but Deque<Char> was expected`
      - 해결 방법: 아래와 같이 '명시적으로' 임포트를 해줌
        ```
        import java.util.Deque
        import java.util.ArrayDeque
        ```
- 코틀린의 깔끔한 부분 (2군데)
  - 1. 맵 선언하는 부분
  - 2. for 문으로 문자열을 반복하는 부분
    - `for (c in s)` 또는
    - `for (i in s.indices)`
- 코틀린 Map 의 기본 구현체 => LinkedHashMap
  - 따라서 자바와 달리, 인터페이스만 선언했어도 에러가 발생하지 않는다.
  - 즉, 사실상 동일한 선언 (↓)
    - 1. `val mappingTable: Map<Char, Char> = mapOf()`
    - 2. `Map<Character, Character> mappingTable = new LinkedHashMap<>();`
- LinkedHashMap vs. HashMap
  - 공통점
    - 해시 테이블의 구현체이다.
  - 차이점
    - LinkedHashMap 의 경우
      - 이중 연결 리스트로 구현됨 => 엘리먼트의 입력 순서를 보장
    - HashMap 의 경우
      - (단일) 연결 리스트로 구현됨 => 엘리먼트의 인력 순서를 보장하지 않음
 */

//import java.util.*  // <-- LeetCode 상의 컴파일 에러를 발생시키는 임포트 구문
// 아래와 같이 '명시적인' 임포트를 해주어야 LeetCode 상에서 컴파일 에러가 발생하지 않음
import java.util.Deque
import java.util.ArrayDeque

class ValidParenthesesK {
  fun isValid(s: String): Boolean {
    val stack: Deque<Char> = ArrayDeque()
    val mappingTable = mapOf(   // 코틀린의 깔끔한 맵 선언하는 부분   // 코틀린 Map 의 기본 구현체 => LinkedHashMap
      ')' to '(',
      '}' to '{',
      ']' to '['
    )

    for (c in s) {  // 코틀린의 깔끔한 for 문으로 문자열을 반복하는 부분
      if (!mappingTable.containsKey(c)) {
        stack.push(c)
      } else if (stack.isEmpty() || stack.pop() != mappingTable[c]) {
        return false
      }
    }

    return stack.isEmpty()
  }
}
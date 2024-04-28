package ch08_linkedList

/* Trial 4
- Trial 2에 대한 코틀린 풀이

- Deque 선언 부분
  - 여기서는 `Deque<Int>` 로 타입을 꼭 명시해야 함
    - LinkedList 만 봐서는 어떤 자료형을 사용할지 예측이 어렵기 때문
    - '데크' 로 사용할 것을 명시
- `val` 이라는 이름의 변수
  - 코틀린에서의 `val` => 읽기 전용 변수를 뜻하는 예약어
  - 변수명과 예약어가 겹칠 경우 => 백틱(`) 사용하여 표현
    - node.`val`
- [차이점] deque.add() vs. deque.push()
  - add()
    - 큐의 '끝쪽(마지막 요소의 위치)'에 추가
      - add 1, 2 => [1, 2]
    - 일반적인 큐의 사용 시 유용
  - push()
    - 큐의 '앞쪽(첫 번째 요소의 위치)'에 추가
      - push 1, 2 => [2, 1]
    - Deque 를 스택처럼 사용 시 유용
 */

import datatype.ListNode
import java.util.Deque
import java.util.LinkedList

class PalindromeLinkedListK {
  fun isPalindrome(head: ListNode?): Boolean {
    val deque: Deque<Int> = LinkedList()

    var node = head
    while (node != null) {
      deque.add(node.`val`)
      node = node.next
    }

    while (!deque.isEmpty() && deque.size > 1) {
      if (deque.pollFirst() != deque.pollLast())
        return false
    }

    return true
  }
}
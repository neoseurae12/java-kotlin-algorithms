package ch08_linkedList

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- 시행착오: odd 변수에 타입 선언 X --> 타입 선언 O
  - ListNode 형으로 타입 선언을 명시적으로 안 해주면 ListNode? 형으로 자동 타입 캐스팅이 되어, 그 뒤쪽 코드에서 null 체크를 위해 `?`를 죄다 붙여줘야 함
- 코틀린의 깔끔한 while 문의 널 판별
  - `while (even?.next != null)`
 */

import datatype.ListNode

class OddEvenLinkedListK {
  fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null)
      return null

    var odd: ListNode = head  // 타입 선언 필요
    val evenHead = head.next
    var even = evenHead

    while (even?.next != null) {
      odd.next = odd.next.next
      even.next = even.next.next
      odd = odd.next
      even = even.next
    }

    odd.next = evenHead

    return head
  }
}
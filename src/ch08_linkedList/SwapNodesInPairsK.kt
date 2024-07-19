package ch08_linkedList

/* Trial 4

- Trial 3에 대한 코틀린 풀이
- 코틀린의 깔끔한 if 문의 널 판별
  - `if (head?.next != null)`
 */

import datatype.ListNode

class SwapNodesInPairsK {
  fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next != null) {
      val p = head.next
      head.next = swapPairs(head.next.next)
      p.next = head

      return p
    }

    return head
  }
}
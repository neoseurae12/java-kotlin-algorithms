package ch08_linkedList

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- 코틀린의 for 문법 => `until`
 */

import datatype.ListNode

class ReverseLinkedListIIK {
  fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null)
      return null

    val root = ListNode(0)
    root.next = head

    var start = root
    for (i in 0 until left - 1) {
      start = start.next
    }
    val end = start.next

    for (i in 0 until right - left) {
      val tmp = start.next
      start.next = end.next
      end.next = end.next.next
      start.next.next = tmp
    }

    return root.next
  }
}
package ch08_linkedList

/* Trial 3
- Trial 2에 대한 코틀린 풀이
 */

import datatype.ListNode

class ReverseLinkedListK {
  fun reverseList(head: ListNode?): ListNode? {
    var node = head
    var prev: ListNode? = null

    while (node != null) {
      val next = node.next
      node.next = prev
      prev = node
      node = next
    }

    return prev
  }
}
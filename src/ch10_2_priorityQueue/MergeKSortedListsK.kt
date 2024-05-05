package ch10_2_priorityQueue

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- 코틀린의 when
- 람다 표현식
 */

import datatype.ListNode
import java.util.PriorityQueue

class MergeKSortedListsK {
  fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val pq = PriorityQueue<ListNode> { o1, o2 ->
      when {
        o1.`val` == o2.`val` -> 0
        o1.`val` > o2.`val` -> 1
        else -> -1
      }
    }

    val root = ListNode(0)
    var tail = root

    for (list in lists) {
      if (list != null)
        pq.add(list)
    }

    while (!pq.isEmpty()) {
      tail.next = pq.poll()
      tail = tail.next

      if (tail.next != null)
        pq.add(tail.next)
    }

    return root.next
  }
}
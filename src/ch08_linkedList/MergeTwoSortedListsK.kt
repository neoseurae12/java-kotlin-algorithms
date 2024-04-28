package ch08_linkedList

/* Trial 2
- Trial 1에 대한 코틀린 풀이

- 리턴 시 if 를 표현'식'으로 활용
 */

import datatype.ListNode

class MergeTwoSortedListsK {
  fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    // 리턴 시 if 를 표현'식'으로 활용
    return if (list1.`val` > list2.`val`) {
      list2.next = mergeTwoLists(list1, list2.next)
      list2
    } else {
      list1.next = mergeTwoLists(list2, list1.next)
      list1
    }
  }
}
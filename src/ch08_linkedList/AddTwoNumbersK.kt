package ch08_linkedList

/* Trial 3

- Trial 2에 대한 코틀린 풀이

- 코틀린은 함수 파라미터를 조작 불가 => 조작하기 위해서는 var 별도 선언 필요
 */

import datatype.ListNode

class AddTwoNumbersK {
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    // 코틀린은 함수 파라미터를 조작 불가 => var 별도 선언
    var l1var = l1
    var l2var = l2

    var node = ListNode(0)
    val root = node

    var sum: Int
    var carry = 0
    var remainder: Int

    while (l1var != null || l2var != null || carry != 0) {
      sum = 0
      if (l1var != null) {
        sum += l1var.`val`
        l1var = l1var.next
      }
      if (l2var != null) {
        sum += l2var.`val`
        l2var = l2var.next
      }
      sum += carry

      remainder = sum % 10
      carry = sum / 10

      node.next = ListNode(remainder)
      node = node.next
    }

    return root.next
  }
}
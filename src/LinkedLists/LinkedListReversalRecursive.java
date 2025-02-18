package LinkedLists;

/*
- Recursive(재귀) 버전
    - 문제를 "점점 더 작은 버전"으로 나누고, 가장 작은 문제(base cases)를 해결한 뒤, 그걸 활용해서 원래 문제를 해결하는 방식
    - 재귀 '함수'의 호출
    - tip: 재귀 함수(Recursive Function)를 설계할 때, 자신이 만든 재귀 호출이 올바르게 동작할 것이라고 믿고 작성하라
- 시간복잡도: O(N)
- 공간복잡도: O(N) -- recursive call stack
 */

import datatype.ListNode;

public class LinkedListReversalRecursive {
    public static ListNode linkedListReversalRecursive(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = linkedListReversalRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode ln = linkedListReversalRecursive(ListNode.createList(1, 2, 4, 7, 3));
        while (ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
    }
}

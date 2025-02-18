package LinkedLists;

/*
- Iterative(반복) 버전
- Pointer Manipulation
    - 새로운 Linked List 를 만들지 않고도, 'in-place' 로 해결 가능
    - pointer 의 방향을 "flip" 시키자
    - prevNode, currNode, nextNode
    - 주의: pointer 를 manipulate 하는 도중에 reference 를 잃지 않게 유의할 것
    - 정지 조건: currNode == null
    - tip: pointer manipulation 을 "visualize"하라
- 시간복잡도: O(N)
- 공간복잡도: O(1)
 */

import datatype.ListNode;

public class LinkedListReversalIterative {
    public static ListNode linkedListReversalIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode ln = linkedListReversalIterative(ListNode.createList(1, 2, 4, 7, 3));
        while (ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
    }
}

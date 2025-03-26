package LinkedLists.test;

import LinkedLists.LinkedListIntersection;
import datatype.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListIntersectionTest {
    @Test
    void testLinkedListIntersection() {
        ListNode shared = ListNode.createList(8, 7, 2);

        ListNode headA = ListNode.createList(1, 3, 4);
        headA.next.next.next = shared;

        ListNode headB = ListNode.createList(6, 4);
        headB.next.next = shared;

        Assertions.assertEquals(8, LinkedListIntersection.linkedListIntersection(headA, headB).val);
    }
}
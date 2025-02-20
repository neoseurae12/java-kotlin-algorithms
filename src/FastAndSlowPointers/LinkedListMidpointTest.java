package FastAndSlowPointers;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListMidpointTest {
    @Test
    void testOddLengthList() {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode midpoint = LinkedListMidpoint.linkedListMidpoint(head);
        assertEquals(3, midpoint.val);
    }

    @Test
    void testEvenLengthList() {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode midpoint = LinkedListMidpoint.linkedListMidpoint(head);
        assertEquals(4, midpoint.val);
    }

    @Test
    void testSingleElementList() {
        ListNode head = new ListNode(1);

        ListNode midpoint = LinkedListMidpoint.linkedListMidpoint(head);
        assertEquals(1, midpoint.val);
    }
}
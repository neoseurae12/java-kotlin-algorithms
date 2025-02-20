package FastAndSlowPointers;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListLoopFastAndSlowTest {
    @Test
    void testNoLoop() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        assertFalse(LinkedListLoopFastAndSlow.linkedListLoopFastAndSlow(head));
    }

    @Test
    void testWithLoop() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        assertTrue(LinkedListLoopFastAndSlow.linkedListLoopFastAndSlow(head));
    }

    @Test
    void testEmptyList() {
        ListNode head = null;
        assertFalse(LinkedListLoopFastAndSlow.linkedListLoopFastAndSlow(head));
    }

    @Test
    void testSingleNodeNoLoop() {
        ListNode head = new ListNode(1);
        assertFalse(LinkedListLoopFastAndSlow.linkedListLoopFastAndSlow(head));
    }

    @Test
    void testSingleNodeWithLoop() {
        ListNode head = new ListNode(1);
        head.next = head;

        assertTrue(LinkedListLoopFastAndSlow.linkedListLoopFastAndSlow(head));
    }
}
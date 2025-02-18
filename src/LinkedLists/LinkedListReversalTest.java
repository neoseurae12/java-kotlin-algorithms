package LinkedLists;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListReversalTest {
    @Test
    void testLinkedListReversalIterative() {
        assertEquals(ListNode.createList(3, 7, 4, 2, 1), LinkedListReversalIterative.linkedListReversalIterative(ListNode.createList(1, 2, 4, 7, 3)));
    }

    @Test
    void testLinkedListReversalRecursive() {
        assertEquals(ListNode.createList(3, 7, 4, 2, 1), LinkedListReversalRecursive.linkedListReversalRecursive(ListNode.createList(1, 2, 4, 7, 3)));
    }
}
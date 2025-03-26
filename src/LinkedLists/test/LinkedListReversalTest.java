package LinkedLists.test;

import LinkedLists.LinkedListReversalIterative;
import LinkedLists.LinkedListReversalRecursive;
import datatype.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListReversalTest {
    @Test
    void testLinkedListReversalIterative() {
        Assertions.assertEquals(ListNode.createList(3, 7, 4, 2, 1), LinkedListReversalIterative.linkedListReversalIterative(ListNode.createList(1, 2, 4, 7, 3)));
    }

    @Test
    void testLinkedListReversalRecursive() {
        Assertions.assertEquals(ListNode.createList(3, 7, 4, 2, 1), LinkedListReversalRecursive.linkedListReversalRecursive(ListNode.createList(1, 2, 4, 7, 3)));
    }
}
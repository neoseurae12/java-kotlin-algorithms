package SortAndSearch.test;

import SortAndSearch.SortLinkedList;
import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortLinkedListTest {
    private boolean isSameList(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == null && l2 == null;
    }

    @Test
    void testEmptyList() {
        ListNode input = null;
        ListNode result = new SortLinkedList().sortLinkedList(input);
        assertNull(result);
    }

    @Test
    void testSingleNode() {
        ListNode input = new ListNode(5);
        ListNode result = new SortLinkedList().sortLinkedList(input);
        assertSame(input, result);
    }

    @Test
    void testMultipleNodesUnsorted_OddLength() {
        ListNode input = ListNode.createList(3, 2, 4, 5, 1);
        ListNode expected = ListNode.createList(1, 2, 3, 4, 5);
        ListNode result = new SortLinkedList().sortLinkedList(input);
        assertTrue(isSameList(expected, result));
    }

    @Test
    void testMultipleNodesUnsorted_EvenLength() {
        ListNode input = ListNode.createList(4, 2, 1, 3, 6, 5);
        ListNode expected = ListNode.createList(1, 2, 3, 4, 5, 6);
        ListNode result = new SortLinkedList().sortLinkedList(input);
        assertTrue(isSameList(expected, result));
    }

    @Test
    void testAlreadySorted() {
        ListNode input = ListNode.createList(1, 2, 3);
        ListNode expected = ListNode.createList(1, 2, 3);
        ListNode result = new SortLinkedList().sortLinkedList(input);
        assertTrue(isSameList(expected, result));
    }

    @Test
    void testWithDuplicates() {
        ListNode input = ListNode.createList(4, 1, 2, 1);
        ListNode expected = ListNode.createList(1, 1, 2, 4);
        ListNode result = new SortLinkedList().sortLinkedList(input);
        assertTrue(isSameList(expected, result));
    }
}
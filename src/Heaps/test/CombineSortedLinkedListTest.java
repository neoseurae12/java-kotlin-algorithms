package Heaps.test;

import Heaps.CombineSortedLinkedList;
import datatype.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CombineSortedLinkedListTest {
    @Test
    void testBasicCase() {
        ListNode ln1 = ListNode.createList(1, 6);
        ListNode ln2 = ListNode.createList(1, 4, 6);
        ListNode ln3 = ListNode.createList(3, 7);

        List<ListNode> lists = List.of(ln1, ln2, ln3);
        ListNode actual = CombineSortedLinkedList.combineSortedLinkedLists(lists);

        ListNode expected = ListNode.createList(1, 1, 3, 4, 6, 6, 7);
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyLists() {
        ListNode ln1 = null;
        ListNode ln2 = null;

        List<ListNode> lists = new ArrayList<>();
        lists.add(ln1);
        lists.add(ln2);

        ListNode result = CombineSortedLinkedList.combineSortedLinkedLists(lists);
        assertNull(result);
    }

    @Test
    void testSingleListOnly() {
        ListNode l1 = ListNode.createList(1, 2, 3);

        List<ListNode> lists = List.of(l1);
        ListNode actual = CombineSortedLinkedList.combineSortedLinkedLists(lists);

        ListNode expected = ListNode.createList(1, 2, 3);
        assertEquals(expected, actual);
    }

    @Test
    void testAllListsEmpty() {
        List<ListNode> lists = List.of();
        ListNode result = CombineSortedLinkedList.combineSortedLinkedLists(lists);

        assertNull(result);
    }
}
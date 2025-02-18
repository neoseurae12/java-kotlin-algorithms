package LinkedLists;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveKthLastNodeTest {
    @Test
    void testRemoveKthLastNode() {
        assertEquals(
            ListNode.createList(1, 2, 4, 3),
            RemoveKthLastNode.removeKthLastNode(ListNode.createList(1, 2, 4, 7, 3), 2)
        );
    }
}
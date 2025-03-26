package LinkedLists.test;

import LinkedLists.RemoveKthLastNode;
import datatype.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveKthLastNodeTest {
    @Test
    void testRemoveKthLastNode() {
        Assertions.assertEquals(
            ListNode.createList(1, 2, 4, 3),
            RemoveKthLastNode.removeKthLastNode(ListNode.createList(1, 2, 4, 7, 3), 2)
        );
    }
}
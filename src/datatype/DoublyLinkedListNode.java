package datatype;

import java.util.Objects;

public class DoublyLinkedListNode {
    public int val;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;
    public int key;

    public DoublyLinkedListNode() {
        this.val = Integer.MIN_VALUE;
    }

    public DoublyLinkedListNode(int val) {
        this.val = val;
    }

    public DoublyLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    public static DoublyLinkedListNode createDoublyLinkedList(int... values) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(values[0]);
        DoublyLinkedListNode prev = head;
        for (int i = 1; i < values.length; i++) {
            prev.next = new DoublyLinkedListNode(values[i]);
            prev.next.prev = prev;
            prev = prev.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoublyLinkedListNode doublyLinkedListNode = (DoublyLinkedListNode) o;
        return val == doublyLinkedListNode.val &&
                Objects.equals(next, doublyLinkedListNode.next) &&
                Objects.equals(prev, doublyLinkedListNode.prev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}

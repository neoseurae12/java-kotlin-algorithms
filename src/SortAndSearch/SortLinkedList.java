package SortAndSearch;

/*
- Sort and Search > Sort
- Stable Sorting
    - Merge Sort ∈ Stable Sorting algorithm
 */

import datatype.ListNode;

public class SortLinkedList {
    public ListNode sortLinkedList(ListNode head) {
        // 만약 linked list가 비어있거나 1개의 node만을 가진다면 => 이미 정렬됨을 의미
        if (head == null || head.next == null)
            return head;

        ListNode secondHead = splitList(head);

        // 첫 번째 반절 & 두 번째 반절 각각 정렬 (재귀)
        ListNode firstHalfSorted = sortLinkedList(head);
        ListNode secondHalfSorted = sortLinkedList(secondHead);

        // 정렬된 첫 번째 반절 & 두 번째 반절 -> 합치기(merge)
        return merge(firstHalfSorted, secondHalfSorted);
    }

    private ListNode splitList(ListNode head) {
        // fast and slow pointer 기법
        ListNode slow, fast;
        slow = fast = head;
        // linked list의 길이가 홀수일 경우, 짝수일 경우 모두 고려
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;   // 첫 번째 반절과 두 번째 반절 간의 연결 해제

        return secondHead;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // 아직 끝나지 않은 linked list가 있을 경우 => 모든 나머지 갖다 붙이기
        tail.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}

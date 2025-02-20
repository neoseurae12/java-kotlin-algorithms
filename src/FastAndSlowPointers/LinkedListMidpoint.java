package FastAndSlowPointers;

/*
- Fractional Point Identification
- 풀이방식에 따른 iteration 의 수 차이
    - 직관적이기만 한 풀이방식 => iteration 2
        - 1. linked list 의 길이 알아내기
        - 2. linked list 의 길이의 절반만큼만 가서 midpoint 알아내기
    - fast and slow pointer 풀이방식 => iteration 1
        - 1. fast pointer 에 끝에 다달았을 때, slow pointer 는 midpoint 를 가리키고 있을 것
- linked list 의 길이에 따른 정지 조건
    - 짝수 길이일 경우
        - second middle point 일 경우 => fast == null
        - first middle point 일 경우 => fast.next.next == null
        - 팁: 짝수 길이일 경우 middle point 가 first 일지 second 일지 등과 같은 모호성을 알아채자.
    - 홀수 길이일 경우 => fast.next == null
- 시간복잡도: O(N)
- 공간복잡도: O(1)
 */

import datatype.ListNode;

public class LinkedListMidpoint {
    public static ListNode linkedListMidpoint(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        // 짝수 길이일 경우 => fast == null 일 때의 slow 반환
        // 홀수 길이일 경우 => fast.next == null 일 때의 slow 반환
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

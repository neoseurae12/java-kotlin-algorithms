package FastAndSlowPointers;

/*
- Fast and Slow Pointers
    - two-pointer 패턴의 특별 유형
    - two-pointer
        - 1. slow pointer => 1 스텝씩 이동
        - 2. fast pointer => 2 스텝씩 이동
    - 실세계 예시: symlinks 의 cycle 판별하기
    - 인덱스 기반으로 접근할 수 없는 'Linked List' 에 유용한 방식
    - Floyd's Circle Detection 알고리즘
        - cycle 이 존재한다면, slow pointer 와 fast pointer 사이의 distance 가 1씩 증가했다가 1씩 감소하면서, 필연적으로 distance 가 0, 즉 만나게 된다.
    - 빠른 포인터가 느린 포인터를 따라잡는 데 필요한 최대 단계 수: k 단계 (둘 다 사이클에 있을 때)
        - k: 사이클의 길이
        - 최악의 경우: n 단계
            - linked list 의 모든 노드가 사이클에 포함된 경우
- 시간복잡도: O(N)
- 공간복잡도: 0(1) -- constant space 로 최적화
 */

import datatype.ListNode;

public class LinkedListLoopFastAndSlow {
    public static boolean linkedListLoopFastAndSlow(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}

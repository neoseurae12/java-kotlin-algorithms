package ch08_linkedList;

/* Trial 2

- '반복 구조' 를 활용한 풀이
    - while 문 & 종료조건
 */

import datatype.ListNode;

public class ReverseLinkedListJ_1 {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode prev = null;   // 우리가 제출할 정답 타겟

        while (node != null) {
            // 정순서의 연결리스트로부터 현재 위치의 노드 분리
            ListNode next = node.next;
            // 현재 위치의 노드를 역순서의 연결리스트에 연결
            node.next = prev;
            prev = node;
            // 현재 위치의 노드 업데이트
            node = next;
        }

        return prev;
    }
}

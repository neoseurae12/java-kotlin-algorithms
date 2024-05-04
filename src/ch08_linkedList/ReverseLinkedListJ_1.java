package ch08_linkedList;

/* Trial 2

- '반복 구조' 를 활용한 풀이
    - while 문 & 종료조건
- [차이점] 재귀 구조 vs. 반복 구조
    - 재귀 구조
        - [장점]
            - 코드가 더 짧은 편
            - 훨씬 더 우아한 풀이라는 느낌을 줌
        - [단점]
            - 코드를 이해하기가 더 어려운 편
    - 반복 구조
        - [장점]
            - 메모리를 더 적게 차지하는 편
            - 실행 속도도 더 빠른 편
            - 코드를 이해하기가 더 쉬운 편
        - [단점]
            - 코드가 더 긴 편
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

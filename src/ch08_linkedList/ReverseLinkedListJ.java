package ch08_linkedList;

/* Trial 1

- 연결 리스트를 뒤집는 문제
    - 실무에서도 일반적으로 빈번하게 쓰이는 활용도 높은 문제
- '재귀 구조' 를 활용한 풀이
    - 정순서의 연결리스트(`node`) vs. 역순서의 연결리스트(`prev`)
    - 우리가 제출할 정답 타겟에 대한 인지 및 집중 => 역순서의 연결리스트(`prev`)
    - 재귀 구조 => '종료조건' 필수 고려
 */

import datatype.ListNode;

public class ReverseLinkedListJ {
    public ListNode reverse(ListNode node, ListNode prev) {
        // 재귀의 종료조건: 정순서의 연결리스트(`node`)가 모두 소진(null) 되었을 때
            // == 역순서의 연결리스트(`prev`)가 모두 완성 됨
        if (node == null) {
            return prev;
        }

        // 정순서의 연결리스트로부터 현재 위치의 노드 분리
        ListNode next = node.next;
        // 현재 위치의 노드를 역순서의 연결리스트에 연결
        node.next = prev;
        // 재귀 호출
        return reverse(next, node);
    }

    public ListNode reverseList(ListNode head) {
         return reverse(head, null);
    }
}

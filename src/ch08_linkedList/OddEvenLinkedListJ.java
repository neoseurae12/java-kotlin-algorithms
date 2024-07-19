package ch08_linkedList;

/* Trial 1

- 반복 구조로 홀짝 노드 처리
- 제약 사항: 공간 복잡도 O(1), 시간 복잡도 O(n)
    - 공간 복잡도 O(1)
        - odd, even, evenHead 변수들이 n 의 크기에 관계없이 항상 일정하게 사용됨
    - 시간 복잡도 O(n)
        - while 문 1개
        - 그마저도 홀&짝으로 한 번에 2개씩 처리함
- 시행착오: 홀/짝 하나씩 처리 --> 홀&짝 함께 처리
    - 처음에 홀 또는 짝으로 하나씩 처리했더니 시간 초과 떴었음
 */

import datatype.ListNode;

public class OddEvenLinkedListJ {
    public ListNode oddEvenList(ListNode head) {
        // 예외 처리
        if (head == null)
            return null;

        // 홀수 노드
            // oddHead 는 어차피 head 나 마찬가지라 따로 선언 안 함
        ListNode odd = head;
        // 짝수 노드
        ListNode evenHead = head.next;
        ListNode even = evenHead;

        // 반복
            // 홀 & 짝 함께 처리
            // 모든 노드의 개수가 홀수 개일 경우 => even == null 일 것 / 짝수 개일 경우 => even.next == null 일 것
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // 홀수 노드 마지막 & 짝수 노드 첫 번째 간의 연결
        odd.next = evenHead;

        return head;
    }
}

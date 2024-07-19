package ch08_linkedList;

/* Trial 3

- 연결 리스트 자체를 바꾸는 방법 with '재귀' 구조
    - Trial 2 의 장점 & 단점
      + '반복' 구조인 Trial 2보다 훨씬 더 깔끔한 풀이
        - 불필요한 변수 사용 X => 낮은 공간 복잡도
            - 포인터 역할을 하는 변수는 p 하나만 있어도 충분하다.
            - 더미 노드를 만들 필요 없이 바로 head 를 리턴할 수 있다.
        - 빈틈 없는 코드 구조 => 짜임새 있고 매우 우아한 풀이
            - 재귀 호출로 계속 스왑된 값을 리턴받게 되면서 연결 리스트가 이어지게 된다.
 */

import datatype.ListNode;

public class SwapNodesInPairsJ_2 {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode p = head.next;
            head.next = swapPairs(head.next.next);
            p.next = head;

            return p;
        }

        return head;
    }
}
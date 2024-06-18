package ch08_linkedList;

/* Trial 1

- 연결 리스트의 노드를 변경하는 게 아닌, 노드 구조는 그대로 유지하되 값만 변경하는 방법
    - 장점: 매우 직관적이다
    - 단점
        - 다소 변칙적인 방법이다
            - 코드 리뷰를 진행하다 좋지 않은 피드백을 받을 가능성이 있다
            - 안 좋은 피드백을 받게 된다면, 쉽게 풀기 위해 시도한 방법이라는 사실을 충분히 어필하고 다른 풀이법(Trial 2)에 대해 충분히 설명할 수 있어야 한다
        - 실용성과는 다소 거리가 있다
            - 대개 연결 리스트는 복잡한 여러 가지 값들의 구조체로 구성되어 있고, 사실상 값만 바꾸는 것은 매우 어려운 일이다
            - 이 문제에서는 단 하나의 값으로 구성된 단순한 연결 리스트이기 때문에 본 방법으로 풀이가 가능한 것임
 */

import datatype.ListNode;

public class SwapNodesInPairsJ {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;

        while (node != null && node.next != null) {
            int tmp = node.next.val;
            node.next.val = node.val;
            node.val = tmp;

            node = node.next.next;
        }

        return head;
    }
}

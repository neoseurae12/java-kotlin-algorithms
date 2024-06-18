package ch08_linkedList;

/* Trial 2

- 연결 리스트 자체를 바꾸는 방법 with '반복' 구조
    - 장점
        - 원칙적인 방법이다
        - 실용적인 방법이다
    - 단점: 단순히 값을 바꾸는 일에 비해서는 다소 복잡한 편이다
- 임시 노드 및 기준 노드의 필요성
    - 이유: 단순히 swap 시킬 노드들 2개만 바꾼다고 끝나는 문제가 아니라 그 앞 & 뒤의 노드 간의 연결 관계도 다같이 변경해야 하기 때문에, 특히 '앞'의 노드 간의 연결 관계의 변경을 위해 임시 노드이자 기준 노드인 `ListNode node = new ListNode(0);` 의 선언이 필요하다.
    - 기준 노드를 도입했다면, 기준 노드를 기준으로 생각하자.
 */

import datatype.ListNode;

public class SwapNodesInPairsJ_1 {
    public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);    // 임시 노드 및 기준 노드
        ListNode root = node;
        node.next = head;

        // 현재 노드를 기준으로 뒤에 swap 시킬 노드들 2개가 더 있는 경우에만 swap 진행시키기
        while (node.next != null && node.next.next != null) {
            // node: 현재 노드 / a: 다음 노드 / b: 다다음 노드
            ListNode a = node.next;
            ListNode b = node.next.next;

            // [... -> node -> a -> b -> ...] --> [... -> node -> b -> a -> ...]
                // 현재 노드인 node 를 기준으로 생각할 것
            a.next = b.next;    // 뒤 연결
            node.next = b;      // 앞 연결         // 현재 노드의 다음
            node.next.next = a; // a <-> b 스왑   // 현재 노드의 다다음

            node = node.next.next;
        }

        return root.next;
    }
}

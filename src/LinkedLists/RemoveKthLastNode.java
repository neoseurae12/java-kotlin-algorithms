package LinkedLists;

/*
- 노드의 삭제
    - 삭제하려는 노드의 '바로 앞 노드'를 찾아야 한다.
- dummy node
    - edge case: 만약 head 를 지워야 한다면?
    - head 의 '바로 앞 노드'가 존재해야 한다 => dummy node 의 추가
- leader & trailer 방식
    - linked list 전체를 두 번이 아닌 한 번만 돌고도 해결할 수 있는 방법
    - leader 가 trailer 보다 k번 먼저 앞서 나가기
    - k 만큼의 격차를 유지한 채로 linked list 전체 탐색 (-> 1번)
- 시간복잡도: O(N)
- 공간복잡도: O(1)
 */

import datatype.ListNode;

public class RemoveKthLastNode {
    public static ListNode removeKthLastNode(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode trailer = dummyNode;
        ListNode leader = dummyNode;

        while (k-- > 0) {
            leader = leader.next;

            // 만약 k가 linked list 의 길이보다도 크다면, 삭제 불가 => 그대로 반환
            if (leader == null)
                return head;
        }

        while (leader.next != null) {
            trailer = trailer.next;
            leader = leader.next;
        }

        trailer.next = trailer.next.next;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode ln = removeKthLastNode(ListNode.createList(1, 2, 4, 7, 3), 2);
        while (ln != null) {
            System.out.print(ln.val + " ");
            ln = ln.next;
        }
    }
}

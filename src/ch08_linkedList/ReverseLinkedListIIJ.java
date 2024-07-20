package ch08_linkedList;

/* Trial 1

- 반복 구조로 노드 뒤집기
- 변동성이 강하다면, 그 변동성에 생각이 휘둘릴 것이 아니라, 그 와중에도 '변하지 않는 것'을 찾아 그것을 기준으로 변동을 진행해야 한다.
    - 본 문제에서는 start 와 end 가 '끝까지 값이 변하지 않는 변수'였다.
    - 매 반복마다 end 의 바로 뒤 노드를 start 의 바로 뒤로 땡겨와준다고 생각하면 쉬웠다.
- root 노드의 필요성
    - root 노드을 선언하지 않고 start 에 head 를 곧바로 넣어주게 되면 left 가 1일 때와 2일 때를 각각 구분하지 못하게 된다.
    - root 노드 없이 작성한 풀이가 통과하지 못한 테스트케이스: head = [3,5], left = 1, right = 2
- 연결 리스트의 연결 순서
    - 앞쪽 -> 뒷쪽 -> 중간 연결
    - 시행착오: '앞쪽 -> 중간 연결 -> 뒷쪽' --> '앞쪽 -> 뒷쪽 -> 중간 연결'
        - 코드의 순서만 달랐을 뿐인데 "Error - Found cycle in the ListNode" 에러가 떴음
 */

import datatype.ListNode;

public class ReverseLinkedListIIJ {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 예외 처리
        if (head == null)
            return null;

        // root 노드 추가
        ListNode root = new ListNode(Integer.MAX_VALUE);
        root.next = head;

        // 변경의 와중에도 끝까지 값이 변하지 않는 변수: start & end
        ListNode start = root;
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        ListNode end = start.next;

        // start & end 를 기준으로 위치 변경 진행
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;  // 앞쪽
            end.next = end.next.next;   // 뒷쪽
            start.next.next = tmp;  // 앞쪽과 뒷쪽 간의 연결
        }

        // root 노드의 다음부터를 결과로 리턴
        return root.next;
    }
}

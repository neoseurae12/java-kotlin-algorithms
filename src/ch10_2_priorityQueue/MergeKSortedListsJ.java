package ch10_2_priorityQueue;

/* Trial 1

- '우선순위 큐(Priority Queue)'를 이용한 리스트 병합
    - 우선순위 큐 with `Comparator`
        - compare() 메서드로 정의한 순서에 따른 우선순위 큐
        - 작은 값일수록 더 우선순위를 가짐
        - 성능 향상: 익명 클래스 -> 람다 표현식
    - 연결 리스트
        - 단순한 노드 하나가 아니라, 그 뒤의 노드들까지 다 딸려 '연결'되어있는 노드 임을 숙지할 것
- 우선순위 큐가 모두 소진될 때까지, tail 의 교체 및 연결 반복
 */

import datatype.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedListsJ {
    public ListNode mergeKLists(ListNode[] lists) {
        // 우선순위 큐 with `Comparator`
            // ListNode 클래스가 Comparable 인터페이스를 구현하고 있지 않아,
            // 만약 PriorityQueue 의 '기본' 생성자(`new PriorityQueue<>()`)를 사용하여 생성한다면 ClassCastException 발생하게 됨.
        // 여기서의 Comparator
            // 정렬 순서: 오름차순
            // 작은 값일수록 더 앞에 배치함
        // 성능 향상: 익명 클래스 (`new Comparator<ListNode>() { ... }`) -> 람다 표현식 (`(o1, o2) -> { ... }`)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> {  // o1: 새로운 값, o2: 기존 값
            // 동일한 경우 => 무시
            if (o1.val == o2.val)
                return 0;
            // 새로운 값 > 기본 값 => 새로운 값을 '뒤'에 배치
            else if (o1.val > o2.val)
                return 1;
            // 새로운 값 < 기본 값 => '앞'에 배치
            else
                return -1;
        });

        ListNode root = new ListNode(0);    // 정답 제출 타깃
        ListNode tail = root;   // 몸통과 꼬리의 연결 지점

        // 각 연결 리스트의 '첫 번째' 노드를 우선순위 큐에 저장
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // 우선순위 큐가 모두 소진될 때까지, tail 의 교체 및 연결 반복
        while (!pq.isEmpty()) {
            tail.next = pq.poll();  // 우선순위에 따라 pq 에서 가장 작은 값 추출 & tail 교체 및 연결
            tail = tail.next;       // tail 의 위치 업데이트

            // 방금 추출한 연결 리스트의 다음 노드로 우선순위 큐의 빈 자리 채우기
            if (tail.next != null) {
                pq.add(tail.next);
            }
        }

        // root 의 '다음' 노드부터가 정답에 해당함
        return root.next;
    }
}

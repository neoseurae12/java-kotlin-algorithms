package Heaps;

/*
- Heaps > Sorting
    - 1. 먼저 "단 2개"의 sorted linked list들에 대한 combining은 어떻게 할 수 있을지부터 생각해보자!
        - "pointer"
        - pointer 사용 시의 과정
            - 1) 각 linked list의 pointer가 가리키고 있는 node의 값 2개를 비교한다.
            - 2) 둘 중 더 작은 값의 pointer를 output linked list에 추가한다.
            - 3) pointer를 다음 node로 이동시킨다.
    - 2. 이제 "k개(2개보다 더 많은)" sorted linked list들을 combining하는 경우를 생각해보자!
        - '단 2개' 경우에서처럼 pointer를 사용한다면?
            - 매 iteration마다 k개의 sorted linked list들에 대한 k번의 '비교'가 요구되게 된다.
            - 각 iteration에서 최솟값을 가지는 node가 어느 것인지 모르기 때문에 매번 search가 요구된다.
            - 너무 많은 비교가 수행된다...
        - 효율적인 해결책: Min Heap
            - 언제든지 최솟값을 바로 식별해 접근할 수 있는 자료구조
            - Min Heap 사용 시의 과정
                - 1) Min Heap에서 최솟값 node를 꺼낸다; poll(pop)
                - 2) output linked list의 뒷부분에 최솟값 node를 연결한다
                - 3) Min Heap에 방금 전 최솟값 node의 다음 node를 넣어준다; offer(push)
- 시간복잡도: O(N log K)
    - Min Heap 생성 => O(K log K)
    - output linked list 생성 => N * O(log K)
- 공간복잡도: Min Heap => O(K)

- add() vs. offer()
    - add()
        - Collection 인터페이스에 정의됨
        - 실패 시 => 예외 (IllegalStateException) 발생
            - 언제 실패하나? => ArrayBlockingQueue와 같이, 용량 제한이 있는 큐에서 용량 초과를 했을 시
    - offer()
        - Queue 인터페이스에 정의됨
        - 실패 시 => false 반환
    - PriorityQueue => 무제한 큐
        - add()와 offer() 간의 차이가 크게 두드러지지 않음
        - BUT offer() => 더 Semantically 정확 & 안정적
- 인터뷰 팁
    - 문제에서 제공한 구조(ListNode 등)를 수정하거나 글로벌하게 바꾸려면, 면접관한테 확인 먼저 하자!
 */

import datatype.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CombineSortedLinkedList {
    public static ListNode combineSortedLinkedLists(List<ListNode> lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(self -> self.val));
        for (ListNode head : lists)
            if (head != null) minHeap.offer(head);

        ListNode dummy = new ListNode(-1);
        ListNode currNode = dummy;
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll();
            currNode.next = smallestNode;
            currNode = currNode.next;
            if (smallestNode.next != null)
                minHeap.offer(smallestNode.next);
        }

        return dummy.next;
    }
}

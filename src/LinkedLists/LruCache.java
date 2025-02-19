package LinkedLists;

/*
- Doubly Linked List
- LRU: Least Recently Used
- 주요 연산
    - 1. put 연산
        - 연산 1: LRU 삭제
        - 연산 2: MRU(Most Recently Used) 추가
    - 2. get 연산
        - 연산 3: MRU 로 이동시키기
        - 연산 4: key 를 이용해 value 에 접근하기
- 디자인(설계) 문제
    - 문제 잘 이해하고, 어떤 자료구조를 사용하면 좋을지 결정하기
    - 둘 이상의 자료구조를 결합(combining)하는 것도 잘 생각해볼 것
    - 연산 1, 2 => Linked List > Doubly Linked List
        - 효율적인 추가/삭제
    - 연산 3, 4 => Hash Map
        - (key, node) 페어
        - key 를 통해, Linked List 상에서의 node 의 위치에 상관없이 바로 접근 가능
- Singly vs. Doubly Linked List
    - head 의 추가/삭제
        - singly & doubly: O(1)
    - tail 의 삭제
        - singly: O(N)
            - tail 에 대한 reference 를 가지고 있다고 해도, tail 을 삭제하기 위해서는 tail 의 직전 노드에 대한 reference 를 가지기 위해 traverse 해야 함
        - doubly: O(1)
- 새로운 노드 추가 시, 새로운 노드를 먼저 연결 후, 기존 노드들에 대한 pointer manipulation 을 하는 것이 더 수월함
- 시간복잡도: O(1)
- 공간복잡도: O(N)
 */

import datatype.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    int capacity;
    Map<Integer, DoublyLinkedListNode> cache;
    DoublyLinkedListNode head, tail;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new DoublyLinkedListNode(-1);
        tail = new DoublyLinkedListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Hash Map 에서 key 에 해당하는 value 객체 찾기
        // 없다면 => -1 반환
        if (!cache.containsKey(key))
            return -1;

        // 있다면
        // 해당 value 객체를 '가장 최신'으로 갱신하기
        DoublyLinkedListNode node = cache.get(key);
        removeNode(node);
        addToTail(node);

        // 해당 value 객체의 값 반환
        return node.val;
    }

    public void put(int key, int value) {
        // Hash Map 에 key 검색
        // 이미 존재하는 key 라면 => 노드 삭제
        if (cache.containsKey(key))
            removeNode(cache.get(key));

        // 가장 최신에다 새로운 노드 추가
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
        addToTail(newNode);

        // 현재 캐시 사이즈 검사
        if (cache.size() > capacity) {
            // '가장 오래된' 노드 삭제
            removeNode(head.next);
        }
    }

    public void addToTail(DoublyLinkedListNode node) {
        // 가장 최신에다 노드 연결 -- 가장 최신이 될 노드 관점
        node.next = tail;
        node.prev = tail.prev;
        // 가장 최신에다 노드 연결 -- 가장 최신이었던 노드 관점
        tail.prev.next = node;
        tail.prev = node;

        cache.put(node.key, node);
    }

    public void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        cache.remove(node.key);
    }
}
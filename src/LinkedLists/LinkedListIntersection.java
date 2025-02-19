package LinkedLists;

/*
- Traversal
- "intersection"
    - 두 개의 linked lists -> converge -> tail 을 공유(shared)
    - 주의: 노드의 '값(value)'과는 상관 없음
- 큰 힌트: 두 개의 linked lists 의 길이가 "같다"면 풀이가 굉장히 쉬워진다.
    - 핵심 결론: 'A -> B' & 'B -> A' => 길이는 같아지고 여전히 tail 을 공유한다.
    - 'A -> B' & 'B -> A' 하기 위해 실제로 A와 B를 합칠 필요 없이 그저 연결만 시켜주면 된다.
- 시간복잡도: O(N + M)
- 공간복잡도: O(1)
 */

import datatype.ListNode;

public class LinkedListIntersection {
    public static ListNode linkedListIntersection(ListNode headA, ListNode headB) {
        ListNode ptrAtoB = headA;
        ListNode ptrBtoA = headB;

        while (ptrAtoB != ptrBtoA) {
            // ptrAtoB 이동
            ptrAtoB = ptrAtoB == null ? headB : ptrAtoB.next;

            // ptrBtoA 이동
            ptrBtoA = ptrBtoA == null ? headA : ptrBtoA.next;
        }

        return ptrAtoB;
    }

    public static void main(String[] args) {
        ListNode shared = ListNode.createList(8, 7, 2);

        ListNode headA = ListNode.createList(1, 3, 4);
        headA.next.next.next = shared;

        ListNode headB = ListNode.createList(6, 4);
        headB.next.next = shared;

        ListNode result = linkedListIntersection(headA, headB);

        System.out.println(result.val);
    }
}

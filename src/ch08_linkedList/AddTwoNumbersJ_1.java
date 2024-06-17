package ch08_linkedList;

/* Trial 2

- 논리 회로의 전가산기(Full Adder) 와 유사한 형태로 구현한 방식
    - 자료형을 일일이 변환하던 Trial 1 풀이에 비해, 훨씬 깔끔하고 우아하고 빠른 풀이
- 자리올림수도 0이 될 때까지 진행하는 이유
    - 자리올림수로 인해 연결 리스트의 자릿수가 하나 늘어나는 경우까지 고려
    - ex) 891(3자리) + 123(3자리) = 1014(4자리)
- while 문의 종료조건 꼭 신경 써주기!
    - l1 = l1.next; l2 = l2.next; node = node.next; 를 안 해줘서 시간 초과 떴었음
- null 여부 꼭 신경 써주기!
    - if (l1 != null) {...}, if (l2 != null) {...} 를 안 해줘서 NPE 발생할 뻔함
- 임시 노드
 */

import datatype.ListNode;

public class AddTwoNumbersJ_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);    // 값 계산에 사용할 임시 노드
        ListNode root = node;   // 임시 노드를 첫 번째 노드로 선언함

        int sum, remainder, carry = 0;

        // 모든 연결 리스트를 끝까지 순회 & 자리올림수도 0이 될 때까지 진행
        // 자리올림수도 0
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;

            remainder = sum % 10;
            carry = sum / 10;

            node.next = new ListNode(remainder);
            node = node.next;
        }

        return root.next; // 임시 노드를 첫 번째 노드로 선언했기 때문에 그 다음(root.next)를 결과로 리턴해야 함
    }
}

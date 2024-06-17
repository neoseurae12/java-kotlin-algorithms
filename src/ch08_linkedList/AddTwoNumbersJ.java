package ch08_linkedList;

/* Trial 1

- 자료형을 변환하여 풀이하는 방식
    - 연결 리스트 -> 문자열 -> 숫자 -> 연결 리스트
- Integer 대신에 BigInteger 로 선언한 이유
    - 문제의 제한조건
        - "The number of nodes in each linked list is in the range [1, 100]."
    - Integer 로 선언할 경우 최댓값을 초과하는 오류가 발생함
    - 해결책: 아무리 큰 숫자라도 문제없도록 자바에서 지원하는 임의 정밀도 정수형인 BigInteger 로 선언하여 풀이함
 */

import datatype.ListNode;
import java.math.BigInteger;
import java.lang.Character;

public class AddTwoNumbersJ {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 'reversed'-order Linked List 를 정방향으로 되돌리기
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);

        // 2. Linked List 를 문자열로 이어 붙인 후 숫자로 변환하기
        // 3. 숫자의 덧셈 계산
        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));

        // 4. 계산 결과를 다시 'reversed'-order Linked List 로 변환
        return toReversedLinkedList(result);
    }

    public ListNode reverseList(ListNode head) {
        ListNode node = head, prev = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    // Integer 대신에 BigInteger 로 선언
    public BigInteger toBigInt(ListNode node) {
        StringBuilder val = new StringBuilder();
        while (node != null) {
            val.append(node.val);
            node = node.next;
        }

        return new BigInteger(val.toString());
    }

    public ListNode toReversedLinkedList(BigInteger val) {
        ListNode node, prev = null;

        for (char c : String.valueOf(val).toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return prev;
    }
}

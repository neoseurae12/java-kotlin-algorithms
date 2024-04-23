package ch08_linkedList;

/* Trial 2

- 데크(Deque) 를 활용한 풀이
- 데크 => '앞뒤로' 모두 추출 가능한 자료구조
    - 이중 연결 리스트 구조
    - 추출(양방향)의 시간 복잡도: O(1)
    - pollFirst() & pollLast()

- 엘리먼트의 개수가 '짝수' 개일 경우 & '홀수' 개일 경우 모두 고려할 것
 */

import datatype.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedListJ_1 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();

        // 연결 리스트를 데크에 복사해넣음
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        // 데크의 양 끝값 비교 => 팰린드롬 판별
        while (!deque.isEmpty() && deque.size() > 1) {  // 데크의 엘리먼트가 '짝수' 개일 경우 & '홀수' 개일 경우 모두 고려
            if (deque.pollFirst() != deque.pollLast())
                return false;
        }
        return true;
    }
}

package ch08_linkedList;

/* Trial 1

- 스택(Stack) 을 활용한 풀이

- 팰린드롬의 여부 판별 => '앞뒤로' 모두 추출 가능한 자료구조 필요
    - 앞 => 연결 리스트
    - 뒤 => 스택
- [주의] Stack<>() => 더 이상 사용해선 안 되는 자료형
 */

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PalindromeLinkedListJ {
    public boolean isPalindrome(ListNode head) {
        // [주의] Stack<>() => 더 이상 사용해선 안 되는 자료형
        Stack<Integer> stack = new Stack<>();

        // 연결리스트를 스택에 복사해넣음
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        // 연결리스트(앞부터) & 스택(뒤부터) 의 값 비교 => 팰린드롬 판별
        while (!stack.isEmpty()) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }

        return true;
    }
}

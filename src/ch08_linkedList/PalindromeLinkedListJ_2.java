package ch08_linkedList;

/* Trial 3

- '러너(Runner) 기법' 을 활용한 풀이
    - 아무런 자료형을 사용하지 않고 단순히 러너 기법만을 활용함 => 매우 빠른 실행속도
    - '연결리스트'답게 풀이한 우아한 방식
    - 빠른 러너(Fast Runner), 느린 러너(Slow Runner), rev(역순 연결 리스트)
        - 빠른 러너 => 2칸씩
        - 느린 러너 => 1칸씩
        - 팰린드롬이 맞다면 => 팰린드롬 후반부의 '역순' 연결 리스트 == 팰린드롬 전반부의 연결 리스트
- rev 생성 방법 => 일명 '꼬리 바꿔 껴주기'
 */

import datatype.ListNode;

public class PalindromeLinkedListJ_2 {
    public boolean isPalindrome(ListNode head) {
        // 러너 기법; 빠른 러너, 느린 러너
        ListNode fast = head, slow = head;

        // 이동: 빠른 러너 => 2칸씩, 느린 러너 => 1칸씩
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 홀수 개일 경우 => 느린 러너가 한 칸 더 앞으로 이동
            // 중앙 값은 팰린드롬 체크에서 스킵 한다.
        if (fast != null) {
            slow = slow.next;
        }

        // 중간에 도달한 느린 러너를 기준으로 역순 연결 리스트 `rev` 생성
            // 일명 '꼬리 바꿔 껴주기'...!
        ListNode rev = null;
        while (slow != null) {
            // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1 의 경우
            // 기존 꼬리 세이브
            ListNode next = slow.next;    // next: 2 -> 1 -> null   // next: 1 -> null      // next: null
            // 역순 꼬리로 바꿔 끼기 => rev
            slow.next = rev;              // slow: 3 -> null        // slow: 2 -> 3 -> null // slow: 1 -> 2 -> 3 -> null
            rev = slow;                   // rev: 3 -> null         // rev: 2 -> 3 -> null  // rev: 1 -> 2 -> 3 -> null
            // 기존 꼬리 다시 갖다 붙이기 => slow
            slow = next;                  // slow: 2 -> 1 -> null   // slow: 1 -> null      // slow: null (끝)
        }

        // 비교: head 전반부 vs. rev
        while (rev != null) {
            if (rev.val != head.val) {
                return false;
            }
            rev = rev.next;
            head = head.next;
        }

        return true;
    }
}

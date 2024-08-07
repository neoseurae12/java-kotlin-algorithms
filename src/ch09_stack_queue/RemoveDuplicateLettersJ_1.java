package ch09_stack_queue;

/* Trial 2

- 스택을 이용한 문자 제거
- 널 체크 -> true 체크
    - true 체크 => 해당 객체에 대해 booleanValue() 함수를 호출하는 것
    - 따라서 true 체크를 하기 전에, 해당 객체가 null 은 아닌지부터 먼저 체크해야 한다.
- Deque 자료구조
    - offerFirst(), offerLast(), pollFirst(), pollLast() => "양방향" 추가/제거 가능 => 스택 & 큐 모두 구현 가능
    - offerFirst() vs. push()
        - 공통점: Deque 의 앞쪽에 요소를 추가하는 기능
        - 차이점
            - offerFirst() => 반환값: 추가 성공 여부 (true/false)
            - push() => 반환값: 없음. 추가할 공간이 없다면 예외(IllegalStateException) 던짐
    - pollFirst() vs. pop()
        - 공통점: Deque 의 첫 번째 요소를 제거 & 반환 하는 기능
        - 차이점
            - pollFirst() => Deque 가 비어있을 때의 반환값: null
            - pop() => Deque 가 비어있을 때의 반환값: 예외(NoSuchElementException) 던짐
    - push() -> pollLast()
        - '큐' 순서대로 추출됨
    - push() -> pop() 또는 pollFirst()
        - '스택' 순서대로 추출됨
- 본 문제의 핵심 => Lexicographically Smaller & 중복 제거
    - Trial 1 의 경우
        - Lexicographically Smaller => 아예 주어진 문자열 내의 알파벳 순서에 따라 접근함 ("ebcabc" => a->b->c->e)
        - 중복 제거 => 집합(Set) 자료구조
    - Trial 2 의 경우
        - Lexicographically Smaller => 유니코드 값의 대소 비교
            - cf. 유니코드 vs. 아스키코드
                - 유니코드 => 거의 모든 세계의 문자와 기호 (1,114,112개) 를 포함할 수 있는 더 큰 범위의 인코딩 표준
                - 아스키코드 => 영어 기반의 문자 (7비트; 128개) 인코딩
        - 중복 제거 => counter(문자별 개수) & seen(처리 여부) & Deque 로 구현한 stack(문자 추가/제거)
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLettersJ_1 {
    public String removeDuplicateLetters(String s) {
        // 각 문자의 개수를 계산해서 담아둘 변수
        Map<Character, Integer> counter = new HashMap<>();
        // 각 문자의 처리 여부를 확인하기 위한 변수
        Map<Character, Boolean> seen = new HashMap<>();
        // 정답 도출을 위해 문자들을 쌓거나 제거하는 작업을 처리할 스택
        Deque<Character> stack = new ArrayDeque<>();

        // 각 문자의 개수 계산
        for (char c : s.toCharArray())
            counter.put(c, counter.get(c) == null ? 1 : counter.get(c) + 1);

        for (char c : s.toCharArray()) {
            // 현재 문자의 개수 하나 깎기 (-1)
            counter.put(c, counter.get(c) - 1);
            // 현재 문자가 이미 처리된 문자라면 => 건너뛰기
            if (seen.get(c) != null && seen.get(c)) // 널 체크 -> true 체크
                continue;
            // stack 에 있는 '현재 문자보다 Lexicographically Smaller 하지 않음 + 현재 문자의 뒷쪽에 더 존재함'을 만족하는 문자들
                // => stack 에서 다 빼버리기 & 처리 여부를 false 로 변경
            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0)
                seen.put(stack.pop(), false);
            // stack 에 현재 문자 PUSH
            stack.push(c);
            // 처리 여부를 true 로 변경
            seen.put(c, true);

            //System.out.println(stack);    // 디버깅
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            // push() -> pollLast() => stack 에 있는 문자들을 "큐(Queue)" 순서대로 추출
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }

    /* 디버깅
    public static void main(String[] args) {
        String result = new RemoveDuplicateLettersJ_1().removeDuplicateLetters("bcabc");
        System.out.println(result);
    }
     */
}

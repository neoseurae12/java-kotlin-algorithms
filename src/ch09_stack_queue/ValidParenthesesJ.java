package ch09_stack_queue;

/* Trial 1

- 풀이 방법: 스택 일치 여부 판별
    - 열림 괄호 [, {, ( => 스택 PUSH
    - 닫힘 괄호 ], }, ) => 스택 POP & 매핑 테이블 결과 비교
- 익명 내부 클래스
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesesJ {
    public boolean isValid(String s) {
        // 스택
        Deque<Character> stack = new ArrayDeque<>();
        // 매핑 테이블
            // 익명 내부 클래스 사용
        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                // 닫힘 괄호가 아닌 경우 => 스택 PUSH
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                // 스택이 중간에 비게 된 경우 or 닫힘 괄호에 대한 매핑 결과와 스택 POP 결과가 일치하지 않는 경우 => 바로 false 결과 리턴
                return false;
            }
        }

        // 반복이 모두 완료된 후, 마지막에는 스택이 비어있어야 한다
        return stack.isEmpty();
    }
}

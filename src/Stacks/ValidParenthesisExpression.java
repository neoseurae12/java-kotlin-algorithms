package Stacks;

/*
- Stacks
    - stack의 메인 연산 (2가지)
        - push (맨 위에 추가)
        - pop (맨 위 제거)
    - LIFO (Last-In-First-Out)
        - stack => '처리' 또는 '삭제'의 순서가 중요한 시나리오에서 유용한 자료구조
            - Nested Structures 다루기
                - e.g. 문자열의 nested parentheses 다루기
                    - 가장 안쪽의 nested structures부터 먼저 처리한다.
            - Reverse order
                - e.g. 배열의 reversing
            - Substitute for recursion
                - recursive call stack
                - recursive functions를 반복적(iteratively)으로 구현 가능
            - Monotonic stacks
                - 특별한 목적으로, 일정한 순서(증가/감소)에 따라 정렬하는 시나리오
    - 시간복잡도
        - push => O(1)
        - pop => O(1)
        - peek => O(1)
        - isEmpty => O(1)
    - 실세계 예제
        - Function call management
            - 함수들이 올바른 순서에 따라 제어하여, nested 또는 recursive 함수 호출을 효율적으로 관리한다.
            - function call stack에 함수의 상태(state; parameters, local variables, return address 등)을 저장한다.

- Stacks > Nested Structures
    - 고려사항: 'opening 괄호와 closing 괄호의 개수 (동일해야 함)' + '괄호들의 순서'
    - 괄호들의 순서
        - 가장 최근의 opening 괄호가 가장 먼저 close 되어야 한다.
        - LIFO (Last-In-First-Out)
        - stack
- 이 문제의 전략
    - opening 괄호를 만난다면 => stack에 추가
        - 가장 최근에 넣은 괄호가 stack의 가장 위에 위치하게 됨
    - closing 괄호를 만난다면 => 이걸로 가장 최근의 opening 괄호를 닫을 수 있는지 체크
        - 닫을 수 있다면 => stack에서 제거
        - 닫을 수 없다면 => invalid 반환
- 예외처리: opening 괄호가 남는 경우
    - invalidity에 대한 체크 작업은 closing 괄호를 만났을 때만 이루어진다.
    - 따라서 모든 작업이 끝나고도 stack이 비어있는지 final check 필요
- 괄호의 타입 관리
    - Hash Map 사용
        - 적합한 opening 괄호와 closing 괄호를 매칭시켜놓기
        - 특정 괄호가 opening 괄호인지, closing 괄호인지 체크도 가능
- 시간복잡도: O(N)
- 공간복잡도
    - stack의 경우 => O(N) -- opening 괄호의 개수에 따라 달라질 것
    - hash map의 경우 => O(1) -- 상수
 */

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesisExpression {
    public static boolean validParenthesisExpression(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('[', ']');
        parenthesisMap.put('{', '}');
        parenthesisMap.put('(', ')');

        for (char c : s.toCharArray()) {
            if (parenthesisMap.containsKey(c))
                stack.push(c);
            else if (c == ']' || c == '}' || c == ')')
                if (!stack.isEmpty() && parenthesisMap.get(stack.peek()) == c)
                    stack.pop();
                else
                    return false;
            else
                return false;
        }

        // 모든 opening parenthesis들이 다 닫혔나 final check
        return stack.isEmpty();
    }
}

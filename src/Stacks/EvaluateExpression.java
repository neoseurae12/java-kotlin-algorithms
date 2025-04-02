package Stacks;

/*
- Stacks > Nested Structures
    - expression => 복합적인 element들이 포함되어있는 상태
        - '복합적인 element들'이란?
            - 음수
            - 괄호 안의 nested expression
            - 여러 자리의 숫자
    - 이 복잡함을 어떻게 해결할 수 있을까?
        - 더 작고, 관리 가능한 정도로 문제를 break down 해서 순차적으로 해결책을 떠올려보자!
        - 복잡한 문제의 break-down steps
            - 1. '여러 자리의 숫자'를 어떻게 처리할 것인가?
            - 2. '연산자'를 어떻게 처리할 것인가?
            - 3. '괄호가 없는' 식을 어떻게 처리할 것인가?
            - 4. '괄호가 있는' 식을 어떻게 처리할 것인가?
    - 1. '여러 자리의 숫자'를 어떻게 처리할 것인가?
        - digit-by-digit으로 숫자를 build 해나가자!
        - 새로운 '숫자'를 마주쳤다면
            - currNum을 building한다.
            - currNum = 기존 currNum * 10 + 새로운 숫자
        - 새로운 '기호'를 마주쳤다면
            - currNum의 building을 멈춘다.
    - 2. '연산자'를 어떻게 처리할 것인가?
        - '뺄셈 또는 덧셈'을 모두 '(pure) 덧셈'으로 처리하자! => '덧셈' 연산을 수행하는 데만 집중하면 됨!
            - '뺄셈 또는 덧셈'의 방식: 1 - 3 + 5 - 2
            - '(pure) 덧셈'의 방식: (+1) + (-3) + (+5) + (-2)
        - (+) 연산자 --> 1 곱하기
        - (-) 연산자 --> -1 곱하기
    - 3. '괄호가 없는' 식을 어떻게 처리할 것인가?
        - 새로운 '연산자'를 마주쳤다면
            - 1) sign 반영
                - sign * currNum
            - 2) (pure) 덧셈
                - res += sign * currNum
            - 3) sign 업데이트
                - sign = -1 또는 1
            - 4) currNum 업데이트
                - currNum = 0
    - 4. '괄호가 있는' 식을 어떻게 처리할 것인가?
        - '괄호'의 등장 => nested expressions 발생 => 아래 2가지 정보를 Stack에 저장해야 함
            - 1) 현재 expression의 `res` (running result)
            - 2) 뒤이어 오는 nested expression의 sign
        - '열린 괄호'를 마주쳤다면
            - 1) Stack에 `res` & `sign` 저장
            - 2) `res` & `sign` 초기화
                - 새로운 expression에 대한 계산을 시작하기 위함
        - '닫힌 괄호'를 마주쳤다면
            - 괄호 안쪽의 결과를 괄호 바깥쪽과 접합(merge)시킨다.
            - 1) sign 반영
                - res *= stack.pop()
            - 2) (pure) 덧셈
                - res += stack.pop()
- 시간복잡도: O(N)
- 공간복잡도: O(N)
 */

import java.util.*;

public class EvaluateExpression {
    public static int evaluateExpression(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int sign = 1;
        int currNum = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                currNum = currNum * 10 + (c - '0');
            else if (c == '+' || c == '-') {
                res += sign * currNum;

                sign = (c == '+') ? 1 : -1;
                currNum = 0;
            }
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            else if (c == ')') {
                res += sign * currNum;

                res *= stack.pop();
                res += stack.pop();

                currNum = 0;
            }
        }

        return res + sign * currNum;
    }
}

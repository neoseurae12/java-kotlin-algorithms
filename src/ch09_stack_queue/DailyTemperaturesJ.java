package ch09_stack_queue;

/* Trial 1

- 스택
    - 스택에 쌓는 대상 => 현재의 '인덱스'
- 유사한 문제: '빗물 트래핑' 문제
    - ch07_array/TrappingRainWaterJ_1.java
- Java의 `new int[5];`
    - Java에서 정수형 배열을 생성하면, 모든 요소들은 기본값 0으로 자동 초기화된다.
    - 따라서 따로 0으로 수동 초기화 해주지 않아도 된다.
- 입력값에 대한 '도식화'의 중요성
    - 입력값을 도식으로 나타내면 보다 직관적으로 해결책을 떠올리기 쉬워진다.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperaturesJ {
    public int[] dailyTemperatures(int[] temperatures) {
        // 결과를 담을 정수형 배열
        int[] result = new int[temperatures.length];
        // 결과 처리를 위해 현재의 인덱스를 담아둘 스택
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();
                // 결과 업데이트
                result[last] = i - last;
            }
            // 스택에 현재 인덱스를 삽입
            stack.push(i);
        }

        return result;
    }
}

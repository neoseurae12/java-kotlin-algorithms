package ch07_array;

/* Trial 2

- 스택
    - '변곡점 (Inflection Point)' 을 기준으로, 동일한 단차 높이만큼 쌓이는 물의 양을 volume 에 추가함
    - peek() 메서드 => 조회 (O), 추출 (X)
- '가로 (horizontal)' 단위로 volume 에 추가
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWaterJ_1 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            // '변곡점'으로 판별된 경우
                // 변곡점 => 오른쪽 장벽
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {  // 스택에서 엘리먼트 '조회'
                // top => 이번 변곡 범위의 기준 바닥 높이
                Integer top = stack.pop();  // 스택에서 엘리먼트 '추출'

                // stack 이 비게 된다면
                    // 왼쪽 장벽에 도달했음을 의미. 즉, 하나의 변곡 범위 종료.
                if (stack.isEmpty())
                    break;

                // stack 에 여전히 남아있는 것이 있다면
                    // 왼쪽 장벽에 아직 도달 못 함을 의미. 즉, 하나의 변곡 범위 진행 중.
                int distance = i - stack.peek() - 1;    // 거리 = 스택의 마지막 위치 ~ 현재 위치
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];   // 단차 높이 = 현재 높이 또는 스택의 마지막 위치 높이 중 낮은 값 - 기준 바닥 높이

                volume += distance * waters;    // 새로운 volume = distance(거리) * waters(단차 높이)
            }

            // 진행하면서 현재 위치를 스택에 삽입
            stack.push(i);
        }

        return volume;
    }
}

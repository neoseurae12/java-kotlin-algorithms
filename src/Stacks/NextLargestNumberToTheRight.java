package Stacks;

/*
- Stacks > Monotonic Stack
    - 문제의 요구사항
        - 각 값의 next largest number to the right를 찾아라
    - "사고의 전환"
        - 현재 값이 그 왼쪽 값들 중 어떠한 값의 next largest number가 될 수 있는가 체크해보자!
        - "candidates" 개념의 도입
        - 왼쪽이 아닌, '오른쪽'에서 왼쪽으로 탐색을 진행해야 한다.
    - Monotonic Stack
        - 현재 값보다 작거나 같은 candidate들은 더이상 그 어느 왼쪽 값들의 next largest number가 될 수 없다.
            - 즉, 자격을 잃게 되어 candidates에서 제거되게 된다.
        - 최종적인 candidates의 모양: "strictly(monotonic) decreasing order"
    - 풀이 순서
        - 1. 현재 막대의 추가로 인해 자격을 잃게 되는 candidate들 "제거"하기; pop()
            - 이로써 자격이 되는 현재 막대의 next largest number to the right가 `candidates` stack의 맨 위에 오게 됨
            - 자격 조건: 현대 막대의 길이 < candidate 길이
        - 2. 현재 막대의 next largest number to the right 기록하기
            - 현재 막대의 next largest number to the right => candidates stack의 맨 위
            - 이때, 만약 candidates stack에 아무도 없다면 => -1
        - 3. 현재 막대를 새로운 candidate로 "추가"하기; push()
- 시간복잡도: O(N)
    - vs. 브루트포스 방식: O(N^2)
- 공간복잡도: O(N)

- vs. 1차 시도
    - '왼쪽'부터 순차적으로 접근함
    - 본인보다 큰 막대 마주치기 전까지 스택에 대기시켜뒀다가, 마주치는 순간 그 항목의 인덱스에 지금 마주친 막대의 길이 저장
    - 장점
        - 시간복잡도: O(N)
        - 모든 테스트를 통과하긴 함
    - 단점
        - '인덱스' 저장이 필요하게 됨.
            - 대기시켜둔 항목의 인덱스를 통해 지금 마주친 막대의 크기를 저장하러 가야하기 때문.
        - '인덱스'도 저장하기 위해 Element라는 클래스를 임의로 만들게 됨.
        - stack에 Element라는 '객체'를 저장하기 때문에 같은 공간복잡도더라도 더 무거움.
        - 덜 직관적임. 오른쪽에 있는 다음 큰 숫자를 찾는 과정에 '대기' 스택을 둔다는 게 덜 직관적으로 느껴질 수 있을 듯.
    - 결론
        - stack을 사용해 푼 건 좋았음.
        - 하지만 2차 시도가 1차 시도의 모든 단점을 해결한다는 점에서 2차 시도가 더 최적화된 풀이 방법임.
 */

import java.util.Deque;
import java.util.ArrayDeque;

public class NextLargestNumberToTheRight {
    public static int[] nextLargestNumberToTheRight(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> candidates = new ArrayDeque<>();

        // 왼쪽이 아닌 '오른쪽'부터 탐색
        for (int i = nums.length - 1; i >= 0; i--) {
            // 1. 현재 막대의 추가로 인해 자격을 잃게 되는 candidate들 제거하기
            while (!candidates.isEmpty() && nums[i] >= candidates.peek())
                candidates.pop();

            // 2. 현재 막대의 next largest number to the right 기록하기
            res[i] = candidates.isEmpty() ? -1 : candidates.peek();

            // 3. 현재 막대를 새로운 candidate로 추가하기
            candidates.push(nums[i]);
        }

        return res;
    }
}

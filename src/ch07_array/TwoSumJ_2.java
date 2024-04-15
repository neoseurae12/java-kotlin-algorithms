package ch07_array;

/* Trial 2

- 최적화 방법 2: Trial 1 에서 조회 구조 개선
    - 2개의 for loop -> 하나의 for loop 으로 통합
    - 시간복잡도: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSumJ_2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        // 최적화: 2개의 for 문 -> 하나의 for 문으로 통합
        for (int i = 0; i < nums.length; i++) {
            int firstNum = target - nums[i];
            // 맵에 있을 경우 => 정답 리턴
            if (numsMap.containsKey(firstNum)) {
                return new int[]{numsMap.get(firstNum), i};
            }
            // 맵에 없을 경우 => 다음번 조회를 위해 맵에 저장
            numsMap.put(nums[i], i);
        }

        return null;
    }
}

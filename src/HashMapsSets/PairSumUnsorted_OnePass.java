package HashMapsSets;

/*
- One pass
    - 1. Hash Map 을 채워넣는 작업 & complement 를 조회하는 작업을 "동시에" 수행하기
- Tip: 단번에 가장 최적의 해결책을 보여주려 하지 말자.
    - 처음에는 생각해낼 수 있는 가장 직관적인 풀이를 보여주고, 그 뒤로 점차 최적화한 풀이를 보여주자.
    - 즉, 하나의 문제에 대해 "여러 가지" 접근법을 점차 떠올릴 수 있는 나의 능력을 보여주는 게 목적이 되어야 한다.
 */

import java.util.HashMap;
import java.util.Map;

public class PairSumUnsorted_OnePass {
    public static int[] pairSumUnsortedOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[] {map.get(complement), i};

            // 없다면 => Hash Map 에 [현재 값 -> 현재 인덱스] 추가
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}

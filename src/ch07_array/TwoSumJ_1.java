package ch07_array;

/* Trial 1

- 최적화 방법 1: 첫 번째 수를 뺀 결과를 키로 사용하여 한 번에 조회하기
    - HashMap
    - 시간복잡도: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSumJ_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();

        // 교체: 키(인덱스) <-> 값
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        // 조회: target - 첫 번째 수
        // 조건: 두 번째 수의 인덱스가 첫 번째 수의 인덱스와 '달라'야 함
            // "you may not use the same element twice"
        for (int i = 0; i< nums.length; i++) {
            int secondNum = target - nums[i];
            if (numsMap.containsKey(secondNum) && numsMap.get(secondNum) != i) {
                return new int[]{i, numsMap.get(secondNum)};
            }
        }

        return null;
    }
}

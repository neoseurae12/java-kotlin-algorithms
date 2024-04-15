package ch07_array;

/* Trial 3

- 투 포인터
    - 시간복잡도: O(n)
- 이 문제는 '투 포인터'로 풀 수 없다. 즉, 본 Trial 3 풀이는 "Wrong Answer"가 뜬다.
    - 투 포인터 => 주로 '정렬된' 입력값을 대상으로 한다.
        - 하지만 본 문제의 nums 는 정렬된 상태가 아니다.
    - 정렬 로직 => `Arrays.sort()`
        - 하지만 본 문제처럼 값이 아닌 '인덱스'를 찾아야 하는 문제에서는 정렬을 통해 인덱스를 엉망으로 섞어버리면 오히려 더 심각한 문제가 발생하게 된다.
 */

import java.util.Arrays;

public class TwoSumJ_3 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        while (left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum < target) {
                left++;
            } else if (twoSum > target) {
                right--;
            } else {
                return new int[]{left, right};
            }
        }

        return null;
    }
}

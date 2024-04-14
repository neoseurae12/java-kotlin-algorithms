package ch07_array;

/* Trial 0

- 브루트 포스 (Brute-Force)
    - 무차별 대입 방식
    - 비효율적인 풀이법
    - 시간복잡도: O(n^2)
 */

public class TwoSumJ {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }

        return null;
    }
}

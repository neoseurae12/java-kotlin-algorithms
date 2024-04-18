package ch07_array;

/* Trial 0

- 문제를 이해하고 떠올 수 있는, 그저 '답'이 나올 수 있는 가장 단순한 풀이
    - 오름차순으로 '정렬'을 한 뒤 앞부터 2개씩 건너뛰면서 더해나감
 */

import java.util.Arrays;

public class ArrayPartition1J {
    public int arrayPairSum(int[] nums) {
        int sum = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}

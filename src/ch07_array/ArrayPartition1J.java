package ch07_array;

/* Trial 0, 2

- 짝수 번째 값에 대한 계산
    - 문제를 이해했다면 떠올 수 있는 '답'이 나오는 풀이
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
        /* 또는
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
         */

        return sum;
    }
}

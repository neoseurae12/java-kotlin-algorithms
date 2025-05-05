package PrefixSums;

/*
- Prefix Sums > Subarray Sums
- 시간복잡도: O(N^2)
    - '모든' subarrays 탐색 => 비효율적
    - 최적화 가능성 여전히 존재
 */

public class KSumSubarrays {
    public static int kSumSubarrays(int[] nums, int k) {
        int count = 0;

        int n = nums.length;
        int[] prefixSum = new int[n + 1];  // 맨 앞에 0인 element 추가
        for (int i = 0; i < n; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];

        // '모든' subarrays 탐색 -- 비효율적
        for (int j = 1; j < n + 1; j++) {
            for (int i = 1; i <= j; i++) {
                if (prefixSum[j] - prefixSum[i - 1] == k)
                    count++;
            }
        }

        return count;
    }
}

package PrefixSums;

/*
- Prefix Sums > Subarray Sums
- 시간복잡도: O(N)
    - HashMap => complement 바로 접근 => 효율적
    - 최적화된 풀이
 */

import java.util.HashMap;
import java.util.Map;

public class KSumSubarraysOptimized {
    public static int kSumSubarraysOptimized(int[] nums, int k) {
        int count = 0;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        int currPrefixSum = 0;
        for (int num : nums) {
            // currPrefixSum 갱신
            currPrefixSum += num;
            // 만약 합이 k인 subarrays 발견 시 => count 증가
            if (prefixSumMap.containsKey(currPrefixSum - k)) {
                count += prefixSumMap.get(currPrefixSum - k);
            }
            // hashmap 내 currPrefixSum의 frequency 갱신
            int freq = prefixSumMap.getOrDefault(currPrefixSum, 0);
            prefixSumMap.put(currPrefixSum, freq + 1);
        }

        return count;
    }
}

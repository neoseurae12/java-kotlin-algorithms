package PrefixSums;

/*
- Prefix Sums > Subarray Sums
 */

public class SumBetweenRange {
    int[] prefixSum;

    public SumBetweenRange(int[] nums) {
        prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    public int sumRange(int i, int j) {
        if (i == 0)
            return prefixSum[j];

        return prefixSum[j] - prefixSum[i - 1];
    }
}

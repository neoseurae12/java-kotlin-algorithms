package TwoPointers;

/*
- Two-pointer 전략 중 'Inward Traversal'에 해당
- 풀이 방식에 따른 시간복잡도의 차이
    - 만약 브루트 포스 방식으로 풀이한다면 => 시간복잡도: O(N^2)
    - 만약 "정렬되어있음"을 고려해 Two Pointers 방식으로 풀이한다면 => 시간복잡도: O(N), 공간복잡도: O(1)
- Two Pointers => left & right
- 핵심: "정렬된 상태"
 */

import java.util.Arrays;

public class PairSumSorted {
    public static int[] pairSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            // If the sum is smaller, increment the left pointer, aiming to increase the sum toward the target value.
            if (sum < target)
                left++;
            // If the sum is larger, decrement the right pointer, aiming to decrease the sum toward the target value.
            else if (sum > target)
                right--;
            // If the target pair is found, return its indexes.
            else
                return new int[] {left, right};
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {-5, -2, 3, 4, 6}, // [2, 3]
                {1, 1, 1},         // [0, 1] (other valid outputs could be [1, 0], [0, 2], [2, 0], [1, 2] or [2, 1]
                {},                // []
                {1},               // []
                {2, 3},            // [0, 1]
                {2, 4},            // []
                {2, 2, 3},         // [0, 2] or [1, 2]
                {-1, 2, 3},        // [0, 2]
                {-3, -2, -1}       // [0, 1]
        };
        int[] targets = new int[]{7, 2, 0, 1, 5, 5, 5, 2, -5};

        for (int i = 0; i < nums.length; i++) {
            int[] result = pairSumSorted(nums[i], targets[i]);

            System.out.println(Arrays.toString(result));
        }

    }
}

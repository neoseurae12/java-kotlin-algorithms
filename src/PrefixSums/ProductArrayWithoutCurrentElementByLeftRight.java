package PrefixSums;

/*
- Prefix Sums > Product Sums
- 최적화 단계
    - 1단계: res = Left product * Right product
        - 특성
            - 2개의 prefix products
            - Cumulative product (왼->오 / 오->왼)
            - "precomputed"
        - 단점
            - O(N)의 공간복잡도
                - 2개의 product 배열
                - extra space
 */

import java.util.Arrays;

public class ProductArrayWithoutCurrentElementByLeftRight {
    public static int[] productArrayWithoutCurrentElementByLeftRight(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];

        // leftProducts 채워넣기
        Arrays.fill(leftProducts, 1);
        for (int i = 1; i < n; i++)
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        // rightProducts 채워넣기
        Arrays.fill(rightProducts, 1);
        for (int i = n - 2; i >= 0; i--)
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];

        // res => 통합
        for (int i = 0; i < n; i++)
            res[i] = leftProducts[i] * rightProducts[i];

        return res;
    }
}

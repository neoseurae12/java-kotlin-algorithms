package PrefixSums;

/*
- Prefix Sums > Product Sums
    - Prefix Sum vs. Prefix Product
        - Prefix Sum
            - cumulative addition
            - 0으로 배열 초기화
        - Prefix Product
            - cumulative multiplication
            - 1로 배열 초기화
- 최적화 단계
    - 2단계(최종): In-place
        - output array에 곧바로 left product & right product 연산 적용
- 시간복잡도: O(N)
- 공간복잡도: O(1)
 */

import java.util.Arrays;

public class ProductArrayWithoutCurrentElementByInPlace {
    public static int[] productArrayWithoutCurrentElementByInPlace(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // In-place Left product
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++)
            res[i] = res[i - 1] * nums[i - 1];

        // In-place Right product
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return res;
    }
}

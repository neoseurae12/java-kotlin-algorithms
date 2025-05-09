package PrefixSums;

/*
- Prefix Sums > Product Sums
- 최적화 단계
    - 0단계: Division 사용
        - 유의: array에 '0' 존재 시
            - 테스트 코드의 testWithZero, testWithMultipleZeros에서 ArithmeticException 발생 가능성을 염두해야 함
                - 0으로 나누는 게 불가능하기 때문
                - 0을 제외한 나머지 수들의 곱 구하는 것이 불가능해지기 때문
 */

import java.util.Arrays;

public class ProductArrayWithoutCurrentElementByDivision {
    public static int[] productArrayWithoutCurrentElementByDivision(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int totalProduct = 1;
        int zeroCount = 0;  // 0의 개수
        for (int num : nums) {
            if (num == 0)
                zeroCount++;
            else
                totalProduct *= num;
        }

        // 배열 내 0이 2개 이상 존재 시 => 무조건 모두 0이 될 수밖에 없음
        if (zeroCount > 1) {
            Arrays.fill(res, 0);
            return res;
        }

        for (int i = 0; i < n; i++) {
            // 배열 내 0이 1개 존재 시 => 0에 대해서만 올바르게 처리 필요
            if (zeroCount == 1)
                res[i] = (nums[i] == 0) ? totalProduct : 0;
            else
                res[i] = totalProduct / nums[i];
        }

        return res;
    }
}

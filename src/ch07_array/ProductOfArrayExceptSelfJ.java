package ch07_array;

/* Trial 1

- nums[i] 기준의 왼쪽 & 오른쪽 수들의 곱셈 결과

- 기존 result 변수의 재활용 => 공간 복잡도 O(1) 로 풀이 가능
- 미리 메모리 공간 잡아놓기
    - new int[nums.length];
 */

public class ProductOfArrayExceptSelfJ {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];    // 미리 메모리 공간 잡아놓기

        // nums[i] 를 기준으로 '왼쪽' 수들의 곱셈 결과
        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = p;
            p *= nums[i];
        }

        // nums[i] 를 기준으로 '오른쪽' 수들의 곱셈 결과까지 result 에 적용
        p = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= p;
            p *= nums[i];
        }

        return result;
    }
}

package BinarySearch;

/*
- Binary Search > Partially Sorted Arrays
    - vs. naive solution
        - target number 찾을 때까지 배열을 iterate 하기
        - 단점
            - 시간복잡도 => linear time 소요
            - 입력 배열이 rotated sorted array 라는 사실을 전혀 고려하지 않은 방식
    - "sorted" before the input array was rotated ==> Binary Search 를 사용하자!
    - 1. define the search space
        => entire array
    - 2. narrow the search space
        - 특이점: 배열이 '완전히' sort된 상태가 아니라는 점
        - normal sorted array vs. rotated sorted array
            - normal sorted array
                - 왼쪽 또는 오른쪽으로 search space 를 줄여나가는 기준 => 오로지 midpoint & target
            - rotated sorted array
                - 왼쪽 또는 오른쪽으로 search space 를 줄여나가는 기준 => midpoint & target + left, right
                - 배열 안의 숫자들을 높이로 '시각화'해보고, mid를 기준으로 왼쪽 / 오른쪽을 구분해서 잘 살펴보면 큰 힌트를 얻을 수 있다.
                    - mid를 기준으로 왼쪽/오른쪽 중 한 쪽은 반드시 ascending order 이다.
    - 3. 나머지 예외처리
        - 수렴된 값이 target과 다를 경우 => -1 반환
        - 수렴된 값이 target과 같을 경우 => 해당 인덱스 반환
- 시간복잡도: O(log N)
- 공간복잡도: O(1)
 */

public class FindTheTargetInARotatedSortedArray {
    public static int findTheTargetInARotatedSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left, right;
        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;

            // mid를 기준으로 왼쪽/오른쪽 중 한 쪽은 반드시 ascending order일 것
            // Case 1: 왼쪽 => ascending order
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Case 2: 오른쪽 => ascending order
            else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return nums[left] == target ? left : -1;
    }
}

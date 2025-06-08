package SortAndSearch;

/*
- Sort and Search > Sort
- Counting Sort
    - 만약 아래와 같은 제약 조건 하에서는 Quicksort보다 Counting Sort가 더 적합하다:
        - 1. 모든 값은 음수가 아니다.
            - Counting Sort 시, 배열 인덱스를 그대로 사용할 수 있음
        - 2. 모든 값은 10^3 이하이다.
            - 값의 최대 범위 k = 1000이므로, 시간/공간 효율이 매우 좋아짐
    - Counting Sort vs. Quicksort
        - SortArrayTest 참고
            - Naive Quicksort: 42 ms <- O(N^2)
            - Optimized Quicksort: 3 ms <- O(N log N)
            - Counting Sort: 1 ms <- O(N+K)
        - 단, Counting Sort는 값의 최대 범위가 그리 크지 않다는 걸 명확히 알고 있는 상황 하에 유리하다.
            - 즉, 값의 최대 범위가 너무 크거나 알 수 없다면, counts array가 엄청 커질 것을 고려해 안전하게 Optimized Quicksort를 사용해야 함
- 시간복잡도: O(N+K)
    - counts array => O(N)
    - sorted array (res) => O(K)
- 공간복잡도: O(N+K)
    - counts array => O(K)
    - sorted array (res) => O(N)
 */

import java.util.Arrays;

public class SortArray_CountingSort {
    public int[] sortArray(int[] nums) {
        int[] res = new int[nums.length];

        if (nums == null || nums.length == 0)
            return res;

        // counts array 채우기
        int max = Arrays.stream(nums).max().getAsInt();
        int[] counts = new int[max + 1];
        for (int num : nums)
            counts[num]++;

        // sorted array (res) 채우기
        int resIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                res[resIndex] = i;
                resIndex++;
            }
        }

        return res;
    }
}

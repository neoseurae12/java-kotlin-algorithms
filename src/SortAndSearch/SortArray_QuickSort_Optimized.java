package SortAndSearch;

/*
- Sort and Search > Sort
- Optimized ver.
    - What Optimized?
        - 최적화 이전: 항상 맨 오른쪽 요소를 피벗으로 선택
        - 최적화 이후: 무작위로 피벗 선택 => input array의 순서에 의존하지 않기 위함
    - How Optimized?
        - Worst-case 시간복잡도에 대한 최적화
            - 최적화 이전: O(N^2)
                - 이미 오름차순/내림차순으로 정렬된 경우 또는 배열 상에 중복값이 많이 포함되어있는 경우, extreme pivot이 선택됨에 따라 uneven partition 발생
            - 최적화 이후: O(N log N)
                - 물론 worst-case 가능성이 여전히 존재하긴 하지만, 그 확률이 매우 낮아지게 됨
                - input array에 상관없이 even partition의 가능성을 높여 average-case 시간복잡도를 보장함
    - Optimized Result
        - SortArrayTest 참고
            - Naive Quicksort: 42 ms
            - Optimized Quicksort: 3 ms
            - 결론: 약 14배의 성능 최적화 발생!
 */

public class SortArray_QuickSort_Optimized {
    public int[] sortArray(int[] nums) {
        quickSortOptimized(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSortOptimized(int[] nums, int left, int right) {
        if (left >= right) return;

        // Optimized 지점: 'random pivot' => 더이상 input array의 순서에 의존하지 않도록 하기 위함
        int randomIndex = left + (int)(Math.random() * (right - left + 1));
        swap(nums, randomIndex, right); // => partition 함수를 변경하지 않아도 됨

        int pivotIndex = partition(nums, left, right);

        quickSortOptimized(nums, left, pivotIndex - 1);
        quickSortOptimized(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int lo = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, lo, i);
                lo++;
            }
        }

        swap(nums, lo, right);

        return lo;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

package SortAndSearch;

public class SortArray_QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // Base Case: subarray에 0개 또는 1개의 element밖에 없을 경우 => 이미 정렬됨을 의미
        if (left >= right)
            return;

        // partitioning & pivot의 인덱스 찾기
        int pivotIndex = partition(nums, left, right);

        // pivot의 인덱스 기준 왼쪽 & 오른쪽도 정렬 (재귀)
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        // pivot보다 작은 element들 => 싹 다 왼쪽으로 몰기
        // 자연스럽게 pivot과 같거나 큰 element들은 오른쪽으로 몰리게 되어있음
        int lo = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, lo, i);
                lo++;
            }
        }

        // pivot 자리시키기
        swap(nums, lo, right);

        return lo;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

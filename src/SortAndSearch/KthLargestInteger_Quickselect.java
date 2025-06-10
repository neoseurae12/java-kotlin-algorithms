package SortAndSearch;

/*
- Sort and Search > Search
- Quickselect 버전
    - 최적화 단계
        - 1. 직관적인 방법 => '모든' 숫자들을 정렬한다.
        - 2. Min-Heap 방법 => 모든 숫자들이 아닌, 탑 'k개'의 가장 큰 숫자들을 관리한다.
        - 3. Quickselect 방법 => 다른 숫자들은 정렬하지 않고도, 예상 정렬 위치에서 k번째로 큰 숫자 '하나'만 배치한다.
    - Quickselect
        - 주로 k번째로 '작은' 요소를 찾아낼 때 사용한다.
        - BUT 이 문제는 k번째로 '작은' 요소가 아닌 "큰" 요소를 구하는 건데?
            - k번째로 '큰' 요소 == (전체 - k)번째로 '작은' 요소
    - vs. Quicksort
        - 공통점
            - pivot을 선택한다.
            - partitioning, 즉 pivot을 기준으로 왼쪽엔 작은 값들, 오른쪽엔 큰 값들이 오도록 이동시킨다.
        - 차이점
            - Quicksort: 왼쪽 & 오른쪽 '모두'에 대해 recursion 실행
            - Quickselect: 왼쪽 또는 오른쪽 중 '한 쪽'에 대해서만 recursion 실행
    - 왼쪽 또는 오른쪽 중, partition의 어느 쪽에 대해 recursion을 실행할지 결정하는 경우의 수 (3가지)
        - 1. pivot의 인덱스 < (n - k) => 오른쪽
        - 2. pivot의 인덱스 > (n - k) => 왼쪽
        - 3. pivot의 인덱스 == (n - k) => pivot의 값 반환
    - vs. Min-Heap
        - KthLargestIntegerTest 참고
            - Min-Heap: 8 ms <- O(N log K)
            - Quickselect: 5 ms <- 평균: O(N), 최악: O(N^2)
        - 결론: 약 1.6배의 성능 최적화 발생!
- 시간복잡도
    - Average case: O(N)
        - Quickselect => 왼쪽 & 오른쪽 partition들 중 '한 쪽'만 선택 => 단계마다 problem size가 거의 반절이 되어버림
        - O(N) + O(N/2) + O(N/4) + ... = O(2N) = O(N)
    - Worst case: O(N^2)
        - random pivot을 선택하기 때문에, input array와 상관없이, worst case가 발생할 가능성이 극히 낮음
        - 그럼에도 불구하고 pivot을 기준으로 partitioning 결과가 한 쪽으로만 치우치는 extremely unbalanced partitions가 발생했다면?
            - O(N) + O(N-1) + O(N-2) + ... = O(N^2)
- 공간복잡도
    - Average case: recursive call stack => O(logN)
    - Worst case: recursive call stack => O(N)
 */

public class KthLargestInteger_Quickselect {
    public int kthLargestIntegerQuickselect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        // Base Case
        if (left >= right) return nums[left];

        // random pivot 선택
        int randomIndex = left + (int)(Math.random() * (right - left + 1));

        // random pivot을 맨 오른쪽으로 일단 빼두기
        swap(nums, randomIndex, right);

        // partitioning => pivot의 인덱스 알아내기
        int pivotIndex = partition(nums, left, right);

        // pivot의 인덱스 & (n - k) 비교
        // pivot의 인덱스 < (n - k) => 오른쪽에 대해서만 Quickselect
        int n = nums.length;
        if (pivotIndex < n - k)
            return quickSelect(nums, pivotIndex + 1, right, k);
        // pivot의 인덱스 > (n - k) => 왼쪽에 대해서만 Quickselect
        else if (pivotIndex > n -k)
            return quickSelect(nums, left, pivotIndex - 1, k);
        // pivot의 인덱스 == (n - k) => pivot의 값 반환
        else
            return nums[pivotIndex];
    }

    // Sort Array 문제에서의 partition 함수와 동일함
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

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

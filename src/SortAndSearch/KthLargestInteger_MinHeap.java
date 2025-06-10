package SortAndSearch;

/*
- Sort and Search > Search
- Min-Heap 버전
    - Min-Heap에 정수 k개를 채워주되, 다 채워지고 나면 둘 중 하나를 선택한다:
        - i) 현재값으로 heap의 최솟값을 갈아치우든가,
        - ii) 아무것도 안하고 다음값으로 넘어가든가
        - 기준: 현재값이 heap의 최솟값보다 큰가 여부
    - vs. 직관적인 방법
        - 직관적인 방법
            - 배열 자체를 역순으로 정렬 -> k-1 번째 인덱스의 정수 반환
            - 단점: k번째로 큰 정수만 필요한데, 굳이 불필요하게 '전체' 배열을 정렬함
            - 시간복잡도: O(N logN)
        - Min-Heap 방법
            - 장점
                - 전체 배열이 아닌, 탑 k개의 가장 큰 정수들만을 관리하면 됨
                - 그 탑 k개의 가장 큰 정수들 중에 최솟값에 바로 접근 가능함
            - 시간복잡도: O(N logK)
- 시간복잡도: O(N logK)
    - heap 연산 => logK
- 공간복잡도: O(K)
    - heap
 */

import java.util.PriorityQueue;

public class KthLargestInteger_MinHeap {
    public int kthLargestIntegerMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            // heap에 정수 k개 유지하기
            if (minHeap.size() < k)
                minHeap.offer(num);
            // 만약 num이 heap의 최솟값보다 크다면 => heap의 최솟값을 pop하고 num을 offer하기
            else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        return minHeap.peek();
    }
}

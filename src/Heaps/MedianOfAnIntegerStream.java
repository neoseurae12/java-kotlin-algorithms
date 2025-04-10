package Heaps;

/*
- Heaps > Finding Values in Sorted Order
    - 본 문제의 도전사항: 새로운 값들이 도착할 때마다 어떻게 모든 값들이 '정렬된' 상태로 유지할 것인가?
        - 핵심: 굳이 '전체' 리스트가 정렬되어 있을 필요 없음. '중앙값(중앙에 있는 값 1~2개)만' 정렬된 상태로 유지되면 충분함.
        - 해결책: leftHalf & rightHalf 두 개의 힙 => 중앙값 근처의 데이터만 관리하자!
            - 중앙값과 그 외 값들 간의 분리
            - 전체 데이터를 두 halves로 나누자!
    - Median (중앙값)
        - 정렬된 리스트의 중앙
        - Median의 종류 (2가지)
            - 1. 홀수 개일 경우 => median 1개
            - 2. 짝수 개일 경우 => median 2개
                - 1번째 median => 왼쪽 반절의 가장 큰 값 => "Max Heap"
                - 2번째 median => 오른쪽 반절의 가장 작은 값 => "Min Heap"
    - 과정
        - 1. Heaps 생성하기
            - Heaps 관리를 위한 원칙 (2가지)
                - 1. leftHalf의 모든 값들 <= rightHalf의 모든 값들
                - 2. leftHalf & rightHalf 값들의 개수
                    - 총 개수가 홀수 개일 경우 => leftHalf 값들의 개수 == rightHalf 값들의 개수 + 1
                    - 총 개수가 짝수 개일 경우 => leftHalf 값들의 개수 == rightHalf 값들의 개수
            - Heaps 관리를 위한 원칙 준수
                - 1. 값 추가
                    - cf. 파이썬에서의 Max Heap 구현
                        - Heap의 디폴트: Min Heap
                        - 값 추가 시, Max Heap으로 만들기 위해 negative로 변환함
                            - 3 -> -3
                        - 값 꺼낼 시, 원래 값으로 되돌리기 위해 -1을 곱함
                - 2. Heaps rebalancing
                    - leftHalf 값들의 개수 > rightHalf 값들의 개수 + 1 => leftHalf -> rightHalf
                    - leftHalf 값들의 개수 < rightHalf 값들의 개수 => leftHalf <- rightHalf
        - 2. 중앙값 반환
            - 총 개수가 홀수 개일 경우 => leftHalf의 top
            - 총 개수가 짝수 개일 경우 => (leftHalf의 top + rightHalf의 top) / 2
- 시간복잡도
    - add 함수 => O(log N)
        - push + rebalancing (pop + push)
    - getMedian 함수 => O(1)
- 공간복잡도: O(N)
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfAnIntegerStream {

    PriorityQueue<Integer> leftHalf;     // Max Heap
    PriorityQueue<Integer> rightHalf;    // Min Heap

    public MedianOfAnIntegerStream() {
        leftHalf = new PriorityQueue<>(Comparator.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }

    public void add(int num) {
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.offer(num);

            if (leftHalf.size() > rightHalf.size() + 1)
                rightHalf.offer(leftHalf.poll());
        }
        else {
            rightHalf.offer(num);

            if (leftHalf.size() < rightHalf.size())
                leftHalf.offer(rightHalf.poll());
        }
    }

    public float getMedian() {
        if (leftHalf.isEmpty()) return 0;

        if (leftHalf.size() == rightHalf.size())
            return (leftHalf.peek() + rightHalf.peek()) / 2f;

        return leftHalf.peek();
    }
}

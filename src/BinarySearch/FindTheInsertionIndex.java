package BinarySearch;

/*
- Binary Search
    - "정확히" 구현하기가 꽤 까다로운 알고리즘 -- 사소하게 판단해야 하는 게 존재함
        - left & right 포인터 각각을 어떤 값으로 초기화할 것인가?
        - while loop의 exit condition을 `left < right`로 할 것인가, `left <= right`로 할 것인가?
        - left & right 포인터 각각을 어떤 값으로 업데이트할 것인가?
            - left = mid + 1 또는 left = mid (right도 마찬가지)
        등등
    - 대상: "sorted" data set
    - binary search 의 구현 단계
        - 1. search space 정의하기
            - left & right 포인터가 search space를 정의한다
        - 2. search space 를 좁혀가기 위한 while loop 안의 동작 정의하기
            - 왼편으로 좁히기 => right 포인터의 이동
            - 오른편으로 좁히기 => left 포인터의 이동
            - midpoint 활용하기
                - midpoint를 포함할 것인가, 포함하지 않을 것인가 잘 판단할 것
            - midpoint 계산하기
                - mid = left + (right - left) / 2
                    - `mid = (left + right) / 2` => integer overflow의 위험 존재
        - 3. while loop의 exit condition 결정하기
            - `left < right` => left와 right가 만나는 순간 종료
                - 하나의 값으로 귀결
            - `left <= right` => left가 right가 앞지르면 종료
        - 4. 적절한 값 반환하기
    - 시간복잡도: O(log N)
        - 각 스텝마다 절반으로 줄어드는 동작 => logarithmic behavior
    - 실세계 예제: 금융 시스템의 트랜젝션 검색

- Binary Search > Sorted Arrays
    - "sorted"
    - "condition"
        - target 이상 / 미만
- 목표
 : insertion index; the first value greater than or equal to the target; lower bound 찾기
    - ex) [1, 2, 4, 5, 7, 8, 9]
        - target: 5 (존재 O) => insertion index: 3 (5 = 5)
        - target: 6 (존재 X) => insertion index: 4 (6 < 7)
- 1. search space 정의하기
    - search space => 0부터 n까지
    - 유의: n-1까지가 아닌 n까지임
        - 왜?: 만약 target이 array 안의 모든 수들보다 큰 수라면 => insertion index는 n-1을 넘어선 n이 되어야 함
- 2. search space 좁히기
    - lower bound <= midpoint
    - 1. 만약 target이 array에 존재하는 수라면
        - 왼편으로 좁히는 경우 => right = mid (mid 포함 O)
        - 오른편으로 좁히는 경우 => left = mid + 1 (mid 포함 X)
        - left & right 가 조우하는 경우 => left 반환
    - 2. 만약 target이 array에 존재하지 않는 수라면
        - 위와 동일
- 시간복잡도: O(log N) -- search space의 크기: N + 1
- 공간복잡도: O(1)
 */

public class FindTheInsertionIndex {
    public static int findTheInsertionIndex(int[] nums, int target) {
        int left, right;
        left = 0;
        right = nums.length;    // search space => from 0 to "n" (주의: n-1이 아님)

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 왼편 (midpoint is included)
            if (nums[mid] >= target) {
                right = mid;
            }
            // 오른편 (midpoint is excluded)
            else {
                left = mid + 1;
            }
        }

        return left;
    }
}

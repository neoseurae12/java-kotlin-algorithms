package BinarySearch;

/*
- Binary Search > Sorted Arrays
    - 브루트포스로 풀어도 되긴 하나...
    - 이왕이면 배열이 "sorted" 되어있다는 점을 활용해 'Binary Search' 방식으로 풀어보자!
- 문제의 핵심
    - first occurrence of a number => "lower bound" of the target
    - last occurrence of a number => "upper bound" of the target
- 1. Lower-bound Binary Search
    - 1. search space 정의하기
        - search space => 0부터 n-1까지 => array 전체
    - 2. search space 를 좁혀가기 위한 while loop 안의 동작 정의하기
        - lower-bound => target 값에 해당하는 범위의 "가장 왼쪽"을 발견해야 함
        - midpoint 값과 target 간의 관계에 따른 3가지 조건
            - 1) midpoint > target
                - 왼쪽으로 좁히기 (exclude the midpoint)
                - `right = mid - 1`
            - 2) midpoint == target
                - 왼쪽으로 좁히기 (include the midpoint)
                - `right = mid`
                - 왜 include the midpoint?
                    - 비록 midpoint == target 이더라도, 그 midpoint가 lower-bound일 수도 있고, 아닐 수도 있기 때문
            - 3) midpoint < target
                - 오른쪽으로 좁히기 (exclude the midpoint)
                - `left = mid + 1`
    - 3. while loop의 exit condition 결정하기
        - `while (left < right)`
    - 4. 적절한 값 반환하기
        - 1) target 값이 존재하는 경우
            - left (lower-bound) 반환
        - 2) target 값이 존재하지 않는 경우
            - -1 반환
- 2. Upper-bound Binary Search
    - Lower-bound Binary Search(1번 경우)와 비슷한 점이 많음. 다만, 몇몇 부분에서 차이점을 보일 뿐.
    - 1. search space 정의하기
        - 위와 동일
    - 2. search space 를 좁혀가기 위한 while loop 안의 동작 정의하기
        - upper-bound => target 값에 해당하는 범위의 "가장 오른쪽"을 발견해야 함
        - midpoint 값과 target 간의 관계에 따른 3가지 조건
            - 1) midpoint > target
                - 위와 동일
            - 2) midpoint == target
                - 오른쪽으로 좁히기 (include midpoint)
                - `left = mid`
                - 유의: infinite loop 에 빠질 수 있다!
                    - 왜?
                        - mid를 업데이트할 때 `mid = left + (right - left) / 2;`로 하게 되면 mid가 left로 bias된다.
                        - 만약 left와 mid가 같은 상황(ex. element가 2개로 좁혀진 상황)에서는 mid가 계속 left를 가리키게 되어 search space가 좁혀지지 않고 계속 infinite loop를 돌게 된다.
                    - 해결책
                        - mid의 업데이트 방식을 mid가 "right"로 bias 되도록 바꾼다.
                        - `mid = left + (right - left) / 2 + 1;`
                        - right로 bias 될 때는 절대 infinite loop에 빠질 수가 없다.
                            - 왜?
                                - right 포인터와 midpoint가 같아질 수가 없기 때문이다.
                                - `right = mid - 1`
            - 3) midpoint < target
                - 위와 동일
    - 3. while loop의 exit condition 결정하기
        - 위와 동일
    - 4. 적절한 값 반환하기
        - 수렴된 최종값과 target 값 비교
        - 1) target 값과 일치하는 경우
            - right (upper-bound) 반환
            - 유의: left가 아닌 "right"에 대하여 반환해야 한다
                - 왜?
                    - 만약 target이 array 상에 존재하지 않을 때, `mid == n - 1`이라면 위의 `left = mid + 1`이 left 포인터를 array의 바깥쪽으로 위치시킬 수 있다.
                    - 그렇게 되면 return 문의 `nums[left]`에서 Array Index Out of Bounds Exception이 발생할 가능성에 노출되게 된다.
        - 2) target 값과 일치하지 않는 경우
            - -1 반환
- 시간복잡도: O(log N)
- 공간복잡도: O(1)
- 팁: 나의 알고리즘을 항상 테스트해보자!
 */

public class FirstAndLastOccurrencesOfANumber {
    public static int[] firstAndLastOccurrencesOfANumber(int[] nums, int target) {
        int lowerBound = lowerBoundBinarySearch(nums, target);
        int upperBound = upperBoundBinarySearch(nums, target);
        return new int[]{lowerBound, upperBound};
    }

    public static int lowerBoundBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left, right;
        left = 0;
        right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // search space 줄이기 (왼편 / 오른편)
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }

        return nums[left] == target ? left : -1;
    }

    public static int upperBoundBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left, right;
        left = 0;
        right = nums.length - 1;

        while (left < right) {
            // 유의: upper-bound binary search => bias the midpoint to the "right"
            int mid = left + (right - left) / 2 + 1;

            // search space 줄이기 (왼편 / 오른편)
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else
                left = mid;
        }

        // 유의: left가 아닌 "right"에 대하여 반환해야 한다
        return nums[right] == target ? right : -1;
    }
}

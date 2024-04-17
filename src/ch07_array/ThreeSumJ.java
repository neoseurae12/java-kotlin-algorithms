package ch07_array;

/* Trial 1

- 브루트 포스 (Brute-force), 쓰리 포인터
    - 시간 복잡도: O(n^3) => Time Limit Exceeded 발생. 즉, 본 Trial 1 풀이는 Submit 불가.
- 입력(input)이 정돈되지 않은 느낌이 있다면 => '정렬' 을 떠올려볼 것
    - Arrays.sort()
    - '정렬'의 시간 복잡도: O(n log n)
- continue
    - 중복된 값 제외를 위한 스킵
- [차이점] ArrayList vs. LinkedList
    - ArrayList
        - 인덱스를 통한 빠른 '접근'
    - LinkedList
        - 빈번한 '추가/삭제'
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumJ {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();   // 빈번한 추가/삭제 => LinkedList

        Arrays.sort(nums);  // 정렬 => 크기대로 정돈된 순서 보장

        int len = nums.length;
        int threeSum;

        // 브루트 포스(쓰리 포인터)의 시간 복잡도: O(n^3)
        for (int first = 0; first < len - 2; first++) {
            // 중복된 값 건너뛰기
                // "Notice that the solution set must not contain duplicate triplets"
            if (first > 0 && nums[first] == nums[first - 1])
                continue;
            for (int second = first + 1; second < len - 1; second++) {
                // 중복된 값 건너뛰기
                if (second > first + 1 && nums[second] == nums[second - 1])
                    continue;
                for (int third = second + 1; third < len; third++) {
                    // 중복된 값 건너뛰기
                    if (third > second + 1 && nums[third] == nums[third - 1])
                        continue;
                    threeSum = nums[first] + nums[second] + nums[third];
                    if (threeSum == 0) {
                        results.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    }
                }
            }
        }

        return results;
    }
}

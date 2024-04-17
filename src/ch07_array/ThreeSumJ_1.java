package ch07_array;

/* Trial 2

- 투 포인터
    - 시간 복잡도: O(n^2)
    - 정렬 되어있는 배열 + 양끝에서부터 좁혀오기
- while 문 => '종료 조건' 신경 쓸 것
- 중복된 값에 대한 '스킵' 처리 주의
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumJ_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        int left, right, threeSum;

        Arrays.sort(nums);  // 정렬

        for (int first = 0; first < nums.length - 2; first++) {
            // 중복된 값 스킵 처리 (1번째 수)
            if (first > 0 && nums[first] == nums[first - 1])
                continue;

            // 투 포인터
            left = first + 1;   // 2번째 수
            right = nums.length - 1;    // 3번째 수

            // while 문의 종료 조건 => while 문 내내 left 또는 right 값에 변화가 있어야 함
                // 2번째 수(left) --> 좁혀오기 <-- 3번째 수(right)
            while (left < right) {
                threeSum = nums[first] + nums[left] + nums[right];
                if (threeSum < 0) {
                    left++;
                } else if (threeSum > 0) {
                    right--;
                } else {    // 정답; threeSum == 0
                    results.add(Arrays.asList(nums[first], nums[left], nums[right]));

                    // 중복된 값 스킵 처리 (2번째 수)
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    // 중복된 값 스킵 처리 (3번째 수)
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // threeSum == 0 인 상황이 이미 나왔으므로 한 쪽만 옮기는 것이 아니라 '두 쪽 모두'를 옮겨야 다른 케이스의 정답을 찾을 수 있음
                    left++;
                    right--;
                }
            }
        }

        return results;
    }
}

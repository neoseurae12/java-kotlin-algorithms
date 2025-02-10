package TwoPointers;

/*
- Two-pointer 전략 중 'Inward Traversal'에 해당
- For any triplet [a, b, c], If we fix 'a', we can focus on finding a pair [b, c] that sums to '-a' (a + b + c = 0 ➔ b + c = -a).
    - (a, b, c) 중에서 a 고정 & b와 c는 PairSumSorted 방식으로 풀이
- 풀이 방식에 따른 시간복잡도의 차이
    - 만약 브루트 포스 방식으로 풀이한다면 => 시간복잡도: O(N^3)
    - 만약 "정렬"하여 Two Pointers 방식으로 풀이한다면
        - 시간복잡도: O(N^2) = O(N*logN)(-> 정렬) + O(N^2)(-> pair sum)
        - 공간복잡도: O(N)
- 중복 방지
    - by 배열 "정렬"
    - 방금 전과 동일한 숫자가 안 나올 때까지 계속 인덱스 증가시킴
    - a와 b의 중복만 잘 방지하면, c는 자동으로 중복 방지됨
- Pair Sum Sorted 과의 중요한 차이
    - 여기서는 pair 하나 찾았다고 그만두지 않고, 조건을 만족하는 '모든' pair들을 찾을 때까지 지속함
- 최적화
    - triplet의 모든 수가 양수라면 절대 그 합이 0이 될 수 없음
    - 제일 작은 수인 a부터가 양수라면 => 더 볼 것 없이 pass
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    public static List<List<Integer>> pairSumSortedAllPairs(int[] nums, int start, int target) {
        List<List<Integer>> pairs = new ArrayList<>();

        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                pairs.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                left++;
                // 중복 방지: 이전 b와 동일하다면 pass
                while (left < right && nums[left - 1] == nums[left])
                    left++;
            }
            else if (sum > target)
                right--;
            // pairSum 찾았다면 => result 에 추가, 이어서 찾기
            else
                left++;
        }

        return pairs;
    }

    public static List<List<Integer>> tripletSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();

        // "정렬된" 배열로 만들기
        Arrays.sort(nums);

        // a 설정
        for (int i = 0; i < nums.length - 2; i++) {
            // 최적화: triplet의 모든 수가 양수라면 절대 그 합이 0이 될 수 없음
            if (nums[i] > 0)
                break;

            // 중복 방지: 이전 a와 동일하다면 pass
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            // b, c 설정
            // b + c = -a 가 되는 Pair Sum 들 찾기
            List<List<Integer>> pairs = pairSumSortedAllPairs(nums, i + 1, -nums[i]);
            for (List<Integer> pair : pairs) {
                // Note: Arrays.asList() => 전달된 매개변수를 통해 "고정된" 크기의 List 를 생성함
                triplets.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
            }
        }

        return triplets;
    }


    public static void main(String[] args) {
        //int[] nums = new int[] {0, -1, 2, -3, 1};
        //int[] nums = new int[] {3, 2, 1};
        //int[] nums = new int[] {-4, -4, -2, 0, 0, 1, 2, 3};
        //int[] nums = new int[] {};  // []
        //int[] nums = new int[] {0};  // []
        //int[] nums = new int[] {1, -1};  // []
        //int[] nums = new int[] {0, 0, 0};  // [[0, 0, 0]]
        //int[] nums = new int[] {1, 0, 1};  // []
        int[] nums = new int[] {0, 0, 1, -1, 1, -1};  // [[-1, 0, 1]]

        List<List<Integer>> triplets = tripletSum(nums);

        System.out.println(triplets);
    }
}

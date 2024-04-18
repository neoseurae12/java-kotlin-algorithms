package ch07_array;

/* Trial 1

- 인접 엘리먼트 페어 (Adjacent Elements Pair)
    - 문제에서 언급된 '페어'의 존재를 살린 풀이

- for 문을 돌되, index 가 굳이 필요 없을 경우
    - `for (int num : nums)`
- Collections.min(Collection<? extends T> coll)
 */

import java.util.*;

public class ArrayPartition1J_1 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();

        Arrays.sort(nums);

        for (int num : nums) {  // for 문을 돌되, index 가 굳이 필요 없을 경우의 표현
            pair.add(num);

            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }

        return sum;
    }
}

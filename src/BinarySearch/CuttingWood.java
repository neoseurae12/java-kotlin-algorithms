package BinarySearch;

/*
- Binary Search
    - Non-intuitive Search Space
    - 입력된 배열이 sort 되지 않았는데 어떻게 Binary Search로 푼다는 걸까?
        - 이 문제에서의 search space -- 다른 binary search 문제와 비교했을 때 특이한 편
            - 인덱스(가로) => X
            - 나무 높이(세로) => O
    - 1. search space => 0 ~ 나무 최고 높이
    - 2. search space 줄여나가기
        - 이 문제는 높이(H)의 "upper"-bound를 구해야 함
            - mid = bottom + (top - bottom) / 2 + 1
        - 해당 높이가 충분한(k 이상의) 나무를 도출하는지 판단하기
            => 함수 yieldsEnoughWood
            - 해당 높이(H)가 k 이상의 나무를 도출하는지 판단하는 함수
            - H에 따른 yieldsEnoughWood의 결과를 '시각화'해보면
                - (true) -> (false)
                - "sorted"
                - 특정 condition에 대한 충족 여부에 따라 '이분화(binary)'되어 분류됨
        - 1. condition 충족 시; 나무 양 >= k
            => bottom = mid
            - mid 포함 O
        - 2. condition 불만족 시; 나무 양 < k
            => top = mid - 1
            - mid 포함 X
- 시간복잡도: O(N * log(M))
- 공간복잡도: O(1)
 */

import java.util.Arrays;

public class CuttingWood {
    public static int cuttingWood(int[] heights, int k) {
        int bottom, top;
        bottom = 0;
        top = getTallestHeight(heights);

        while (top > bottom) {
            int mid = bottom + (top - bottom) / 2 + 1;  // upper-bound

            if (yieldsEnoughWood(heights, mid, k)) {
                bottom = mid;
            }
            else {
                top = mid - 1;
            }
        }

        return top;
    }

    private static boolean yieldsEnoughWood(int[] heights, int H, int k) {
        int woodCollected = 0;
        for (int height : heights) {
            if (height > H) {
                woodCollected += height - H;
            }
        }

        return woodCollected >= k;
    }

    static int getTallestHeight(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        return Arrays.stream(heights).max().getAsInt();
    }
}

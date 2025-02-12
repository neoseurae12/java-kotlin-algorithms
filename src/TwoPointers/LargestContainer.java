package TwoPointers;

/*
- Two-pointer 전략 중 'Inward Traversal'에 해당
- 컨테이너의 넓이 = min(heights[i], heights[j]) * (j - i)
- 핵심 관건
    - 컨테이너의 너비 (width)
    - 컨테이너의 높이 (height)
        - 특히, 두 벽 중 "짧은" 벽의 높이
        - 만약 양쪽 벽의 높이가 같다면 => 양쪽 pointers 동시에 움직이기
- 풀이 방식에 따른 시간복잡도의 차이
    - 만약 브루트 포스 방식으로 풀이한다면 => 시간복잡도: O(N^2)
    - 만약 Two Pointers Inward 방식으로 풀이한다면
        - 시간복잡도: O(N)
        - 공간복잡도: O(1)
 */

public class LargestContainer {
    public static int largestContainer(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxWater = 0;

        while (left < right) {
            // 최대 넓이 갱신
            int water = (right - left) * Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, water);

            // 더 짧은 포인터를 안쪽으로 이동시키기
            if (heights[left] < heights[right])
                left++;
            else if (heights[left] > heights[right])
                right--;
            // 만약 왼쪽 == 오른쪽 => 양쪽 이동
            else {
                left++;
                right--;
            }
        }

        return maxWater;
    }
}

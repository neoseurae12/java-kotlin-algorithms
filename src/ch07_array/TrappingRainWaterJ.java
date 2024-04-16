package ch07_array;

/* Trial 1

- 투 포인터
    - 최대 높이 막대를 기준으로 양쪽의 포인터들을 최대 높이 막대를 향해 이동시킴
    - 최대 높이 막대 => 왼쪽, 오른쪽을 가르는 장벽 역할
- '세로 (vertical)' 단위로 volume 에 추가
 */

public class TrappingRainWaterJ {
    public int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        // 반복: 최대 높이의 막대에 도달할 때까지 좁혀오기
        while (left < right) {
            // 갱신: 최대 높이의 막대 기준 오른쪽, 왼쪽 각각의 max 높이
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            // 투 포인터 이동: 낮 --> 높 <-- 낮
            if (leftMax <= rightMax) {
                volume += leftMax - height[left];
                left++;
            } else {
                volume += rightMax - height[right];
                right--;
            }
        }

        return volume;
    }
}

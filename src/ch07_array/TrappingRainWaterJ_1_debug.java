package ch07_array;

/* Trial 2 에 대한 디버깅 */

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWaterJ_1_debug {
    public static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            System.out.println("i: " + i);

            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();
                System.out.println("top: " + top);

                if (stack.isEmpty())
                    break;

                int distance = i - stack.peek() - 1;
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];
                System.out.println("distance: " + distance);
                System.out.println("waters: " + waters);

                volume += distance * waters;
                System.out.println("new volume: " + distance * waters);
                System.out.println("volume: " + volume);
            }

            stack.push(i);
            System.out.println("stack: " + stack);
        }

        return volume;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(height);
        System.out.println("최종 결과: " + result);
    }
}

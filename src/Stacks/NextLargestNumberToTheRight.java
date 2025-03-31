package Stacks;

import java.util.*;

public class NextLargestNumberToTheRight {
    public static int[] nextLargestNumberToTheRight(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Element> standByStack = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!standByStack.isEmpty() && standByStack.peek().value < nums[i]) {
                Element poppedElement = standByStack.pop();
                res[poppedElement.index] = nums[i];
            }
            standByStack.push(new Element(nums[i], i));
        }

        while (!standByStack.isEmpty()) {
            Element poppedElement = standByStack.pop();
            res[poppedElement.index] = -1;
        }

        return res;
    }
}

class Element {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

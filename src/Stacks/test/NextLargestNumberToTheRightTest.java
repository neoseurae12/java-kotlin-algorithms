package Stacks.test;

import Stacks.NextLargestNumberToTheRight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextLargestNumberToTheRightTest {
    @Test
    void testGeneralCase() {
        int[] nums = {5, 2, 4, 6, 1};
        int[] result = NextLargestNumberToTheRight.nextLargestNumberToTheRight(nums);
        int[] expected = {6, 4, 6, -1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    void testAllIncreasing() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = NextLargestNumberToTheRight.nextLargestNumberToTheRight(nums);
        int[] expected = {2, 3, 4, 5, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    void testAllDecreasing() {
        int[] nums = {5, 4, 3, 2, 1};
        int[] result = NextLargestNumberToTheRight.nextLargestNumberToTheRight(nums);
        int[] expected = {-1, -1, -1, -1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    void testWithDuplicates() {
        int[] nums = {1, 3, 2, 3, 1};
        int[] result = NextLargestNumberToTheRight.nextLargestNumberToTheRight(nums);
        int[] expected = {3, -1, 3, -1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    void testSingleElement() {
        int[] nums = {10};
        int[] result = NextLargestNumberToTheRight.nextLargestNumberToTheRight(nums);
        int[] expected = {-1};
        assertArrayEquals(expected, result);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int[] result = NextLargestNumberToTheRight.nextLargestNumberToTheRight(nums);
        int[] expected = {};
        assertArrayEquals(expected, result);
    }
}
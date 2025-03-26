package BinarySearch.test;

import BinarySearch.FirstAndLastOccurrencesOfANumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstAndLastOccurrencesOfANumberTest {
    @Test
    void testMultipleOccurrences() {
        int[] nums = {1, 2, 2, 2, 3, 4, 5};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 2);
        assertArrayEquals(new int[]{1, 3}, result);

        nums = new int[]{1, 2, 2, 2, 3, 5, 5};
        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 5);
        assertArrayEquals(new int[]{5, 6}, result);

        nums = new int[]{1, 1, 2, 2, 3, 5, 5};
        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 1);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void testSingleOccurrence() {
        int[] nums = {1, 3, 5, 7, 9};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 5);
        assertArrayEquals(new int[]{2, 2}, result);

        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 1);
        assertArrayEquals(new int[]{0, 0}, result);

        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 9);
        assertArrayEquals(new int[]{4, 4}, result);
    }

    @Test
    void testTargetNotInArray() {
        int[] nums = {2, 3, 5, 7, 9};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 6);
        assertArrayEquals(new int[]{-1, -1}, result);

        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 10);
        assertArrayEquals(new int[]{-1, -1}, result);

        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 1);
        assertArrayEquals(new int[]{-1, -1}, result);

        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 8);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    void testTargetAtBeginningAndEnd() {
        int[] nums = {2, 2, 2, 2};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 2);
        assertArrayEquals(new int[]{0, 3}, result);
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {3};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 3);
        assertArrayEquals(new int[]{0, 0}, result);

        result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 5);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    void testTwoElementsArray() {
        // 왜 upperBoundBinarySearch() 함수에서 left가 아닌 right를 반환해야 하는지 알 수 있는 테스트케이스!
        int[] nums = {3, 5};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 7);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 5);
        assertArrayEquals(new int[]{-1, -1}, result);
    }

    @Test
    void testNullArray() {
        int[] nums = null;
        int[] result = FirstAndLastOccurrencesOfANumber.firstAndLastOccurrencesOfANumber(nums, 5);
        assertArrayEquals(new int[]{-1, -1}, result);
    }
}
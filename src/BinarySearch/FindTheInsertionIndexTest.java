package BinarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheInsertionIndexTest {
    @Test
    void testTargetExistsInArray() {
        int[] nums = {1, 2, 4, 5, 7, 8, 9};
        assertEquals(2, FindTheInsertionIndex.findTheInsertionIndex(nums, 4));
        assertEquals(6, FindTheInsertionIndex.findTheInsertionIndex(nums, 9));
    }

    @Test
    void testTargetNotInArray() {
        int[] nums = {2, 4, 6, 8, 10};
        assertEquals(1, FindTheInsertionIndex.findTheInsertionIndex(nums, 3));
        assertEquals(2, FindTheInsertionIndex.findTheInsertionIndex(nums, 5));
    }

    @Test
    void testInsertAtStart() {
        int[] nums = {2, 4, 6, 8};
        assertEquals(0, FindTheInsertionIndex.findTheInsertionIndex(nums, 1));
    }

    @Test
    void testInsertAtEnd() {
        int[] nums = {2, 4, 6, 8};
        assertEquals(4, FindTheInsertionIndex.findTheInsertionIndex(nums, 10));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, FindTheInsertionIndex.findTheInsertionIndex(nums, 5));
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {5};
        assertEquals(0, FindTheInsertionIndex.findTheInsertionIndex(nums, 3));
        assertEquals(1, FindTheInsertionIndex.findTheInsertionIndex(nums, 7));
    }

    @Test
    void testEvenLengthArrays() {
        assertEquals(4, FindTheInsertionIndex.findTheInsertionIndex(new int[]{1, 2, 4, 5, 7, 8}, 6));
        assertEquals(3, FindTheInsertionIndex.findTheInsertionIndex(new int[]{1, 2, 4, 5, 7, 8}, 5));
    }

    @Test
    void testOddLengthArrays() {
        assertEquals(4, FindTheInsertionIndex.findTheInsertionIndex(new int[]{1, 2, 4, 5, 7, 8, 9}, 6));
        assertEquals(3, FindTheInsertionIndex.findTheInsertionIndex(new int[]{1, 2, 4, 5, 7, 8, 9}, 5));
    }
}

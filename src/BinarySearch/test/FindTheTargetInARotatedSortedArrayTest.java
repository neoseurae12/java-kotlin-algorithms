package BinarySearch.test;

import BinarySearch.FindTheTargetInARotatedSortedArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheTargetInARotatedSortedArrayTest {
    @Test
    void testFoundInRotatedArray() {
        int[] nums = {8, 9, 1, 2, 3, 4, 5, 6, 7};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 1);
        assertEquals(2, result);
    }

    @Test
    void testNotFoundInRotatedArray() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 3);
        assertEquals(-1, result);
    }

    @Test
    void testFoundAtBeginning() {
        int[] nums = {6, 7, 8, 1, 2, 3, 4, 5};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 6);
        assertEquals(0, result);
    }

    @Test
    void testFoundAtEnd() {
        int[] nums = {6, 7, 8, 1, 2, 3, 4, 5};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 5);
        assertEquals(7, result);
    }

    @Test
    void testSortedArrayNoRotation() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 4);
        assertEquals(3, result);
    }

    @Test
    void testSingleElementFound() {
        int[] nums = {1};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 1);
        assertEquals(0, result);
    }

    @Test
    void testSingleElementNotFound() {
        int[] nums = {1};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 2);
        assertEquals(-1, result);
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 1);
        assertEquals(-1, result);
    }

    @Test
    void testNullArray() {
        int[] nums = null;
        int result = FindTheTargetInARotatedSortedArray.findTheTargetInARotatedSortedArray(nums, 1);
        assertEquals(-1, result);
    }
}
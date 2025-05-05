package PrefixSums.test;

import PrefixSums.KSumSubarrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KSumSubarraysTest {
    @Test
    void testBasicCase() {
        int[] nums = {1, 2, -1, 1, 2};
        assertEquals(3, KSumSubarrays.kSumSubarrays(nums, 3));
    }

    @Test
    void testMultipleSubarrays() {
        int[] nums = {1, 1, 1};
        assertEquals(2, KSumSubarrays.kSumSubarrays(nums, 2));
    }

    @Test
    void testZeroSum() {
        int[] nums = {1, -1, 0};
        assertEquals(3, KSumSubarrays.kSumSubarrays(nums, 0));
    }

    @Test
    void testEntireArray() {
        int[] nums = {2, 3, 0, 1};
        assertEquals(1, KSumSubarrays.kSumSubarrays(nums, 6));
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {5};
        assertEquals(1, KSumSubarrays.kSumSubarrays(nums, 5));
        assertEquals(0, KSumSubarrays.kSumSubarrays(nums, 3));
    }

    @Test
    void testEmptyArray() {
        int[] nums = {};
        assertEquals(0, KSumSubarrays.kSumSubarrays(nums, 0));
        assertEquals(0, KSumSubarrays.kSumSubarrays(nums, 3));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-2, -1, 3, 1, 2};
        assertEquals(2, KSumSubarrays.kSumSubarrays(nums, 2));
    }
}
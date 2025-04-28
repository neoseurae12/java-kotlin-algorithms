package PrefixSums.test;

import PrefixSums.SumBetweenRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumBetweenRangeTest {

    @Test
    void testNormalCase() {
        int[] nums = {1, 2, 3, 4, 5};
        SumBetweenRange sum = new SumBetweenRange(nums);

        assertEquals(6, sum.sumRange(0, 2));
        assertEquals(9, sum.sumRange(1, 3));
        assertEquals(12, sum.sumRange(2, 4));
    }

    @Test
    void testZeroIndexCase() {
        int[] nums = {3, -7, 6, 0, -2, 5};
        SumBetweenRange sum = new SumBetweenRange(nums);

        assertEquals(2, sum.sumRange(0, 2));
        assertEquals(3, sum.sumRange(0, 0));
    }

    @Test
    void testSingleElementRange() {
        int[] nums = {3, 8, 1, 9};
        SumBetweenRange sum = new SumBetweenRange(nums);

        assertEquals(8, sum.sumRange(1, 1));
        assertEquals(1, sum.sumRange(2, 2));
    }

    @Test
    void testArrayWithNegativeNumbers() {
        int[] nums = {3, -7, 6, 0, -2, 5};
        SumBetweenRange sum = new SumBetweenRange(nums);

        assertEquals(-4, sum.sumRange(0, 1));
        assertEquals(-1, sum.sumRange(1, 3));
    }

    @Test
    void testSingleElementArray() {
        int[] nums = {42};
        SumBetweenRange sum = new SumBetweenRange(nums);

        assertEquals(42, sum.sumRange(0, 0));
    }
}
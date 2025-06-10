package SortAndSearch.test;

import SortAndSearch.KthLargestInteger_MinHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestInteger_MinHeapTest {
    KthLargestInteger_MinHeap solution = new KthLargestInteger_MinHeap();

    @Test
    void testBasicCase() {
        int[] nums = {5, 2, 4, 3, 1, 6};
        int k = 3;
        assertEquals(4, solution.kthLargestIntegerMinHeap(nums, k));
    }

    @Test
    void testKEquals1() {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 1;
        assertEquals(20, solution.kthLargestIntegerMinHeap(nums, k));
    }

    @Test
    void testKEqualsLength() {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = nums.length;
        assertEquals(3, solution.kthLargestIntegerMinHeap(nums, k));
    }

    @Test
    void testSingleElement() {
        int[] nums = {99};
        int k = 1;
        assertEquals(99, solution.kthLargestIntegerMinHeap(nums, k));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = {-1, -3, -2, -5, -4};
        int k = 3;
        assertEquals(-3, solution.kthLargestIntegerMinHeap(nums, k));
    }
}
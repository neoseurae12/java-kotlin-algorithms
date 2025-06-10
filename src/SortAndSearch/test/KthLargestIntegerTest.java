package SortAndSearch.test;

import SortAndSearch.KthLargestInteger_MinHeap;
import SortAndSearch.KthLargestInteger_Quickselect;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestIntegerTest {

    private static final int ARRAY_SIZE = 1_000_000;
    private static final int K = 100;

    private int[] generateRandomArray() {
        Random rand = new Random(42);
        int[] arr = new int[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++)
            arr[i] = rand.nextInt();

        return arr;
    }

    @Nested
    class MinHeapTests {
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

        @Test
        public void testReverseSortedArray() {
            int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
            int k = 4;
            int expected = 6;
            assertEquals(expected, solution.kthLargestIntegerMinHeap(nums, k));
        }

        @Test
        void testPerformanceComparison() {
            int[] nums = generateRandomArray();

            long start = System.nanoTime();
            int result = solution.kthLargestIntegerMinHeap(nums, K);
            long duration = System.nanoTime() - start;

            System.out.println("[MinHeap] Kth Largest: " + result + ", Time: " + duration / 1_000_000 + " ms");

            // 성능 차이 테스트 => [MinHeap] Kth Largest: 2147264242, Time: 8 ms
        }
    }

    @Nested
    class QuickselectTests {
        KthLargestInteger_Quickselect solution = new KthLargestInteger_Quickselect();

        @Test
        void testBasicCase() {
            int[] nums = {5, 2, 4, 3, 1, 6};
            int k = 3;
            assertEquals(4, solution.kthLargestIntegerQuickselect(nums, k));
        }

        @Test
        void testKEquals1() {
            int[] nums = {7, 10, 4, 3, 20, 15};
            int k = 1;
            assertEquals(20, solution.kthLargestIntegerQuickselect(nums, k));
        }

        @Test
        void testKEqualsLength() {
            int[] nums = {7, 10, 4, 3, 20, 15};
            int k = nums.length;
            assertEquals(3, solution.kthLargestIntegerQuickselect(nums, k));
        }

        @Test
        void testSingleElement() {
            int[] nums = {99};
            int k = 1;
            assertEquals(99, solution.kthLargestIntegerQuickselect(nums, k));
        }

        @Test
        void testNegativeNumbers() {
            int[] nums = {-1, -3, -2, -5, -4};
            int k = 3;
            assertEquals(-3, solution.kthLargestIntegerQuickselect(nums, k));
        }

        @Test
        public void testReverseSortedArray() {
            int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1};
            int k = 4;
            int expected = 6;
            assertEquals(expected, solution.kthLargestIntegerQuickselect(nums, k));
        }

        @Test
        void testPerformanceComparison() {
            int[] nums = generateRandomArray();

            long start = System.nanoTime();
            int result = solution.kthLargestIntegerQuickselect(nums, K);
            long duration = System.nanoTime() - start;

            System.out.println("[Quickselect] Kth Largest: " + result + ", Time: " + duration / 1_000_000 + " ms");

            // 성능 차이 테스트 => [Quickselect] Kth Largest: 2147264242, Time: 5 ms
            // Min Heap에 비해 약 1.6배 성능 최적화 발생
        }
    }
}
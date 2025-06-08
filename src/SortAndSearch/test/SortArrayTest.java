package SortAndSearch.test;

import SortAndSearch.SortArray_QuickSort;
import SortAndSearch.SortArray_QuickSort_Optimized;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SortArrayTest {

    @Nested
    class QuickSortTests {
        SortArray_QuickSort sorter = new SortArray_QuickSort();

        @Test
        void testBasicCase() {
            int[] input = {6, 8, 4, 2, 7, 3, 1, 5};
            int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testEmptyArray() {
            int[] input = {};
            int[] expected = {};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testSingleElement() {
            int[] input = {42};
            int[] expected = {42};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testAlreadySorted() {
            int[] input = {1, 2, 3, 4, 5};
            int[] expected = {1, 2, 3, 4, 5};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testReversedArray() {
            int[] input = {5, 4, 3, 2, 1};
            int[] expected = {1, 2, 3, 4, 5};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testWithDuplicates() {
            int[] input = {3, 1, 2, 3, 1};
            int[] expected = {1, 1, 2, 3, 3};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testNegativeNumbers() {
            int[] input = {-2, -5, 0, 3, 1};
            int[] expected = {-5, -2, 0, 1, 3};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testAllSameValues() {
            int[] input = {7, 7, 7, 7};
            int[] expected = {7, 7, 7, 7};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testPerformanceComparison() {
            int[] sortedArray = IntStream.range(0, 1_0000).toArray();

            int[] input = Arrays.copyOf(sortedArray, sortedArray.length);

            long start = System.nanoTime();
            sorter.sortArray(input);
            long duration = System.nanoTime() - start;

            System.out.println("Naive Quicksort: " + duration / 1_000_000 + " ms");

            // 성능 차이 테스트 => Naive Quicksort: 13 ms
        }
    }

    @Nested
    class QuickSortOptimizedTests {
        SortArray_QuickSort_Optimized sorter = new SortArray_QuickSort_Optimized();

        @Test
        void testBasicCase() {
            int[] input = {6, 8, 4, 2, 7, 3, 1, 5};
            int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testEmptyArray() {
            int[] input = {};
            int[] expected = {};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testSingleElement() {
            int[] input = {42};
            int[] expected = {42};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testAlreadySorted() {
            int[] input = {1, 2, 3, 4, 5};
            int[] expected = {1, 2, 3, 4, 5};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testReversedArray() {
            int[] input = {5, 4, 3, 2, 1};
            int[] expected = {1, 2, 3, 4, 5};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testWithDuplicates() {
            int[] input = {3, 1, 2, 3, 1};
            int[] expected = {1, 1, 2, 3, 3};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testNegativeNumbers() {
            int[] input = {-2, -5, 0, 3, 1};
            int[] expected = {-5, -2, 0, 1, 3};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testAllSameValues() {
            int[] input = {7, 7, 7, 7};
            int[] expected = {7, 7, 7, 7};
            assertArrayEquals(expected, sorter.sortArray(input));
        }

        @Test
        void testPerformanceComparison() {
            int[] sortedArray = IntStream.range(0, 1_0000).toArray();

            int[] input = Arrays.copyOf(sortedArray, sortedArray.length);

            long start = System.nanoTime();
            sorter.sortArray(input);
            long duration = System.nanoTime() - start;

            System.out.println("Optimized Quicksort: " + duration / 1_000_000 + " ms");

            // 성능 차이 테스트 => Optimized Quicksort: 1 ms
            // 약 13배 성능 최적화 발생...!
        }
    }
}
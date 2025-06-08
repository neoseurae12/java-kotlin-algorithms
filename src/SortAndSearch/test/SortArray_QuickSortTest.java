package SortAndSearch.test;

import SortAndSearch.SortArray_QuickSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortArray_QuickSortTest {
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
}
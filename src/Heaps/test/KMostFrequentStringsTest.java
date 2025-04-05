package Heaps.test;

import Heaps.KMostFrequentStrings_MaxHeap;
import Heaps.KMostFrequentStrings_MinHeap;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KMostFrequentStringsTest {

    @Nested
    class MaxHeapTests {
        @Test
        void testBasicCase() {
            String[] strs = {"go", "coding", "byte", "byte", "go", "interview", "go"};
            int k = 2;
            List<String> expected = List.of("go", "byte");
            List<String> actual = KMostFrequentStrings_MaxHeap.kMostFrequentStringsMaxHeap(strs, k);

            assertEquals(expected, actual);
        }

        @Test
        void testSameFrequencyDifferentLexOrder() {
            String[] input = {"dog", "cat", "dog", "cat", "hamster"};
            int k = 2;
            List<String> expected = List.of("cat", "dog");
            List<String> actual = KMostFrequentStrings_MaxHeap.kMostFrequentStringsMaxHeap(input, k);

            assertEquals(expected, actual);
        }

        @Test
        void testSingleElement() {
            String[] input = {"onlyone"};
            int k = 1;
            List<String> expected = List.of("onlyone");
            List<String> actual = KMostFrequentStrings_MaxHeap.kMostFrequentStringsMaxHeap(input, k);

            assertEquals(expected, actual);
        }
    }

    @Nested
    class MinHeapTests {
        @Test
        void testBasicCase() {
            String[] strs = {"go", "coding", "byte", "byte", "go", "interview", "go"};
            int k = 2;
            List<String> expected = List.of("go", "byte");
            List<String> actual = KMostFrequentStrings_MinHeap.kMostFrequentStringsMinHeap(strs, k);

            assertEquals(expected, actual);
        }

        @Test
        void testSameFrequencyDifferentLexOrder() {
            String[] input = {"dog", "cat", "dog", "cat", "hamster"};
            int k = 2;
            List<String> expected = List.of("cat", "dog");
            List<String> actual = KMostFrequentStrings_MinHeap.kMostFrequentStringsMinHeap(input, k);

            assertEquals(expected, actual);
        }

        @Test
        void testSingleElement() {
            String[] input = {"onlyone"};
            int k = 1;
            List<String> expected = List.of("onlyone");
            List<String> actual = KMostFrequentStrings_MinHeap.kMostFrequentStringsMinHeap(input, k);

            assertEquals(expected, actual);
        }
    }
}
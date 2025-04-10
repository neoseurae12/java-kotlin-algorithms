package Heaps.test;

import Heaps.MedianOfAnIntegerStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfAnIntegerStreamTest {
    @Test
    void testSingleElement() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        stream.add(10);
        assertEquals(10f, stream.getMedian());
    }

    @Test
    void testTwoElements() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        stream.add(10);
        stream.add(20);
        assertEquals(15f, stream.getMedian());
    }

    @Test
    void testOddNumberOfElements() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        stream.add(10);
        stream.add(30);
        stream.add(20);
        assertEquals(20f, stream.getMedian());
    }

    @Test
    void testEvenNumberOfElements() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        stream.add(10);
        stream.add(30);
        stream.add(20);
        stream.add(50);
        assertEquals(25f, stream.getMedian());
    }

    @Test
    void testNegativeAndZero() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        stream.add(-10);
        stream.add(0);
        stream.add(-20);
        assertEquals(-10f, stream.getMedian());
    }

    @Test
    void testWithDuplicates() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        stream.add(5);
        stream.add(5);
        stream.add(5);
        assertEquals(5f, stream.getMedian());
    }

    @Test
    void testLongSequence() {
        MedianOfAnIntegerStream stream = new MedianOfAnIntegerStream();
        for (int i = 1; i <= 1000; i++) {
            stream.add(i);
        }
        assertEquals(500.5, stream.getMedian());
    }
}
package Intervals.test;

import Intervals.LargestOverlapOfIntervals;
import datatype.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestOverlapOfIntervalsTest {

    @Test
    void testFullyOverlappingIntervals() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 5),
                new Interval(2, 6),
                new Interval(3, 7)
        ));
        assertEquals(3, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }

    @Test
    void testNonOverlappingIntervals() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 2),
                new Interval(3, 4),
                new Interval(5, 6)
        ));
        assertEquals(1, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }

    @Test
    void testTouchingButNotOverlappingIntervals() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 3),
                new Interval(3, 5),
                new Interval(5, 7)
        ));
        assertEquals(1, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }

    @Test
    void testMixedOverlappingIntervals() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(4, 8),
                new Interval(6, 7),
                new Interval(5, 7)
        ));
        assertEquals(3, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }

    @Test
    void testSingleInterval() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(1, 10)));
        assertEquals(1, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }

    @Test
    void testEmptyList() {
        List<Interval> intervals = new ArrayList<>();
        assertEquals(0, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }

    @Test
    void testNullList() {
        assertEquals(0, LargestOverlapOfIntervals.largestOverlapOfIntervals(null));
    }

    @Test
    void testOverlappingAtExactSameTime() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 5),
                new Interval(1, 5),
                new Interval(1, 5)
        ));
        assertEquals(3, LargestOverlapOfIntervals.largestOverlapOfIntervals(intervals));
    }
}
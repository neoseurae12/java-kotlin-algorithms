package Intervals.test;

import Intervals.MergeOverlappingIntervals;
import datatype.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeOverlappingIntervalsTest {

    @Test
    void testNoOverlap() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 2),
                new Interval(3, 4),
                new Interval(5, 6)
        ));

        List<Interval> expected = List.of(
                new Interval(1, 2),
                new Interval(3, 4),
                new Interval(5, 6)
        );

        assertEquals(expected, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
    }

    @Test
    void testCompleteOverlap() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 5),
                new Interval(2, 3),
                new Interval(4, 6)
        ));

        List<Interval> expected = List.of(
                new Interval(1, 6)
        );

        assertEquals(expected, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
    }

    @Test
    void testPartialOverlap() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(3, 4),
                new Interval(7, 8),
                new Interval(2, 5),
                new Interval(6, 7),
                new Interval(1, 4)
        ));

        List<Interval> expected = List.of(
                new Interval(1, 5),
                new Interval(6, 8)
        );

        assertEquals(expected, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
    }

    @Test
    void testAdjacentButNotOverlapping() {
        List<Interval> intervals = new ArrayList<>(List.of(
                new Interval(1, 2),
                new Interval(2, 3),
                new Interval(3, 4)
        ));

        List<Interval> expected = List.of(
                new Interval(1, 4)
        );

        assertEquals(expected, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
    }

    @Test
    void testEmptyInput() {
        List<Interval> intervals = new ArrayList<>();
        List<Interval> expected = new ArrayList<>();

        assertEquals(expected, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
    }

    @Test
    void testSingleInterval() {
        List<Interval> intervals = new ArrayList<>(List.of(new Interval(5, 10)));
        List<Interval> expected = List.of(new Interval(5, 10));

        assertEquals(expected, MergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
    }
}
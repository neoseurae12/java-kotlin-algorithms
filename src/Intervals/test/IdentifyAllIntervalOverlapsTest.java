package Intervals.test;

import Intervals.IdentifyAllIntervalOverlaps;
import datatype.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IdentifyAllIntervalOverlapsTest {
    @Test
    void testBasicOverlap() {
        List<Interval> list1 = List.of(
                new Interval(1, 4),
                new Interval(5, 6),
                new Interval(9, 10)
        );

        List<Interval> list2 = List.of(
                new Interval(2, 7),
                new Interval(8, 9)
        );

        List<Interval> expected = List.of(
                new Interval(2, 4),
                new Interval(5, 6),
                new Interval(9, 9)
        );

        List<Interval> actual = IdentifyAllIntervalOverlaps.identifyAllIntervalOverlaps(
                new ArrayList<>(list1), new ArrayList<>(list2)
        );

        assertEquals(expected, actual);
    }

    @Test
    void testNoOverlap() {
        List<Interval> list1 = List.of(
                new Interval(1, 2),
                new Interval(5, 6)
        );

        List<Interval> list2 = List.of(
                new Interval(3, 4),
                new Interval(7, 8)
        );

        List<Interval> expected = List.of();

        List<Interval> actual = IdentifyAllIntervalOverlaps.identifyAllIntervalOverlaps(
                new ArrayList<>(list1), new ArrayList<>(list2)
        );

        assertEquals(expected, actual);
    }

    @Test
    void testExactMatchOverlap() {
        List<Interval> list1 = List.of(new Interval(2, 5), new Interval(10, 11));
        List<Interval> list2 = List.of(new Interval(2, 5), new Interval(10, 11));

        List<Interval> expected = List.of(new Interval(2, 5), new Interval(10, 11));

        List<Interval> actual = IdentifyAllIntervalOverlaps.identifyAllIntervalOverlaps(
                new ArrayList<>(list1), new ArrayList<>(list2)
        );

        assertEquals(expected, actual);
    }

    @Test
    void testSingleSidedEmpty() {
        List<Interval> list1 = new ArrayList<>();
        List<Interval> list2 = List.of(new Interval(1, 3));

        List<Interval> actual = IdentifyAllIntervalOverlaps.identifyAllIntervalOverlaps(
                list1, new ArrayList<>(list2)
        );

        assertEquals(List.of(), actual);
    }

    @Test
    void testBothSidedEmpty() {
        List<Interval> list1 = new ArrayList<>();
        List<Interval> list2 = new ArrayList<>();

        List<Interval> actual = IdentifyAllIntervalOverlaps.identifyAllIntervalOverlaps(
                list1, list2
        );

        assertEquals(List.of(), actual);
    }

    @Test
    void testTouchingButNotOverlapping() {
        List<Interval> list1 = List.of(new Interval(1, 3));
        List<Interval> list2 = List.of(new Interval(3, 5));

        List<Interval> expected = List.of(new Interval(3, 3));

        List<Interval> actual = IdentifyAllIntervalOverlaps.identifyAllIntervalOverlaps(
                new ArrayList<>(list1), new ArrayList<>(list2)
        );

        assertEquals(expected, actual);
    }
}
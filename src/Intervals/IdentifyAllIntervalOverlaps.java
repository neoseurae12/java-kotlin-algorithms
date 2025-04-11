package Intervals;

/*
- Intervals > Managing Overlaps
 */

import datatype.Interval;

import java.util.ArrayList;
import java.util.List;

public class IdentifyAllIntervalOverlaps {
    public static List<Interval> identifyAllIntervalOverlaps(List<Interval> intervals1, List<Interval> intervals2) {
        if (intervals1 == null || intervals1.isEmpty() || intervals2 == null || intervals2.isEmpty())
            return new ArrayList<>();

        ArrayList<Interval> intersections = new ArrayList<>();

        int idx1, idx2;
        idx1 = idx2 = 0;
        while (idx1 < intervals1.size() && idx2 < intervals2.size()) {
            Interval interval1 = intervals1.get(idx1);
            Interval interval2 = intervals2.get(idx2);

            Interval a, b;
            if (interval1.start <= interval2.start) {
                a = interval1;
                b = interval2;
            }
            else {
                a = interval2;
                b = interval1;
            }

            // overlapping
            if (a.end >= b.start)
                intersections.add(new Interval(b.start, Math.min(a.end, b.end)));

            // advance to next interval
            if (interval1.end < interval2.end)
                idx1++;
            else
                idx2++;
        }

        return intersections;
    }
}

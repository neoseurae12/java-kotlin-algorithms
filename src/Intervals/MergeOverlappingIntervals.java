package Intervals;

/*
- Intervals > Managing Overlaps
 */

import datatype.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static List<Interval> mergeOverlappingIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return new ArrayList<>();

        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        List<Interval> merged = new ArrayList<>();
        for (Interval b : intervals) {
            if (merged.isEmpty()) {
                merged.add(b);
                continue;
            }

            Interval a = merged.get(merged.size() - 1);

            // overlapped
            if (b.start <= a.end) {
                // end 업데이트
                a.end = Math.max(a.end, b.end);
            }
            // not overlapped
            else {
                // new interval 추가
                merged.add(b);
            }
        }

        return merged;
    }
}

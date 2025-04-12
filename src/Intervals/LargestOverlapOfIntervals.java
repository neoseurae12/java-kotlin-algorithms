package Intervals;

/*
- Intervals > Finding Values in Sorted Order
 */

import datatype.Interval;

import java.util.*;

public class LargestOverlapOfIntervals {
    public static int largestOverlapOfIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return 0;

        // intervals -> points
        List<int[]> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new int[]{interval.start, 'S'});
            points.add(new int[]{interval.end, 'E'});
        }

        points.sort((a, b) -> {
            int timeA = a[0], timeB = b[0];
            int pointTypeA = a[1], pointTypeB = b[1];

            // 걑은 시점일 시 => end point가 start point에 더 우선됨; 'E' -> 'S'
            if (timeA == timeB)
                return Integer.compare(pointTypeA, pointTypeB);
            // 일반적 => 더 빠른 시점의 point가 더 우선됨
            return Integer.compare(timeA, timeB);
        });

        int maxOverlaps = 0;
        int activeIntervals = 0;
        for (int[] point : points) {
            int pointType = point[1];

            if (pointType == 'S')
                activeIntervals++;
            else
                activeIntervals--;

            maxOverlaps = Math.max(maxOverlaps, activeIntervals);
        }

        return maxOverlaps;
    }
}

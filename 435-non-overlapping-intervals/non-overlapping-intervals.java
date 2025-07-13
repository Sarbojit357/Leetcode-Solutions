import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int nonOverlapCount = 1;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                nonOverlapCount++;
                prevEnd = intervals[i][1];
            }
        }
        return intervals.length - nonOverlapCount;
    }
}

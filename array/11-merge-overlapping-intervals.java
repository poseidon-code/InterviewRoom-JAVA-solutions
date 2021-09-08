// PROBLEM: Merge overlapping intervals
// https://leetcode.com/problems/merge-intervals/
// https://www.interviewbit.com/problems/merge-intervals/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    // SOLUTION
    public int[][] merge_intervals (int[][] intervals) {
        if (intervals.length<=1) return intervals;

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i=1; i<intervals.length; i++) {
            if (result.get(result.size()-1)[1]<=intervals[i][0])
                result.add(intervals[i]);
            else
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], intervals[i][1]);
        }

        return result.toArray(new int[result.size()][]);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        // OUTPUT :
        var mergeintervals = s.merge_intervals(intervals);
        System.out.print("[");
        for (int i=0; i<mergeintervals.length; i++) {
            System.out.print("[");
            for (int j=0; j<mergeintervals[i].length; j++)
                System.out.print(mergeintervals[i][j] + " ");
            System.out.print("\b], ");
        }
        System.out.println("\b\b]");
    }
}

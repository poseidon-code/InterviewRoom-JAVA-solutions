// PROBLEM: Topological Sort (Course Schedule 2)
// https://leetcode.com/problems/course-schedule-ii/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // SOLUTION
    public ArrayList<Integer> find_order (int courses, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[courses]; for (int i=0; i<courses; i++) G[i] = new ArrayList<Integer>();
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[courses];
        for (var pre : prerequisites) {
            G[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> q  = new LinkedList<>();
        for (int i=0; i<courses; i++)
            if (indegree[i]==0) q.add(i);
        
        while (q.size()!=0) {
            var cur = q.poll();
            ans.add(cur);

            for (var nextCourse : G[cur])
                if (--indegree[nextCourse] == 0)
                    q.add(nextCourse);
        }

        if (ans.size()==courses) return ans;
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int courses = 2;
        int[][] prerequisites = {{1,0}};

        // OUTPUT :
        var result = s.find_order(courses, prerequisites);
        System.out.print("["); for (var x : result) System.out.print(x + ", "); System.out.println("\b\b]");
    }
}
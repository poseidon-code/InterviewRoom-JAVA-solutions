// PROBLEM: Cycle in a directed graph
// https://leetcode.com/problems/course-schedule/
// https://www.interviewbit.com/problems/cycle-in-directed-graph/

import java.util.ArrayList;

class Solution {
    // SOLUTION
    public boolean can_finish (int courses, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[courses];
        int[] degree = new int[courses];
        ArrayList<Integer> bfs = new ArrayList<>();
        for (int i=0; i<courses; ++i) G[i]=new ArrayList<Integer>();
        
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        
        for (int i=0; i<courses; ++i)
            if (degree[i] == 0) bfs.add(i);
        
        for (int i=0; i<bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        
        return bfs.size() == courses;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int courses = 2;
        int[][] prerequisites = {{1,0},{0,1}};

        // OUTPUT :
        System.out.println(s.can_finish(courses, prerequisites));
    }
}
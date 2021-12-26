// PROBLEM: Cycle in undirected graph
// https://www.interviewbit.com/problems/cycle-in-undirected-graph/
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/?category{]=Graph&category[]=Graph&page=1&query=category[]Graphpage1category[]Graph


import java.util.ArrayList;
    
class Solution {
    // SOLUTION
    static boolean dfs (ArrayList<Integer>[] adj, boolean[] v, int p, int s) {
        v[s] = true;

        for(var i : adj[s]) {
            if(v[i]==false) {
                if(dfs(adj,v,s,i))
                    return true;
            } else if (i!=p) {
                return true;
            }
        }

        return false;
    }

    public boolean is_cycle (int[][] graph, int n) {
        boolean[] v = new boolean[n+1]; v[0] = false;
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) adj[i] = new ArrayList<Integer>();
        adj[0].add(-1);
        
        for(int i=0; i<graph.length; i++) {
            adj[graph[i][0]].add(graph[i][1]);
            adj[graph[i][1]].add(graph[i][0]);
        }

        for(int i=1; i<n+1; i++) {
            if (v[i]==false)
                if (dfs(adj, v, -1, i))
                    return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int n = 5;
        int[][] graph = {{1,2},{1,3},{2,3},{1,4},{4,5}};

        // OUTPUT :
        System.out.println(s.is_cycle(graph, n));
    }
}
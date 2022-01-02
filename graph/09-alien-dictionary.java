// PROBLEM: Alien Dictionary
// https://practice.geeksforgeeks.org/problems/alien-dictionary/1/?category[]=Graph&category[]=Graph&page=1&query=category[]Graphpage1category[]Graph

import java.util.ArrayList;

class Solution {
    // SOLUTION
    public int index;
    public char[] toposort(ArrayList<ArrayList<Integer>> adj, int k) {
        index = k-1;
        char ans[] = new char[k];
        boolean visited[] = new boolean[k];

        for(int i=0; i<k; i++)
            if(!visited[i])
                dfs(adj, ans, k, i, visited);
        
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, char[] ans, int k, int i, boolean visited[]) {
        visited[i] = true;
        ArrayList<Integer> childs = adj.get(i);
        
        for(int j=0; j<childs.size(); j++)
            if(!visited[childs.get(j)])
                dfs(adj, ans, k, childs.get(j), visited);
        
        ans[index--] = (char)(i+'a');
    }

    public String order (String[] d, int n, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<d.length-1; i++) {
            for(int j=0; j<Math.min(d[i].length(), d[i+1].length()); j++) {
                if(d[i].charAt(j) != d[i+1].charAt(j)) {
                    adj.get(d[i].charAt(j)-'a').add(d[i+1].charAt(j)-'a');
                    break;
                }
            }
        }

        char ans[] = toposort(adj, k);
        return new String(ans);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String[] d = {"caa", "aaa", "aab"};
        int n = 3;
        int k = 3;

        // OUTPUT :
        System.out.println(s.order(d, n, k));
    }
}
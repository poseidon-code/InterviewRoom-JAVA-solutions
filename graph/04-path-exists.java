// PROBLEM: Find whether the pat exists
// https://www.interviewbit.com/problems/path-in-directed-graph/
// https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/?category[]=Graph&category[]=Graph&page=1&query=category[]Graphpage1category[]Graph

class Solution {
    // SOLUTION
    static boolean path (int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0) return false;
        if (grid[i][j]==2) return true;
        grid[i][j] = 0;

        return path(grid, i+1, j) || path(grid, i-1, j) || path(grid, i, j+1) || path(grid, i, j-1);
    }

    public boolean is_possible (int[][] grid) {
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return path(grid, i, j);
            }
        }
    
        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[][] grid = {{1,3},{3,2}};

        // OUTPUT :
        System.out.println(s.is_possible(grid));
    }
}
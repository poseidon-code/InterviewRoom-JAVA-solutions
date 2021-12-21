// PROBLEM: Region in binary matrix
// https://www.interviewbit.com/problems/region-in-binarymatrix/
// https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1


class Solution {
    // SOLUTION
    static int result = 0;
    static void dfs (int[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0) return;
    
        grid[i][j] = 0;
        result++;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i,   j+1);
        dfs(grid, i,   j-1);
        dfs(grid, i+1, j+1);
        dfs(grid, i-1, j+1);
        dfs(grid, i+1, j-1);
        dfs(grid, i-1, j-1);
    }

    public int region (int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxarea=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                result = 0;
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxarea = Math.max(maxarea, result);
                }
            }
        }

        return maxarea;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};

        // OUTPUT :
        System.out.println(s.region(grid));
    }
}
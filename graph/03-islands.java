// PROBLEM: Number of islands
// https://leetcode.com/problems/number-of-islands/
// https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1/?category[]=Graph&category[]=Graph&page=1&query=category[]Graphpage1category[]Graph

class Solution {
    // SOLUTION
    static int dfs (char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0') return 0;
        
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }

    public int islands (char[][] grid) {
        int islands = 0;
    
        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[i].length; j++)
                islands += dfs(grid, i, j);
        
        return islands;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        // OUTPUT :
        System.out.println(s.islands(grid));
    }
}
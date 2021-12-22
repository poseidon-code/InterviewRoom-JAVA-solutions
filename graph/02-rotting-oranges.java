// PROBLEM: Rotting Oranges
// https://leetcode.com/problems/rotting-oranges/
// https://practice.geeksforgeeks.org/problems/rotten-oranges/0

class Solution {
    // SOLUTION
    static int rot (int[][] grid, int i, int j, int d) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]!=1) return 0;
        grid[i][j] = d + 3;
        return 1;
    }

    public int oranges (int[][] grid) {
        int fresh=0, d=0;

        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[i].length; j++)
                if (grid[i][j]==1) ++fresh;
        
        for (int old=fresh; fresh>0; d++, old=fresh) {
            for (int i=0; i<grid.length; i++)
                for (int j=0; j<grid[i].length; j++)
                    if (grid[i][j] == d+2)
                        fresh -= rot(grid, i+1, j, d) +
                                rot(grid, i-1, j, d) +
                                rot(grid, i, j+1, d) +
                                rot(grid, i, j-1, d);
            if (fresh == old) return -1;
        }

        return d;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};

        // OUTPUT :
        System.out.println(s.oranges(grid));
    }
}
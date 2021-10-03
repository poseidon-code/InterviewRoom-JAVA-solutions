// PROBLEM: Minimum time to rot all oranges
// https://leetcode.com/problems/rotting-oranges/
// https://practice.geeksforgeeks.org/problems/rotten-oranges/0


import java.util.LinkedList;
import java.util.Queue;


class Solution {
    // SOLUTION
    public int rotting (int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int dir[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int ct=0, result=-1;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] > 0) ct++;
                if (grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }

        while (!q.isEmpty()) {
            result++;
            int size=q.size();

            for (int k=0; k<size; k++) {
                int cur[] = q.peek();
                ct--;
                q.poll();

                for (int i=0; i<4; i++) {
                    int x=cur[0]+dir[i][0];
                    int y=cur[1]+dir[i][1];

                    if (x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]!=1)
                        continue;

                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                }
            }
        }

        if (ct==0) return Math.max(0, result);
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};

        // OUTPUT :
        System.out.println(s.rotting(grid));
    }
}
// PROBLEM: Snakes and Ladders
// https://leetcode.com/problems/snakes-and-ladders/
// https://www.interviewbit.com/problems/snake-ladder-problem/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // SOLUTION
    public int[] calc (int row, int next) {
        int x = (next-1)/row;
        int y = (next-1)%row;
        if (x%2==1) y = row-1-y;
        x = row-1-x;
        return new int[] {x,y};
    }

    public int snl (int[][] board) {
        int r = board.length;
        Queue<Integer> q = new LinkedList<>(); q.add(1);
        int step = 0;
        
        while (!q.isEmpty()) {
            int n = q.size();
            
            for (int i=0; i<n; i++) {
                int t = q.poll();
                if(t==r*r)return step;

                for(int j=1; j<=6; j++) {
                    int next_step = t+j;
                    if (next_step>r*r) break;

                    var v = calc(r, next_step);
                    int row=v[0], col=v[1];
                    
                    if(board[row][col]!=-1)
                        next_step=board[row][col];
                    
                    if(board[row][col]!=r*r+1) {
                        q.add(next_step);
                        board[row][col]=r*r+1;
                    }
                }
            }

            step++;
        }
        
        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[][] board = {{-1,-1},{-1,3}};

        // OUTPUT :
        System.out.println(s.snl(board));
    }
}
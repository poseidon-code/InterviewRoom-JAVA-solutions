// PROBLEM: Find kth smallest element in matrix
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    // SOLUTION
    public int k_smallest (int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int r=0; r<Math.min(m, k); r++)
            pq.offer(new int[]{matrix[r][0], r, 0});
        
        for (int i=1; i<=k; i++) {
            int[] top = pq.poll();
            int r = top[1];
            int c = top[2];
            result = top[0];
            if (c + 1 < n) pq.offer(new int[]{matrix[r][c+1], r, c+1});
        }

        return result;
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        int k = 8;

        // OUTPUT :
        System.out.println(s.k_smallest(matrix, k));
    }
}
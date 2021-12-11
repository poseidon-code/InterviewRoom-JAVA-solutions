// PROBLEM: 01 Knapsack
// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0

class Solution {
    // SOLUTION
    public int knapsack (int W, int[] weights, int[] values, int N) {
        int[] dp = new int[W+1];

        for (int i=1; i<N+1; i++) {
            for (int w=W; w>=0; w--) {
                if (weights[i-1] <= w)
                    dp[w] = Math.max(dp[w], dp[w - weights[i-1]] + values[i-1]);
            }
        }
    
        return dp[W];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int N = 3;
        int W = 4;
        int[] values = {1,2,3};
        int[] weights = {4,5,1};

        // OUTPUT :
        System.out.println(s.knapsack(W, weights, values, N));
    }
}
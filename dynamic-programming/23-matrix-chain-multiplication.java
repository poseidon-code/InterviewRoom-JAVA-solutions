// PROBLEM: Burst Baloons (Matrix Chain Multiplication)
// https://leetcode.com/problems/burst-balloons/

class Solution {
    // SOLUTION
    public int max_coins (int[] nums) {
        int[] N = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x>0) N[n++]=x;
        N[0] = N[n++] = 1;


        int[][] dp = new int[n][n];
        
        for (int k=2; k<n; ++k) {
            for (int l=0; l<n-k; ++l) {
                int r = l+k;
                for (int i=l+1; i<r; ++i)
                    dp[l][r] = Math.max(dp[l][r], N[l] * N[i] * N[r] + dp[l][i] + dp[i][r]);
            }
        }

        return dp[0][n-1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {3,1,5,8};

        // OUTPUT :
        System.out.println(s.max_coins(nums));
    }
}
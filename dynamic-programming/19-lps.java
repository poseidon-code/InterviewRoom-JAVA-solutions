// PROBLEM: Longest palindromic subsequence
// https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution {
    // SOLUTION
    public int lps (String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n];
        for (int i=0; i<n; i++) dp[1][i]=1;

        for (int i=2; i<=n; i++) {
            for (int j=0; j<n-i+1; j++) {
                dp[i][j] = s.charAt(j)==s.charAt(i+j-1) ? 2+dp[i-2][j+1] : Math.max(dp[i-1][j], dp[i-1][j+1]);
            }
        }

        return dp[n][0];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String x = "bbbab";

        // OUTPUT :
        System.out.println(s.lps(x));
    }
}
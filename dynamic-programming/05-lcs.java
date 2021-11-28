// PROBLEM: Longest common subsequence (delete operation for two strings)
// https://leetcode.com/problems/delete-operation-for-two-strings/


class Solution {
    // SOLUTION
    public int lcs (String word1, String word2) {
        int m = word1.length(), n = word2.length();
        char[] a = word1.toCharArray(), b = word2.toCharArray();
        int[][] dp = new int[m+1][n+1];

        for (int i=m; i>=0; i--) {
            for (int j=n; j>=0; j--) {
                if (i<m || j<n) {
                    dp[i][j] = 
                        i<m && j<n && a[i]==b[j]
                        ? dp[i+1][j+1]
                        : 1 + Math.min(
                                (i<m ? dp[i+1][j] : Integer.MAX_VALUE), 
                                (j<n ? dp[i][j+1] : Integer.MAX_VALUE)
                            );
                }
            }
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String word1 = "sea";
        String word2 = "eat";

        // OUTPUT :
        System.out.println(s.lcs(word1, word2));
    }
}
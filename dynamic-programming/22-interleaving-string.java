// PROBLEM: Interleaving String
// https://leetcode.com/problems/interleaving-string/
// https://www.interviewbit.com/problems/interleaving-strings/

class Solution {
    // SOLUTION
    public boolean is_interleaving (String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(s3.length() != m + n) return false;

        boolean[][] dp = new boolean[m+1][n+1];
        
        for(int i=0; i<m+1; i++) {
            for(int j=0; j<n+1; j++){
                if(i==0 && j==0)
                    dp[i][j] = true;
                else if(i == 0)
                    dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
                else if(j == 0)
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
                else
                    dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) ) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        // OUTPUT :
        System.out.println(s.is_interleaving(s1, s2, s3));
    }
}
// PROBLEM: Min cost path
// https://www.interviewbit.com/problems/min-sum-path-in-matrix/

class Solution {
    // SOLUTION
    public int path (int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];

        for(int i=m-1; i>=0; i--)
            for(int j=n-1; j>=0; j--)
                if(i==m-1 && j==n-1) dp[i][j] = A[i][j];
                else if(i==m-1) dp[i][j] = A[i][j] + dp[i][j+1];
                else if(j==n-1) dp[i][j] = A[i][j] + dp[i+1][j];            
                else dp[i][j] = A[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
        
        return dp[0][0];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[][] A = {{1,3,2},{4,3,1},{5,6,1}};

        // OUTPUT :
        System.out.println(s.path(A));
    }
}
// PROBLEM: Coin sum infinite
// https://www.interviewbit.com/problems/coin-sum-infinite/

class Solution {
    // SOLUTION
    public int coin_sum (int[] s, int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        for (int i=0; i<s.length; i++) {
            for (int j=s[i]; j<=n; j++) {
                dp[j] += dp[j-s[i]];
            }
        }
    
        return dp[n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int coins[] = {1,2,3};
        int n = 4;

        // OUTPUT :
        System.out.println(s.coin_sum(coins, n));
    }
}
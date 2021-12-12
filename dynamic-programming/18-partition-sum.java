import java.util.Arrays;

// PROBLEM: Partition Equal Subset Sum
// https://leetcode.com/problems/partition-equal-subset-sum/

class Solution {
    // SOLUTION
    public boolean partition (int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        if ((sum & 1)==1) return false;
        sum /=2;

        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int x : nums)
            for (int i=sum; i>0; i--)
                if (i >= x)
                    dp[i] = dp[i] || dp[i-x];

        return dp[sum];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {1,5,11,5};

        // OUTPUT :
        System.out.println(s.partition(nums));
    }
}
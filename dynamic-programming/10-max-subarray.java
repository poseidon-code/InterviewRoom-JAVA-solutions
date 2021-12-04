// PROBLEM: Maximum subarray
// https://leetcode.com/problems/maximum-subarray/

class Solution {
    // SOLUTION
    public int max_subarray (int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];
        
        for (int i=1; i<n; i++) {
            dp[i] = nums[i] + (dp[i-1]>0 ? dp[i-1] : 0);
            result = Math.max(result, dp[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {5,4,-1,7,8};

        // OUTPUT :
        System.out.println(s.max_subarray(nums));
    }
}
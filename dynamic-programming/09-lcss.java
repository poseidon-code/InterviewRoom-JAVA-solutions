// PROBLEM: Longest common substring
// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

class Solution {
    // SOLUTION
    public int lcss (int[] nums1, int[] nums2) {
        int m=nums1.length, n=nums2.length;
        int[] dp = new int[n+1];
        int result = 0;

        for (int i=1; i<=m; i++) {
            for (int j=n; j>0; j--) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[j] = 1 + dp[j-1];
                    result = Math.max(result, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};

        // OUTPUT :
        System.out.println(s.lcss(nums1, nums2));
    }
}
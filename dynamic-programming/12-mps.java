// PROBLEM: Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/

class Solution {
    // SOLUTION
    public int mps (int[] nums) {
        int n=nums.length, l=0, r=0;
        int result = nums[0];

        for (int i=0; i<n; i++) {
            l = (l!=0 ? l : 1) * nums[i];
            r = (r!=0 ? r : 1) * nums[n-1-i];
            result = Math.max(result, Math.max(l, r));
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {2,3,-2,4};

        // OUTPUT :
        System.out.println(s.mps(nums));
    }
}
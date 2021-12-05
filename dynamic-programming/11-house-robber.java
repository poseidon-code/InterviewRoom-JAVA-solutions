// PROBLEM: House Robber
// https://leetcode.com/problems/house-robber/

class Solution {
    // SOLUTION
    public int rob (int[] nums) {
        int a=0, b=0, n=nums.length;
        
        for (int i=0; i<n; i++) {
            if (i%2==0)
                a = Math.max(a+nums[i], b);
            else
                b = Math.max(a, b+nums[i]);
        }

        return Math.max(a, b);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {1,2,3,1};

        // OUTPUT :
        System.out.println(s.rob(nums));
    }
}
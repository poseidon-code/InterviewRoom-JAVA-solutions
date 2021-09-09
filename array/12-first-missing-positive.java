// PROBLEM: First missing positive
// https://leetcode.com/problems/first-missing-positive/
// https://www.interviewbit.com/problems/first-missing-integer/


class Solution {
    // SOLUTION
    int missing_positive (int[] nums) {
        int n = nums.length;

        for (int i=0; i<n; i++) {
            while (nums[i]>0 && nums[i]<=n && nums[nums[i]-1] != nums[i]) {
                int t=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[nums[i]-1]=t;
            }
        }

        for (int i=0; i<n; i++)
            if (nums[i] != i+1)
                return i+1;
        
        return n+1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[] nums = {7,8,9,11,12,-3};

        // OUTPUT :
        System.out.println(s.missing_positive(nums));
    }
}
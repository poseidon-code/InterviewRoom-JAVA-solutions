// PROBLEM: Find duplicate number
// https://leetcode.com/problems/find-the-duplicate-number/


class Solution {
    // SOLUTION
    public int duplicate(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            nums[index] *= -1;
            
            if (nums[index]>0)
                return Math.abs(nums[i]);
        }

        return -1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {3,1,3,4,2};

        // OUTPUT :
        System.out.println(s.duplicate(nums));
    }
}
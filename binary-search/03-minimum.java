// PROBLEM: Find minimum in a rotated sorted array
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    // SOLUTION
    public int minimum (int[] nums) {
        int start=0, end=nums.length-1;
    
        while (start<end) {
            if (nums[start]<nums[end])
                return nums[start];
            
            int mid = (start+end)/2;

            if (nums[mid]>=nums[start]) start = mid+1;
            else end = mid;
        }

        return nums[start];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {3,4,5,1,2};

        // OUTPUT :
        System.out.println(s.minimum(nums));
    }
}
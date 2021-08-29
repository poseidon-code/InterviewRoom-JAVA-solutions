// PROBLEM: Missing number in array
// https://leetcode.com/problems/missing-number/
// https://practice.geeksforgeeks.org/problems/missing-number-in-array/0

class Solution {
    // SOLUTION
    public int missing_number(int[] nums) {
        int result=nums.length;
        int i=0;

        for (int num:nums) {
            result ^= num^i;
            i++;
        }

	    return result;
    }

    public static void main (String[] args) {
        Solution s = new Solution();

        // INPUT :
        int nums[] = {3,2,0,1};

        // OUTPUT :
        System.out.println(s.missing_number(nums));
    }
}

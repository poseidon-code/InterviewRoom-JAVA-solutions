// PROBLEM: Majority element
// https://leetcode.com/problems/majority-element/
// https://www.interviewbit.com/problems/majority-element/
// https://practice.geeksforgeeks.org/problems/majority-element/0


class Solution {
    // SOLUTION
    public int majority_element (int[] nums) {
        int major=nums[0];
        int count=1;

        for (int n : nums) {
            if (count == 0) {
                count++;
                major = n;
            }
            else if (major == n)
                count++;
            else
                count--;
        }

        return major;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {3,2,3};

        // OUTPUT :
        System.out.println(s.majority_element(nums));
    }
}
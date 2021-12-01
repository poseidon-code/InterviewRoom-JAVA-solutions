// PROBLEM: Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/
// https://www.interviewbit.com/problems/longest-increasing-subsequence/

class Solution {
    // SOLUTION
    public int lis (int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i=0, j=size;

            while (i!=j) {
                int m =(i+j)/2;
                if (tails[m]<x) i = m+1;
                else j = m;
            }

            tails[i] = x;
            if (i==size) ++size;
        }

        return size;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {10,9,2,5,3,7,101,18};

        // OUTPUT :
        System.out.println(s.lis(nums));
    }
}
// PROBLEM: Next permutation
// https://leetcode.com/problems/next-permutation/
// https://www.interviewbit.com/problems/next-permutation/


import java.util.Arrays;
import java.util.Collections;


class Solution {
    // SOLUTION
    public void next_permutation (int[] nums) {
        int n = nums.length;
        int k, l;

        for (k=n-2; k>=0; k--)
            if (nums[k] < nums[k+1]) break;

        if (k<0) {
            Collections.reverse(Arrays.asList(nums));
        } else {
            for (l=n-1; l>k; l--)
                if (nums[l] > nums[k]) break;

            int t=nums[k];
            nums[k]=nums[l];
            nums[l]=t;

            Collections.reverse(Arrays.asList(nums));
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[] nums = {1,1,5};

        // OUTPUT :
        s.next_permutation(nums);
        System.out.print("["); for (int i : nums) System.out.print(i + " "); System.out.println("\b]");
    }
}

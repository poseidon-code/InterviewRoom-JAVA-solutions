// PROBLEM: Max consecutive ones
// https://leetcode.com/problems/max-consecutive-ones/
// https://www.interviewbit.com/problems/max-continuous-series-of-1s/

class Solution {
    // SOLUTION
    public int max_ones (int[] nums) {
        int max1s=0;
        int count=0;

        for (int n : nums) {
            if (n==1) {
                count++;
                max1s = Math.max(count, max1s);
            } else {
                count = 0;
            }
        }

        return max1s;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {1,1,0,1,1,1};

        // OUTPUT :
        System.out.println(s.max_ones(nums));
    }
}
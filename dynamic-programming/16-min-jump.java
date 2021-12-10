// PROBLEM: Minimum jump to reach end
// https://leetcode.com/problems/jump-game-ii/
// https://www.interviewbit.com/problems/min-jumps-array/

class Solution {
    // SOLUTION
    public int jump (int[] nums) {
        int jumps=0;
        int ce = 0, cf = 0;

        for (int i=0; i<nums.length-1; i++) {
            cf = Math.max(cf, i + nums[i]);

            if (i == ce) {
                jumps++;
                ce = cf;
            }
        }

        return jumps;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {2,3,1,1,4};

        // OUTPUT :
        System.out.println(s.jump(nums));
    }
}
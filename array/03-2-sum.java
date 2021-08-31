// PROBLEM: 2 sum
// https://leetcode.com/problems/two-sum/
// https://www.interviewbit.com/problems/2-sum/
// https://practice.geeksforgeeks.org/problems/key-pair/0


import java.util.HashMap;
import java.util.Map;

class Solution {
    // SOLUTION
    public int[] two_sum (int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; map.put(nums[i], i++))
            if (map.containsKey(target - nums[i]))
                return new int[] {map.get(target - nums[i]), i};
        
        return new int[] {0,0};
    }

    public static void main (String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {2,7,11,15};
        int target = 18;

        // OUTPUT :
        var twosum = s.two_sum(nums, target);
        System.out.println("[" + twosum[0] + ", " + twosum[1] + "]");
    }
}
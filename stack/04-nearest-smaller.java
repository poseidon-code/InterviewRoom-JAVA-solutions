// PROBLEM: Nearest smaller
// https://www.interviewbit.com/problems/nearest-smaller-element/


import java.util.ArrayList;
import java.util.Stack;


class Solution {
    // SOLUTION
    public ArrayList<Integer> nearest_smaller (int[] nums) {
        ArrayList<Integer> result = new ArrayList<>(); result.add(-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);

        for (int i=1; i<nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i])
                stack.pop();
            
            result.add(stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {4,5,2,10,8};

        // OUTPUT :
        var result = s.nearest_smaller(nums);
        System.out.print("["); for (var n : result) System.out.print(n + " "); System.out.println("\b]");
    }
}
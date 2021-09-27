// PROBLEM: Next greater element
// https://leetcode.com/problems/next-greater-element-ii/
// https://practice.geeksforgeeks.org/problems/next-larger-element/0


import java.util.Arrays;
import java.util.Stack;


class Solution {
    // SOLUTION
    public int[] next_greater (int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i=0; i<n*2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%n]) {
                result[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {1,2,3,4,3};

        // OUTPUT :
        var result = s.next_greater(nums);
        System.out.print("["); for (var n : result) System.out.print(n + " "); System.out.println("\b]");
    }
}
// PROBLEM: Largest rectangle in a histogram
// https://leetcode.com/problems/largest-rectangle-in-histogram/
// https://www.interviewbit.com/problems/largest-rectangle-in-histogram/


import java.util.Stack;

class Solution {
    // SOLUTION
    public int rectangle (int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int l = heights.length;
        int max_area = 0;

        for (int i=0; i<=l; i++) {
            int h = i==l ? 0 : heights[i];

            if (stack.isEmpty() || h>=heights[stack.peek()])
                stack.push(i);
            else {
                int tp = stack.pop();
                max_area = Math.max(max_area, heights[tp]*(stack.isEmpty() ? i : i-1-stack.peek()));
                i--;

            }
        }

        return max_area;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] heights = {2,1,5,6,2,3};

        // OUTPUT :
        System.out.println(s.rectangle(heights));
    }
}
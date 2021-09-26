// PROBLEM: Length of longest valid parentheses
// https://leetcode.com/problems/longest-valid-parentheses/


import java.util.Stack;


class Solution {
    // SOLUTION
    public int longest_length (String s) {
        Stack<Integer> parentheses = new Stack<>();
        char[] S = s.toCharArray();
        parentheses.push(-1);
        int result = 0;

        for (int i=0; i<s.length(); i++) {
            if (S[i]=='(') {
                parentheses.push(i);
            } else {
                parentheses.pop();

                if (parentheses.isEmpty())
                    parentheses.push(i);
                else
                    result = Math.max(result, i - parentheses.peek());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String p = ")()())";

        // OUTPUT :
        System.out.println(s.longest_length(p));
    }
}
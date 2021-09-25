import java.util.Stack;

// PROBLEM: Valid parenthesis
// https://leetcode.com/problems/valid-parentheses/


class Solution {
    // SOLUTION
    public boolean is_valid (String s) {
        Stack<Character> parenthesis = new Stack<>();

        for (var c : s.toCharArray()) {
            switch(c) {
                case '{': parenthesis.push('}'); break;
                case '[': parenthesis.push(']'); break;
                case '(': parenthesis.push(')'); break;
                default:
                    if (parenthesis.isEmpty() || c!=parenthesis.pop())
                        return false;
            }
        }

        return parenthesis.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String p = "()[]{}";

        // OUTPUT :
        System.out.println(s.is_valid(p));
    }
}
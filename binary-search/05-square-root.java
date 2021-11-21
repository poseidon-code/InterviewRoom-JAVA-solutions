// PROBLEM: Find square root of a number
// https://leetcode.com/problems/sqrtx/
// https://www.interviewbit.com/problems/square-root-of-integer/

class Solution {
    // SOLUTION
    public int sqrt (int x) {
        int r = x;
        while (r*r > x)
            r = (r + x/r)/2;
        return r;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int x = 8;

        // OUTPUT :
        System.out.println(s.sqrt(x));
    }
}
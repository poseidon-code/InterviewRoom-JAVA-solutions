// PROBLEM: Climbing stairs
// https://leetcode.com/problems/climbing-stairs/

class Solution {
    // SOLUTION
    public int climb_stairs (int n) {
        int a=1, b=1;
        while (n--!=0)
            a = (b+=a) - a;
        return a;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int n = 3;

        // OUTPUT :
        System.out.println(s.climb_stairs(n));
    }
}
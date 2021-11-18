// PROBLEM: Power(x,n)
// https://leetcode.com/problems/powx-n/
// https://www.interviewbit.com/problems/implement-power-function/

class Solution {
    // SOLUTION
    public double power (double x, int n) {
        if (n==0) return 1;
        if (n==Integer.MIN_VALUE) {
            x = x*x;
            n = n/2;
        }
        if (n<0) {
            n = -n;
            x = 1/x;
        }

        return (n%2==0) ? power(x*x, n/2) : x * power(x*x, n/2);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        double x = 2.10000;
        int n = 3;

        // OUTPUT :
        System.out.println(s.power(x, n));
    }
}
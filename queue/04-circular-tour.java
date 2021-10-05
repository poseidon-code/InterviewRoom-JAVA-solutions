// PROBLEM: Circular tour
// https://leetcode.com/problems/gas-station/
// https://practice.geeksforgeeks.org/problems/circular-tour/1


class Solution {
    // SOLUTION
    public int circular_tour (int[] gas, int[] cost) {
        int start=0, total=0, tank=0;

        for (int i=0; i<gas.length; i++) {
            tank += gas[i]-cost[i];
            if (tank < 0) {
                start = i+1;
                total += tank;
                tank = 0;
            }
        }

        if (total + tank < 0) return -1;
        else return start;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        // OUTPUT :
        System.out.println(s.circular_tour(gas, cost));
    }
}
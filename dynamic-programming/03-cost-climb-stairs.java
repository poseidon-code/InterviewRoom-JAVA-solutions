// PROBLEM: Min cost climbing stairs
// https://leetcode.com/problems/min-cost-climbing-stairs/

class Solution {
    // SOLUTION
    public int min_cost (int[] cost) {
        for (int i=2; i<cost.length; i++)
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int cost[] = {10,15,20};

        // OUTPUT :
        System.out.println(s.min_cost(cost));
    }
}
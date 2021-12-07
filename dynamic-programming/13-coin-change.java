// PROBLEM: Coin change
// https://leetcode.com/problems/coin-change/

class Solution {
    // SOLUTION
    public int change (int[] coins, int amount) {
        int[] need = new int[amount+1]; 
        for (int i=0; i<need.length; i++) need[i] = amount+1;
        need[0] = 0;

        for (int c : coins)
            for (int a=c; a<=amount; a++) 
                need[a] = Math.min(need[a], need[a-c]+1);
        
        return need[need.length-1] > amount ? -1 : need[need.length-1];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] coins = {1,2,5};
        int amount = 11;

        // OUTPUT :
        System.out.println(s.change(coins, amount));
    }
}
// PROBLEM: Rod cutting
// https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

class Solution {
    // SOLUTION
    public int cutting (int[] price, int n) {
        int result[] = new int[n+1];
        result[0] = 0;

        for (int i=1; i<=n; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j=0; j<i; j++)
                max_val = Math.max(max_val, price[j] + result[i-j-1]);
            result[i] = max_val;
        }

        return result[n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int price[] = {1,5,8,9,10,17,17,20};
        int n = 8;

        // OUTPUT :
        System.out.println(s.cutting(price, n));
    }
}
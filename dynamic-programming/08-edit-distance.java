// PROBLEM: Edit distance
// https://leetcode.com/problems/edit-distance/

class Solution {
    // SOLUTION
    public int edit_distance (String word1, String word2) {
        int m = word1.length(), n = word2.length(), pre;
        int[] result = new int[n+1];
        for (int i=1; i<=n; i++) result[i] = i;

        for (int i=1; i<=m; i++) {
            pre = result[0];
            result[0] = i;

            for (int j=1; j<=n; j++) {
                int temp = result[j];
                if (word1.charAt(i-1)==word2.charAt(j-1))
                    result[j] = pre;
                else 
                    result[j] = Math.min(pre, Math.min(result[j-1], result[j])) + 1;
                pre = temp;
            }
        }

        return result[n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String word1 = "horse";
        String word2 = "ros";

        // OUTPUT :
        System.out.println(s.edit_distance(word1, word2));
    }
}
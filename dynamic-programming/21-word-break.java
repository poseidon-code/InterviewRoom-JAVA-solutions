import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// PROBLEM: Word Break
// https://leetcode.com/problems/word-break/
// https://www.interviewbit.com/problems/word-break/

class Solution {
    // SOLUTION
    public boolean word_break (String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);
        dp[0] = true;

        for (int i = 1; i <= n; i++)
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]) break;
            }

        return dp[n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String x = "leetcode";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");

        // OUTPUT :
        System.out.println(s.word_break(x, wordDict));
    }
}
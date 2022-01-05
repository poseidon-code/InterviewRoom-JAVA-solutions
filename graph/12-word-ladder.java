// PROBLEM: Word Ladder
// https://leetcode.com/problems/word-ladder/
// https://www.interviewbit.com/problems/word-ladder-i/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


class Solution {
    // SOLUTION
    public int ladder_length (String begin_word, String end_word, List<String> word_list) {
        Set<String> dict = new HashSet<>(word_list), vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(begin_word);
        
        for (int len=1; !q.isEmpty(); len++) {
            for (int i=q.size(); i>0; i--) {
                String w = q.poll();
                if (w.equals(end_word)) return len;

                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    
                    for (char c='a'; c<='z'; c++) {
                        if (c == w.charAt(j)) continue;
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (dict.contains(nb) && vis.add(nb)) q.offer(nb);
                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String begin_word = "hit";
        String end_word = "cog";
        List<String> word_list = new ArrayList<String>(List.of("hot","dot","dog","lot","log","cog"));

        // OUTPUT :
        System.out.println(s.ladder_length(begin_word, end_word, word_list));
    }
}
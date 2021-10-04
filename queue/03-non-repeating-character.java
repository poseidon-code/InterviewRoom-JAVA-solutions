// PROBLEM: First non-repeating character in a stream
// https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1


import java.util.LinkedList;
import java.util.Queue;


class Solution {
    // SOLUTION
    public String non_repeating (String a) {
        int[] count = new int[26];
        Queue<Character> q = new LinkedList<>();
        String result = new String();

        for (var x : a.toCharArray()) {
            q.add(x);
            count[x-'a']++;

            if (!q.isEmpty() && count[q.peek()-'a']==1)
                result += q.peek();
            else if (count[q.peek()-'a']>1) {
                while (!q.isEmpty() && count[q.peek()-'a']>1)
                    q.poll();
                
                if (!q.isEmpty()) result += q.peek();
                else result += '#';
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        String a = "aabc";

        // OUTPUT :
        System.out.println(s.non_repeating(a));
    }
}
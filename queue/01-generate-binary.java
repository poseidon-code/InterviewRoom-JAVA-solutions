// PROBLEM: Generate binary numbers from 1 to n  
// https://www.geeksforgeeks.org/interesting-method-generate-binary-numbers-1-n/


import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // SOLUTION
    public void generate (int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.print(s1 + " ");

            String s2 = s1;

            q.add(s1 + "0");
            q.add(s2 + "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int n = 10;

        // OUTPUT :
        s.generate(n);
    }
}
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// PROBLEM: Check if 2 binary trees are mirror of each other
// https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree1528/1


class Solution {
    // SOLUTION
    public boolean check_mirror (int n, int e, int[] A, int[] B) {
        Map<Integer, Stack<Integer>> mp = new HashMap<>();

        for (int i=0; i<2*e; i+=2) {
            if (mp.containsKey(A[i])) {
                mp.get(A[i]).push(A[i+1]);
            } else {
                mp.put(A[i], new Stack<>());
                mp.get(A[i]).push(A[i+1]);
            }
        }

        for (int i=0; i<2*e; i+=2) {
            if (mp.containsKey(B[i]) && mp.get(B[i]).size()>0) {
                if (B[i+1] != mp.get(B[i]).pop())
                    return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int n = 3;
        int e = 2;
        int[] A = {1,2,1,3};
        int[] B = {1,3,1,2};

        // OUTPUT :
        System.out.println(s.check_mirror(n, e, A, B));
    }
}
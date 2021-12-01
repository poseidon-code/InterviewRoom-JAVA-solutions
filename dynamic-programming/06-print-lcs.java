// PROBLEM: Print longest common subsequence
// https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem


import java.util.ArrayList;
import java.util.Collections;

class Solution {
    // SOLUTION
    public ArrayList<Integer> lcs (int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] lca = new int[n+1][m+1];

        for (int i=1; i<=n; i++)
            for (int j=1; j<=m; j++)
                if (A[i-1]==B[j-1])
                    lca[i][j] = lca[i-1][j-1]+1;
                else
                    lca[i][j] = Math.max(lca[i][j-1], lca[i-1][j]);

        int i=n, j=m;
        ArrayList<Integer> C = new ArrayList<>(); 
        while (i>0 && j>0) {
            if (A[i-1]==B[j-1]) {
                C.add(A[i-1]);
                i--; j--;
            }
            else
                if (lca[i-1][j]>lca[i][j-1]) i--;
                else j--;
        }

        Collections.reverse(C);
        return C;

    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] A = {1,2,3,4,1};
        int[] B = {3,4,1,2,1,3};

        // OUTPUT :
        System.out.println(s.lcs(A, B));
    }
}
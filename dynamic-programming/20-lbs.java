// PROBLEM: Longest Bitonic Subsequence
// https://www.interviewbit.com/problems/length-of-longest-subsequence/


import java.util.Arrays;

class Solution {
    // SOLUTION
    public int lbs (int[] A) {
        int n = A.length;

        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i=1; i<n; i++)
            for (int j=0; j<i; j++)
                if (A[i]>A[j] && lis[i]<lis[j]+1)
                    lis[i] = lis[j]+1;

        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i=n-2; i>=0; i--)
            for (int j=n-1; j>i; j--)
                if (A[i]>A[j] && lds[i]<lds[j]+1)
                    lds[i] = lds[j]+1;

        int result = lis[0] + lds[0] - 1;
        for (int i=1; i<n; i++)
            if (lis[i]+lds[i]-1 > result)
                result = lis[i] + lds[i] -1;
        
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] A = {1,2,1};

        // OUTPUT :
        System.out.println(s.lbs(A));
    }
}
// PROBLEM: Subarray with given sum
// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0

import java.util.ArrayList;

class Solution {
    // SOLUTION
    public ArrayList<Integer> subarray_sum(int A[], int S, int N) {
        ArrayList<Integer> position = new ArrayList<Integer>();
        int sum=A[0];
        int start=0;
        int end;

        for (end=1; end<=N; end++) {
            while (sum>S && start<end-1) {
                sum = sum - A[start];
                start++;
            }
            
            if (sum == S) {
                position.add(start+1);
                position.add(end);
                return position;
            }

            if (end < N)
                sum = sum + A[end];
        }

        position.add(-1);
        return position;
    }
    
    public static void main (String args[]) {
        Solution s = new Solution();
        
        // INPUT :
        int[] A = {1,2,3,7,5};
        int S=12;
        int N=A.length;

        // OUTPUT :
        var ss = s.subarray_sum(A,S,N);
        for (int p : ss) System.out.print(p + " ");
        System.out.println();
    }
}

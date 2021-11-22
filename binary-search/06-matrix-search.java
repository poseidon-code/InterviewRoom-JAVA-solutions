// PROBLEM: Matrix search
// https://leetcode.com/problems/search-a-2d-matrix/
// https://www.interviewbit.com/problems/matrix-search/

class Solution {
    // SOLUTION
    public boolean matrix_search (int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) return false;

        int m=matrix.length, n=matrix[0].length;
        int start=0, end=m*n-1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            int e = matrix[mid/n][mid%n];
            
            if(target < e) end = mid - 1;
            else if (target > e) start = mid + 1;
            else return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int matrix[][] = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int target = 3;

        // OUTPUT :
        System.out.println(s.matrix_search(matrix, target));
    }
}
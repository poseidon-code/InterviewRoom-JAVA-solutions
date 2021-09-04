// PROBLEM: Spiral matrix
// https://leetcode.com/problems/spiral-matrix/
// https://www.interviewbit.com/problems/spiral-order-matrix-i/


import java.util.ArrayList;
import java.util.List;

class Solution {
    // SOLUTION
    public List<Integer> spiral_matrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[] steps = {n, m-1};

        int id = 0;
        int ir = 0;
        int ic = -1;

        while (steps[id%2] != 0) {
            for (int i=0; i<steps[id%2]; i++) {
                ir += directions[id][0];
                ic += directions[id][1];
                result.add(matrix[ir][ic]);
            }

            steps[id%2]--;
            id = (id+1) % 4;
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        // OUTPUT :
        var spiralmatrix = s.spiral_matrix(matrix);
        System.out.print("["); for (int i : spiralmatrix) System.out.print(i + " "); System.out.println("\b]");
    }
}
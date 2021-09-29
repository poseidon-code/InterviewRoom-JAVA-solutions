// PROBLEM: Trapping rain water
// https://leetcode.com/problems/trapping-rain-water/
// https://www.interviewbit.com/problems/rain-water-trapped/



class Solution {
    // SOLUTION
    public int trap (int[] height) {
        int h1 = 0, h2 = 0;
        int total = 0;

        for (int l=0, r=height.length - 1; l<r;) {
            if (height[l]<height[r]) {
                h1 = Math.max(h1, height[l]);
                total += h1 - height[l++];
            } else {
                h2 = Math.max(h2, height[r]);
                total += h2 - height[r--];
            }
        }
    
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        // OUTPUT :
        System.out.println(s.trap(height));
    }
}
// PROBLEM: Sort an array of 0s, 1s and 2s
// https://leetcode.com/problems/sort-colors/
// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0


class Solution {
    // SOLUTION
    public void sort_array(int[] nums) {
        int l=0;
        int m=0;
        int h=nums.length-1;

        while (m<=h) {
            if (nums[m]==0) {
                int t = nums[m];
                nums[m] = nums[l];
                nums[l] = t;
                m++;
                l++;
            } else if (nums[m]==1) {
                m++;
            } else {
                int t = nums[m];
                nums[m] = nums[h];
                nums[h] = t;
                h--;
            }
        }

        System.out.print("["); for (int i : nums) System.out.print(i + " "); System.out.println("\b]");
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[] nums = {2,0,2,1,1,0};

        // OUTPUT :
        s.sort_array(nums);
    }
}
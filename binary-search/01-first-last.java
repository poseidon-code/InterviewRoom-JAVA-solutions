// PROBLEM: Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    // SOLUTION
    public int[] search_range (int[] nums, int target) {
        int i=0, j=nums.length-1;
        int[] result = {-1, -1};

        while (i<j) {
            int mid = (i+j)/2;
            if (nums[mid]<target) i = mid+1;
            else j = mid;
        }
        if (nums[i] != target) return result;
        else result[0] = i;
    
        j = nums.length-1;
        while (i<j) {
            int mid = (i+j)/2 + 1;
            if (nums[mid]>target) j = mid-1;
            else i = mid;
        }
        result[1] = j;
        
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        // OUTPUT :
        var result = s.search_range(nums, target);
        System.out.print("["); for (var x : result) System.out.print(x + " "); System.out.println("\b]");
    }
}
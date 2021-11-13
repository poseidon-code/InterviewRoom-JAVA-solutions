// PROBLEM: Sort a nearly sorted array
// https://www.geeksforgeeks.org/nearly-sorted-algorithm/

import java.util.PriorityQueue;

class Solution {
    // SOLUTION
    public int[] k_sorted (int[] nums, int k) {
        int size = nums.length==k ? k : k+1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<size; i++) pq.add(nums[i]);
        
        int index = 0;
        for (int i=k+1; i<nums.length; i++) {
            nums[index++] = pq.poll();
            pq.add(nums[i]);
        }

        while (!pq.isEmpty()) {
            nums[index++] = pq.poll();
        }

        return nums;
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[] nums = {2,6,3,12,56,8};
        int k = 3;

        // OUTPUT :
        var result = s.k_sorted(nums, k);
        System.out.print("["); for (var x : result) System.out.print(x + " "); System.out.println("\b]");        
    }
}
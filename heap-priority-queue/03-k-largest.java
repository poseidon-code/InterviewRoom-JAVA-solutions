// PROBLEM: Find kth largest element in a stream
// https://leetcode.com/problems/kth-largest-element-in-a-stream/

import java.util.PriorityQueue;

class Solution {
    // SOLUTION
    static PriorityQueue<Integer> pq;
    static int qsize;

    public void k_largest(int k, int[] nums) {
        qsize = k;
        pq = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }

    public int add(int val) {
        if (pq.size() < qsize)
            pq.offer(val);
        else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int k = 3;
        int[] nums = {4,5,8,2};
        int[] input = {3,5,10,9,4};

        // OUTPUT :
        s.k_largest(k, nums);
        for (var i : input) {
            System.out.println(s.add(i));
        }
    }
}
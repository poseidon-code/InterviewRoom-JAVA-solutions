// PROBLEM: Sliding window maximum
// https://leetcode.com/problems/sliding-window-maximum/
// https://www.interviewbit.com/problems/sliding-window-maximum/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class Solution {
    // SOLUTION
    public int[] maximum (int[] nums, int k) {
        Deque<Integer> buffer = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            while (!buffer.isEmpty() && nums[i]>=nums[buffer.peekLast()])
                buffer.pollLast();
            buffer.addLast(i);

            if (i>=k-1)
                result.add(nums[buffer.peekFirst()]);
            if (buffer.peekFirst()<=i-k+1)
                buffer.pollFirst();
        }

        return result.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        // OUTPUT :
        var result = s.maximum(nums, k);
        System.out.print("["); for (var m : result) System.out.print(m + " "); System.out.println("\b]");
    }
}
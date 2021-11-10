import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// PROBLEM: Find top k frequent elements
// https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    // SOLUTION
    public List<Integer> k_frequent (int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (var i : nums) counts.put(i, counts.getOrDefault(i, 0)+1);

        List<Integer>[] buckets = new List[nums.length+1];
        for (int key : counts.keySet()) {
            var count = counts.get(key);
            if (buckets[count]==null)
                buckets[count] = new ArrayList<>();
            buckets[count].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length-1; i>=0 && result.size()<k; i--) {
            if (buckets[i]!=null) 
                result.addAll(buckets[i]);
        }

        return result;
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        // OUTPUT :
        var result = s.k_frequent(nums, k);
        System.out.print("["); for (int i : result) System.out.print(i + " "); System.out.println("\b]");
    }
}
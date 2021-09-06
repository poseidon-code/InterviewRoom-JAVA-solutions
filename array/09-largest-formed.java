// PROBLEM: Largest number formed from an array
// https://leetcode.com/problems/largest-number/
// https://www.interviewbit.com/problems/largest-number/
// https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0


import java.util.Arrays;
import java.util.Comparator;


class Solution {
    // SOLUTION
    public String largest_formed (int[] nums) {
        String[] s = new String[nums.length];
        for (int i=0; i<nums.length; i++) s[i]=String.valueOf(nums[i]);

        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo((a+b));
            }
        };
        Arrays.sort(s, comp);

        if (s[0].charAt(0)=='0') return "0";

        StringBuilder result = new StringBuilder();
        for (String i : s) result.append(i);

        return result.toString();
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int[] nums = {3,30,34,5,9};

        // OUTPUT :
        System.out.println(s.largest_formed(nums));
    }
}
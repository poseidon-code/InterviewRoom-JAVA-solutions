// PROBLEM: Median of two sorted arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/
// https://www.interviewbit.com/problems/median-of-array/

class Solution {
    // SOLUTION
    public double median (int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, l = 0, r = m;
        if (m > n) return median(nums2, nums1);

        while (l <= r) {
            int i=(l+r)/2, j=(m+n+1)/2 - i;

            if (i!=0 && nums1[i-1] > nums2[j]) {
                r = i-1;
            } else if (i<m && nums2[j-1] > nums1[i]) {
                l = i+1;
            } else {
                int lmax = i==0 ? nums2[j-1] : (j==0 ? nums1[i-1] : Math.max(nums1[i-1], nums2[j-1]));
                if ((m + n) % 2 != 0) return lmax;
                int rmin = i == m ? nums2[j] : (j == n ? nums1[i] : Math.min(nums1[i], nums2[j]));

                return 0.5 * (lmax + rmin);
            }
        }

        return 0.0;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        // INPUT :
        int nums1[] = {1,2};
        int nums2[] = {3,4};

        // OUTPUT :
        System.out.println(s.median(nums1, nums2));
    }
}
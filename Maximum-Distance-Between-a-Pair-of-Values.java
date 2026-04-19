1 class Solution {
2    public int maxDistance(int[] nums1, int[] nums2) {
3        int i = 0, j = 0;
4        int maxDist = 0;
5
6        while (i < nums1.length && j < nums2.length) {
7            
8            if (nums1[i] <= nums2[j]) {
9                // valid pair
10                maxDist = Math.max(maxDist, j - i);
11                j++; // try to expand distance
12            } else {
13                i++; // move i to satisfy condition
14            }
15        }
16
17        return maxDist;
18    }
19}
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int i = 0, j = 0;
4
5        while (i < nums1.length && j < nums2.length) {
6            if (nums1[i] == nums2[j]) {
7                return nums1[i];
8            } else if (nums1[i] < nums2[j]) {
9                i++;
10            } else {
11                j++;
12            }
13        }
14
15        return -1;
16    }
17}
18
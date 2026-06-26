1class Solution {
2
3    public int binarySearch(int[] nums, int target, boolean first) {
4
5        int low = 0;
6        int high = nums.length - 1;
7        int ans = -1;
8
9        while (low <= high) {
10
11            int mid = low + (high - low) / 2;
12
13            if (target < nums[mid]) {
14                high = mid - 1;
15            } else if (target > nums[mid]) {
16                low = mid + 1;
17            } else {
18                ans = mid;
19
20                if (first) {
21                    high = mid - 1;   // left side search
22                } else {
23                    low = mid + 1;    // right side search
24                }
25            }
26        }
27
28        return ans;
29    }
30
31    public int[] searchRange(int[] nums, int target) {
32
33        int[] ans = new int[2];
34
35        ans[0] = binarySearch(nums, target, true);
36        ans[1] = binarySearch(nums, target, false);
37
38        return ans;
39    }
40}
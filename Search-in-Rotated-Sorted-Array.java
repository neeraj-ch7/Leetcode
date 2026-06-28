1class Solution {
2    public int search(int[] nums, int target) {
3
4        int low = 0;
5        int high = nums.length - 1;
6
7        while (low <= high) {
8
9            int mid = low + (high - low) / 2;
10
11            if (nums[mid] == target)
12                return mid;
13
14            // Left half sorted
15            if (nums[low] <= nums[mid]) {
16
17                if (target >= nums[low] && target < nums[mid]) {
18                    high = mid - 1;
19                } else {
20                    low = mid + 1;
21                }
22
23            }
24            // Right half sorted
25            else {
26
27                if (target > nums[mid] && target <= nums[high]) {
28                    low = mid + 1;
29                } else {
30                    high = mid - 1;
31                }
32            }
33        }
34
35        return -1;
36    }
37}
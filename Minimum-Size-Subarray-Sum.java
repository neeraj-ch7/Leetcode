1class Solution{
2public int minSubArrayLen(int target, int[] nums) {
3
4        int n = nums.length;
5        int left = 0, sum = 0;
6        int minLen = Integer.MAX_VALUE;
7
8        for (int right = 0; right < n; right++) {
9            sum += nums[right];
10
11            // shrink window while sum >= target
12            while (sum >= target) {
13                minLen = Math.min(minLen, right - left + 1);
14                sum -= nums[left];
15                left++;
16            }
17        }
18
19        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
20    }
21}
22
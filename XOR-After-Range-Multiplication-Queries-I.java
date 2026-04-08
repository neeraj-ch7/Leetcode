1class Solution {
2    public int xorAfterQueries(int[] nums, int[][] queries) {
3        int MOD = 1_000_000_007;
4        int n = nums.length;
5
6        // Process each query
7        for (int[] q : queries) {
8            int l = q[0];
9            int r = q[1];
10            int k = q[2];
11            int v = q[3];
12
13            // Apply updates
14            for (int idx = l; idx <= r; idx += k) {
15                long val = (long) nums[idx] * v;
16                nums[idx] = (int) (val % MOD);
17            }
18        }
19
20        // Compute XOR
21        int xor = 0;
22        for (int num : nums) {
23            xor ^= num;
24        }
25
26        return xor;
27    }
28}
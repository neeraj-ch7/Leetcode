1class Solution {
2    public int maxProductPath(int[][] grid) {
3        int m = grid.length, n = grid[0].length;
4        long MOD = 1000000007;
5
6        long[] maxProd = new long[n];
7        long[] minProd = new long[n];
8
9        maxProd[0] = minProd[0] = grid[0][0];
10
11        // First row
12        for (int j = 1; j < n; j++) {
13            maxProd[j] = minProd[j] = maxProd[j - 1] * grid[0][j];
14        }
15
16        for (int i = 1; i < m; i++) {
17
18            // First column update
19            maxProd[0] = minProd[0] = maxProd[0] * grid[i][0];
20
21            for (int j = 1; j < n; j++) {
22                long val = grid[i][j];
23
24                long a = maxProd[j] * val;     // from top (old value)
25                long b = minProd[j] * val;
26
27                long c = maxProd[j - 1] * val; // from left (updated value)
28                long d = minProd[j - 1] * val;
29
30                long newMax = Math.max(Math.max(a, b), Math.max(c, d));
31                long newMin = Math.min(Math.min(a, b), Math.min(c, d));
32
33                maxProd[j] = newMax;
34                minProd[j] = newMin;
35            }
36        }
37
38        long ans = maxProd[n - 1];
39        return ans < 0 ? -1 : (int)(ans % MOD);
40    }
41}
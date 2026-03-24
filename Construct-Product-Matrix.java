1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int n = grid.length;
4        int m = grid[0].length;
5        int MOD = 12345;
6
7        int[][] res = new int[n][m];
8
9        // Step 1: prefix product
10        long prefix = 1;
11        for (int i = 0; i < n; i++) {
12            for (int j = 0; j < m; j++) {
13                res[i][j] = (int) prefix;
14                prefix = (prefix * grid[i][j]) % MOD;
15            }
16        }
17
18        // Step 2: suffix product
19        long suffix = 1;
20        for (int i = n - 1; i >= 0; i--) {
21            for (int j = m - 1; j >= 0; j--) {
22                res[i][j] = (int)((res[i][j] * suffix) % MOD);
23                suffix = (suffix * grid[i][j]) % MOD;
24            }
25        }
26
27        return res;
28    }
29}
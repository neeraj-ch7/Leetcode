1class Solution {
2    public int[][] constructProductMatrix(int[][] grid) {
3        int n = grid.length, m = grid[0].length;
4        int MOD = 12345;
5
6        int[][] res = new int[n][m];
7
8        // Step 1: prefix product
9        long prefix = 1;
10        for (int i = 0; i < n; i++) {
11            for (int j = 0; j < m; j++) {
12                res[i][j] = (int) prefix;
13                prefix = (prefix * grid[i][j]) % MOD;
14            }
15        }
16
17        // Step 2: suffix product
18        long suffix = 1;
19        for (int i = n - 1; i >= 0; i--) {
20            for (int j = m - 1; j >= 0; j--) {
21                res[i][j] = (int)((res[i][j] * suffix) % MOD);
22                suffix = (suffix * grid[i][j]) % MOD;
23            }
24        }
25
26        return res;
27    }
28}
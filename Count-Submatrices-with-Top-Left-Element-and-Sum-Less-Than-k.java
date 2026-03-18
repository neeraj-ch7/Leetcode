1class Solution {
2    public int countSubmatrices(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int ans = 0;
5
6        for (int i = 0; i < m; i++) {
7            for (int j = 0; j < n; j++) {
8
9                int up = (i > 0) ? grid[i - 1][j] : 0;
10                int left = (j > 0) ? grid[i][j - 1] : 0;
11                int diag = (i > 0 && j > 0) ? grid[i - 1][j - 1] : 0;
12
13                grid[i][j] += up + left - diag;
14
15                if (grid[i][j] <= k) {
16                    ans++;
17                } else {
18                    break; // no need for (j == 0) check
19                }
20            }
21        }
22
23        return ans;
24    }
25}
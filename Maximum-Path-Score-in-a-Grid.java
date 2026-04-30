1import java.util.*;
2
3class Solution {
4    public int maxPathScore(int[][] grid, int k) {
5        int m = grid.length, n = grid[0].length;
6
7        int[][] dp = new int[n][k + 1];
8        int[][] prev = new int[n][k + 1];
9
10        for (int[] row : dp) Arrays.fill(row, -1);
11        for (int[] row : prev) Arrays.fill(row, -1);
12
13        prev[0][0] = 0;
14
15        for (int i = 0; i < m; i++) {
16            for (int[] row : dp) Arrays.fill(row, -1);
17
18            for (int j = 0; j < n; j++) {
19                int val = grid[i][j];
20                int cost = (val == 0) ? 0 : 1;
21
22                for (int c = 0; c <= k; c++) {
23
24                    // from top
25                    if (i > 0 && prev[j][c] != -1) {
26                        int newCost = c + cost;
27                        if (newCost <= k) {
28                            dp[j][newCost] = Math.max(dp[j][newCost], prev[j][c] + val);
29                        }
30                    }
31
32                    // from left
33                    if (j > 0 && dp[j - 1][c] != -1) {
34                        int newCost = c + cost;
35                        if (newCost <= k) {
36                            dp[j][newCost] = Math.max(dp[j][newCost], dp[j - 1][c] + val);
37                        }
38                    }
39
40                    // start cell
41                    if (i == 0 && j == 0 && c == 0) {
42                        dp[j][0] = 0;
43                    }
44                }
45            }
46
47            int[][] temp = prev;
48            prev = dp;
49            dp = temp;
50        }
51
52        int ans = -1;
53        for (int c = 0; c <= k; c++) {
54            ans = Math.max(ans, prev[n - 1][c]);
55        }
56
57        return ans;
58    }
59}
60
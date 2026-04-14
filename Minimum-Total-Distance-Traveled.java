1import java.util.*;
2
3class Solution {
4    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
5        Collections.sort(robot);
6        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
7
8        int n = robot.size();
9        int m = factory.length;
10
11        long[][] dp = new long[n + 1][m + 1];
12
13        for (int i = 0; i <= n; i++) {
14            Arrays.fill(dp[i], Long.MAX_VALUE);
15        }
16
17        // 0 robots => 0 cost
18        for (int j = 0; j <= m; j++) {
19            dp[0][j] = 0;
20        }
21
22        for (int j = 1; j <= m; j++) {
23            int pos = factory[j - 1][0];
24            int limit = factory[j - 1][1];
25
26            for (int i = 0; i <= n; i++) {
27                // skip this factory
28                dp[i][j] = dp[i][j - 1];
29
30                long cost = 0;
31
32                // try assigning k robots to this factory
33                for (int k = 1; k <= Math.min(i, limit); k++) {
34                    cost += Math.abs(robot.get(i - k) - pos);
35
36                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
37                        dp[i][j] = Math.min(dp[i][j],
38                                dp[i - k][j - 1] + cost);
39                    }
40                }
41            }
42        }
43
44        return dp[n][m];
45    }
46}
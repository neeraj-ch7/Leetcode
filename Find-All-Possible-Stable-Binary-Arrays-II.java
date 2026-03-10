1class Solution {
2    public int numberOfStableArrays(int zero, int one, int limit) {
3
4        int MOD = 1000000007;
5
6        long[][][] dp = new long[zero+1][one+1][2];
7
8        for(int i=1;i<=Math.min(zero,limit);i++)
9            dp[i][0][0] = 1;
10
11        for(int j=1;j<=Math.min(one,limit);j++)
12            dp[0][j][1] = 1;
13
14        for(int i=1;i<=zero;i++){
15            for(int j=1;j<=one;j++){
16
17                long over0 = (i-limit-1 >= 0) ? dp[i-limit-1][j][1] : 0;
18                long over1 = (j-limit-1 >= 0) ? dp[i][j-limit-1][0] : 0;
19
20                dp[i][j][0] =
21                    (dp[i-1][j][0] + dp[i-1][j][1] - over0 + MOD) % MOD;
22
23                dp[i][j][1] =
24                    (dp[i][j-1][0] + dp[i][j-1][1] - over1 + MOD) % MOD;
25            }
26        }
27
28        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
29    }
30}
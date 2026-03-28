1class Solution {
2    public String findTheString(int[][] lcp) {
3        int n = lcp.length;
4        char[] word = new char[n];
5        for (int i = 0; i < n; i++) word[i] = '?';
6
7        char ch = 'a';
8
9        // Step 1: Build string greedily
10        for (int i = 0; i < n; i++) {
11            if (word[i] == '?') {
12                if (ch > 'z') return ""; // more than 26 chars not allowed
13
14                for (int j = i; j < n; j++) {
15                    if (lcp[i][j] > 0) {
16                        word[j] = ch;
17                    }
18                }
19                ++ch;
20            }
21        }
22
23        // Step 2: Validate LCP
24        int[][] dp = new int[n + 1][n + 1];
25
26        for (int i = n - 1; i >= 0; i--) {
27            for (int j = n - 1; j >= 0; j--) {
28                if (word[i] == word[j]) {
29                    dp[i][j] = 1 + dp[i + 1][j + 1];
30                } else {
31                    dp[i][j] = 0;
32                }
33
34                if (dp[i][j] != lcp[i][j]) {
35                    return "";
36                }
37            }
38        }
39
40        return new String(word);
41    }
42}
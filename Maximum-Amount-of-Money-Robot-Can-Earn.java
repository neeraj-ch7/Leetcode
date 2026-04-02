1class Solution {
2    public int maximumAmount(int[][] coins) {
3        int m = coins.length, n = coins[0].length;
4        
5        int[][] prev = new int[n][3];
6        int[][] curr = new int[n][3];
7        
8        // Initialize with very small values
9        for (int j = 0; j < n; j++) {
10            for (int k = 0; k < 3; k++) {
11                prev[j][k] = Integer.MIN_VALUE;
12            }
13        }
14        
15        // Start cell (0,0)
16        for (int k = 0; k < 3; k++) {
17            if (coins[0][0] >= 0) {
18                prev[0][k] = coins[0][0];
19            } else {
20                if (k > 0) prev[0][k] = 0; // neutralize
21                else prev[0][k] = coins[0][0];
22            }
23        }
24        
25        // Fill first row
26        for (int j = 1; j < n; j++) {
27            for (int k = 0; k < 3; k++) {
28                int val = coins[0][j];
29                
30                if (val >= 0) {
31                    prev[j][k] = prev[j-1][k] + val;
32                } else {
33                    int takeLoss = prev[j-1][k] + val;
34                    int neutralize = (k > 0) ? prev[j-1][k-1] : Integer.MIN_VALUE;
35                    prev[j][k] = Math.max(takeLoss, neutralize);
36                }
37            }
38        }
39        
40        // Process rest rows
41        for (int i = 1; i < m; i++) {
42            
43            // reset curr
44            for (int j = 0; j < n; j++) {
45                for (int k = 0; k < 3; k++) {
46                    curr[j][k] = Integer.MIN_VALUE;
47                }
48            }
49            
50            // first column
51            for (int k = 0; k < 3; k++) {
52                int val = coins[i][0];
53                
54                if (val >= 0) {
55                    curr[0][k] = prev[0][k] + val;
56                } else {
57                    int takeLoss = prev[0][k] + val;
58                    int neutralize = (k > 0) ? prev[0][k-1] : Integer.MIN_VALUE;
59                    curr[0][k] = Math.max(takeLoss, neutralize);
60                }
61            }
62            
63            for (int j = 1; j < n; j++) {
64                int val = coins[i][j];
65                
66                for (int k = 0; k < 3; k++) {
67                    
68                    int bestPrevSameK = Math.max(prev[j][k], curr[j-1][k]);
69                    
70                    if (val >= 0) {
71                        curr[j][k] = bestPrevSameK + val;
72                    } else {
73                        int takeLoss = bestPrevSameK + val;
74                        
75                        int bestPrevKminus1 = Integer.MIN_VALUE;
76                        if (k > 0) {
77                            bestPrevKminus1 = Math.max(prev[j][k-1], curr[j-1][k-1]);
78                        }
79                        
80                        int neutralize = bestPrevKminus1;
81                        
82                        curr[j][k] = Math.max(takeLoss, neutralize);
83                    }
84                }
85            }
86            
87            // move curr → prev
88            int[][] temp = prev;
89            prev = curr;
90            curr = temp;
91        }
92        
93        int ans = Integer.MIN_VALUE;
94        for (int k = 0; k < 3; k++) {
95            ans = Math.max(ans, prev[n-1][k]);
96        }
97        
98        return ans;
99    }
100}
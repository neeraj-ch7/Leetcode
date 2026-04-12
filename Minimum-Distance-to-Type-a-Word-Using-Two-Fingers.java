1class Solution {
2    
3    // distance between two characters
4    private int dist(int a, int b) {
5        if (a == -1) return 0; // free finger
6        int x1 = a / 6, y1 = a % 6;
7        int x2 = b / 6, y2 = b % 6;
8        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
9    }
10
11    public int minimumDistance(String word) {
12        int n = word.length();
13        
14        // dp[j] = min cost where one finger is at prev char,
15        // other finger is at j
16        int[] dp = new int[26];
17        for (int i = 0; i < 26; i++) dp[i] = Integer.MAX_VALUE;
18        
19        int prev = word.charAt(0) - 'A';
20        
21        // initially second finger is free → cost 0
22        for (int j = 0; j < 26; j++) dp[j] = 0;
23        
24        for (int i = 1; i < n; i++) {
25            int curr = word.charAt(i) - 'A';
26            int[] newDp = new int[26];
27            
28            for (int j = 0; j < 26; j++) {
29                newDp[j] = Integer.MAX_VALUE;
30            }
31            
32            for (int j = 0; j < 26; j++) {
33                if (dp[j] == Integer.MAX_VALUE) continue;
34                
35                // 1️⃣ move same finger (prev → curr)
36                int cost1 = dp[j] + dist(prev, curr);
37                newDp[j] = Math.min(newDp[j], cost1);
38                
39                // 2️⃣ move other finger (j → curr)
40                int cost2 = dp[j] + dist(j, curr);
41                newDp[prev] = Math.min(newDp[prev], cost2);
42            }
43            
44            dp = newDp;
45            prev = curr;
46        }
47        
48        int ans = Integer.MAX_VALUE;
49        for (int val : dp) ans = Math.min(ans, val);
50        
51        return ans;
52    }
53}
1class Solution {
2
3    int[] best = {-1, -1, -1};
4
5    private void insertValue(int val){
6
7        for(int x : best)
8            if(x == val) return;
9
10        if(val > best[0]){
11            best[2] = best[1];
12            best[1] = best[0];
13            best[0] = val;
14        }
15        else if(val > best[1]){
16            best[2] = best[1];
17            best[1] = val;
18        }
19        else if(val > best[2]){
20            best[2] = val;
21        }
22    }
23
24    public int[] getBiggestThree(int[][] grid) {
25
26        int n = grid.length;
27        int m = grid[0].length;
28
29        int limit = Math.min(n, m);
30
31        for(int r = 0; r < n; r++){
32            for(int c = 0; c < m; c++){
33
34                insertValue(grid[r][c]);
35
36                for(int k = 1; k < limit; k++){
37
38                    int left = c - k;
39                    int right = c + k;
40                    int bottom = r + 2*k;
41
42                    if(left < 0 || right >= m || bottom >= n)
43                        break;
44
45                    int sum = 0;
46
47                    int x = r;
48                    int y = c;
49
50                    for(int i = 0; i < k; i++)
51                        sum += grid[++x][++y];
52
53                    for(int i = 0; i < k; i++)
54                        sum += grid[++x][--y];
55
56                    for(int i = 0; i < k; i++)
57                        sum += grid[--x][--y];
58
59                    for(int i = 0; i < k; i++)
60                        sum += grid[--x][++y];
61
62                    insertValue(sum);
63                }
64            }
65        }
66
67        int cnt = 0;
68        for(int v : best)
69            if(v != -1) cnt++;
70
71        int[] ans = new int[cnt];
72        int p = 0;
73
74        for(int v : best)
75            if(v != -1)
76                ans[p++] = v;
77
78        return ans;
79    }
80}
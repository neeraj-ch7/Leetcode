1class Solution {
2    public int[][] minAbsDiff(int[][] grid, int k) {
3        int m = grid.length, n = grid[0].length;
4        int[][] ans = new int[m - k + 1][n - k + 1];
5
6        for (int i = 0; i <= m - k; i++) {
7            for (int j = 0; j <= n - k; j++) {
8
9                // collect elements
10                List<Integer> temp = new ArrayList<>();
11                for (int x = i; x < i + k; x++) {
12                    for (int y = j; y < j + k; y++) {
13                        temp.add(grid[x][y]);
14                    }
15                }
16
17                // single element case
18                if (k == 1) {
19                    ans[i][j] = 0;
20                    continue;
21                }
22
23                Collections.sort(temp);
24
25                int minDiff = Integer.MAX_VALUE;
26                int prev = temp.get(0);
27
28                // compute min difference (skip duplicates inline)
29                for (int idx = 1; idx < temp.size(); idx++) {
30                    int curr = temp.get(idx);
31
32                    if (curr != prev) {
33                        minDiff = Math.min(minDiff, curr - prev);
34                        prev = curr;
35                    }
36                }
37
38                // if all elements same → minDiff remains MAX_VALUE
39                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
40            }
41        }
42
43        return ans;
44    }
45}
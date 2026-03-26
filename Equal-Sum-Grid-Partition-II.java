1import java.util.*;
2
3class Solution {
4
5    // check if we can remove 'diff' from a section while keeping it connected
6    private boolean canRemove(int[][] grid, int r1, int c1, int r2, int c2, int diff) {
7        int rows = r2 - r1 + 1;
8        int cols = c2 - c1 + 1;
9
10        // Case 1: Proper 2D → any cell removal is safe
11        if (rows > 1 && cols > 1) {
12            for (int i = r1; i <= r2; i++) {
13                for (int j = c1; j <= c2; j++) {
14                    if (grid[i][j] == diff) return true;
15                }
16            }
17            return false;
18        }
19
20        // Case 2: Single row
21        if (rows == 1) {
22            // only edge cells allowed
23            if (grid[r1][c1] == diff) return true;
24            if (grid[r1][c2] == diff) return true;
25            return false;
26        }
27
28        // Case 3: Single column
29        if (cols == 1) {
30            // only edge cells allowed
31            if (grid[r1][c1] == diff) return true;
32            if (grid[r2][c1] == diff) return true;
33            return false;
34        }
35
36        return false;
37    }
38
39    public boolean canPartitionGrid(int[][] grid) {
40        int m = grid.length, n = grid[0].length;
41
42        long total = 0;
43        for (int[] row : grid)
44            for (int val : row)
45                total += val;
46
47        // ----------- Horizontal cuts -----------
48        long topSum = 0;
49
50        for (int i = 0; i < m - 1; i++) {
51            for (int j = 0; j < n; j++) {
52                topSum += grid[i][j];
53            }
54
55            long bottomSum = total - topSum;
56
57            if (topSum == bottomSum) return true;
58
59            // remove from top
60            if (topSum > bottomSum) {
61                long diff = topSum - bottomSum;
62                if (diff <= 100000 && canRemove(grid, 0, 0, i, n - 1, (int) diff)) {
63                    return true;
64                }
65            }
66            // remove from bottom
67            else {
68                long diff = bottomSum - topSum;
69                if (diff <= 100000 && canRemove(grid, i + 1, 0, m - 1, n - 1, (int) diff)) {
70                    return true;
71                }
72            }
73        }
74
75        // ----------- Vertical cuts -----------
76        long leftSum = 0;
77
78        for (int j = 0; j < n - 1; j++) {
79            for (int i = 0; i < m; i++) {
80                leftSum += grid[i][j];
81            }
82
83            long rightSum = total - leftSum;
84
85            if (leftSum == rightSum) return true;
86
87            // remove from left
88            if (leftSum > rightSum) {
89                long diff = leftSum - rightSum;
90                if (diff <= 100000 && canRemove(grid, 0, 0, m - 1, j, (int) diff)) {
91                    return true;
92                }
93            }
94            // remove from right
95            else {
96                long diff = rightSum - leftSum;
97                if (diff <= 100000 && canRemove(grid, 0, j + 1, m - 1, n - 1, (int) diff)) {
98                    return true;
99                }
100            }
101        }
102
103        return false;
104    }
105}
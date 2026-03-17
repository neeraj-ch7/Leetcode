1import java.util.*;
2
3class Solution {
4    public int largestSubmatrix(int[][] grid) {
5        int m = grid.length, n = grid[0].length;
6        int result = 0;
7
8        // height array instead of modifying original grid directly
9        int[] height = new int[n];
10
11        for (int i = 0; i < m; i++) {
12
13            // Step 1: Build histogram for current row
14            for (int j = 0; j < n; j++) {
15                height[j] = (grid[i][j] == 0) ? 0 : height[j] + 1;
16            }
17
18            // Step 2: Clone and sort
19            int[] sorted = height.clone();
20            Arrays.sort(sorted);
21
22            // Step 3: Calculate max area
23            for (int j = n - 1; j >= 0; j--) {
24                int width = n - j;
25                result = Math.max(result, sorted[j] * width);
26            }
27        }
28
29        return result;
30    }
31}
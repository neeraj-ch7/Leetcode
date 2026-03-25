1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        long totalSum = 0;
7
8        // Step 1: Total sum
9        for (int i = 0; i < m; i++) {
10            for (int j = 0; j < n; j++) {
11                totalSum += grid[i][j];
12            }
13        }
14
15        // If odd, impossible
16        if (totalSum % 2 != 0) return false;
17
18        long target = totalSum / 2;
19
20        // Step 2: Horizontal cut
21        long currSum = 0;
22        for (int i = 0; i < m - 1; i++) { // ensure non-empty
23            for (int j = 0; j < n; j++) {
24                currSum += grid[i][j];
25            }
26            if (currSum == target) return true;
27        }
28
29        // Step 3: Vertical cut
30        currSum = 0;
31        for (int j = 0; j < n - 1; j++) { // ensure non-empty
32            for (int i = 0; i < m; i++) {
33                currSum += grid[i][j];
34            }
35            if (currSum == target) return true;
36        }
37
38        return false;
39    }
40}
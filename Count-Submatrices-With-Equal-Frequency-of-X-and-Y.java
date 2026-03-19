1class Solution {
2    public int numberOfSubmatrices(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5
6        int[][] balance = new int[m][n]; // X - Y
7        int[][] countX = new int[m][n];  // count of X
8
9        int ans = 0;
10
11        for (int i = 0; i < m; i++) {
12            for (int j = 0; j < n; j++) {
13
14                int val = 0;
15                if (grid[i][j] == 'X') val = 1;
16                else if (grid[i][j] == 'Y') val = -1;
17
18                int xVal = (grid[i][j] == 'X') ? 1 : 0;
19
20                int upBal = (i > 0) ? balance[i-1][j] : 0;
21                int leftBal = (j > 0) ? balance[i][j-1] : 0;
22                int diagBal = (i > 0 && j > 0) ? balance[i-1][j-1] : 0;
23
24                balance[i][j] = upBal + leftBal - diagBal + val;
25
26                int upX = (i > 0) ? countX[i-1][j] : 0;
27                int leftX = (j > 0) ? countX[i][j-1] : 0;
28                int diagX = (i > 0 && j > 0) ? countX[i-1][j-1] : 0;
29
30                countX[i][j] = upX + leftX - diagX + xVal;
31
32                if (balance[i][j] == 0 && countX[i][j] > 0) {
33                    ++ans;
34                }
35            }
36        }
37
38        return ans;
39    }
40}
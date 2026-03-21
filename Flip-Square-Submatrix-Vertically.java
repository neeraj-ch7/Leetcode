1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3        for(int i = 0; i < k / 2; i++){
4            for(int j = 0; j < k; j++){
5                int temp = grid[x + i][y + j];
6                grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
7                grid[x + k - 1 - i][y + j] = temp;
8            }
9        }
10        return grid;
11    }
12}
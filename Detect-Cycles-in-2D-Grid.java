1class Solution {
2    int m, n;
3    boolean[][] visited;
4    
5    public boolean containsCycle(char[][] grid) {
6        m = grid.length;
7        n = grid[0].length;
8        visited = new boolean[m][n];
9        
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (!visited[i][j]) {
13                    if (dfs(grid, i, j, -1, -1, grid[i][j])) {
14                        return true;
15                    }
16                }
17            }
18        }
19        
20        return false;
21    }
22    
23    private boolean dfs(char[][] grid, int x, int y, int px, int py, char ch) {
24        visited[x][y] = true;
25        
26        int[] dx = {0, 0, 1, -1};
27        int[] dy = {1, -1, 0, 0};
28        
29        for (int d = 0; d < 4; d++) {
30            int nx = x + dx[d];
31            int ny = y + dy[d];
32            
33            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
34            if (grid[nx][ny] != ch) continue;
35            
36            // If not visited → go deeper
37            if (!visited[nx][ny]) {
38                if (dfs(grid, nx, ny, x, y, ch)) {
39                    return true;
40                }
41            }
42            // If visited and not parent → cycle found
43            else if (nx != px || ny != py) {
44                return true;
45            }
46        }
47        
48        return false;
49    }
50}
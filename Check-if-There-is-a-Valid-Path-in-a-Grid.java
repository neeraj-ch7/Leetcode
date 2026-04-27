1import java.util.*;
2
3class Solution {
4    public boolean hasValidPath(int[][] grid) {
5        int m = grid.length, n = grid[0].length;
6        
7        // Directions: up, down, left, right
8        int[][] dirs = {
9            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
10        };
11        
12        // Street mapping
13        int[][] streetDirs = {
14            {},
15            {2, 3},   // type 1
16            {0, 1},   // type 2
17            {2, 1},   // type 3
18            {3, 1},   // type 4
19            {2, 0},   // type 5
20            {3, 0}    // type 6
21        };
22        
23        boolean[][] visited = new boolean[m][n];
24        Queue<int[]> q = new LinkedList<>();
25        
26        q.offer(new int[]{0, 0});
27        visited[0][0] = true;
28        
29        while (!q.isEmpty()) {
30            int[] curr = q.poll();
31            int x = curr[0], y = curr[1];
32            
33            // Reached destination
34            if (x == m - 1 && y == n - 1) return true;
35            
36            int type = grid[x][y];
37            
38            for (int d : streetDirs[type]) {
39                int nx = x + dirs[d][0];
40                int ny = y + dirs[d][1];
41                
42                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
43                if (visited[nx][ny]) continue;
44                
45                int nextType = grid[nx][ny];
46                
47                // Check reverse connection
48                int reverse = d ^ 1;
49                boolean valid = false;
50                
51                for (int nd : streetDirs[nextType]) {
52                    if (nd == reverse) {
53                        valid = true;
54                        break;
55                    }
56                }
57                
58                if (valid) {
59                    visited[nx][ny] = true;
60                    q.offer(new int[]{nx, ny});
61                }
62            }
63        }
64        
65        return false;
66    }
67}
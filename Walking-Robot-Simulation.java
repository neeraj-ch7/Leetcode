1import java.util.*;
2
3class Solution {
4    public int robotSim(int[] commands, int[][] obstacles) {
5        // Directions: North, East, South, West
6        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
7        int dir = 0; // start facing North
8        
9        int x = 0, y = 0;
10        int maxDist = 0;
11
12        // Store obstacles in HashSet
13        Set<String> set = new HashSet<>();
14        for (int[] obs : obstacles) {
15            set.add(obs[0] + "#" + obs[1]);
16        }
17
18        for (int cmd : commands) {
19            if (cmd == -1) {
20                dir = (dir + 1) % 4; // turn right
21            } else if (cmd == -2) {
22                dir = (dir + 3) % 4; // turn left
23            } else {
24                // move step by step
25                for (int i = 0; i < cmd; i++) {
26                    int nx = x + dirs[dir][0];
27                    int ny = y + dirs[dir][1];
28
29                    // check obstacle
30                    if (set.contains(nx + "#" + ny)) {
31                        break;
32                    }
33
34                    x = nx;
35                    y = ny;
36
37                    maxDist = Math.max(maxDist, x*x + y*y);
38                }
39            }
40        }
41
42        return maxDist;
43    }
44}
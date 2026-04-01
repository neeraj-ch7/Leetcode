1import java.util.*;
2
3class Solution {
4    static class Robot {
5        int pos, health, index;
6        char dir;
7
8        Robot(int p, int h, char d, int i) {
9            pos = p;
10            health = h;
11            dir = d;
12            index = i;
13        }
14    }
15
16    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
17        int n = positions.length;
18
19        Robot[] robots = new Robot[n];
20        for (int i = 0; i < n; i++) {
21            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
22        }
23
24        // Step 1: sort by position
25        Arrays.sort(robots, (a, b) -> a.pos - b.pos);
26
27        Stack<Robot> stack = new Stack<>();
28
29        for (Robot curr : robots) {
30            if (curr.dir == 'R') {
31                stack.push(curr);
32            } else {
33                // curr.dir == 'L'
34                while (!stack.isEmpty() && stack.peek().dir == 'R') {
35                    Robot top = stack.peek();
36
37                    if (top.health < curr.health) {
38                        stack.pop();
39                        curr.health--;
40                    } else if (top.health > curr.health) {
41                        top.health--;
42                        curr = null; // current dies
43                        break;
44                    } else {
45                        // equal
46                        stack.pop();
47                        curr = null;
48                        break;
49                    }
50                }
51
52                if (curr != null) {
53                    stack.push(curr);
54                }
55            }
56        }
57
58        // Collect survivors
59        List<Robot> survivors = new ArrayList<>(stack);
60
61        // Sort back to original order
62        survivors.sort((a, b) -> a.index - b.index);
63
64        List<Integer> result = new ArrayList<>();
65        for (Robot r : survivors) {
66            result.add(r.health);
67        }
68
69        return result;
70    }
71}
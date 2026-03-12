1import java.util.*;
2
3class Solution {
4
5    class DSU {
6        int[] parent, rank;
7
8        DSU(int n) {
9            parent = new int[n];
10            rank = new int[n];
11            for (int i = 0; i < n; i++) parent[i] = i;
12        }
13
14        int find(int x) {
15            if (parent[x] != x)
16                parent[x] = find(parent[x]);
17            return parent[x];
18        }
19
20        boolean union(int a, int b) {
21            int pa = find(a);
22            int pb = find(b);
23            if (pa == pb) return false;
24
25            if (rank[pa] < rank[pb]) parent[pa] = pb;
26            else if (rank[pb] < rank[pa]) parent[pb] = pa;
27            else {
28                parent[pb] = pa;
29                ++rank[pa];
30            }
31            return true;
32        }
33    }
34
35    public int maxStability(int n, int[][] edges, int k) {
36
37        int left = 1, right = 200000, ans = -1;
38
39        while (left <= right) {
40            int mid = left + (right - left) / 2;
41
42            if (canBuild(n, edges, k, mid)) {
43                ans = mid;
44                left = mid + 1;
45            } else {
46                right = mid - 1;
47            }
48        }
49
50        return ans;
51    }
52
53    boolean canBuild(int n, int[][] edges, int k, int target) {
54
55        DSU dsu = new DSU(n);
56        int usedEdges = 0;
57        int upgrades = 0;
58
59        List<int[]> upgradeEdges = new ArrayList<>();
60
61        // process mandatory edges
62        for (int[] e : edges) {
63            int u = e[0], v = e[1], s = e[2], must = e[3];
64
65            if (must == 1) {
66                if (s < target) return false;
67
68                if (!dsu.union(u, v)) return false; // cycle
69
70                ++usedEdges;
71            }
72        }
73
74        // optional edges
75        for (int[] e : edges) {
76            int u = e[0], v = e[1], s = e[2], must = e[3];
77
78            if (must == 0) {
79
80                if (s >= target) {
81                    if (dsu.union(u, v)) usedEdges++;
82                } else if (2 * s >= target) {
83                    upgradeEdges.add(e);
84                }
85            }
86        }
87
88        // use upgrades if needed
89        for (int[] e : upgradeEdges) {
90
91            if (usedEdges == n - 1) break;
92            if (upgrades == k) break;
93
94            int u = e[0], v = e[1];
95
96            if (dsu.union(u, v)) {
97                upgrades++;
98                usedEdges++;
99            }
100        }
101
102        return usedEdges == n - 1;
103    }
104}
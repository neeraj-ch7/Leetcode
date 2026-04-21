1import java.util.*;
2
3class Solution {
4    
5    class DSU {
6        int[] parent;
7        
8        DSU(int n) {
9            parent = new int[n];
10            for (int i = 0; i < n; i++) parent[i] = i;
11        }
12        
13        int find(int x) {
14            if (parent[x] != x) {
15                parent[x] = find(parent[x]); // path compression
16            }
17            return parent[x];
18        }
19        
20        void union(int x, int y) {
21            int px = find(x);
22            int py = find(y);
23            if (px != py) {
24                parent[py] = px;
25            }
26        }
27    }
28    
29    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
30        int n = source.length;
31        DSU dsu = new DSU(n);
32        
33        // Step 1: Union all allowed swaps
34        for (int[] swap : allowedSwaps) {
35            dsu.union(swap[0], swap[1]);
36        }
37        
38        // Step 2: Group indices by component
39        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
40        
41        for (int i = 0; i < n; i++) {
42            int parent = dsu.find(i);
43            map.putIfAbsent(parent, new HashMap<>());
44            
45            Map<Integer, Integer> freq = map.get(parent);
46            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
47        }
48        
49        // Step 3: Match with target
50        int hammingDistance = 0;
51        
52        for (int i = 0; i < n; i++) {
53            int parent = dsu.find(i);
54            Map<Integer, Integer> freq = map.get(parent);
55            
56            if (freq.getOrDefault(target[i], 0) > 0) {
57                freq.put(target[i], freq.get(target[i]) - 1);
58            } else {
59                hammingDistance++;
60            }
61        }
62        
63        return hammingDistance;
64    }
65}
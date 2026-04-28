1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        List<Integer> list = new ArrayList<>();
4        
5        // Step 1: Flatten
6        for (int[] row : grid) {
7            for (int val : row) {
8                list.add(val);
9            }
10        }
11
12        // Step 2: Check feasibility
13        int rem = list.get(0) % x;
14        for (int val : list) {
15            if (val % x != rem) return -1;
16        }
17
18        // Step 3: Sort and find median
19        Collections.sort(list);
20        int median = list.get(list.size() / 2);
21
22        // Step 4: Calculate operations
23        int ops = 0;
24        for (int val : list) {
25            ops += Math.abs(val - median) / x;
26        }
27
28        return ops;
29    }
30}
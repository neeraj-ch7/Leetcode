1class Solution {
2    public int minSwaps(int[][] grid) {
3        int n = grid.length;
4        int[] zeros = new int[n];
5        
6        // Step 1: Count trailing zeros
7        for (int i = 0; i < n; i++) {
8            int count = 0;
9            for (int j = n - 1; j >= 0; j--) {
10                if (grid[i][j] == 0) count++;
11                else break;
12            }
13            zeros[i] = count;
14        }
15        
16        int swaps = 0;
17        
18        // Step 2: Greedy placement
19        for (int i = 0; i < n; i++) {
20            int required = n - i - 1;
21            int j = i;
22            
23            // Find suitable row
24            while (j < n && zeros[j] < required) {
25                j++;
26            }
27            
28            if (j == n) return -1; // Not possible
29            
30            // Bring row j to i using swaps
31            while (j > i) {
32                int temp = zeros[j];
33                zeros[j] = zeros[j - 1];
34                zeros[j - 1] = temp;
35                j--;
36                swaps++;
37            }
38        }
39        
40        return swaps;
41    }
42}
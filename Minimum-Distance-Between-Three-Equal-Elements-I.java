1import java.util.*;
2
3class Solution {
4    public int minimumDistance(int[] nums) {
5        HashMap<Integer, List<Integer>> map = new HashMap<>();
6        
7        // Step 1: Store indices
8        for (int i = 0; i < nums.length; i++) {
9            map.putIfAbsent(nums[i], new ArrayList<>());
10            map.get(nums[i]).add(i);
11        }
12        
13        int ans = Integer.MAX_VALUE;
14        
15        // Step 2: Check each value
16        for (List<Integer> list : map.values()) {
17            if (list.size() < 3) continue;
18            
19            // Try all triplets of consecutive indices
20            for (int i = 0; i <= list.size() - 3; i++) {
21                int first = list.get(i);
22                int third = list.get(i + 2);
23                
24                int dist = 2 * (third - first);
25                ans = Math.min(ans, dist);
26            }
27        }
28        
29        return ans == Integer.MAX_VALUE ? -1 : ans;
30    }
31}
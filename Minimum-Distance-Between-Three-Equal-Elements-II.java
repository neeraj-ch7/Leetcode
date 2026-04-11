1import java.util.*;
2
3class Solution {
4    public int minimumDistance(int[] nums) {
5        Map<Integer, List<Integer>> map = new HashMap<>();
6        
7        // Step 1: store indices
8        for (int i = 0; i < nums.length; i++) {
9            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
10        }
11        
12        int ans = Integer.MAX_VALUE;
13        
14        // Step 2: process each value
15        for (List<Integer> list : map.values()) {
16            if (list.size() < 3) continue;
17            
18            // Step 3: sliding window of size 3
19            for (int i = 0; i + 2 < list.size(); i++) {
20                int dist = 2 * (list.get(i + 2) - list.get(i));
21                ans = Math.min(ans, dist);
22            }
23        }
24        
25        return ans == Integer.MAX_VALUE ? -1 : ans;
26    }
27}
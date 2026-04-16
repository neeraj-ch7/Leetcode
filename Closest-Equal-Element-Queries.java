1import java.util.*;
2
3class Solution {
4    public List<Integer> solveQueries(int[] nums, int[] queries) {
5        int n = nums.length;
6        
7        Map<Integer, List<Integer>> map = new HashMap<>();
8        
9        for (int i = 0; i < n; i++) {
10            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
11        }
12        
13        List<Integer> ans = new ArrayList<>();
14        
15        for (int idx : queries) {
16            int val = nums[idx];
17            List<Integer> list = map.get(val);
18            
19            if (list.size() == 1) {
20                ans.add(-1);
21                continue;
22            }
23            
24            // binary search in original list
25            int pos = Collections.binarySearch(list, idx);
26            int res = Integer.MAX_VALUE;
27            
28            // left neighbor
29            int left = list.get((pos - 1 + list.size()) % list.size());
30            int diff1 = Math.abs(idx - left);
31            res = Math.min(res, Math.min(diff1, n - diff1));
32            
33            // right neighbor
34            int right = list.get((pos + 1) % list.size());
35            int diff2 = Math.abs(idx - right);
36            res = Math.min(res, Math.min(diff2, n - diff2));
37            
38            ans.add(res);
39        }
40        
41        return ans;
42    }
43}
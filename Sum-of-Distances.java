1import java.util.*;
2
3class Solution {
4    public long[] distance(int[] nums) {
5        int n = nums.length;
6        long[] res = new long[n];
7
8        // Step 1: group indices
9        Map<Integer, List<Integer>> map = new HashMap<>();
10        for (int i = 0; i < n; i++) {
11            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
12        }
13
14        // Step 2: process each group
15        for (List<Integer> list : map.values()) {
16            int size = list.size();
17            
18            long[] prefix = new long[size];
19            prefix[0] = list.get(0);
20            
21            for (int i = 1; i < size; i++) {
22                prefix[i] = prefix[i - 1] + list.get(i);
23            }
24
25            for (int i = 0; i < size; i++) {
26                int idx = list.get(i);
27
28                long left = 0, right = 0;
29
30                if (i > 0) {
31                    left = (long) i * idx - prefix[i - 1];
32                }
33
34                if (i < size - 1) {
35                    right = (prefix[size - 1] - prefix[i]) 
36                            - (long)(size - i - 1) * idx;
37                }
38
39                res[idx] = left + right;
40            }
41        }
42
43        return res;
44    }
45}
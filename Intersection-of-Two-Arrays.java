1import java.util.*;
2
3class Solution {
4    public int[] intersection(int[] nums1, int[] nums2) {
5        
6        Set<Integer> set2 = new HashSet<>();
7        Set<Integer> result = new HashSet<>();
8        
9        // nums2 ko set me convert karo
10        for (int num : nums2) {
11            set2.add(num);
12        }
13        
14        // check intersection
15        for (int num : nums1) {
16            if (set2.contains(num)) {
17                result.add(num);
18            }
19        }
20        
21        // convert to array
22        return result.stream().mapToInt(Integer::intValue).toArray();
23    }
24}
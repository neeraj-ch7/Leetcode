1class Solution {
2    public int[] intersection(int[] nums1, int[] nums2) {
3        
4        Set<Integer> set2 = new HashSet<>();
5        Set<Integer> result = new HashSet<>();
6        
7        // nums2 ko set me convert karo
8        for (int num : nums2) {
9            set2.add(num);
10        }
11        
12        // check intersection
13        for (int num : nums1) {
14            if (set2.contains(num)) {
15                result.add(num);
16            }
17        }
18        
19        // convert to array
20        return result.stream().mapToInt(Integer::intValue).toArray();
21    }
22}
1class Solution {
2    public int subarraySum(int[] nums, int k) {
3
4        HashMap<Integer, Integer> map = new HashMap<>();
5
6        map.put(0, 1);
7
8        int prefixSum = 0;
9        int count = 0;
10
11        for (int num : nums) {
12            prefixSum += num;
13
14            count += map.getOrDefault(prefixSum - k, 0);
15
16            map.put(prefixSum,
17                    map.getOrDefault(prefixSum, 0) + 1);
18        }
19
20        return count;
21    }
22}
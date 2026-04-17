1import java.util.*;
2
3class Solution {
4    public int minMirrorPairDistance(int[] nums) {
5        HashMap<Integer, Integer> map = new HashMap<>();
6        int minDist = Integer.MAX_VALUE;
7
8        for (int i = 0; i < nums.length; i++) {
9            int curr = nums[i];
10            int rev = reverse(curr);
11
12            // check if current already exists as reverse of previous
13            if (map.containsKey(curr)) {
14                int j = map.get(curr);
15                minDist = Math.min(minDist, i - j);
16            }
17
18            // store reverse as key
19            map.put(rev, i);
20        }
21
22        return minDist == Integer.MAX_VALUE ? -1 : minDist;
23    }
24
25    private int reverse(int num) {
26        int rev = 0;
27        while (num > 0) {
28            rev = rev * 10 + num % 10;
29            num /= 10;
30        }
31        return rev;
32    }
33}
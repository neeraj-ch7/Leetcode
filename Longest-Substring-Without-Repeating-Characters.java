1import java.util.*;
2class Solution {
3    public int lengthOfLongestSubstring(String s) {
4
5        HashSet<Character> set = new HashSet<>();
6        int left = 0;
7        int maxLen = 0;
8
9        for (int right = 0; right < s.length(); right++) {
10
11            while (set.contains(s.charAt(right))) {
12                set.remove(s.charAt(left));
13                left++;
14            }
15
16            set.add(s.charAt(right));
17            maxLen = Math.max(maxLen, right - left + 1);
18        }
19
20        return maxLen;
21    }
22}
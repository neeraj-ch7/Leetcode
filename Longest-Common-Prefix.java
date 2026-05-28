1class Solution {
2    public String longestCommonPrefix(String[] strs) {
3        
4        // Edge case
5        if (strs == null || strs.length == 0) {
6            return "";
7        }
8
9        // Assume first string is the prefix
10        String prefix = strs[0];
11
12        // Compare with remaining strings
13        for (int i = 1; i < strs.length; i++) {
14
15            // Reduce prefix until it matches
16            while (strs[i].indexOf(prefix) != 0) {
17                prefix = prefix.substring(0, prefix.length() - 1);
18
19                // If prefix becomes empty
20                if (prefix.isEmpty()) {
21                    return "";
22                }
23            }
24        }
25
26        return prefix;
27    }
28}
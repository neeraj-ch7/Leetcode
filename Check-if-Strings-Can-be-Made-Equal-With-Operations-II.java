1class Solution {
2    public boolean checkStrings(String s1, String s2) {
3        int[] even1 = new int[26];
4        int[] odd1 = new int[26];
5        int[] even2 = new int[26];
6        int[] odd2 = new int[26];
7
8        int n = s1.length();
9
10        for (int i = 0; i < n; i++) {
11            if (i % 2 == 0) {
12                even1[s1.charAt(i) - 'a']++;
13                even2[s2.charAt(i) - 'a']++;
14            } else {
15                odd1[s1.charAt(i) - 'a']++;
16                odd2[s2.charAt(i) - 'a']++;
17            }
18        }
19
20        for (int i = 0; i < 26; i++) {
21            if (even1[i] != even2[i] || odd1[i] != odd2[i]) {
22                return false;
23            }
24        }
25
26        return true;
27    }
28}
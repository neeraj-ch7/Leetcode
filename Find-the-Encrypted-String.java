1class Solution {
2    public String getEncryptedString(String s, int k) {
3        int n = s.length();
4        k = k % n;
5
6        StringBuilder b = new StringBuilder();
7
8        for (int i = 0; i < n; i++) {
9            b.append(s.charAt((i + k) % n));
10        }
11
12        return b.toString();
13    }
14}
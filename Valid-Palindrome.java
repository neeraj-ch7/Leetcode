1class Solution {
2    public boolean isPalindrome(String s) {
3        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
4        
5        int l = 0;
6        int r = s.length() - 1;
7
8        while (l <= r) {
9            if (s.charAt(l) != s.charAt(r)) {
10                return false;
11            }
12            l++;
13            r--;
14        }
15        return true;
16    }
17}
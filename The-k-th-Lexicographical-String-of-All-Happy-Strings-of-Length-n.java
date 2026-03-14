1class Solution {
2
3    String ans = "";
4    int count = 0;
5
6    public String getHappyString(int n, int k) {
7        backtrack("", n, k);
8        return ans;
9    }
10
11    void backtrack(String s, int n, int k) {
12
13        if (s.length() == n) {
14            count++;
15
16            if (count == k) {
17                ans = s;
18            }
19            return;
20        }
21
22        for (char ch : new char[]{'a','b','c'}) {
23
24            if (s.length() > 0 && s.charAt(s.length()-1) == ch)
25                continue;
26
27            backtrack(s + ch, n, k);
28        }
29    }
30}
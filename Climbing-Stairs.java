1class Solution {
2    public int climbStairs(int n) {
3        if (n <= 2) return n;
4
5        int a = 1, b = 2;
6
7        for (int i = 3; i <= n; i++) {
8            int c = a + b;
9            a = b;
10            b = c;
11        }
12
13        return b;
14    }
15}
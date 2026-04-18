1class Solution {
2    public int mirrorDistance(int n) {
3          int rev = 0;
4          int m = n;
5    while (m != 0) {
6        int digit = m % 10;
7        rev = rev * 10 + digit;
8        m /= 10;
9    }
10    return Math.abs(n - rev);
11    }
12}
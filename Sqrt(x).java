1class Solution {
2    public int mySqrt(int x) {
3        if (x < 2) return x;
4
5        int left = 1, right = x / 2;
6        int ans = 0;
7
8        while (left <= right) {
9            int mid = left + (right - left) / 2;
10
11            if ((long) mid * mid == x) {
12                return mid;
13            } 
14            else if ((long) mid * mid < x) {
15                ans = mid;       // store best answer
16                left = mid + 1;
17            } 
18            else {
19                right = mid - 1;
20            }
21        }
22
23        return ans;
24    }
25}
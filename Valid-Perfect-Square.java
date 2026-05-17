1class Solution {
2    public boolean isPerfectSquare(int num) {
3        long low = 1, high = num;
4
5        while (low <= high) {
6            long mid = low + (high - low) / 2;
7            long square = mid * mid;
8
9            if (square == num) {
10                return true;
11            } else if (square < num) {
12                low = mid + 1;
13            } else {
14                high = mid - 1;
15            }
16        }
17
18        return false;
19    }
20}
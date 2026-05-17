1import java.util.*;
2
3class Solution {
4    public boolean isPerfectSquare(int num) {
5        long low = 1, high = num;
6
7        while (low <= high) {
8            long mid = low + (high - low) / 2;
9            long square = mid * mid;
10
11            if (square == num) {
12                return true;
13            } else if (square < num) {
14                low = mid + 1;
15            } else {
16                high = mid - 1;
17            }
18        }
19
20        return false;
21    }
22}
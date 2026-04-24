1class Solution {
2    public int furthestDistanceFromOrigin(String moves) {
3        int left = 0, right = 0, blank = 0;
4
5        for (char c : moves.toCharArray()) {
6            if (c == 'L') left++;
7            else if (c == 'R') right++;
8            else blank++;
9        }
10
11        return Math.abs(right - left) + blank;
12    }
13}
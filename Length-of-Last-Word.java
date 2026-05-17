1class Solution {
2    public int lengthOfLastWord(String s) {
3        int i = s.length() - 1;
4        int length = 0;
5
6        // 1. skip trailing spaces
7        while (i >= 0 && s.charAt(i) == ' ') {
8            i--;
9        }
10
11        // 2. count last word
12        while (i >= 0 && s.charAt(i) != ' ') {
13            length++;
14            i--;
15        }
16
17        return length;
18    }
19}
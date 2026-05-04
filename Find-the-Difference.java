1class Solution {
2    public char findTheDifference(String s, String t) {
3        char result = 0;
4
5        for (char c : s.toCharArray()) result ^= c;
6        for (char c : t.toCharArray()) result ^= c;
7
8        return result;
9    }
10}
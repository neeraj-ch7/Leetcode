1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        int count = 0;
4
5        for (String pattern : patterns) {
6            if (word.contains(pattern)) {
7                count++;
8            }
9        }
10
11        return count;
12    }
13}
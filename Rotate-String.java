1class Solution {
2    public boolean rotateString(String s, String goal) {
3     if(s.length()!=goal.length()) return false;
4     return (s+s).contains(goal);
5    }
6}
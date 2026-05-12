1class Solution {
2    public int scoreOfString(String s) {
3        if(s.length()<1) return 0;
4        int a =0;
5        for(int i =0;i<s.length()-1;i++){
6            char ch = s.charAt(i);
7            char  ch1  = s.charAt(i+1);
8            a = a + Math.abs(ch - ch1);
9        }
10        return a;
11    }
12}
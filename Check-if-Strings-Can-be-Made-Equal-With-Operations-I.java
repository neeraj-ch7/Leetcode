1import java.util.Arrays;
2
3class Solution {
4    public boolean canBeEqual(String s1, String s2) {
5        char[] s1Even = {s1.charAt(0), s1.charAt(2)};
6        char[] s1Odd  = {s1.charAt(1), s1.charAt(3)};
7        
8        char[] s2Even = {s2.charAt(0), s2.charAt(2)};
9        char[] s2Odd  = {s2.charAt(1), s2.charAt(3)};
10        
11        Arrays.sort(s1Even);
12        Arrays.sort(s1Odd);
13        Arrays.sort(s2Even);
14        Arrays.sort(s2Odd);
15        
16        return Arrays.equals(s1Even, s2Even) && 
17               Arrays.equals(s1Odd, s2Odd);
18    }
19}
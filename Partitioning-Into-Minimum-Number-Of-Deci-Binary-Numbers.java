1class Solution {
2    public int minPartitions(String n) {
3        int maxDigit = 0;
4        
5        for (char c : n.toCharArray()) {
6            maxDigit = Math.max(maxDigit, c - '0');
7            
8            // Early exit optimization
9            if (maxDigit == 9) return 9;
10        }
11        
12        return maxDigit;
13    }
14}
1class Solution {
2    public int bitwiseComplement(int n) {
3        String binary = Integer.toBinaryString(n);
4        String s = new String();
5        for (int i = 0; i < binary.length(); i++) {
6            if (binary.charAt(i) == '1') {
7                s = s + '0';
8            } else {
9                s = s + '1';
10            }
11        }
12        int number = Integer.parseInt(s, 2);
13        return number;
14    }
15}
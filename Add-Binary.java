1class Solution {
2    public String addBinary(String a, String b) {
3        int i = a.length() - 1;
4        int j = b.length() - 1;
5        int carry = 0;
6        
7        String ans = "";
8
9        while (i >= 0 || j >= 0 || carry == 1) {
10            int sum = carry;
11
12            if (i >= 0) sum += a.charAt(i--) - '0';
13            if (j >= 0) sum += b.charAt(j--) - '0';
14
15            ans = (sum % 2) + ans;  // direct string add
16            carry = sum / 2;
17        }
18
19        return ans;
20    }
21}
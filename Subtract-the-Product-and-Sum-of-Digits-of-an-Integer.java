1class Solution {
2    public int subtractProductAndSum(int n) {
3        int s =0;
4        int p= 1;
5        while(n>0){
6            int m= n%10;
7            s = m+ s;
8            p = p*m;
9            n = n/10;
10        }
11        return p -s;
12    }
13}
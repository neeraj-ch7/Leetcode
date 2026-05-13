1class Solution {
2    public int countEven(int num) {
3        int sum = 0;
4        int temp = num;
5
6        while (temp > 0) {
7            sum += temp % 10;
8            temp /= 10;
9        }
10
11        if (sum % 2 == 0) {
12            return num / 2;
13        } else {
14            return (num - 1) / 2;
15        }
16    }
17}
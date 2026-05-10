1class Solution {
2    public int sumOfEncryptedInt(int[] nums) {
3        int sum = 0;
4
5        for (int num : nums) {
6            int maxDigit = 0;
7            int temp = num;
8
9            // Step 1: Find max digit
10            while (temp > 0) {
11                maxDigit = Math.max(maxDigit, temp % 10);
12                temp /= 10;
13            }
14
15            // Step 2: Build encrypted number
16            int encrypted = 0;
17            temp = num;
18
19            while (temp > 0) {
20                encrypted = encrypted * 10 + maxDigit;
21                temp /= 10;
22            }
23
24            sum += encrypted;
25        }
26
27        return sum;
28    }
29}
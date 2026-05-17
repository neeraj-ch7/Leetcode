1class Solution {
2    public int[] plusOne(int[] digits) {
3        for (int i = digits.length - 1; i >= 0; i--) {
4
5            // if digit is less than 9 → just add 1 and done
6            if (digits[i] < 9) {
7                digits[i]++;
8                return digits;
9            }
10
11            // if digit is 9 → becomes 0 and carry continues
12            digits[i] = 0;
13        }
14
15        // if all digits were 9 → need new array
16        int[] result = new int[digits.length + 1];
17        result[0] = 1;
18        return result;
19    }
20}
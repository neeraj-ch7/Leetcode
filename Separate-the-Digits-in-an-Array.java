1import java.util.*;
2
3class Solution {
4    public int[] separateDigits(int[] nums) {
5        ArrayList<Integer> answer = new ArrayList<>();
6
7        for (int num : nums) {
8            String s = String.valueOf(num);
9
10            for (char c : s.toCharArray()) {
11                answer.add(c - '0');
12            }
13        }
14
15        // convert to int[]
16        int[] arr = new int[answer.size()];
17        for (int i = 0; i < answer.size(); i++) {
18            arr[i] = answer.get(i);
19        }
20
21        return arr;
22    }
23}
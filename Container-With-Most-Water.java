1class Solution {
2    public int maxArea(int[] height) {
3
4        int left = 0;
5        int right = height.length - 1;
6        int maxArea = 0;
7
8        while (left < right) {
9
10            int width = right - left;
11            int h = Math.min(height[left], height[right]);
12
13            maxArea = Math.max(maxArea, width * h);
14
15            if (height[left] < height[right]) {
16                left++;
17            } else {
18                right--;
19            }
20        }
21
22        return maxArea;
23    }
24}
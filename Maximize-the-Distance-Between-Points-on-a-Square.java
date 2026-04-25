1import java.util.*;
2
3class Solution {
4
5    public int maxDistance(int side, int[][] points, int k) {
6        List<Long> arr = new ArrayList<>();
7
8        for (int[] p : points) {
9            int x = p[0];
10            int y = p[1];
11            if (x == 0) {
12                arr.add((long) y);
13            } else if (y == side) {
14                arr.add((long) side + x);
15            } else if (x == side) {
16                arr.add(side * 3L - y);
17            } else {
18                arr.add(side * 4L - x);
19            }
20        }
21        Collections.sort(arr);
22
23        long lo = 1;
24        long hi = side;
25        int ans = 0;
26
27        while (lo <= hi) {
28            long mid = (lo + hi) / 2;
29            if (check(arr, side, k, mid)) {
30                lo = mid + 1;
31                ans = (int) mid;
32            } else {
33                hi = mid - 1;
34            }
35        }
36        return ans;
37    }
38
39    private boolean check(List<Long> arr, int side, int k, long limit) {
40        long perimeter = side * 4L;
41
42        for (long start : arr) {
43            long end = start + perimeter - limit;
44            long cur = start;
45
46            for (int i = 0; i < k - 1; i++) {
47                int idx = lowerBound(arr, cur + limit);
48                if (idx == arr.size() || arr.get(idx) > end) {
49                    cur = -1;
50                    break;
51                }
52                cur = arr.get(idx);
53            }
54
55            if (cur >= 0) {
56                return true;
57            }
58        }
59        return false;
60    }
61
62    private int lowerBound(List<Long> arr, long target) {
63        int left = 0;
64        int right = arr.size();
65        while (left < right) {
66            int mid = left + (right - left) / 2;
67            if (arr.get(mid) < target) {
68                left = mid + 1;
69            } else {
70                right = mid;
71            }
72        }
73        return left;
74    }
75}
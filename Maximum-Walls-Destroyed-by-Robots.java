1import java.util.*;
2
3class Solution {
4
5    public int maxWalls(int[] robots, int[] distance, int[] walls) {
6        int n = robots.length;
7
8        int[] left = new int[n];
9        int[] right = new int[n];
10        int[] num = new int[n];
11
12        Map<Integer, Integer> robotsToDistance = new HashMap<>();
13        for (int i = 0; i < n; i++) {
14            robotsToDistance.put(robots[i], distance[i]);
15        }
16
17        Arrays.sort(robots);
18        Arrays.sort(walls);
19
20        for (int i = 0; i < n; i++) {
21            int pos1 = upperBound(walls, robots[i]);
22
23            // LEFT
24            int leftBound = robots[i] - robotsToDistance.get(robots[i]);
25            if (i >= 1) {
26                leftBound = Math.max(leftBound, robots[i - 1] + 1);
27            }
28            int leftPos = lowerBound(walls, leftBound);
29            left[i] = pos1 - leftPos;
30
31            // RIGHT
32            int rightBound = robots[i] + robotsToDistance.get(robots[i]);
33            if (i < n - 1) {
34                rightBound = Math.min(rightBound, robots[i + 1] - 1);
35            }
36            int rightPos = upperBound(walls, rightBound);
37
38            int pos2 = lowerBound(walls, robots[i]);
39            right[i] = rightPos - pos2;
40
41            // OVERLAP
42            if (i > 0) {
43                int pos3 = lowerBound(walls, robots[i - 1]);
44                num[i] = pos1 - pos3;
45            }
46        }
47
48        int subLeft = left[0];
49        int subRight = right[0];
50
51        for (int i = 1; i < n; i++) {
52            int currentLeft = Math.max(
53                subLeft + left[i],
54                subRight - right[i - 1] +
55                Math.min(left[i] + right[i - 1], num[i])
56            );
57
58            int currentRight = Math.max(
59                subLeft + right[i],
60                subRight + right[i]
61            );
62
63            subLeft = currentLeft;
64            subRight = currentRight;
65        }
66
67        return Math.max(subLeft, subRight);
68    }
69
70    private int lowerBound(int[] arr, int target) {
71        int left = 0, right = arr.length;
72        while (left < right) {
73            int mid = (left + right) >>> 1;
74            if (arr[mid] < target) left = mid + 1;
75            else right = mid;
76        }
77        return left;
78    }
79
80    private int upperBound(int[] arr, int target) {
81        int left = 0, right = arr.length;
82        while (left < right) {
83            int mid = (left + right) >>> 1;
84            if (arr[mid] <= target) left = mid + 1;
85            else right = mid;
86        }
87        return left;
88    }
89}
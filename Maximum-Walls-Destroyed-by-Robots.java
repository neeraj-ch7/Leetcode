1class Solution {
2
3    public int maxWalls(int[] robots, int[] distance, int[] walls) {
4        int n = robots.length;
5
6        int[] left = new int[n];
7        int[] right = new int[n];
8        int[] num = new int[n];
9
10        Map<Integer, Integer> robotsToDistance = new HashMap<>();
11        for (int i = 0; i < n; i++) {
12            robotsToDistance.put(robots[i], distance[i]);
13        }
14
15        Arrays.sort(robots);
16        Arrays.sort(walls);
17
18        for (int i = 0; i < n; i++) {
19            int pos1 = upperBound(walls, robots[i]);
20
21            // LEFT
22            int leftBound = robots[i] - robotsToDistance.get(robots[i]);
23            if (i >= 1) {
24                leftBound = Math.max(leftBound, robots[i - 1] + 1);
25            }
26            int leftPos = lowerBound(walls, leftBound);
27            left[i] = pos1 - leftPos;
28
29            // RIGHT
30            int rightBound = robots[i] + robotsToDistance.get(robots[i]);
31            if (i < n - 1) {
32                rightBound = Math.min(rightBound, robots[i + 1] - 1);
33            }
34            int rightPos = upperBound(walls, rightBound);
35
36            int pos2 = lowerBound(walls, robots[i]);
37            right[i] = rightPos - pos2;
38
39            // OVERLAP
40            if (i > 0) {
41                int pos3 = lowerBound(walls, robots[i - 1]);
42                num[i] = pos1 - pos3;
43            }
44        }
45
46        int subLeft = left[0];
47        int subRight = right[0];
48
49        for (int i = 1; i < n; i++) {
50            int currentLeft = Math.max(
51                subLeft + left[i],
52                subRight - right[i - 1] +
53                Math.min(left[i] + right[i - 1], num[i])
54            );
55
56            int currentRight = Math.max(
57                subLeft + right[i],
58                subRight + right[i]
59            );
60
61            subLeft = currentLeft;
62            subRight = currentRight;
63        }
64
65        return Math.max(subLeft, subRight);
66    }
67
68    private int lowerBound(int[] arr, int target) {
69        int left = 0, right = arr.length;
70        while (left < right) {
71            int mid = (left + right) >>> 1;
72            if (arr[mid] < target) left = mid + 1;
73            else right = mid;
74        }
75        return left;
76    }
77
78    private int upperBound(int[] arr, int target) {
79        int left = 0, right = arr.length;
80        while (left < right) {
81            int mid = (left + right) >>> 1;
82            if (arr[mid] <= target) left = mid + 1;
83            else right = mid;
84        }
85        return left;
86    }
87}
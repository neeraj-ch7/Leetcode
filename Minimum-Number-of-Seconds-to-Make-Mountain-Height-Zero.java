1class Solution {
2
3    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
4
5        long left = 1;
6        long right = (long)1e18; // large upper bound
7        long ans = right;
8
9        while (left <= right) {
10
11            long mid = left + (right - left) / 2;
12
13            if (canFinish(mid, mountainHeight, workerTimes)) {
14                ans = mid;
15                right = mid - 1;
16            } else {
17                left = mid + 1;
18            }
19        }
20
21        return ans;
22    }
23
24    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {
25
26        long total = 0;
27
28        for (int t : workerTimes) {
29
30            long low = 0, high = 100000;
31
32            while (low <= high) {
33
34                long mid = (low + high) / 2;
35                long cost = (long)t * mid * (mid + 1) / 2;
36
37                if (cost <= time) {
38                    low = mid + 1;
39                } else {
40                    high = mid - 1;
41                }
42            }
43
44            total += high;
45
46            if (total >= mountainHeight)
47                return true;
48        }
49
50        return total >= mountainHeight;
51    }
52}
1class Solution {
2    public int[][] insert(int[][] intervals, int[] newInterval) {
3
4        List<int[]> sortedArr = new ArrayList<>();
5        boolean inserted = false;
6
7        for(int i = 0; i < intervals.length; i++) {
8
9            if(!inserted && intervals[i][0] >= newInterval[0]) {
10                sortedArr.add(newInterval);
11                inserted = true;
12            }
13
14            sortedArr.add(intervals[i]);
15        }
16
17        if(!inserted) {
18            sortedArr.add(newInterval);
19        }
20
21        int[][] arr = sortedArr.toArray(new int[sortedArr.size()][]);
22
23        List<int[]> res = new ArrayList<>();
24
25        int start = arr[0][0];
26        int end = arr[0][1];
27
28        for(int i = 1; i < arr.length; i++) {
29
30            int s = arr[i][0];
31            int e = arr[i][1];
32
33            if(end >= s) {
34                end = Math.max(end, e);
35            } else {
36                res.add(new int[]{start, end});
37                start = s;
38                end = e;
39            }
40        }
41
42        res.add(new int[]{start, end});
43
44        return res.toArray(new int[res.size()][]);
45    }
46}
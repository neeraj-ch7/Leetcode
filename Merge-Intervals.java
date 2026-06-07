1class Solution{
2    public int[][] merge(int[][] intervals) {
3       
4       Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
5
6       List<int[]> res = new ArrayList<>();
7       int start = intervals[0][0];
8       int end = intervals[0][1];
9
10       for(int i=1;i<intervals.length;i++){
11        int s = intervals[i][0];
12        int e = intervals[i][1];
13        
14        if(end>=s){
15            end = Math.max(end,e);
16            continue;
17        }
18
19        res.add(new int[]{start,end});
20        start =s;
21        end = e;
22
23       }
24       res.add(new int[]{start,end});
25       return res.toArray(new int[res.size()][]);
26    }
27}
28
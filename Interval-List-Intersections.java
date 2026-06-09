1class Solution {
2    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
3        
4        List<int[]> res = new ArrayList<>();
5        int i =0;
6        int j=0;
7
8        while(i < firstList.length && j< secondList.length){
9            int start1 = firstList[i][0];
10            int end1 = firstList[i][1];
11            int start2 = secondList[j][0];
12            int end2 = secondList[j][1];
13
14            if(start1<= start2){
15                if(end1>=start2){
16                    int s = Math.max(start1,start2);
17                    int e = Math.min(end1,end2);
18                    res.add(new int[]{s,e});
19                }
20            }else{ // start2 <= start1
21                if(end2 >= start1){
22                    int s = Math.max(start1,start2);
23                    int e = Math.min(end1,end2);
24                    res.add(new int[]{s,e});
25                }
26            }
27            if(end1<=end2){
28                i++;
29            }else{
30                j++;
31            }
32        }
33        return res.toArray(new int[res.size()][]);
34    }
35}
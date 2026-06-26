1class Solution {
2    public int[] searchRange(int[] nums, int target) {
3       int t = target;
4        int[] r = {-1,-1};
5        int low = 0;
6        int high = nums.length-1;
7        int res = -1 ;
8        while(low<=high){
9            int mid = low + (high -low)/2;
10            if(t< nums[mid]){
11                high = mid-1;
12            }else if(t>nums[mid]){
13                low = mid +1;
14            }else{
15                res = mid;
16                high = mid -1;
17            }
18        }
19        
20            r[0] = res;
21         low = 0;
22         high = nums.length-1;
23         res = -1 ;
24
25
26            while(low<=high){
27            int mid = low + (high -low)/2;
28            if(t< nums[mid]){
29                high = mid-1;
30            }else if(t>nums[mid]){
31                low = mid +1;
32            }else{
33                res = mid;
34                low = mid +1;
35            }
36    } 
37        r[1] = res;
38
39    return r;
40}
41
42}
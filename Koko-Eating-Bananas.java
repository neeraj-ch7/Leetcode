1class Solution {
2    public long fun(int[] a,int n,int guess){
3        long h =0;
4        for(int i =0;i<n;i++){
5            h =h +a[i]/guess;
6            if(a[i]%guess != 0){
7                h++;
8            }
9        }
10        return h;
11    }
12
13    public int minEatingSpeed(int[] piles, int h) {
14        
15         int high = Arrays.stream(piles).max().getAsInt();
16         int low = 1;
17         int res =-1;
18         int n = piles.length;
19
20         while(low<=high){
21            int mid = low+ (high-low)/2;
22            long hours = fun(piles,n,mid);
23
24            if(hours>h){
25                low=mid+1;
26            }else{
27                res = mid;
28                high = mid-1;
29            }
30         }
31         return res;
32    }
33}
1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3        int low =0;
4        int high = arr.length-1;
5        int res = 0;
6
7        while(low<=high){
8            int mid = low + (high-low)/2;
9
10            if(arr[mid]<arr[mid+1]){
11                low = mid+1;
12            }
13            else{
14                res = mid;
15                high = mid-1;
16            }
17        }
18        return res;
19    }
20}
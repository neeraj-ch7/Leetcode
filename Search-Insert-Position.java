1class Solution {
2    public int searchInsert(int[] nums, int target) {
3        
4        int l=0;
5        int r=nums.length-1;
6       
7
8        while(l<=r){
9          int  mid = l + (r-l)/2;
10            if(nums[mid]==target){
11                return mid;
12            }else if(nums[mid]<target){
13                l=mid+1;
14            }else{
15                r=mid-1;
16            }
17        }
18        return l;
19    }
20}
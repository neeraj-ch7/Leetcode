1class Solution {
2    public int search(int[] nums, int target) {
3        int start = 0;
4        int end =nums.length -1;
5
6        while(start <= end ){
7            int mid = start + (end - start)/2;
8            
9            if(target>nums[mid]){
10               start=mid+1;
11            }else if(target<nums[mid]){
12               end = mid-1; 
13            }else{
14                return mid;
15            }
16        }
17        return -1;
18    }
19}
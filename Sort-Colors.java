1class Solution {
2    public void sortColors(int[] nums) {
3        int low=0;
4        int mid=0;
5        int high =nums.length-1;
6        
7        while(mid<=high){
8
9            if(nums[mid]==0){
10                int temp = nums[low];
11                nums[low]=nums[mid];
12                nums[mid]=temp;
13                mid++;
14                low++;
15
16            }else if(nums[mid]==1){
17                mid++;
18
19            }else{  // nums[mid] == 2
20                int temp=nums[high];
21                nums[high]=nums[mid];
22                nums[mid]=temp;
23                high--;
24            }
25        }
26    }
27}
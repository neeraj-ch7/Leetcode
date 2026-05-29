1class Solution {
2    public int findDuplicate(int[] nums) {
3        
4      int slow=0;
5      int fast =0;
6
7      while(true){
8         slow=nums[slow];
9         fast=nums[fast];
10         fast=nums[fast];
11         if(slow==fast){
12            slow=0;
13         while(slow!=fast){
14            slow=nums[slow];
15            fast=nums[fast];
16           }
17           return slow;
18         }
19        
20      }
21
22    }
23}
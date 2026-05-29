1
2class Solution {
3    public int findDuplicate(int[] nums) {
4        
5      int slow=0;
6      int fast =0;
7
8      while(true){
9         slow=nums[slow];
10         fast=nums[fast];
11         fast=nums[fast];
12         if(slow==fast){
13            slow=0;
14         while(slow!=fast){
15            slow=nums[slow];
16            fast=nums[fast];
17           }
18           return slow;
19         }
20        
21      }
22    }
23}
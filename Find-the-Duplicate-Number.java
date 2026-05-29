1import java.util.*;
2
3class Solution {
4    public int findDuplicate(int[] nums) {
5        
6      int slow=0;
7      int fast =0;
8
9      while(true){
10         slow=nums[slow];
11         fast=nums[fast];
12         fast=nums[fast];
13         if(slow==fast){
14            slow=0;
15         while(slow!=fast){
16            slow=nums[slow];
17            fast=nums[fast];
18           }
19           return slow;
20         }
21        
22      }
23
24    }
25}
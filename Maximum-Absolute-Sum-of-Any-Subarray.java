1class Solution {
2    public int maxAbsoluteSum(int[] nums) {
3        
4        if(nums.length==1) return Math.abs(nums[0]);
5
6        int minend  = nums[0];
7        int maxend = nums[0];
8        int res = nums[0];
9
10        for(int i =1;i<nums.length;i++){
11          int  v1= nums[i];
12          int  v2= nums[i]+maxend;
13          int  v3= nums[i]+minend;
14          minend = Math.min(v1,Math.min(v2,v3));
15          maxend = Math.max(v1,Math.max(v2,v3));
16    
17          res = Math.max(res,Math.max(maxend,Math.abs(minend)));
18
19        }
20        return res;
21    }
22}
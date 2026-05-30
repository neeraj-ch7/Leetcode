1class Solution {
2    public int maxProduct(int[] nums) {
3         
4         
5         int bestendmax =nums[0];
6         int bestendmin = nums[0];
7         int res= nums[0];
8
9         for(int i =1;i<nums.length;i++){
10            int v1 = nums[i];
11            int v2=  nums[i]*bestendmax;
12            int v3= nums[i]*bestendmin;
13            bestendmin = Math.min(v1,Math.min(v2,v3));
14            bestendmax= Math.max(v1,Math.max(v2,v3));
15            res= Math.max(res,Math.max(bestendmin,bestendmax));
16         }
17         return res;
18    }
19}
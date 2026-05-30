1class Solution {
2    public int maxSubArray(int[] nums) {
3        
4        int bestend = nums[0];
5        int ans= nums[0];
6        
7        for(int i =1;i<nums.length;i++){
8
9            int v1 = bestend + nums[i];
10            int v2 = nums[i];
11            bestend = Math.max(v1,v2);
12            ans = Math.max(ans,bestend);
13        }
14        return ans;
15    }
16}
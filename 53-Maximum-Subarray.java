class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int ans = nums[0];
        for(int i =1;i<nums.length;i++){
            int v1 = nums[i];
            int v2 = best + nums[i];
            best = Math.max(v1,v2);
            ans = Math.max(best,ans);
        }
        return ans;
    }
}
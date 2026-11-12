class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incr = 1;
        int decr = 1;
        int ans=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]> nums[i-1]){
                incr++;
                decr=1;
            }
            else if(nums[i]<nums[i-1]){
                 decr++;
                 incr=1;   
            }else{
                incr=1;
                decr=1;
            }
            ans=Math.max(ans,Math.max(decr,incr));
        }
        return ans;
    }
}

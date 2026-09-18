class Solution {
    public int firstStableIndex(int[] nums, int k) {

        int idx = -1;

        for(int i = 0; i < nums.length; i++){

            int maxN = Integer.MIN_VALUE;
            int minV = Integer.MAX_VALUE;

          
            for(int j = 0; j <= i; j++){
                maxN = Math.max(maxN, nums[j]);
            }

           
            for(int j = i; j < nums.length; j++){
                minV = Math.min(minV, nums[j]);
            }

            int iscore = maxN - minV;

            if(iscore <= k){
                return i;
            }
        }

        return -1;
    }
}

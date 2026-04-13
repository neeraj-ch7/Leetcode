1class Solution {
2    public int getMinDistance(int[] nums, int target, int start) {
3      int minDist = Integer.MAX_VALUE;
4       for(int i =0;i<nums.length;i++){
5        if(nums[i]==target){
6           int dist= Math.abs(i-start);
7           minDist = Math.min(minDist,dist);
8        }
9       } return minDist;
10    }
11}
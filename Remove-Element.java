1class Solution {
2    public int removeElement(int[] nums, int val) {
3            
4            int count =0;
5
6            for (int i=0;i<nums.length;i++){
7                if(nums[i]!=val){
8                nums[count]=nums[i];
9                  count++;
10                }
11            }
12            return count;
13    }
14}
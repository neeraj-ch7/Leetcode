class Solution {
    public void sortColors(int[] nums) {
        int left = 0 ;
        int low = 0;
        int right = nums.length-1;

        while(left<=right){
            if(nums[left]== 2){
                nums[left]= nums[right];
                nums[right]=2;
                right--;
            }
            else if(nums[left]==0){
                nums[left]=nums[low];
                nums[low]=0;
                low++;
                left++;
            }else{
                left++;
            }
        }
    }
}
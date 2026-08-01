class Solution {
    public boolean predictTheWinner(int[] nums) {
         return solve(nums, 0, nums.length - 1) >= 0;
    }

    private int solve(int[] nums, int i, int j) {

        if (i == j)
            return nums[i];

        int pickLeft = nums[i] - solve(nums, i + 1, j);
        int pickRight = nums[j] - solve(nums, i, j - 1);

        return Math.max(pickLeft, pickRight);
    }
}
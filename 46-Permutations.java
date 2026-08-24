import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<>(), used, ans);

        return ans;
    }

    private void backtrack(int[] nums, List<Integer> current,
                           boolean[] used, List<List<Integer>> ans) {

        if (current.size() == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

           
            if (used[i]) {
                continue;
            }

           
            current.add(nums[i]);
            used[i] = true;

           
            backtrack(nums, current, used, ans);

            
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}


1import java.util.*;
2
3class Solution {
4    public List<List<Integer>> threeSum(int[] nums) {
5        Arrays.sort(nums);  // IMPORTANT
6        
7        List<List<Integer>> list = new ArrayList<>();
8        
9        for (int i = 0; i < nums.length; i++) {
10            
11            // skip duplicates
12            if (i > 0 && nums[i] == nums[i - 1]) continue;
13            
14            int left = i + 1;
15            int right = nums.length - 1;
16            
17            while (left < right) {
18                int sum = nums[i] + nums[left] + nums[right];
19                
20                if (sum == 0) {
21                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
22                    
23                    // skip duplicates
24                    while (left < right && nums[left] == nums[left + 1]) left++;
25                    while (left < right && nums[right] == nums[right - 1]) right--;
26                    
27                    left++;
28                    right--;
29                } 
30                else if (sum < 0) {
31                    left++;
32                } 
33                else {
34                    right--;
35                }
36            }
37        }
38        
39        return list;
40    }
41}
1class Solution {
2    public List<List<Integer>> threeSum(int[] nums) {
3        Arrays.sort(nums);  // IMPORTANT
4        
5        List<List<Integer>> list = new ArrayList<>();
6        
7        for (int i = 0; i < nums.length; i++) {
8            
9            // skip duplicates
10            if (i > 0 && nums[i] == nums[i - 1]) continue;
11            
12            int left = i + 1;
13            int right = nums.length - 1;
14            
15            while (left < right) {
16                int sum = nums[i] + nums[left] + nums[right];
17                
18                if (sum == 0) {
19                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
20                    
21                    // skip duplicates
22                    while (left < right && nums[left] == nums[left + 1]) left++;
23                    while (left < right && nums[right] == nums[right - 1]) right--;
24                    
25                    left++;
26                    right--;
27                } 
28                else if (sum < 0) {
29                    left++;
30                } 
31                else {
32                    right--;
33                }
34            }
35        }
36        
37        return list;
38    }
39}